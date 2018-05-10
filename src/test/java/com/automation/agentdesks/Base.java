package com.automation.agentdesks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.fail;

public class Base {

    public static AppiumDriver driver;
    public static DesiredCapabilities capabilities;
    public static final String Default_Platform = "iOS";
    public static WebDriverWait driverWait;
    public static final String platform = System.getProperty("platform", Default_Platform);

    @BeforeClass
    public static void setUp() throws Exception {

        switch (platform) {

            case "Android":
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "6.0");
                capabilities.setCapability("browserName", "Chrome");
                capabilities.setCapability("deviceName", "Samsung");
                capabilities.setCapability("showChromedriverLog", true);
                capabilities.setCapability("autoWebView", true);
                driver = new AndroidDriver(new URL("http://0.0.0.0:" + 4723 + "/wd/hub"), capabilities);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.navigate().to("https://web.agentdesks.com/#/login/choice");
                break;

            case "iOS":
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("platformVersion", "11.3");
                capabilities.setCapability("browserName", "Safari");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("deviceName", "iPad Air");
                capabilities.setCapability("udid", "Auto");
                capabilities.setCapability("startIWDP", true);
                capabilities.setCapability("safariInitialUrl", "https://web.agentdesks.com/#/login/choice");
                capabilities.setCapability("launchTimeout", "100000");
                driver = new IOSDriver(new URL("http://0.0.0.0:" + 4723 + "/wd/hub"), capabilities);
                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
                driver.navigate().to("https://web.agentdesks.com/#/login/choice");
                break;

        }

        driverWait = new WebDriverWait(driver, 5000);
    }


        public static boolean findElementByIdAndClick(String elementId) {

            int counter = 0;
            System.out.println(elementId);

            while (counter < Labels.MIN_ATTEMPTS) {
                try {
                    driver.context("NATIVE_APP");
                    WebElement element = driver.findElement(By.id(elementId));
                    if (element.isDisplayed()) {
                        element.click();
                        return true;
                    }
                } catch (Exception e) {
                    System.out.println(counter + "time trying to find" + elementId);
                }
                sleep(5000);
                counter++;
            }
            return false;
        }

        public static boolean findElementByXpathAndClick(String elementXpath) {
          int counter = 0;
          while (counter < Labels.MIN_ATTEMPTS) {
              try {
                  driver.findElement(By.xpath(elementXpath)).click();
                  return true;
              } catch (Exception e) {
                  System.out.println(counter + "time trying to find" + elementXpath);
              }
              sleep(500);
              counter++;
          }
            return false;
        }


    public static void waitForElementToLoad(String element) {
        int minAttempts = 0;
        while(minAttempts < 4) {
            try {
                WebDriverWait driverWait = new WebDriverWait(driver, 20);
                driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(element)));
                sleep(5000);
                break;
            }catch(TimeoutException timeout) {
                minAttempts++;
            }
        }
    }


    public static boolean isElementDisplayedById(String elementName) {

        int counter = 0;

        while (counter < Labels.MIN_ATTEMPTS) {
            try {
                driver.context("NATIVE_APP");
                if(platform.equals("iOS"))
                    driver.findElement(By.xpath(elementName));
                else
                driver.findElement(By.id(elementName));
                    return true;
            } catch (Exception e) {
                System.out.println(counter + "time trying to find" + elementName);
            }
            sleep(5000);
            counter++;
        }
        return false;
    }

    public static void sleep(long millis) {

        try{
            Thread.sleep(millis);
        }catch(InterruptedException e) { }
    }

    public static void selectElementById(String elementId) {

        try {
            if(platform.equals("iOS")) {
                driver.findElement(By.xpath(elementId)).click();
            }

            driver.findElement(By.id(elementId)).click();
        }catch (Exception elementNotFound) {
        }
    }

    public static boolean sendTextById(String message, String elementId) {
        int counter = 0;
        while(counter < Labels.MIN_ATTEMPTS) {
            try {

                if(platform.equals("iOS")) {

                    driver.findElement(By.xpath(elementId)).clear();
                    driver.findElement(By.xpath(elementId)).sendKeys(message);
                    return true;
                }
                else {
                        driver.findElement(By.id(elementId)).clear();
                        driver.findElement(By.id(elementId)).sendKeys(message);
                    return true;

                }
            }catch(Exception e) {
                System.out.println(counter + "time trying to find" + elementId);
            }
            sleep(5000);
            counter++;
        }

        return false;
    }


    public static void dismissAndroidKeyboard() throws Exception {
        try {
            String commandToEnableLocation = "adb -s shell input keyevent 111";
            executeTerminalCommand(commandToEnableLocation);
        } catch (Exception exceptionDetail) {
            fail("Failed to dismiss android keyboard");
        }
    }

    public static void executeTerminalCommand(String command) {

        Process p;

        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
       }

    }

    public static boolean checkEmailFormat(String elementId) {

        try{

            String email;
            if(platform.equals("iOS"))
                email = driver.findElement(By.xpath(elementId)).getText();
            else
            email =   driver.findElement(By.id(elementId)).getText();

            System.out.println(email);
            String EMAIL_PATTERN = "^[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }catch (Exception e) {
            System.out.println("element not found exception");
        }

        return false;
    }


}




