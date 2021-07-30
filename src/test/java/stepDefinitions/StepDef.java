package stepDefinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.awt.*;
import static java.lang.Thread.sleep;


public class StepDef {
    WebDriver driver;

    @Given("I launch Chrome browser")
    public void iLaunchChromeBrowser() {
        // To replace the chrome driver path with your local machine chrome driver path before Test execution
    System.setProperty("webdriver.chrome.driver","C:\\Rekha\\driver\\chromedriver.exe");
        driver= new ChromeDriver();
    }

    @When("I open the Collective Staging URL")
    public void iOpenTheCollectiveStagingUrl() throws InterruptedException {

       driver.get("https://staging.thecollective.com/");
       driver.manage().window().maximize();
        sleep(1000);
    }

    @Then("I verify the Collective logo is present on the home page")
    public void iVerifyTheCollectiveLogoIsPresentOnTheHomePage() {

      boolean status1= driver.findElement(By.cssSelector("#__layout > div > div:nth-child(3) > header > div > div > div > div > a.main-header__branding.nuxt-link-exact-active.nuxt-link-active > span > img:nth-child(1)")).isDisplayed();
        Assert.assertEquals(true,status1);
    }

    @Then("I verify Book now exist")
    public void iVerifyLocationsExist() {
        boolean status= driver.findElement(By.cssSelector("#__layout > div > div:nth-child(3) > header > div > div > div > nav > button")).isDisplayed();
        Assert.assertEquals(true,status);

    }

    @And("close browser")
    public void closeBrowser() {
    driver.quit();

    }

    @And("click on Book now button")
    public void clickOnBookNowButton() {
        driver.findElement(By.cssSelector("#__layout > div > div:nth-child(3) > header > div > div > div > nav > button")).click();
    }

    @Then("I verify {string} item is highlighted")
    public void iVerifyItemIsHighlighted(String arg0) throws InterruptedException {
        sleep(2000);
       boolean status= driver.findElement(By.xpath("//*[@class='booking-nav-item active']")).isEnabled();
               Assert.assertEquals(true,status);
    }

    @And("Location is selected as {string}")
    public void locationIsSelectedAs(String location) throws InterruptedException {
        sleep(2000);
         String sel = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/input")).getText();
         sel.indexOf(1);


    }

    @And("click on {string} button")
    public void clickOnButton(String text) throws InterruptedException {
        sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"booking\"]/div/div[2]/div[2]/div[2]/form/div[2]/button")).click();
    }

    @Then("I verify Home page is navigated to {string}")
    public void iVerifyHomePageIsNavigatedTo(String navigatedUrl) {
        driver.get(navigatedUrl);
        try{
            Assert.assertEquals(navigatedUrl, driver.getCurrentUrl());
        }
        catch(Throwable pageNavigationError){
            System.out.println("Didn't navigate to correct webpage");
        }

    }

    @And("Location field is unselected")
    public void locationFieldIsUnselected() throws AWTException, InterruptedException {
        Thread.sleep(2000);
        //Initializing Actions class
        Actions act = new Actions(driver);
        WebElement btnElement;
        //Locate WebElement to perform double click
        btnElement = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/input"));
        //Double Click the button
        act.doubleClick(btnElement).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div/button")).click();
    }

    @Then("{string} error message is thrown")
    public void errorMessageIsThrown(String errormessage) throws InterruptedException{
        Thread.sleep(2000);
        String select = driver.findElement(By.className("error-message")).getText();
        select.compareTo(errormessage);
    }

    @Then("I verify {string} exist")
    public void iVerifyExist(String signup) throws InterruptedException {
    Thread.sleep(2000);
        WebElement element = driver.findElement(By.cssSelector("#__layout > div > footer > section.newsletter-signup > div > div > div.text-center--mobile.text-center--tablet.col-10.offset-1.col-lg-3.offset-lg-0 > h2"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //This will scroll down the page until the desired element becomes visible
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    @And("I enter the {string} in the newsletter field")
    public void iEnterTheInTheNewsletterField(String email) {
        driver.findElement(By.id("field-email")).sendKeys(email);
    }

    @And("Click on submit button")
    public void clickOnSubmitButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/footer/section[1]/div/div/div[2]/form/div[2]/button")).submit();
    }

    @Then("verify {string} message is displayed")
    public void verifyMessageIsDisplayed(String str) throws InterruptedException {
        Thread.sleep(2000);
       boolean status = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/footer/section[1]/div/div/div/h2")).isDisplayed();
       Assert.assertEquals(true,status);
    }
}
