package spring.boot.examples.domain;

public class Welcome {

  private String welcomeText;
  private String ownedBy;

  public Welcome(String welcomeText, String ownedBy) {
    this.welcomeText = welcomeText;
    this.ownedBy = ownedBy;
  }

  public String getWelcomeText() {
    return welcomeText;
  }

  public void setWelcomeText(String welcomeText) {
    this.welcomeText = welcomeText;
  }

  public String getOwnedBy() {
    return ownedBy;
  }

  public void setOwnedBy(String ownedBy) {
    this.ownedBy = ownedBy;
  }


}
