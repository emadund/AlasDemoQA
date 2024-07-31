package page;

import base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BaseClass {

    @FindBy (id="APjFqb")
    WebElement googleSearch;



    public GooglePage () {
        PageFactory.initElements(driver, this);
    }

    public void searchForText (String text) {
        fillTextElement(googleSearch, text);
        googleSearch.sendKeys(Keys.ENTER);
    }


}
