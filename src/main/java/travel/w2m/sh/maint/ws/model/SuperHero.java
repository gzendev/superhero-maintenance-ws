package travel.w2m.sh.maint.ws.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import travel.w2m.sh.maint.ws.dto.SuperHeroDTO;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Data
@NoArgsConstructor
@Table(name = "SUPERHERO")
@Cache(region = "superheroCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class SuperHero implements Serializable {

  private static final long serialVersionUID = -1047095364453371811L;

  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @NotEmpty
  @NotNull
  @Column(name = "nickname", updatable = true, nullable = false)
  private String nickname;

  @NotEmpty
  @NotNull
  @Column(name = "fullname", updatable = true, nullable = false)
  private String fullname;

  @NotEmpty
  @NotNull
  @Column(name = "gender", updatable = true, nullable = false)
  private String gender;

  @NotEmpty
  @NotNull
  @Column(name = "height", updatable = true, nullable = false)
  private Double height;

  @NotEmpty
  @NotNull
  @Column(name = "weight", updatable = true, nullable = false)
  private Double weight;

  @NotEmpty
  @NotNull
  @Column(name = "occupation", updatable = true, nullable = false)
  private String occupation;

  @Column(name = "creation_date", updatable = false, nullable = false)
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private LocalDateTime creationDate;
  
  @Column(name = "modification_date", updatable = true, nullable = false)
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private LocalDateTime modificationDate;

  @OneToOne
  private Power power;

  @PrePersist
  public void prePersist() {
    creationDate = LocalDateTime.now();
  }
  
  @PreUpdate
  public void preUpdate() {
    modificationDate = LocalDateTime.now();
  }

  public SuperHero(SuperHeroDTO dto) {
    if (dto == null) return;
    id = dto.getId();
    nickname = dto.getNickname();
    fullname = dto.getFullname();
    gender = dto.getGender();
    height = dto.getHeight();
    weight = dto.getWeight();
    occupation = dto.getOccupation();
    power = new Power(dto.getPower()); 
  }
  
  
  
}
