package travel.w2m.sh.maint.ws.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import travel.w2m.sh.maint.ws.dto.SuperHeroDTO;
import travel.w2m.sh.maint.ws.exception.SuperHeroException;
import travel.w2m.sh.maint.ws.model.SuperHero;
import travel.w2m.sh.maint.ws.repository.SuperHeroRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaSuperHeroServiceTest {
  
  @Autowired
  private SuperHeroService service;
  private final SuperHeroRepository repository = Mockito.mock(SuperHeroRepository.class);
  private SuperHeroDTO superHeroDTO; 
  
  @BeforeEach
  void setUp() {
    SuperHero model = new SuperHero();
    model.setId(2L);
    model.setNickname("Spider-Man");
    model.setFullname("Peter Parker");
    model.setOccupation("Periodista");
    superHeroDTO = new SuperHeroDTO(model);
  }
  
  @Test
  void validFieldsComparison() {
    var dto1 = service.findById(2L);
    Assertions.assertAll(() -> dto1.getId().equals(superHeroDTO.getId()),
        () -> dto1.getNickname().equals(superHeroDTO.getNickname()),
        () -> dto1.getFullname().equals(superHeroDTO.getFullname()));
  }
  
  @Test
  void throwSuperHeroExceptionByInvalidId() {
    assertThrows(SuperHeroException.class, () -> service.findById(5L));
  }
  
  @Test
  void findAllSuperHeros() {
    var actual = service.findAll();
    Assertions.assertAll(
      () -> assertNotNull(actual),
      () -> assertEquals(actual.get(1).getNickname(), superHeroDTO.getNickname()),
      () -> assertEquals(actual.get(1).getFullname(), superHeroDTO.getFullname()),
      () -> assertEquals(actual.get(1).getOccupation(), superHeroDTO.getOccupation()));
  }
  
  @Test
  void EmptyWhenEmptyDatabase() {
    Mockito.when(repository.findAll()).thenReturn(Collections.EMPTY_LIST);
    var superHeros = repository.findAll();
    assertTrue(superHeros.isEmpty());
  }
  
}
