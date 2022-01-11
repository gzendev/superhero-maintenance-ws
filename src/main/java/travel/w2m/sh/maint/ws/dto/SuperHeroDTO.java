package travel.w2m.sh.maint.ws.dto;

import lombok.Data;
import travel.w2m.sh.maint.ws.model.SuperHero;

@Data
public class SuperHeroDTO {
  
  private Long id;
  private String nickname;
  private String fullname;
  private String gender;
  private Double height;
  private Double weight;
  private String occupation;
  private PowerDTO power;
  
  public SuperHeroDTO(SuperHero superHero) {
    if (superHero == null) return;
    id = superHero.getId();
    nickname = superHero.getNickname();
    fullname = superHero.getFullname();
    gender = superHero.getGender();
    height = superHero.getHeight();
    weight = superHero.getWeight();
    occupation = superHero.getOccupation();
    power = new PowerDTO(superHero.getPower());
  }

}
