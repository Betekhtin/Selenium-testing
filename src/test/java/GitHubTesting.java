import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GitHubTesting {

    @Test
    public void wrongUsernameOrPasswordTest() {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/login");

        WebElement loginField = driver.findElement(By.id("login_field"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement signInButton = driver.findElement(By.cssSelector(".btn"));

        passwordField.sendKeys("Wrong password");
        loginField.sendKeys("Wrong login");
        signInButton.click();

        String check = "Incorrect username or password.";
        WebElement errorMessage = driver.findElement(By.cssSelector("#js-flash-container .container"));

        Assert.assertEquals(check, errorMessage.getText());
    }

    @Test
    public void incorrectSearch() {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/");

        WebElement searchField = driver.findElement(By.className("js-site-search-focus"));
        searchField.clear();
        String check = "We couldn’t find any repositories matching 'Unexisting repository'";
        searchField.sendKeys("Unexisting repository");
        searchField.sendKeys(Keys.ENTER);

        WebElement searchResults = driver.findElement(By.cssSelector(".blankslate h3"));
        Assert.assertEquals(check, searchResults.getText());
    }

}

