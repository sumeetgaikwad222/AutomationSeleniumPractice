package com.nutrimenu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * HOME PAGE CLASS
 * This class represents the Home Page of Nutri Menu website
 * It contains all elements and actions you can do on home page
 */
public class HomePage {
    
    // WebDriver reference
    private WebDriver driver;
    
    // ====== FINDING ELEMENTS ON PAGE ======
    // @FindBy = Find element by ID, Name, XPath, etc.
    
    @FindBy(xpath = "//span[@class='ant-input-affix-wrapper css-dev-only-do-not-override-1ohd0t2 ant-input-outlined w-44 h-10 rounded-lg border-2 border-gray-300']//input[@type='text']")  // Find search box by ID
    private WebElement searchBox;
    
    @FindBy(xpath = "//button//span[contains(text(),'Apply')]")  // Find button by XPath
    private WebElement searchButton;
    
   
    @FindBy(xpath = "//button//span[contains(text(),'Reset')]")  // Find link with text "Sign Up"
    private WebElement signUpLink;
    
    
    
    // ====== CONSTRUCTOR ======
    // Constructor runs when you create: new HomePage(driver)
    public HomePage(WebDriver driver) {
        this.driver = driver;
        // PageFactory helps find all @FindBy elements
        PageFactory.initElements(driver, this);
    }
    
    
    // ====== ACTIONS YOU CAN DO ON HOME PAGE ======
    
    /**
     * Type something in search box
     */
    public void typeInSearch(String text) {
        searchBox.clear();  // Clear old text
        searchBox.sendKeys(text);  // Type new text
        System.out.println("Typed in search: " + text);
    }
    
    /**
     * Click search button
     */
    public void clickSearchButton() {
        searchButton.click();
        System.out.println("Clicked search button");
    }
    
    /**
     * Search for food (Type + Click)
     */
    public void searchFood(String foodName) {
        typeInSearch(foodName);
        clickSearchButton();
        System.out.println("Searched for: " + foodName);
    }
    
    /**
     * Click Login link
     */
   
    
    /**
     * Click Sign Up link
     */
    public void clickSignUp() {
        signUpLink.click();
        System.out.println("Clicked Sign Up");
    }
    
    /**
     * Click Menu link
     */
    /**
     * Check if search box is visible
     */
    public boolean isSearchBoxVisible() {
        try {
            return searchBox.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Get page title
     */
    public String getTitle() {
        return driver.getTitle();
    }
}

/*
 * HOW TO USE THIS CLASS:
 * 
 * 1. Create object: HomePage homePage = new HomePage(driver);
 * 2. Use methods: homePage.searchFood("apple");
 * 3. Use methods: homePage.clickLogin();
 */