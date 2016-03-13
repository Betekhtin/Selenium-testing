import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.dom.OnElement;

public class GitHubTesting {

    WebDriver driver = new FirefoxDriver();
    @Test
    public void wrongUsernameOrPasswordTest() {

        driver.manage().window().maximize();
        driver.get("https://github.com/login");

        //testing incorrect sign in message
        WebElement loginField = driver.findElement(By.id("login_field"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement signInButton = driver.findElement(By.cssSelector(".btn"));

        passwordField.sendKeys("Incorrect password");
        loginField.sendKeys("Incorrect login");
        signInButton.click();

        String check = "Incorrect username or password.";
        WebElement errorMessage = driver.findElement(By.cssSelector("#js-flash-container .container"));

        Assert.assertEquals(check, errorMessage.getText(), "Unexpected error message.");
    }

    @Test
    public void incorrectSearch() {

        driver.manage().window().maximize();
        driver.get("https://github.com/join");

        //testing search message
        WebElement searchField = driver.findElement(By.className("js-site-search-focus"));
        searchField.clear();

        String check = "We couldn’t find any repositories matching 'Unexisting repository'";
        searchField.sendKeys("Unexisting repository");
        searchField.sendKeys(Keys.ENTER);

        WebElement searchResults = driver.findElement(By.cssSelector(".blankslate h3"));
        Assert.assertEquals(check, searchResults.getText(), "Unexpected search results.");
    }


    @Test
    public void incorrectSignUp(){
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        String error;
        WebElement content = driver.findElement(By.className("marketing-section-signup"));


        //testing username field message
        WebElement usernameField = driver.findElement(By.name("user[login]"));
        usernameField.sendKeys("Incorrect username");
        content.click();
        error = "Username may only contain alphanumeric characters or single hyphens, and cannot begin or end with a hyphen";
        Assert.assertEquals(driver.findElement(By.className("error")).getText(), error, "Wrong message for incorrect username");
        usernameField.clear();

        //testing email field message
        WebElement emailField = driver.findElement(By.name("user[email]"));
        emailField.sendKeys("Incorrect email");
        error = "Email is invalid or already taken";
        content.click();
        Assert.assertEquals(driver.findElement(By.className("error")).getText(), error, "Wrong message for incorrect email");
        emailField.clear();

        //Password
        WebElement passwordField = driver.findElement(By.name("user[password]"));

        //testing short password message
        passwordField.sendKeys("short");
        error = "Password is too short (minimum is 7 characters) and needs at least one number";
        content.click();
        Assert.assertEquals(driver.findElement(By.className("error")).getText(), error, "Wrong message for short password");
        passwordField.clear();

        //testing lowcase letter message
        passwordField.sendKeys("12345678");
        error = "Password needs at least one lowercase letter";
        content.click();
        Assert.assertEquals(driver.findElement(By.className("error")).getText(), error, "Wrong message for password without lowcase letters");
        passwordField.clear();
    }
}

