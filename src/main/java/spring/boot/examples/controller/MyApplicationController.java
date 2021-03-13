package spring.boot.examples.controller;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import spring.boot.examples.domain.Welcome;
import spring.boot.examples.service.WelcomeService;

@RestController
@RequestMapping(path = "app/")
public class MyApplicationController {

  private static final Logger logger = LoggerFactory.getLogger(MyApplicationController.class);

  @Autowired
  WelcomeService welcomeService;

  @GetMapping(path = "welcome/{owner}")
  public Welcome getWelcome(@PathVariable String owner) throws InterruptedException {
    logger.info("info: request received for {}", "getWelcome");
    return welcomeService.getWelcomeText(owner);
  }

  @GetMapping(path = "users")
  public String getAllUsers() {
    ResponseEntity<String> entity = null;
    RestTemplate template = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> httpEntity = new HttpEntity<String>("parameters", headers);

    entity = template.exchange("http://theinstashare.com/instashare/users/active/users",
        HttpMethod.GET, httpEntity, String.class);
    return entity.getBody();
  }
}
