import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class seleniumwebdrivertester {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\WebDrivers\\geckodriver.exe"); // Setting system properties of FirefoxDriver
        WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
        LoginPage loginPage = new LoginPage("LOGIN MINFIN",
                "https://developers.minfin.com.ua/login/",
                driver);
        loginPage.printScreenToFile();
        loginPage.navigateToLoginPage();
        if (loginPage.canUseElements())
        {
            System.out.println("Заголовок 1 "+loginPage.getTitle());
            System.out.println("Адрес 1 "+loginPage.getAddress());
            loginPage.printScreenToFile();
            loginPage = loginPage.login();
            String actualAddress = loginPage.currentDriver().getCurrentUrl();
            String expectedAddress = "https://developers.minfin.com.ua/";
            System.out.println("actualAddress = "+actualAddress);
            System.out.println("expectedAddress = "+expectedAddress);
        }
        else
        {
            System.out.println("Ошибка навигации");
        }


        Thread.sleep(5000);// пауза в 5 секунд = время отдыха JVM
        driver.quit();

    }

    public static void main_local(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver","C:\\WebDrivers\\geckodriver.exe"); // Setting system properties of FirefoxDriver
        WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("file:///D:/MyData/home.html");
        System.out.println("Заголовок "+driver.getTitle());
        System.out.println("Загруженный адрес "+driver.getCurrentUrl());
        // WebElement input = driver.findElement(By.name("search"));
        // WebElement input = driver.findElement(By.id("searchInput"));
        WebElement input = driver.findElement(By.xpath("//input[@id=\"searchInput\"]"));
        if (input!=null)
        {
            // input.sendKeys("google"+Keys.ENTER);
            input.sendKeys("google");
        }
        WebElement inputButton = driver.findElement(By.id("searchButton"));
        if (inputButton!=null)
        {
            inputButton.click();
        }

        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String filename = format.format(dateNow)+".png";

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot,
                    new File("D:\\MyData\\"+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }


        Thread.sleep(5000);// пауза в 5 секунд = время отдыха JVM
        driver.quit();
        //
    }

    public static void main_wiki(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver","C:\\WebDrivers\\geckodriver.exe"); // Setting system properties of FirefoxDriver
        WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        System.out.println("Заголовок "+driver.getTitle());
        System.out.println("Загруженный адрес "+driver.getCurrentUrl());
        // WebElement input = driver.findElement(By.name("search"));
        // WebElement input = driver.findElement(By.id("searchInput"));
        WebElement input = driver.findElement(By.xpath("//input[@id=\"searchInput\"]"));
        if (input!=null)
        {
            // input.sendKeys("google"+Keys.ENTER);
            input.sendKeys("google");
        }
        WebElement inputButton = driver.findElement(By.id("searchButton"));
        if (inputButton!=null)
        {
            inputButton.click();
        }

        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String filename = format.format(dateNow)+".png";

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot,
                    new File("D:\\MyData\\"+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }


        Thread.sleep(5000);// пауза в 5 секунд = время отдыха JVM
        driver.quit();
        //
    }
    public static void main_previous(String[] args) throws InterruptedException {
        System.out.println("Hello from selenium webd river test");
        //
        System.setProperty("webdriver.gecko.driver","C:\\WebDrivers\\geckodriver.exe"); // Setting system properties of FirefoxDriver
        // System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe"); // Setting system properties of FirefoxDriver
        WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
        // WebDriver driver = new ChromeDriver(); //Creating an object of FirefoxDriver
        //
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com");
        // driver.get("https://www.ukr.net");
        System.out.println("Заголовок "+driver.getTitle());
        System.out.println("Загруженный адрес "+driver.getCurrentUrl());

        WebElement input = driver.findElement(By.name("q"));

        if (input != null)
        {
            input.sendKeys("wiki"+ Keys.ENTER);
        }

        System.out.println("Заголовок "+driver.getTitle());
        System.out.println("Загруженный адрес "+driver.getCurrentUrl());


        Thread.sleep(5000);// пауза в 5 секунд = время отдыха JVM
        driver.quit();
        //
    }
}
