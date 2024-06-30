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
import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class CraeteCourseStepdefinition {
    WebDriver driver;
    String course;

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

        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("inputPassword")).sendKeys(password);
        driver.findElement(By.id("inputPassword")).submit();

    }

    @And("Open Courses Page")
    public void OpenCoursesPage() throws InterruptedException {
        driver.findElement(By.id("btnMyCoursesList")).click();

    }

    @When("^User Click on Add Course Button And Enter \"(.*)\" as the name, \"(.*)\" as Year and \"(.*)\" as Teacher of course$")
    public void addCourse(String courseName, String year, String teacherName) throws InterruptedException {
        course = courseName ;
        Thread.sleep(2000);
        driver.findElement(By.id("btnListAddCourse")).click();
       WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("courseGrade")));

        Select select=new Select(driver.findElement(By.id("courseGrade")));


        driver.findElement(By.id("txtCourseName")).sendKeys(courseName);
        select.selectByVisibleText(year);
        driver.findElement(By.id("teacherOnBehalf")).click();
        driver.findElement(By.cssSelector("h5[title=\"" + teacherName +"\"]")).click();
    }

    @And("User click create")
    public void ClickCreate() throws InterruptedException {

        driver.findElement(By.id("btnSaveAsDraftCourse")).click();

    }
   @Then("Course should be appear in courses List")
   public void AppearCourse() throws InterruptedException {
        Thread.sleep(2000);
       String courseName = driver.findElement(By.id("courseNameView")).getText();
       assertTrue(courseName.contains(course), "Course Not Added");



   }
    @After
    public void Down() {
      driver.quit();
    }
}