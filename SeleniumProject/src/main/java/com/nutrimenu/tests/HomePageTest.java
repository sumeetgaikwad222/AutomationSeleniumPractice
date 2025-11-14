package com.nutrimenu.tests;

import com.nutrimenu.base.BaseTest;
import com.nutrimenu.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * HOME PAGE TEST CLASS
 * This contains actual tests
 * It extends BaseTest (inherits browser open/close)
 */
public class HomePageTest extends BaseTest {
    
    /**
     * TEST 1: Check if home page opens
     */
    @Test(priority = 1)
    public void test1_CheckHomePageOpens() {
        System.out.println("\n===== TEST 1: Check Home Page Opens =====");
        
        // Step 1: Create HomePage object
        HomePage homePage = new HomePage(driver);
        
        // Step 2: Get page title
        String title = homePage.getTitle();
        System.out.println("Page Title: " + title);
        
        // Step 3: Verify title is not empty
        Assert.assertFalse(title.isEmpty(), "Title should not be empty");
        
        System.out.println("✓ Test Passed: Home page opened successfully");
    }
    
    /**
     * TEST 2: Check if search box exists
     */
    @Test(priority = 2)
    public void test2_CheckSearchBox() {
        System.out.println("\n===== TEST 2: Check Search Box =====");
        
        // Step 1: Create HomePage object
        HomePage homePage = new HomePage(driver);
        
        // Step 2: Check if search box is visible
        boolean isVisible = homePage.isSearchBoxVisible();
        System.out.println("Search box visible: " + isVisible);
        
        // Step 3: Verify search box is visible
        Assert.assertTrue(isVisible, "Search box should be visible");
        
        System.out.println("✓ Test Passed: Search box is visible");
    }
    
    /**
     * TEST 3: Search for a food item
     */
    @Test(priority = 3)
    public void test3_SearchForFood() {
        System.out.println("\n===== TEST 3: Search for Food =====");
        
        // Step 1: Create HomePage object
        HomePage homePage = new HomePage(driver);
        
        // Step 2: Search for "apple"
        homePage.searchFood("Chole Bhature");
        
        // Step 3: Wait 2 seconds to see results
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("✓ Test Passed: Search executed");
    }
    
    /**
     * TEST 4: Click Login link
     */
   
    
    /**
     * TEST 5: Click Menu link
     */
    
}

/*
 * ===== HOW EVERYTHING CONNECTS =====
 * 
 * 1. @BeforeMethod in BaseTest runs → Opens browser
 * 2. test1_CheckHomePageOpens() runs
 *    - Creates HomePage object
 *    - Uses HomePage methods
 * 3. @AfterMethod in BaseTest runs → Closes browser
 * 
 * 4. @BeforeMethod runs again → Opens browser
 * 5. test2_CheckSearchBox() runs
 *    - Creates HomePage object
 *    - Uses HomePage methods
 * 6. @AfterMethod runs again → Closes browser
 * 
 * ...and so on for each test
 * 
 * ===== FLOW SUMMARY =====
 * BaseTest (Opens browser) 
 *    → HomePage (Finds elements & actions)
 *       → HomePageTest (Uses HomePage to test)
 *          → BaseTest (Closes browser)
 */