package core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by william.russell on 7/3/17.
 */

@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.FIELD)
public @interface KatchFindBy {

    /**
     * Locator path within the sites yml file.
     * Example:
     * page.lander.zipcodeInputField
     *
     * This would indicate that the given locator is within the page name of lander, with an element name of zipCodeInputField.
     * @return
     */
    String locatorPath() default "";
}