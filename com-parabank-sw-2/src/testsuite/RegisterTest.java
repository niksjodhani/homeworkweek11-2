package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void startup() {

        openbrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        // this is move into Registerpage via xpath

        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();

//Verify the text ‘Signing up is easy!’
        String expectedresult = "Signing up is easy!";
        WebElement signingpage = driver.findElement(By.xpath("//h1[@class='title']"));
        String actualresult = signingpage.getText();
        Assert.assertEquals("user is not in signing page", expectedresult, actualresult);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // this is move into Registerpage via xpath
        //click on the ‘Register’ link
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        // Enter First name
        driver.findElement(By.id("customer.firstName")).sendKeys("Ramesh");
        //Enter Last name
        driver.findElement(By.id("customer.lastName")).sendKeys("kothari");
        //Enter Address
        driver.findElement(By.id("customer.address.street")).sendKeys("wembley");
        //  Enter City
        driver.findElement(By.id("customer.address.city")).sendKeys("london");
        //	* Enter State
        driver.findElement(By.id("customer.address.state")).sendKeys("United kingdom");
        //	* Enter Zip Code
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("HA96KC");
        //  * Enter Phone
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("07777788888");
        //  * Enter SSN
        driver.findElement(By.id("customer.ssn")).sendKeys("123456789");
        //  * Enter Username
        driver.findElement(By.id("customer.username")).sendKeys("Ramesh123");
        // * Enter Password
        driver.findElement(By.id("customer.password")).sendKeys("123456");
        //  * Enter Confirm
        driver.findElement(By.id("repeatedPassword")).sendKeys("123456");


        //  * Click on REGISTER button
        driver.findElement(By.xpath("//table[@class='form2']//input[@type='submit']")).click();
        //  * Verify the text 'Your account was created successfully. You are now logged in.’
        String expectedresult = "Your account was created successfully. You are now logged in.";
        WebElement actualresult1 = driver.findElement(By.xpath("//div[@id='rightPanel']/p"));
        String actulresult = actualresult1.getText();

        Assert.assertEquals("uesr is not registerd", expectedresult, actulresult);


    }


}