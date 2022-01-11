package travel.w2m.sh.maint.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import travel.w2m.sh.maint.ws.model.SuperHero;

@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {

  List<SuperHero> findByNicknameContaining(String nickname);

}
