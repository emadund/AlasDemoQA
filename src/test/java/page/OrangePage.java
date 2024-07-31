package page;

import base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;

public class OrangePage extends BaseClass {
    @FindBy (id = "left_menu_item_15")
    WebElement recruitment;
    @FindBy (css=".oxd-status-tab-panel-filter.--selected")
    WebElement candidates;
    @FindBy (id="btnLogin")
    WebElement login;
    @FindBy (css="[tooltip=\"Add Candidate\"]")
    WebElement addCandidate;
    @FindBy (id="addCandidateForm_firstName")
    WebElement firstName;
    @FindBy (id="addCandidateForm_lastName")
    WebElement lastName;
    @FindBy (id="addCandidateForm_email")
    WebElement email;
    @FindBy (css=".oxd-file-input")
    WebElement browse;
    @FindBy (xpath="(//*[@class=\"oxd-icon oxd-icon--medium bi-caret-down-fill\"])[1]")
    WebElement vacancy;
    @FindBy (xpath = "//*[contains(text(),\"Vacancy for Customer Support Specalist - USA\")]")
    WebElement menuitem;
    @FindBy (css="[type=\"submit\"]")
    WebElement submit;
    @FindBy (xpath ="(//*[@class='oxd-svg-icon oxd-svg-icon--xx-small oxd-checkbox-input-icon'])[1]" )
    WebElement firstCheckBox;
    @FindBy (xpath = "//*[contains(text(),'Delete Selected')]")
    WebElement deleteSelected;
    @FindBy (xpath = "//*[contains(text(),'log out')]")
    WebElement logout;
    @FindBy (css=".img-responsive")
    WebElement orange;

    public OrangePage () {
        PageFactory.initElements(driver, this);
    }

    public void clickOnRecruitment () {
        clickOnElement(recruitment);
    }

    public void clickOnCandidates () {
        clickOnElement(candidates);
    }

    public String getCandidatesText () {
        return  candidates.getText();
    }

    public void clickOnLogin () {
        clickOnElement(login);
    }

    public int getCandidatesNumber () {   // extracting number of String
        String source = this.getCandidatesText();
        StringBuilder num = new StringBuilder();
        for (int i=0; i<source.length(); i++) {
            if (Character.isDigit(source.charAt(i)))
            { num.append(source.charAt(i));
            }
        }
        return Integer.parseInt(String.valueOf(num));
    }
    public void clickOnAddCandidate () {
        clickOnElement(addCandidate);
    }

    public void fillFirstName () {
        LocalDate d1 = LocalDate.now();
        fillTextElement(firstName,("QA Automation - "+d1));
    }
    public void fillLastName () {
        LocalDate d1 = LocalDate.now();
        fillTextElement(lastName,("QA Automation - "+d1));
    }
    public void clickOnBrowse() {  // method for trying to upload file
        String path="D:\\Marko\\CV_Marko_Dunda.pdf";
        wdWait.until(ExpectedConditions.visibilityOf(browse));
        browse.sendKeys(path);

    }
    public void clickOnVacancy () {
        clickOnElement(vacancy);
    }
    public void clickOnMenuitem() {
        clickOnElement(menuitem);
    }
    public void clickOnSubmit () {
        clickOnElement(submit);
    }
    public void fillEmail() {
        fillTextElement(email,"dundaetf@gmail.com");
    }
    public void clickOnFirstCheckBox () {
        clickOnElement(firstCheckBox);
    }
    public void clickOnDeleteSelected() {
        clickOnElement(deleteSelected);
    }
    public void clickOnLogout () {
        clickOnElement(logout);
    }
    public boolean isOrangeVisible() {
        return orange.isDisplayed();
    }
}
