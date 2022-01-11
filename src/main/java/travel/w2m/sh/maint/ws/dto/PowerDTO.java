package travel.w2m.sh.maint.ws.dto;

import lombok.Data;
import travel.w2m.sh.maint.ws.model.Power;

@Data
public class PowerDTO {
  
  private Double strength;
  private Double speed;
  private Double endurance;
  private Double attack;
  
  public PowerDTO(Power power) {
    if (power == null) return;
    strength = power.getStrength();
    speed = power.getSpeed();
    endurance = power.getEndurance();
    attack = power.getAttack();
  }

}
