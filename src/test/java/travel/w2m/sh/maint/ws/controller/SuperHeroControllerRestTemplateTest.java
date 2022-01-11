package travel.w2m.sh.maint.ws.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.http.HttpStatus;

import travel.w2m.sh.maint.ws.dto.SuperHeroDTO;
import travel.w2m.sh.maint.ws.model.SuperHero;
import travel.w2m.sh.maint.ws.service.SuperHeroService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class SuperHeroControllerRestTemplateTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @MockBean
  private SuperHeroService service;

  @Before
  public void init() {
    SuperHero model = new SuperHero();
    model.setId(2L);
    model.setNickname("Spider-Man");
    model.setFullname("Peter Parker");
    model.setOccupation("Periodista");
    SuperHeroDTO dto = new SuperHeroDTO(model);
    when(service.findById(2L)).thenReturn(dto);
  }

  @Test
  public void get_auth_ok() throws Exception {
    ResponseEntity<String> response = restTemplate
        .withBasicAuth("user", "password")
        .getForEntity("/api/superheros/2", String.class);
    
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }
  
  @Test
  public void get_noauth_401() throws Exception {
    ResponseEntity<String> response = restTemplate
        .getForEntity("/api/superheros/2", String.class);
    
    assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
  }

}
