package travel.w2m.sh.maint.ws.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import travel.w2m.sh.maint.ws.service.SuperHeroService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SuperHeroControllerTest {
  
  @Autowired
  private MockMvc mockMvc;
  
  @MockBean
  private SuperHeroService superHeroService;
  
  @WithMockUser("USER")
  @Test
  public void get_auth_ok() throws Exception {
    mockMvc.perform(get("/api/superheros/2"))
      .andDo(print())
      .andExpect(status().isOk());
  }
  
  @Test
  public void get_noauth_401() throws Exception {
    mockMvc.perform(get("/api/superheros/2"))
      .andDo(print())
      .andExpect(status().isUnauthorized());
  }
  
}
