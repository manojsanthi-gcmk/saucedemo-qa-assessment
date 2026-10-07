package com.playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.regex.Pattern;


public class SauceDemo {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")
				
				);
		Page page = browser.newPage();
		
		page.navigate("https://www.saucedemo.com/");
		page.locator("#user-name").fill("standard_user");
		page.locator("#password").fill("secret_sauce");
		page.locator("#login-button").click();
		
		
		
		assertThat(page).hasURL(Pattern.compile(".*inventory.html*."));
		
		System.out.println("login sucessfully");
		
		
		
		page.locator("//button[@data-test='add-to-cart-sauce-labs-backpack']").click();
		
		assertThat(page.locator("(//div[@class='inventory_item_name '])[1]")).hasText("Sauce Labs Backpack");
		
		assertThat(page.locator("//span[@class='shopping_cart_badge']")).hasCount(1);
		
		
		page.locator("#shopping_cart_container").click();
		
		page.locator("#checkout").click();
		
		page.locator("#first-name").fill("Manoj");
		page.locator("#last-name").fill("kumar");
		
		page.locator("#postal-code").fill("600097");
		
		page.locator("#continue").click();
		
		page.locator("#finish").click();
		
		assertThat(page.locator("//h2[@class='complete-header']")).hasText("Thank you for your order!");
		
		String ordermessage = page.locator("//h2[@class='complete-header']").innerText();
		
		System.out.println(ordermessage);
		
		
		
		
		
		browser.close();
		playwright.close();
		
		
		

	}

}
