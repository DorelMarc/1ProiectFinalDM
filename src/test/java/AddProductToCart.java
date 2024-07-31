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
    public void addToCartTest() {
        //open product page
        Wait<WebDriver> waitproduct = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitproduct.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]")));
        WebElement productPage = driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]"));
        productPage.click();
        // add to cart
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-add-to-cart")));
        WebElement addToCartButton = driver.findElement(By.id("btn-add-to-cart"));
        addToCartButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"lblCartCount\"]")));
        WebElement cartNumber = driver.findElement(By.xpath("//*[@id=\"lblCartCount\"]"));
        String expectedCartNumber = "1";
        Assert.assertTrue(cartNumber.getText().contains(expectedCartNumber));
        // open cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a/fa-icon")));
        WebElement cartIcon = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a/fa-icon"));
        cartIcon.click();

        // Clear the cart
        Wait<WebDriver> wait3=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/table/tbody/tr/td[5]/a")));
        WebElement clearCart=driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/table/tbody/tr/td[5]/a"));
        clearCart.click();
        Wait<WebDriver> wait2= new WebDriverWait(driver, Duration.ofSeconds(20));
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"lblCartCount\"]")));
        Assert.assertFalse(cartIcon.isDisplayed());

    }
}
