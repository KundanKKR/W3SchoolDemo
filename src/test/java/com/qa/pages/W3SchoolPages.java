package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3SchoolPages
{
	WebDriver driver;
	public W3SchoolPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*@FindBy(id="navbtn_tutorials")
	WebElement tutorialsSection;
	public WebElement getTutorialsSection()
	{
		return tutorialsSection;
	}*/
	
	/*@FindBy(xpath="//a[@class=\"w3-bar-item w3-button\"][text()='Learn JavaScript']")
	WebElement learnJS;
	public WebElement getLearnJS()
	{
		return learnJS;
	}*/
	
	@FindBy(xpath="//a[@class='w3-button w3-block tut-button'][text()='Learn JavaScript']")
	WebElement learnJS;
	public WebElement getLearnJS()
	{
		return learnJS;
	}
	
	@FindBy(xpath="//a[@title='Search W3Schools']")
	WebElement searchBtn;
	public WebElement getSearchBtn()
	{
		return searchBtn;
	}
	
	@FindBy(id="gsc-i-id1")
	WebElement searchTxtBox;
	public WebElement getSearchTxtBox()
	{
		return searchTxtBox;
	}
	
	@FindBy(xpath="//button[@class='gsc-search-button gsc-search-button-v2']")
	WebElement googleSearchBtn;
	public WebElement getGoogleSearchBtn()
	{
		return googleSearchBtn;
	}

	@FindAll(@FindBy(xpath="//*[@class='gsc-thumbnail-inside']/div/a"))
	List<WebElement> allJSOptions;
	public List<WebElement> getAllJSOptions()
	{
		return allJSOptions;
	}
	
	@FindBy(xpath="//div[@id='main']/div[2]/a[1]")
	WebElement tryYourself1;
	public WebElement getTryYourself1()
	{
		return tryYourself1;
	}
	
	@FindBy(id="iframeResult")
	WebElement iframe;
	public WebElement getIframe()
	{
		return iframe;
	}
	
	@FindBy(xpath="//button[text()='Try it']")
	WebElement tryIt;
	public WebElement getTryIt()
	{
		return tryIt;
	}
	
	@FindBy(xpath="//a[@class='w3-button w3-bar-item topnav-icons fa fa-adjust']")
	WebElement changeTheme;
	public WebElement getChangeTheme()
	{
		return changeTheme;
	}
	
	@FindBy(xpath="//div[@class='gsc-results-close-btn gsc-results-close-btn-visible']")
	WebElement close;
	public WebElement getClose()
	{
		return close;
	}
}
