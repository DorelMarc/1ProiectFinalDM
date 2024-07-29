import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddProductToCart {
    String url = "https://practicesoftwaretesting.com";
    WebDriver driver;
    @BeforeTest
    public void setUp () {
        driver= new EdgeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }
    @Test
    public void addToCartTest(){
       //open the product page
        WebElement openthepage=driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[2]/div[2]/h5"));
        openthepage.click();
        // add to cart
        Wait<WebDriver> wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButton= driver.findElement(By.xpath("//*[@id=\"btn-add-to-cart\"]"));
        addToCartButton.click();

    }
}
