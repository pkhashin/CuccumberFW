package pages;

import common.ElementUtil;
import org.openqa.selenium.WebDriver;
import repo.login.LoginRepo;

public class LoginPage extends LoginRepo {

    private WebDriver driver;
    private ElementUtil elementutil;
    private LoginRepo loginrepo;
  public LoginPage(WebDriver driver){
      this.driver=driver;
      elementutil=new ElementUtil(this.driver);
  }

  public void doLogin(String username,String password){

      elementutil.doSendKeys(LoginRepo.txtUserName,username);
      elementutil.doSendKeys(LoginRepo.txtPassword,password);
  }
}
