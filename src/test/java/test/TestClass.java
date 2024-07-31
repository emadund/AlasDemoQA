package test;

import base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import page.DemoQAHomePage;
import page.GooglePage;
import page.OrangePage;
import page.SearchPage;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class TestClass extends BaseClass {

    private GooglePage googlePage;
    private SearchPage searchPage;
    private DemoQAHomePage demoQAHomePage;
    private OrangePage orangePage;



    @Before
    public void prepare () {
        googlePage = new GooglePage();
        searchPage = new SearchPage();
        demoQAHomePage = new DemoQAHomePage();
        orangePage = new OrangePage();
    }

    @Test

    public void firstTest () throws Exception {

            googlePage.searchForText("demoqa.com");
            searchPage.clickOnFirst();
            demoQAHomePage.clickOnInteractions();
            demoQAHomePage.clickOnDroppable();
            Thread.sleep(1000);
            demoQAHomePage.dragAndDropDropabble();
            System.out.println(demoQAHomePage.printDropabbleText());
            printScreen(true);
            demoQAHomePage.clickOnWidget();
            demoQAHomePage.clickOnToolTips();
            demoQAHomePage.hoverOverToSee();
            demoQAHomePage.clickOnHover();
            try {
        Assert.assertTrue(demoQAHomePage.isHoveredTextShown());
        Assert.assertEquals(demoQAHomePage.getHoveredText(),"You hovered over the Button");
                printScreen(true);
        System.out.println(demoQAHomePage.getHoveredText()); }
            catch (Exception e) {
                e.printStackTrace();
                printScreen(false);
            }

    }

    @Test

    public void secondTest () throws Exception {

        googlePage.searchForText("cheese");
        searchPage.clickOnTools();
        System.out.println("Number of results is: "+searchPage.getCheeseNumberResults());
        Assert.assertEquals("There is too much cheese on the internet ", 777, searchPage.getCheeseNumberResults());
        }

    @Test

    public void thirdTest () throws Exception{
        driver.get("https://orangehrm-demo-7x.orangehrmlive.com/");
        Thread.sleep(5000);
        orangePage.clickOnLogin();
        Thread.sleep(13000);   // Long load, waiting needed
        orangePage.clickOnRecruitment();
        Thread.sleep(3000);
        orangePage.clickOnCandidates();
        printScreen(true);
        int i = orangePage.getCandidatesNumber();   // temporarly keeping number of candidates to compare later
        System.out.println("Number of candidates are: "+i);
        orangePage.clickOnAddCandidate();
        orangePage.clickOnVacancy();
        Thread.sleep(1000);
        orangePage.clickOnMenuitem();
        orangePage.fillLastName();
        orangePage.fillFirstName();
        orangePage.fillEmail();
        orangePage.clickOnBrowse();
        orangePage.clickOnSubmit();
        try {
            Assert.assertEquals(orangePage.getCandidatesNumber(), i + 1);    // Checking if number of candidates increased by 1
            System.out.println("Number of candidates increased by one");
            printScreen(true);
        }
        catch (Exception e) {
            Assert.assertEquals("Not increased by one",orangePage.getCandidatesNumber(), i + 1);
            printScreen(false);
        }
        orangePage.clickOnFirstCheckBox();
        orangePage.clickOnDeleteSelected();
        try {
            Assert.assertEquals(orangePage.getCandidatesNumber(), i);  // Checking if number of candidates restored
            System.out.println("Number of candidates restored");
            printScreen(true);
        }
        catch (Exception e) {
            Assert.assertEquals("Number of candidates didn't restore",orangePage.getCandidatesNumber(), i);
            printScreen(false);
        }
        orangePage.clickOnLogout();
        try {
            Assert.assertTrue( orangePage.isOrangeVisible());   // checking out if final logout is successful
        }
        catch (Exception e) {
            Assert.assertTrue("Logout not successfull", orangePage.isOrangeVisible());
            printScreen(false);
        }


    }

    private void printScreen (boolean t) throws IOException {       // Making printscreens. True parameter is for positive outcomes, false is for negative and bugs
        Date d1 = new Date ();
        String d2=d1.toString().replaceAll(":","_");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File scrFile = ts.getScreenshotAs(OutputType.FILE);
        if (t) {
        File destFile = new File("positivePrintScreens//screenShot_" + d2 + ".png");  // for positive outcomes it goes to one folder
            FileUtils.copyFile(scrFile, destFile);}
        else { File destFile = new File("bugScreenShots//screenShot_" + d2 + ".png"); // for negative it goes to other folder
            FileUtils.copyFile(scrFile, destFile);}

    }


}
