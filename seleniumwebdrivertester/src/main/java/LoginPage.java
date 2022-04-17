import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageObject {

    private WebElement username;
    private WebElement password;
    private WebElement login;

    public LoginPage(String title, String address, WebDriver driver) {
        super(title, address, driver);
    }

    @Override
    public boolean canUseElements() {
        this.username = this.driver.findElement(By.name("login"));
        this.password = this.driver.findElement(By.name("password"));
        this.login = this.driver.findElement(By.cssSelector("button[type='submit']"));
        if (this.username == null) return false;
        if (this.password == null) return false;
        if (this.login == null) return false;
        return true;
    }

    public void navigateToLoginPage() {
        WebElement link = this.driver.findElement(By.cssSelector("a[href='/login/']"));
        if (link != null)
        {
            System.out.println("Have link "+link);//toString()
            link.click();
        }
    }

    public LoginPage login()
    {
        if (this.canUseElements())
        {
            this.username.sendKeys("artem.konstantinovich@ukr.net");
            this.password.sendKeys("Password123_"+Keys.ENTER);
            this.login.click();
            try
            {
                Thread.sleep(5000);
            }catch (InterruptedException ex)
            {
                System.out.println(ex);
            }
        }
        return this;
    }

    public WebDriver currentDriver()
    {
        return this.driver;
    }

}
