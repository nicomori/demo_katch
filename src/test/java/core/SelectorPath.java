package core;

import org.openqa.selenium.By;

/**
 * Created by william.russell on 7/3/17.
 */
class SelectorPath {

    static By determineSelector(String selectorType, String selectorLocation){
        switch (selectorType.toLowerCase()){
            case "xpath":
                return By.xpath(selectorLocation);
            case "css":
                return By.cssSelector(selectorLocation);
            case "classname":
                return By.className(selectorLocation);
            case "id":
                return By.id(selectorLocation);
            case "tagname":
                return By.tagName(selectorLocation);
            case "name":
                return By.name(selectorLocation);
            case "linktext":
                return By.linkText(selectorLocation);
            case "partialLinkText":
                return By.partialLinkText(selectorLocation);
             default:
                 return null;
        }
    }
}
