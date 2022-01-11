package travel.w2m.sh.maint.ws.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Data;
import lombok.NoArgsConstructor;
import travel.w2m.sh.maint.ws.dto.PowerDTO;

@Entity
@Data
@NoArgsConstructor
@Table(name = "POWER")
@Cache(region = "powerCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Power implements Serializable {

  private static final long serialVersionUID = 8484576573062152284L;

  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @NotEmpty
  @NotNull
  @Column(name = "strength", updatable = true, nullable = false)
  private Double strength;

  @NotEmpty
  @NotNull
  @Column(name = "speed", updatable = true, nullable = false)
  private Double speed;

  @NotEmpty
  @NotNull
  @Column(name = "endurance", updatable = true, nullable = false)
  private Double endurance;

  @NotEmpty
  @NotNull
  @Column(name = "attack", updatable = true, nullable = false)
  private Double attack;

  @OneToOne
  @JoinColumn(name = "superhero_id")
  private SuperHero superHero;

  public Power(PowerDTO dto) {
    if (dto == null) return;
    strength = dto.getStrength();
    speed = dto.getSpeed();
    endurance = dto.getEndurance();
    attack = dto.getAttack();
  }

}
