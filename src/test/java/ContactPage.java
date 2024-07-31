import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactPage {


    //open website page
    String url = "https://practicesoftwaretesting.com";
    WebDriver driver;
    @BeforeTest
    public void setUp () {
        driver= new EdgeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }
    @Test
    public void contactPageTest() {
        //go to the Contact Page
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a")));
        WebElement contactPage=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a"));
        contactPage.click();
    //fill the form
        Wait<WebDriver> wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));
        WebElement firstNameInput=driver.findElement(By.id("first_name"));
    firstNameInput.sendKeys("Dorel");
        WebElement lastNameInput=driver.findElement(By.id("last_name"));
    lastNameInput.sendKeys("Marc");
        WebElement emailInput=driver.findElement(By.id("email"));
    emailInput.sendKeys("dorel_marc@abc.com");
        WebElement dropDownSelect= driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-contact[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/select[1]"));
        Select option= new Select(dropDownSelect);
    option.selectByValue("status-of-order");
        WebElement optionSelected=driver.findElement(By.xpath("//*[@id=\"subject\"]/option[7]"));
        Assert.assertTrue(optionSelected.isSelected());
        WebElement messageInput=driver.findElement(By.id("message"));
    messageInput.sendKeys("I would like to know my order status. Order number is 9989989. Thank you! ");
        WebElement fileUploadButton= driver.findElement(By.xpath("//*[@id=\"attachment\"]"));
    fileUploadButton.sendKeys("C:\\Users\\admin\\IdeaProjects\\ProiectFinalDM\\src\\test\\resources\\ContactFormFile.txt");
        WebElement sendButton=driver.findElement(By.xpath("/html/body/app-root/div/app-contact/div/div/div/form/div/div[2]/div[4]/input"));
    sendButton.click();
    // Checking if the message has been sent
        Wait<WebDriver> wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root > div > app-contact > div > div > div > div")));
    WebElement message=driver.findElement(By.cssSelector("body > app-root > div > app-contact > div > div > div > div"));
    String expectedmessage="Thanks for your message! We will contact you shortly.";
    Assert.assertTrue(message.getText().contains(expectedmessage));

    }

}

