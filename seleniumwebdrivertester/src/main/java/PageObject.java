import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PageObject {

    public PageObject(String title, String address, WebDriver driver) {
        this.title = title;
        this.address = address;
        this.driver = driver;
        this.initPage();
        this.navigatePage();
    }

    protected void navigatePage()
    {
        this.driver.get(this.address);
    }

    protected void initPage()
    {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void printScreenToFile()
    {
        File screenshort =  ( (TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE);
        // import java.util.Date;
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String fileName = format.format(dateNow)+".png";
        try {
            FileUtils.copyFile(screenshort, new File( "C:\\MyData\\"+fileName  )   );
        } catch (IOException ex) {
            System.out.println("Что-то не так с именем файла");
        }
    }


    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    protected String title;
    protected  String address;
    protected WebDriver driver;

    protected WebElement input;//login, password, button
    public boolean canUseElements()
    {
        this.input = driver.findElement(By.cssSelector(".myName"));
        if (this.input == null)
        {
            return false;
        }else
        {
            return true;
        }
    }

}
