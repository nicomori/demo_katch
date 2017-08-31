package core;

import org.openqa.selenium.WebDriver;

/**
 * Created by william.russell on 8/28/17.
 */
public class ZipFactory {

	public static ZipContainer newZipContainer(WebDriver driver) {
		return new ZipContainerImpl(driver);
	}

}
