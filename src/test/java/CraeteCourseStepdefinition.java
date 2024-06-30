import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CraeteCourseStepdefinition {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("^User open (.*)$")
    public void goToWebsite(String link) {
        driver.navigate().to(link);



    }

    @And("^User enter (.*) and (.*)$")
    public void enterEmailAndPassword(String email, String password) {
        driver.navigate().to("https://swinji.azurewebsites.net");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("inputPassword")).sendKeys(password);
        driver.findElement(By.id("inputPassword")).submit();

    }

    @And("Open Courses Page")
    public void OpenCoursesPage() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("btnMyCoursesList")).click();

    }

    @When("^User Click on Add Course Button And Enter \"(.*)\" as the name, \"(.*)\" as Year and \"(.*)\" as Teacher of course$")
    public void addCourse(String courseName, String year, String teacherName) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("btnMyCoursesList")).click();

        Select select=new Select(driver.findElement(By.id("txtCourseName")));

        driver.findElement(By.id("btnListAddCourse")).click();
        driver.findElement(By.id("txtCourseName")).sendKeys("Maths");
        select.selectByVisibleText("3");
        driver.findElement(By.cssSelector("h5[title=\"Test Teacher\"]")).click();
    }

    @And("User click create")
    public void ClickCreate() throws InterruptedException {

        driver.findElement(By.id("btnSaveAsDraftCourse")).click();

    }
   @Then("Course should be appear in courses List")
   public void AppearCourse(){

   }
    @After
    public void Down() {
      //  driver.quit();
    }
}