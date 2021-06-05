package spring.boot.examples.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import spring.boot.examples.domain.Welcome;
import spring.boot.examples.service.WelcomeService;

@Service
public class WelcomeServiceImpl implements WelcomeService {

  List<Welcome> welcomeObjList;

  public WelcomeServiceImpl() {
    welcomeObjList = new ArrayList<Welcome>();
    String welcomeString = "Hey Man!! Welcome It's your first spring boot project";

    String[] names = {"gaurav", "paras", "bhupesh", "prabhat", "sumit", "shubham"};

    Arrays.stream(names).forEach(name -> welcomeObjList.add(new Welcome(welcomeString, name)));
  }

  @Override
  public Welcome getWelcomeText(String owner) {
    Welcome welcome = null;
    welcome =
        this.welcomeObjList.stream().filter((welcomeObj) -> welcomeObj.getOwnedBy().equals(owner))
            .collect(Collectors.toList()).get(0);
    return welcome;
  }

}
