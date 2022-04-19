package stepDefinitions;

import PageObjects.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.BaseHelper;

import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class stepDefinitions extends BaseHelper {
    WebDriver driver;
    HomePage hp;
   // WebDriverWait wait;

    @Before

    public void before() throws IOException {

        initializeDriver();
        hp= new HomePage(driver);
       // wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }
    @Given("^Navigated to Home Page (.+)")
    public void navigatedToHomePageUrl(String url) {driver.get(url);  }

    @And("Logged in with (.+) and (.+)")
    public void loggedInWithEmailAndPassword(String email,String password) {
       hp.logIN(email,password);
    }

    @When("Hovers on CryptoCurrencies dropdown")
    public void hovers_on_CryptoCurrencies_dropdown() {hp.hoversOnCryptCurrDropDown();  }

    @When("Clicks on Filters button")
    public void clicksOnFiltersButton() {hp.clickOnFiltersButton();}

    @And("Clicks on Ranking dropdown option")
    public void clicks_on_Ranking_dropdown_option() {
        hp.clickOnRankingOption();
    }

    @And("Clicks on Show rows dropdown")
    public void clicksOnShowRowsDropdown() { hp.clickOnShowRowsDropdown();  }

    @And("Clicks on {int} option from the Show rows dropdown")
    public void clicksOnOptionFromTheShowRowsDropdown(int arg0) {hp.chooseOptionFromShowRowsDropdown();  }

    @And("Clicks on More Filter button")
    public void clicksOnMoreFilterButton() {hp.clickOnMoreFilterButton();}

    @And("Clicks on Price option in the popup menu")
    public void clicksOnPriceOptionInThePopupMenu() {hp.clicksOnPriceOption();}

    @And("Enters {int} in the left price text box")
    public void entersInTheLeftPriceTextBox(int arg1) {hp.enterLowerSum(arg1);}

    @And("Enters {int} in the right price text box")
    public void entersInTheRightPriceTextBox(int arg1) {hp.enterHigherSum(arg1);}

    @And("Clicks on Apply Filter button")
    public void clicksOnApplyFilterButton() {hp.clickOnApplyFilterButton(); }

    @And("Clicks on Show Results button")
    public void clicksOnShowResultsButton() {hp.clickOnShowResultsButton(); }

    @And("Clicks on the chosen star buttons")
    public void clicksOnTheChosenStarButtons() {hp.clickOnStarButtons();  }

    @And("Clicks on Watch List button")
    public void clicksOnWatchListButton() {hp.clickOnWatchListButton(); }

    @Then("Verify correct search results")
    public void verify_correct_search_results() {
        Assert.assertEquals("Search criteria does not match",hp.getSearchResults(),100);
    }

    @Then("Verify chosen Cryptocurrencies are in Watch List")
    public void verifyChosenCryptocurrenciesAreInWatchList() {
       // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("")));
        List<WebElement> watchList = driver.findElements(By.xpath(""));
        for(WebElement currency:watchList) {
            Assert.assertTrue("", currency.isDisplayed());
            Assert.assertTrue("",driver.findElement(By.xpath("")).isSelected());
        }
    }

    @After

    public void after() {
        driver.close();
        driver.quit();
    }



}
