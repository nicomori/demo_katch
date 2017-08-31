package core;

import java.lang.reflect.Field;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;

import com.demo.katcha.util.DotUtil;
import com.google.common.base.Preconditions;

class AnnotationOverride extends org.openqa.selenium.support.pagefactory.Annotations {
	private final Field field;

	AnnotationOverride(Field field) {
		super(field);
		this.field = field;
	}

	@Override
	public By buildBy() {
		KatchFindBy katchFindBy = field.getAnnotation(KatchFindBy.class);
		if (katchFindBy != null) {
			Preconditions.checkArgument(isNotNullAndEmpty(katchFindBy.locatorPath()));
			JSONObject jsonObject = DotUtil.getProperty(katchFindBy.locatorPath());
			if (null != jsonObject) {

				JSONObject locator = jsonObject.getJSONObject("locator");

				String locatorType = locator.getString("locatorType");

				String locatorPath = locator.getString("locatorPath");
				System.out.println(locatorPath);

				return SelectorPath.determineSelector(locatorType, locatorPath);

			} else {
				return super.buildBy();
			}
		}
		return null;
	}

	@Override
	public boolean isLookupCached() {
		return (field.getAnnotation(CacheLookup.class) != null);
	}

	private static boolean isNotNullAndEmpty(String arg) {
		return ((arg != null) && (!arg.trim().isEmpty()));
	}
}