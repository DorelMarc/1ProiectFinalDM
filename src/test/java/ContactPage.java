import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactPage {
@Test
    public void contactPageTest(){
        //open page
        String url="https://practicesoftwaretesting.com/contact";
    WebDriver driver=new EdgeDriver();
    driver.get(url);
    driver.manage().window().maximize();
    //fill the form
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



    }

}
