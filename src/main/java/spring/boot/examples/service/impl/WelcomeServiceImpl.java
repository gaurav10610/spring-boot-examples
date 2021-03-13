package spring.boot.examples.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import spring.boot.examples.domain.Welcome;
import spring.boot.examples.service.WelcomeService;

@Service
public class WelcomeServiceImpl implements WelcomeService {

  List<Welcome> welcomeObjList;

  public WelcomeServiceImpl() {
    welcomeObjList = new ArrayList<Welcome>();
    welcomeObjList
        .add(new Welcome("Hey Man!! Welcome It's your first spring boot project", "Gaurav"));
    welcomeObjList
        .add(new Welcome("Hey Man!! Welcome It's your first spring boot project", "Paras"));
    welcomeObjList
        .add(new Welcome("Hey Man!! Welcome It's your first spring boot project", "Bhupesh"));
    welcomeObjList
        .add(new Welcome("Hey Man!! Welcome It's your first spring boot project", "Prabhat"));
    welcomeObjList
        .add(new Welcome("Hey Man!! Welcome It's your first spring boot project", "Sumit"));
    welcomeObjList
        .add(new Welcome("Hey Man!! Welcome It's your first spring boot project", "Shubham"));
  }

  @Cacheable("Welcome")
  @Override
  public Welcome getWelcomeText(String owner) throws InterruptedException {
    Welcome welcome = null;
    welcome =
        this.welcomeObjList.stream().filter((welcomeObj) -> welcomeObj.getOwnedBy().equals(owner))
            .collect(Collectors.toList()).get(0);
//    Thread.sleep(5000);
    return welcome;
  }

}
