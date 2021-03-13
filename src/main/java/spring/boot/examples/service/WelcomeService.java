package spring.boot.examples.service;

import spring.boot.examples.domain.Welcome;

public interface WelcomeService {
  public Welcome getWelcomeText(String owner) throws InterruptedException;
}
