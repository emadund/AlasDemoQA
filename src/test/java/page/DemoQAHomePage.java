package page;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class DemoQAHomePage extends BaseClass {
    @FindBy (xpath = "(//*[@class=\"card mt-4 top-card\"])[5]")
    WebElement interactions;
    @FindBy (xpath="//*[contains(text(),\"Droppable\")]")
    WebElement droppable;
    @FindBy (id="draggable")
    WebElement source;
    @FindBy (id="droppable")
    WebElement destination;
    @FindBy (xpath = "(//*[@class=\"group-header\"])[4]")
    WebElement widgets;
    @FindBy (xpath = "//*[contains(text(),\"Tool Tips\")]")
    WebElement toolTips;
    @FindBy (id="toolTipButton")
    WebElement toolTipButton;
    @FindBy (css=".fade.show.tooltip.bs-tooltip-right")
    WebElement hoverShowed;

    public DemoQAHomePage () {
        PageFactory.initElements(driver, this);
    }

    public void clickOnInteractions () {
        clickOnElement(interactions);
    }
    public void clickOnDroppable () {
             try {
                 clickOnElement(droppable);
             }
             catch (Exception e) {
                 js.executeScript("window.scrollBy(0,100)");
                 clickOnElement(droppable);
             }
    }
    public void dragAndDropDropabble () {
        dragAndDrop(source, destination);
    }
    public String printDropabbleText() {
       return getTextFromElement(destination);
    }
    public void clickOnWidget () {
        clickOnElement(widgets);
    }
    public void clickOnToolTips () {   // for this element scrolling is needed
        js.executeScript("window.scrollBy(0,300)");
        clickOnElement(toolTips);
    }
    public void hoverOverToSee () {
        hoverOverElement(toolTipButton);
    }
    public void clickOnHover () {
        clickOnElement(toolTipButton);
    }
    public String getHoveredText () {
        return getTextFromElement(hoverShowed);
    }
    public boolean isHoveredTextShown () {
        return isElementDisplayed(hoverShowed);
    }

}
