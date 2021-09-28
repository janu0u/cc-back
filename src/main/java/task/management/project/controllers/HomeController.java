package task.management.project.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {

  @GetMapping("/")
  public ResponseEntity<String> home() {

    return new ResponseEntity<>("Home", HttpStatus.OK);

  }

  @GetMapping("/health")
  public ResponseEntity<String> health() {

    return new ResponseEntity<>("Healthy and running", HttpStatus.OK);

  }

}
