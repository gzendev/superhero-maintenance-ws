package travel.w2m.sh.maint.ws.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import travel.w2m.sh.maint.ws.dto.SuperHeroDTO;
import travel.w2m.sh.maint.ws.exception.SuperHeroException;
import travel.w2m.sh.maint.ws.model.Power;
import travel.w2m.sh.maint.ws.model.SuperHero;
import travel.w2m.sh.maint.ws.repository.SuperHeroRepository;
import travel.w2m.sh.maint.ws.service.SuperHeroService;

@CacheConfig(cacheNames = "superhero")
@Service
public class JpaSuperHeroService implements SuperHeroService {
  
  @Autowired
  private SuperHeroRepository superHeroRepository;
  
  @Cacheable(value = "allsuperheroscache")
  @Override
  public List<SuperHeroDTO> findAll() {
    return superHeroRepository.findAll().stream().map(SuperHeroDTO::new).collect(Collectors.toList());
  }

  @Cacheable(value = "allsuperheroscache")
  @Override
  public List<SuperHeroDTO> findByNickname(String nickname) {
    return superHeroRepository.findByNicknameContaining(nickname).stream().map(SuperHeroDTO::new).collect(Collectors.toList());
  }

  @Cacheable(value = "allsuperheroscache")
  @Override
  public SuperHeroDTO findById(Long id) {
    return new SuperHeroDTO(superHeroRepository.findById(id).orElseThrow(() -> new SuperHeroException(id)));
  }

  @Caching(evict = {@CacheEvict(value = "allsuperherocache", allEntries = true),
      @CacheEvict(value = "superherocache", key = "#superhero.id")
      })
  @Override
  public SuperHeroDTO update(SuperHeroDTO dto) {
    SuperHero superHero = null;

    if(dto.getId() != null) {
      superHero = superHeroRepository.findById(dto.getId()).orElseThrow(() -> new SuperHeroException(dto.getId()));
      superHero.setFullname(dto.getFullname());
      superHero.setGender(dto.getGender());
      superHero.setHeight(dto.getHeight());
      superHero.setNickname(dto.getNickname());
      superHero.setOccupation(dto.getOccupation());
      superHero.setWeight(dto.getWeight());
      superHero.setPower(new Power(dto.getPower()));
      superHero = superHeroRepository.save(superHero);
    }

    return new SuperHeroDTO(superHero);
  }

  @Caching(evict = {@CacheEvict(value = "allsuperherocache", allEntries = true),
      @CacheEvict(value = "superherocache", key = "#superhero.id")
      })
  @Override
  public void deleteById(Long id) {
    superHeroRepository.deleteById(id);    
  }

  @Override
  public boolean existById(Long id) {
    return superHeroRepository.existsById(id);
  }

}
