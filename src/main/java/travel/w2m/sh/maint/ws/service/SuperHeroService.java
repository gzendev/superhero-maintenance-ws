package travel.w2m.sh.maint.ws.service;

import java.util.List;

import travel.w2m.sh.maint.ws.dto.SuperHeroDTO;

public interface SuperHeroService {

  public List<SuperHeroDTO> findAll();

  public List<SuperHeroDTO> findByNickname(final String nickname);

  public SuperHeroDTO findById(final Long id);

  public SuperHeroDTO update(final SuperHeroDTO dto);

  public void deleteById(final Long id);

  public boolean existById(final Long id);

}