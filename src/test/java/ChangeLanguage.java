import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChangeLanguage {
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
    public void changeLanguageTestES() {
        //ES Language
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"language\"]"));
        dropdown.click();
        WebElement esLanguage = driver.findElement(By.xpath("//*[@id=\"dropdown-animated\"]/li[3]"));
        esLanguage.click();
    }
    @Test
            public void changeLanguageTestDE() {
        // DE Language
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"language\"]"));
        dropdown.click();
        WebElement deLanguage = driver.findElement(By.xpath("//*[@id=\"dropdown-animated\"]/li[1]/a"));
        deLanguage.click();
    }
    @Test
    public void changeLanguageTestFR() {
        // FR Language
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"language\"]"));
        dropdown.click();
        WebElement frLanguage = driver.findElement(By.xpath("//*[@id=\"dropdown-animated\"]/li[4]/a"));
        frLanguage.click();
    }
    @Test
    public void changeLanguageTestNL(){
        //NL Language
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"language\"]"));
        dropdown.click();
        WebElement nlLanguage = driver.findElement(By.xpath("//*[@id=\"dropdown-animated\"]/li[5]/a"));
        nlLanguage.click();
    }
    @Test
    public void changeLanguageTestTR(){
        // TR Language
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"language\"]"));
        dropdown.click();
        WebElement trLanguage = driver.findElement(By.xpath("//*[@id=\"dropdown-animated\"]/li[6]/a"));
        trLanguage.click();
    }
driver.close();

}

