package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ManageCusBank {
    WebDriver driver = null;
    String projectPath = System.getProperty("user.dir");

    @Given("user is on manager page")
    public void user_is_on_manager_page() {
        System.out.println("hello ....");
        System.setProperty("Webdriver.chrome.driver", projectPath + "/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

    }

    //Verify manage page
    @Given("verify manage page")
    public void verify_manage_page() throws Throwable {
        //Verify url
        String manageCusPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(manageCusPageUrl, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        //Verify title
        String manageCusPageTitle = driver.getTitle();
        Assert.assertEquals(manageCusPageTitle, "XYZ Bank");
        Thread.sleep(2*1000);
    }
    @Given("user login successfully")
    public void user_login_successfully() throws Throwable {
        user_is_on_manager_page();
        verify_manage_page();
        user_click_on_customer_login_button();
        select_account();
        click_on_login_button();
    }
    @When("user click on Customer Login button")
    public void user_click_on_customer_login_button() throws Throwable{
        driver.findElement(By.xpath("//button[contains(text(),'Customer Login')]")).click();
        Thread.sleep(2*1000);
    }
    @When("select <account>")
    public void select_account(){
        driver.findElement(By.id("userSelect")).click();
        driver.findElement(By.xpath("//*[@id=\"userSelect\"]/option[2]")).click();
    }

    @And("click on Login button")
    public void click_on_login_button() throws Throwable {
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Thread.sleep(2*1000);
    }

    // Deposit amount

    @When("^user input valid (.+) into amount field on Deposit$")
    public void user_input_valid_into_amount_field_on_deposit(String data) throws Throwable {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(data);
        Thread.sleep(2*1000);

    }
    @When("^input invalid (.+) into amount field$")
    public void input_invalid_into_amount_field(String data) throws Throwable{
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(data);
        Thread.sleep(2*2000);
    }
    // leave blank
    @And("user click on Deposit button")
    public void user_click_on_Deposit_button(){
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/button[2]")).click();
    }
    @And("click on Deposit button")
    public void click_on_Deposit_button() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/form/button")).click();
    }
    // Balance equal zero

    @When("input Amount more than Balance")
    public void input_Amount_more_than_Balance(){
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/form/div/input")).sendKeys("10000");
    }
    @When("input valid Amount to be Withdrawn")
    public void input_valid_Amount_to_be_Withdrawn(){
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/form/div/input")).sendKeys("2000");
    }

    @When("^input (.+) invalid Amount to be Withdrawn$")
    public void input_invalid_amount_to_be_withdrawn(String data) throws Throwable {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(data);
        Thread.sleep(2*2000);
    }
    @When("user click on Withdrawl button")
    public void user_click_on_Withdrawl_button(){
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/button[3]")).click();
    }
    @And("click on Withdrawl button")
    public void click_on_Withdrawl_button() throws Throwable{
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/form/button")).click();
        Thread.sleep(2*2000);
    }
    // navigate to the transactions page
    @When("click on Transactions button")
    public void click_on_Transactions_button() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/button[1]")).click();
        Thread.sleep(2*2000);
    }
    @When("filter data")
    public void filter_data() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/table/thead/tr/td[1]/a")).click();
        Thread.sleep(2*1000);
    }
    @When("click on reset button")
    public void click_on_reset_button() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/button[2]")).click();
        Thread.sleep(2*2000);
    }
    @When("click on back button")
    public void click_on_back_button() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/button[1]")).click();
        Thread.sleep(2*1000);
    }
    // Logout
    @When("click on Logout button")
    public void click_on_Logout_button(){
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/button[2]")).click();
    }
    @Then("message is display")
    public void message_is_display() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        System.out.println("Successfully excution");
    }
}
