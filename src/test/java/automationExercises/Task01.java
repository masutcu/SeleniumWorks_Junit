package automationExercises;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Task01 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //Verify that home page is visible successfully
        WebElement a = driver.findElement(By.xpath("//html"));
        assertTrue(a.isDisplayed());


        //Click on 'Signup / Login' button
        WebElement signUp = driver.findElement(By.xpath("//a[@href='/login']"));
        signUp.click();
        Thread.sleep(1000);

        //Verify 'New User Signup!' is visible
        WebElement signUpText =driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        assertTrue(signUpText.isDisplayed());

        //Enter name and email address
       WebElement name = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        name.sendKeys("user1");
        //WebElement name = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        //name.sendKeys("user");

        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("password1@gmail.com");

        //Click 'Signup' button
        WebElement signUpEnter = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpEnter.click();

        //Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement information =      driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(information.isDisplayed());

        //Fill details: Title, Name, Email, Password, Date of birth
        WebElement mr = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        if(!mr.isSelected())
            mr.click();

        WebElement name1 = driver.findElement(By.xpath("//input[@id='name']"));
        name1.clear();
        name1.sendKeys("mali");

        WebElement eMail = driver.findElement(By.xpath("//input[@data-qa='password']"));
        eMail.sendKeys("password1");


        WebElement date = driver.findElement(By.xpath("//select[@id='days']"));
        Select date1=new Select(date);
        date1.selectByValue("11");

        WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
        Select month1=new Select(month);
        month1.selectByValue("3");

        WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
        Select year1=new Select(year);
        year1.selectByVisibleText("1979");
        Thread.sleep(1000);


        //Select checkbox 'Sign up for our newsletter!'
        WebElement check =driver.findElement(By.xpath("//label[@for='newsletter']"));
        if(!check.isSelected())
            check.click();
        Thread.sleep(1000);

        //           Select checkbox 'Receive special offers from our partners!'
        WebElement check1 =driver.findElement(By.xpath("//label[@for='optin']"));
        if(!check1.isSelected())
            check1.click();

        Thread.sleep(2000);

//           12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName =driver.findElement(By.xpath("//input[@id='first_name']"));
        firstName.sendKeys("mali");

        WebElement lastName =driver.findElement(By.xpath("//input[@id='last_name']"));
        lastName.sendKeys("sutcu");

        WebElement company =driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("userogluAS");

        WebElement address1 =driver.findElement(By.xpath("//input[@id='address1']"));
        address1.sendKeys("beylikdüzü");

        WebElement address2 =driver.findElement(By.xpath("//input[@id='address2']"));
        address2.sendKeys("istanbul");

        WebElement country =driver.findElement(By.xpath("//select[@id='country']"));
        Select tr=new Select(country);
        country.sendKeys("Turkiye");

        //State, City, Zipcode, Mobile Number
        WebElement state=driver.findElement(By.xpath("//input[@id='state']"));
        state.sendKeys("ankara");

        WebElement city=driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys("angara");

        WebElement zip=driver.findElement(By.xpath("//input[@id='zipcode']"));
        zip.sendKeys("061525");

        WebElement tel=driver.findElement(By.xpath("//input[@id='mobile_number']"));
        tel.sendKeys("5525252321");
        Thread.sleep(1000);

//           13. Click 'Create Account button'
        WebElement createAButton=driver.findElement(By.cssSelector("button[data-qa='create-account']"));
        createAButton.click();


//           14. Verify that 'ACCOUNT CREATED!' is visible
//h2[@data-qa='account-created']
        WebElement accountIs=driver.findElement(By.xpath("//h2[@data-qa='account-created']"));
        assertTrue(accountIs.isDisplayed());

//           15. Click 'Continue' button
        WebElement continueB=driver.findElement(By.xpath("//a[text()='Continue']"));
        continueB.click();
        Thread.sleep(1000);
       //Task de yok açılan pencereyi kapatıyoruz
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();


//           16. Verify that 'Logged in as username' is visible
        WebElement loggedAs=driver.findElement(By.xpath("//a[text()=' Logged in as '] "));
        Assert.assertTrue(loggedAs.isDisplayed());

        // DİKKAT : 2. Task de açılmış hesap olması gerektiği için 17 ve 18. adım kapatıldı
//           17. Click 'Delete Account' button
        //WebElement deleteAccount=driver.findElement(By.xpath("//a[text()=' Delete Account'] "));
        //deleteAccount.click();
//      //     18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        //WebElement accDeleted=driver.findElement(By.xpath("//b[text()='Account Deleted!'] "));
        //Assert.assertTrue(accDeleted.isDisplayed());
      }







    }
