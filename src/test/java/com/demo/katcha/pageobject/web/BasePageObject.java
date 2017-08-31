package com.demo.katcha.pageobject.web;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.SkipException;

import com.demo.katcha.util.TabUtils;

import core.FileBasedElementLocatorFactory;
import core.KatchFactory;

/**
 * internal.BasePageObject is to group any common functionality and map some functionality to the
 * existing framework.
 *
 */
public class BasePageObject<T> {

	public WebDriver driver;
	private Wait<WebDriver> wait;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
		KatchFactory.initElements(new FileBasedElementLocatorFactory(driver), this);

		if (wait == null) {
			wait = configureWebDriverWait(this.driver, 35);
		}
	}

	/**
	 * Send keys to a given web element
	 * 
	 * @param element
	 * @param keysToSend
	 * @return (T) element
	 */
	public T sendKeys(WebElement element, String keysToSend) {
		element.clear();
		element.sendKeys(keysToSend);
		return (T) this;
	}

	/**
	 * Set the date of a form. Format mm-dd-yyyy (06-07-1985)
	 * 
	 * @param month
	 * @param day
	 * @param year
	 * @param date
	 * @return
	 */
	public T setDate(WebElement month, WebElement day, WebElement year, String date) {

		String[] dates = date.split("-");
		if (dates.length == 0) {
			throw new SkipException(
					"Unable to create an array from the provided date, please validate the mm-dd-yyyy format");
		}
		sendKeys(month, dates[0]);
		sendKeys(day, dates[1]);
		sendKeys(year, dates[2]);
		return (T) this;
	}

	public T clickElement(WebElement element) {
		element.click();
		return (T) this;
	}

	/**
	 * This is a mandatory wait configuration, this must be used over any type of Thread.Sleep.
	 * Thread.sleep, or TimeUtil.SECONDS.sleep are not allowed, unless under extreme circumstances.
	 *
	 * @param driver
	 * @param timeout
	 * @return
	 */
	public Wait<WebDriver> configureWebDriverWait(WebDriver driver, Integer timeout) {
		return new FluentWait<>(driver).withTimeout(timeout, TimeUnit.SECONDS).pollingEvery(250, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
	}

	/**
	 * Validates if the page is open based on the current url.
	 * 
	 * @param url
	 * @return bool if loaded
	 */
	public boolean isPageOpen(String url) {

		// NOTE, this is not the actual implementation.
		waitForLoad();
		return driver.getCurrentUrl().contains(url);

	}

	public void waitForLoad() {
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

	public boolean isPageLoaded(String sourceName) {
		waitForPageLoad();
		return wait.until((ExpectedCondition<Boolean>) d -> driver.getPageSource().contains(sourceName));
	}

	JavascriptExecutor getJavascriptExecutor() {
		return (JavascriptExecutor) driver;
	}

	public JavascriptExecutor getJavascriptExecutor(WebDriver driver) {
		return (JavascriptExecutor) driver;
	}

	/**
	 * Validates if an element is displayed. It uses waitForElementToLoad which will wait and poll
	 * for the element every 250 milliseconds
	 */
	public boolean isElementDisplayed(WebElement element) {
		// NOTE not actual framework implementation.
		return element != null && element.isDisplayed();

	}

	/**
	 * Validates if an element is displayed. It uses waitForElementToLoad which will wait and poll
	 * for the element every 250 milliseconds
	 */
	public boolean isElementDisplayedNoWait(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException | TimeoutException | NullPointerException nsee) {
			return false;
		}
	}

	/**
	 *
	 * Scrolls the element into the center of the view
	 * 
	 * @param elementToFind
	 * @return
	 */
	public boolean scrollElementToCenterView(WebElement elementToFind) {
		Object screenPosy = getJavascriptExecutor(driver).executeScript("return pageYOffset;");
		long screenPosition = 0;
		if (screenPosy != null) {
			screenPosition = (long) screenPosy;
		}

		try {
			getJavascriptExecutor(driver).executeScript(
					"var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
							+ "var elementTop = arguments[0].getBoundingClientRect().top;"
							+ "window.scrollBy(0, elementTop-(viewPortHeight/2));",
					elementToFind);
		} catch (NoSuchElementException nsee) {
			return false;
		}

		return screenPosition != (long) getJavascriptExecutor(driver).executeScript("return pageYOffset;");
	}

	/**
	 * Evaluate the start position of the element. Then set the scroll of the element. Finally
	 * return boolean if the element is no longer in the same position.
	 * 
	 * @param element
	 *            the scrollable view container, such as a form group
	 * @param amount
	 *            how much to scroll by. This should not have an out of bounds, it should limit to
	 *            the max scrollable if a high number.
	 * @return if the element moved or not.
	 */
	public boolean scrollElement(WebElement element, int amount) {
		int startPos = (int) getJavascriptExecutor(driver).executeScript("return arguments[0].scrollTop;", element);
		getJavascriptExecutor(driver).executeScript("return arguments[0].scrollTop = $amount;", element);
		int finalPos = (int) getJavascriptExecutor(driver).executeScript("return arguments[0].scrollTop;", element);
		animationDelay(); // the animation of scrolling lasts for about 1 second, unable to fluently
							// wait for it.
		return !(startPos == finalPos);
	}

	/**
	 * Scrolls the element into the view. Usually to the top of the page behind the header. If
	 * scrolling to the footer, it will pull the footer into view
	 * 
	 * @param elementToFind
	 * @return
	 */
	public boolean scrollElementToView(WebElement elementToFind, boolean up) {
		long screenPosition = (long) getJavascriptExecutor(driver).executeScript("return window.scrollY;");

		getJavascriptExecutor(driver).executeScript("arguments[0].scrollIntoView(${String.valueOf(up)});",
				elementToFind);
		// The element scrolls to the top and hides behind the header, this moves it back into view,
		// below the header
		return screenPosition != (long) getJavascriptExecutor(driver).executeScript("return window.scrollY;");
	}

	/**
	 * Scroll the browser by X/Y Examples: 0, 50 Scroll down 0, -50 Scroll up 100, 0 Scroll right
	 * -100, 0 Scroll left
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean scrollDirectionByPixels(int x, int y) {
		long screenPosition = (long) getJavascriptExecutor(driver).executeScript("return window.scrollY;");
		getJavascriptExecutor(driver).executeScript("window.scrollBy($x, $y)");
		return screenPosition != (long) getJavascriptExecutor(driver).executeScript("return window.scrollY;");
	}

	T moveElementToElement(WebElement fromElement, WebElement toElement) {

		TouchActions touchActions = new TouchActions(driver);
		touchActions.scroll(fromElement, toElement.getLocation().getX(), toElement.getLocation().getY()).perform();
		return (T) this;

	}

	/**
	 * This method is useful if the element selector is dynamic. The @FindBy annotations are final
	 * and do not allow for dynamic locators.
	 * 
	 * @param by
	 * @return
	 */
	WebElement getDynamicWebElement(By by) {
		return driver.findElement(by);
	}

	public boolean waitForPageLoad() {
		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return (long) getJavascriptExecutor(driver).executeScript("return jQuery.active") == 0;
				} catch (Exception e) {
					return true;
				}
			}
		};

		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return Objects.equals(
						getJavascriptExecutor(driver).executeScript("return document.readyState").toString(),
						"complete");
			}
		};

		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	/*
	 * Navigation
	 */

	T navigateToURL(String url) {
		try {
			driver.get(url);
		} catch (TimeoutException te) {
			driver.get(url);
		}
		waitForLoad();
		return (T) this;
	}

	T hoverOverElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		return (T) this;
	}

	/**
	 * Switch between popups or new tabs.
	 * 
	 * @param tabNumber
	 * @return
	 */
	T switchTab(int tabNumber) {
		TabUtils.switchTab(driver, tabNumber);
		waitForLoad();
		return (T) this;
	}

	T closeTab(int tabToClose) {
		TabUtils.closeTab(driver, tabToClose);
		return (T) this;
	}

	/**
	 * Sometimes the waitForElement returns true, this is a cheap second delay to wait for
	 * animation. TODO update delay to be dynamic and search for js or animations to be complete.
	 * 
	 * @return
	 */
	T animationDelay() {
		waitForLoad();
		// TODO determine a hook or listener for CSS animations, including JQuery.
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return (T) this;
	}

	/**
	 * Wait until the element is available in the dom by web element
	 * 
	 * @param element
	 * @return web element
	 */
	private WebElement getWebElement(WebElement element) {
		waitForLoad();
		return element;
	}

	/**
	 * Get the text attribute of an element. If the text is blank, it will return the attribute
	 * "value"
	 * 
	 * @param elementKey
	 * @return
	 */
	public String getText(WebElement elementKey) {
		String text = getWebElement(elementKey).getText();
		if (text.contains("true")) {
			text = getWebElement(elementKey).getAttribute("innerText");
		}

		if (StringUtils.isBlank(text)) {
			text = getAttribute(elementKey, "value");
		}
		return text;
	}

	/**
	 * Similar to getText, however, it returns
	 * 
	 * @param elementKey
	 * @param attribute
	 * @return
	 */
	String getAttribute(WebElement elementKey, String attribute) {
		return elementKey.getAttribute(attribute);
	}

	/**
	 * Boolean if web element contains specific text
	 * 
	 * @param element
	 * @param textToContain
	 * @return
	 */
	boolean containsText(WebElement element, String textToContain) {
		if (element != null) {
			return getText(element).contains(textToContain);
		} else {
			return false;
		}
	}

	/**
	 * returns if an element is visible or not. It will chec
	 * 
	 * @param elementKey
	 * @return
	 */
	boolean isDisplayed(WebElement elementKey) {
		try {
			return isElementDisplayed(getWebElement(elementKey));
		} catch (WebDriverException ignored) {
			try {
				scrollElementToCenterView(elementKey);
				return isElementDisplayed(getWebElement(elementKey));
			} catch (WebDriverException ignored2) {
				return false;
			}
		}
	}

	/**
	 * return true if the element is not displayed.
	 * 
	 * @param elementKey
	 * @return
	 */
	boolean isNotDisplayed(WebElement elementKey) {
		try {
			return !elementKey.isDisplayed();
		} catch (WebDriverException ignored) {
			return true;
		}
	}

	T selectCheckbox(WebElement elementKey, boolean shouldSelect) {
		if (shouldSelect) {
			if (!getWebElement(elementKey).isSelected()) {
				elementKey.click();
			}
		} else {
			if (getWebElement(elementKey).isSelected()) {
				elementKey.click();
			}
		}
		return (T) this;
	}

	boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	void navigateBack() {
		driver.navigate().back();
	}

	/**
	 * Determine if an element is currently in focus. E.g, is the mouse cursor blinking in it.
	 *
	 * Note: Typically return element == driver.switchTo().activeElement() is used to determine the
	 * focus. However, the KatchFactory implements Element, and driver.activeElement returns a
	 * RemoteWebElement.
	 * 
	 * @param element
	 * @return
	 */
	boolean isElementInFocus(WebElement element) {
		return element.getLocation().getY() == driver.switchTo().activeElement().getLocation().getY()
				&& element.getLocation().getX() == driver.switchTo().activeElement().getLocation().getX();
	}

	/**
	 * Click awaits for elements to be clickable. This can be useful when a temporary modal is
	 * overlapping the element to be clicked.
	 */
	T clickWaitedElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		clickElement(element);
		return (T) this;
	}

	/**
	 * Drags and drop an element to anothers elements position.
	 * 
	 * @param dragedElement
	 *            - WebElement to be draged o another position
	 * @param dropOnElement
	 *            - WebElement where the draged element is going to
	 */
	T dragAndDrop(WebElement dragedElement, WebElement dropOnElement) {
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(dragedElement).moveToElement(dropOnElement).release(dropOnElement)
				.build();
		dragAndDrop.perform();
		return (T) this;
	}

	static WebElement findParentFromChildElement(WebElement childElement) {
		return childElement.findElement(By.xpath(".."));
	}

}
