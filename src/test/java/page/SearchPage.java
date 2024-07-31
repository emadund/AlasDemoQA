package page;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SearchPage extends BaseClass {
    @FindBy (css = ".LC20lb.MBeuO.DKV0Md")
    WebElement search;
    @FindBy (id = "result-stats")
    WebElement cheeseNumberResults;
    @FindBy (id="hdtb-tls")
    WebElement tools;

    public SearchPage () {
        PageFactory.initElements(driver, this);
    }

    public void clickOnFirst () {
         clickOnElement(search);
    }
    public int getCheeseNumberResults () {     // Extracting integer number out of long string
        String source= cheeseNumberResults.getText();
        String pom = source.substring(0,25);
        return Integer.parseInt(pom.replaceAll("[^0-9]",""));
    }
public void clickOnTools () {
        clickOnElement(tools);
}
}
