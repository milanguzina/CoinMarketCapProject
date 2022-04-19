package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import resources.BaseHelper;

import java.time.Duration;
import java.util.List;

public class HomePage extends BaseHelper {

    @FindBy(xpath ="//span[contains(text(),'Cryptocurrencies')]")
    WebElement cryptCurrDropDown;
    @FindBy(xpath = "//div/a[contains(text(),'Ranking')]")
    WebElement rankingOption;
    @FindBy(xpath ="//button[contains(text(),'Log in')]")
    WebElement loginButton;
    @FindBy(xpath ="//input[@type='email']")
    WebElement emailTextbox;
    @FindBy(xpath ="///input[@type='password']")
    WebElement passwordTextbox;
    @FindBy(xpath ="//button[contains(text(),'Log in')]")
    WebElement logInConfirmButton;
    @FindBy(xpath ="//button[contains(text(),'Filters')]")
    WebElement filtersButton;
    @FindBy(xpath ="//button[contains(text(),'1 More Filters')]")
    WebElement moreFilterButton;
    @FindBy(xpath ="//tbody/tr[1]/td[1]/span[1]/span[1]")
    WebElement starButton1;
    @FindBy(xpath ="//tbody/tr[3]/td[1]/span[1]/span[1]")
    WebElement starButton3;
    @FindBy(xpath ="//span[contains(text(),'Watch List')]")
    WebElement watchListButton;
    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[3]/div[1]/div[1]")
    WebElement showRowsDropdown;



    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private void clickOnLogInButton(){ loginButton.click();}

    private void enterEmail(String email){ emailTextbox.sendKeys(email);}

    private void enterPassword(String password){ passwordTextbox.sendKeys(password);}

    private void clickOnLogInConfirmationButton(){logInConfirmButton.click();}

    public void logIN(String email, String password){
       clickOnLogInButton();
       enterEmail(email);
       enterPassword(password);
       clickOnLogInConfirmationButton();
    }

    public void clickOnFiltersButton(){filtersButton.click(); }

    public void clickOnShowRowsDropdown(){
        wait.until(ExpectedConditions.elementToBeClickable(showRowsDropdown)) ;
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",showRowsDropdown);
        js.executeScript("arguments[0].click();",showRowsDropdown);
    }

    public void chooseOptionFromShowRowsDropdown() {

        List<WebElement> rowsNumberOptions = driver.findElements(By.className("bnhhNH"));
        for (WebElement option:rowsNumberOptions){
            wait.until(ExpectedConditions.elementToBeClickable(option));
            if(option.getText().contains("100")){
                option.click();
            }
        }

    }

    public void clickOnMoreFilterButton(){moreFilterButton.click();}

    public void clicksOnPriceOption(){
        WebElement priceFilterOption= driver.findElement(By.xpath("//button[contains(text(),'Price')]"));
        priceFilterOption.click();
    }

    public void enterLowerSum(int lowerSum){
        WebElement lowerSumTextbox = driver.findElement(By.xpath("//input[@placeholder='$0']"));
        lowerSumTextbox.sendKeys(String.valueOf(lowerSum));
    }

    public void enterHigherSum(int higherSum){
        WebElement higherSumTextbox = driver.findElement(By.xpath("//input[@placeholder='$99999']"));
        higherSumTextbox.sendKeys(String.valueOf(higherSum));
    }

    public void clickOnApplyFilterButton(){
        WebElement applyFilterButton= driver.findElement(By.xpath("//button[contains(text(),'Apply Filter')]"));
        applyFilterButton.click();
    }

    public void clickOnShowResultsButton(){
        WebElement showResultsButton= driver.findElement(By.xpath("//button[contains(text(),'Show Results')]"));
        showResultsButton.click();
    }

    public void clickOnStarButtons(){
        starButton1.click();
        starButton3.click();
    }

    public void clickOnWatchListButton(){watchListButton.click();}

    public void hoversOnCryptCurrDropDown(){
        Actions a = new Actions(driver);
        a.moveToElement(cryptCurrDropDown).build().perform();
    }

    public void clickOnRankingOption(){
        rankingOption.click();}

    public int getSearchResults (){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody/tr")));
        List<WebElement> currencyList = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("Cryptocurrency list size is: " + currencyList.size());
        return currencyList.size();
    }

    public  void getCurrencyPrice() {
        List<WebElement> currencyList = driver.findElements(By.xpath("//tbody/tr"));
        for (WebElement currency : currencyList) {
            String currencyPriceString = currency.findElement(By.className("cmc-link")).getText();
            int currencyPriceInt = Integer.parseInt(currencyPriceString.trim());
            System.out.println(currencyPriceInt);
        }
    }

}
