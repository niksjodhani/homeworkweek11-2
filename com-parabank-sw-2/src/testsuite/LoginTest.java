package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    @Before
    public void startup() {
        String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
        openbrowser(baseUrl);

    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        driver.findElement(By.xpath("//div[@class='login']//input[@name='username']")).sendKeys("Ramesh123");
        driver.findElement(By.xpath("//div[@class='login']//input[@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@class='button']")).click();

        // Verify the ‘Accounts Overview’ text is display
        String expectedresult = "Accounts Overview";
        WebElement acualresult1 = driver.findElement(By.xpath("//a[contains(text(),'Accounts Overview')]"));
        String acualresult = acualresult1.getText();
        Assert.assertEquals("not found it means you are not log in", expectedresult, acualresult);

    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.xpath("//div[@class='login']//input[@name='username']")).sendKeys("jRamesh001");
        driver.findElement(By.xpath("//div[@class='login']//input[@name='password']")).sendKeys("j123456");
        driver.findElement(By.xpath("//input[@class='button']")).click();

        // Verify the ‘Accounts Overview’ text is display
        String expectedresult = "The username and password could not be verified.";
        WebElement acualresult1 = driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
        String acualresult = acualresult1.getText();
        Assert.assertEquals("not found it means you are not ragister", expectedresult, acualresult);

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        driver.findElement(By.xpath("//div[@class='login']//input[@name='username']")).sendKeys("Ramesh123");
        driver.findElement(By.xpath("//div[@class='login']//input[@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@class='button']")).click();
        //logout click
        driver.findElement(By.xpath("//a[@href=\"/parabank/logout.htm\"]")).click();
        String expectedresult = "Customer Login";
        WebElement acual = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));

        String acualresult = acual.getText();
        Assert.assertEquals("you are not logout", expectedresult, acualresult);

    }

}
