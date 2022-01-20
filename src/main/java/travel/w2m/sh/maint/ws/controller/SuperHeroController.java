package travel.w2m.sh.maint.ws.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import travel.w2m.sh.maint.ws.advice.TimedExecution;
import travel.w2m.sh.maint.ws.dto.SuperHeroDTO;
import travel.w2m.sh.maint.ws.service.SuperHeroService;

@RestController
@RequestMapping("/api/superheros")
public class SuperHeroController {

  private static final Logger LOGGER = LoggerFactory.getLogger(SuperHeroController.class);

  @Autowired
  private SuperHeroService superHeroService;

  @TimedExecution
  @GetMapping
  public ResponseEntity<List<SuperHeroDTO>> findAll() {
    LOGGER.info("GET api/superheros");
    return ResponseEntity.ok(superHeroService.findAll());
  }

  @TimedExecution
  @GetMapping("/{id}")
  public ResponseEntity<SuperHeroDTO> findById(@PathVariable("id") Long id) {
    LOGGER.info("GET api/superheros/{}", id);
    return ResponseEntity.ok(superHeroService.findById(id));
  }

  @GetMapping("/query")
  public ResponseEntity<List<SuperHeroDTO>> findByName(@RequestParam("name") String name) {
    LOGGER.info("QUERY api/superheros/query?name={}", name);
    return ResponseEntity.ok(superHeroService.findByNickname(name));
  }

  @TimedExecution
  @PutMapping("/{id}")
  public ResponseEntity<SuperHeroDTO> update(@PathVariable("id") String id, 
      @RequestBody(required = true) final SuperHeroDTO dto) {
    LOGGER.info("UPDATE api/superheros/update");
    if (superHeroService.existById(Long.valueOf(id))) {
      return ResponseEntity.ok(superHeroService.update(dto));
    }
    
    throw new IllegalArgumentException("SuperHero not found with id " + id);
  }

  @TimedExecution
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") Long id) {
    LOGGER.info("DELETE api/superheros/delete/{}", id);
    superHeroService.deleteById(id);
  }

}