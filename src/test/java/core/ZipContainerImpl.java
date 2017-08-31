package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demo.katcha.pageobject.web.BasePageObject;

/**
 * Created by william.russell on 8/28/17.
 */
public class ZipContainerImpl extends BasePageObject<ZipContainer> implements ZipContainer {

	@KatchFindBy(locatorPath = "page.lander.c_ZipContainer.zc_ZipButton")
	WebElement zipButton;

	@KatchFindBy(locatorPath = "page.lander.c_ZipContainer.zc_ZipInput")
	WebElement zipInput;

	@KatchFindBy(locatorPath = "page.lander.c_ZipContainer.zc_CardImage")
	WebElement cardImage;

	@KatchFindBy(locatorPath = "page.lander.c_ZipContainer.zc_CardSubTitle")
	WebElement cardSubTitle;

	@KatchFindBy(locatorPath = "page.lander.c_ZipContainer.zc_CardTitle")
	WebElement cardTitle;

	@KatchFindBy(locatorPath = "page.lander.c_ZipContainer.zc_LabelImage")
	WebElement labelImage;

	@KatchFindBy(locatorPath = "page.lander.c_ZipContainer.zc_LabelImageSm")
	WebElement labelImageSm;

	@KatchFindBy(locatorPath = "page.lander.c_ZipContainer.zc_LocationIcon")
	WebElement locationIcon;

	@KatchFindBy(locatorPath = "page.lander.c_Carriers.cc_Title")
	WebElement ccTitle;

	@KatchFindBy(locatorPath = "page.lander.c_Carriers.cc_availableCarriers")
	WebElement availableCarriers;

	@KatchFindBy(locatorPath = "page.lander.c_ChooseConfidence.confidence_Title")
	WebElement confidence_Title;

	@KatchFindBy(locatorPath = "page.lander.c_ChooseConfidence.confidence_SubTitle")
	WebElement confidence_SubTitle;

	@KatchFindBy(locatorPath = "page.lander.c_ChooseConfidence.confidence_StepOneImage")
	WebElement confidence_StepOneImage;

	@KatchFindBy(locatorPath = "page.lander.c_ChooseConfidence.confidence_StepOneTitle")
	WebElement confidence_StepOneTitle;

	@KatchFindBy(locatorPath = "page.lander.c_ChooseConfidence.confidence_StepOneDesc")
	WebElement confidence_StepOneDesc;

	@KatchFindBy(locatorPath = "page.lander.c_ChooseConfidence.confidence_StepTwoImage")
	WebElement confidence_StepTwoImage;

	@KatchFindBy(locatorPath = "page.lander.c_ChooseConfidence.confidence_StepTwoTitle")
	WebElement confidence_StepTwoTitle;

	@KatchFindBy(locatorPath = "page.lander.c_ChooseConfidence.confidence_StepTwoDesc")
	WebElement confidence_StepTwoDesc;

	@KatchFindBy(locatorPath = "page.lander.c_ChooseConfidence.confidence_StepThreeImage")
	WebElement confidence_StepThreeImage;

	@KatchFindBy(locatorPath = "page.lander.c_ChooseConfidence.confidence_StepThreeTitle")
	WebElement confidence_StepThreeTitle;

	@KatchFindBy(locatorPath = "page.lander.c_ChooseConfidence.confidence_StepThreeDesc")
	WebElement confidence_StepThreeDesc;

	@KatchFindBy(locatorPath = "page.lander.c_ChooseConfidence.confidence_ZipLocation")
	WebElement confidence_ZipLocation;

	@KatchFindBy(locatorPath = "page.lander.c_ChooseConfidence.confidence_ZipInput")
	WebElement confidence_ZipInput;

	@KatchFindBy(locatorPath = "page.lander.c_ChooseConfidence.confidence_ZipButton")
	WebElement confidence_ZipButton;

	@KatchFindBy(locatorPath = "page.lander.c_SmartChoice.sc_Title")
	WebElement sc_Title;

	@KatchFindBy(locatorPath = "page.lander.c_SmartChoice.sc_SubTitle")
	WebElement sc_SubTitle;

	@KatchFindBy(locatorPath = "page.lander.c_SmartChoice.sc_Image")
	WebElement sc_Image;

	@KatchFindBy(locatorPath = "page.lander.c_LearnMore.lm_Title")
	WebElement lm_Title;

	@KatchFindBy(locatorPath = "page.lander.c_LearnMore.lm_TitleImg")
	WebElement lm_TitleImg;

	@KatchFindBy(locatorPath = "page.lander.c_LearnMore.lm_BasicsLink")
	WebElement lm_BasicsLink;

	@KatchFindBy(locatorPath = "page.lander.c_LearnMore.lm_BasicsIcon")
	WebElement lm_BasicsIcon;

	@KatchFindBy(locatorPath = "page.lander.c_LearnMore.lm_BasicsTitle")
	WebElement lm_BasicsTitle;

	@KatchFindBy(locatorPath = "page.lander.c_LearnMore.lm_DiscountLink")
	WebElement lm_DiscountLink;

	@KatchFindBy(locatorPath = "page.lander.c_LearnMore.lm_DiscountIcon")
	WebElement lm_DiscountIcon;

	@KatchFindBy(locatorPath = "page.lander.c_LearnMore.lm_DiscountTitle")
	WebElement lm_DiscountTitle;

	@KatchFindBy(locatorPath = "page.lander.c_LearnMore.lm_ACALink")
	WebElement lm_ACALink;

	@KatchFindBy(locatorPath = "page.lander.c_LearnMore.lm_ACAIcon")
	WebElement lm_ACAIcon;

	@KatchFindBy(locatorPath = "page.lander.c_LearnMore.lm_ACATitle")
	WebElement lm_ACATitle;

	@KatchFindBy(locatorPath = "page.lander.c_LearnMore.lm_MedicareLink")
	WebElement lm_MedicareLink;

	@KatchFindBy(locatorPath = "page.lander.c_LearnMore.lm_MedicareIcon")
	WebElement lm_MedicareIcon;

	@KatchFindBy(locatorPath = "page.lander.c_LearnMore.lm_MedicareTitle")
	WebElement lm_MedicareTitle;

	@KatchFindBy(locatorPath = "page.lander.c_StartSearching.ss_SubmitButton")
	WebElement ss_SubmitButton;

	@KatchFindBy(locatorPath = "page.lander.c_StartSearching.ss_ZipCodeInput")
	WebElement ss_ZipCodeInput;

	@KatchFindBy(locatorPath = "page.lander.c_StartSearching.ss_LocationIcon")
	WebElement ss_LocationIcon;

	@KatchFindBy(locatorPath = "page.lander.c_StartSearching.ss_Image")
	WebElement ss_Image;

	@KatchFindBy(locatorPath = "page.lander.c_StartSearching.ss_Title")
	WebElement ss_Title;

	@KatchFindBy(locatorPath = "page.lander.c_WhyChoose.wc_Title")
	WebElement wc_Title;

	@KatchFindBy(locatorPath = "page.lander.c_WhyChoose.wc_SubTitle")
	WebElement wc_SubTitle;

	@KatchFindBy(locatorPath = "page.lander.c_WhyChoose.wc_HuffingtonImage")
	WebElement wc_HuffingtonImage;

	@KatchFindBy(locatorPath = "page.lander.c_WhyChoose.wc_YahooImage")
	WebElement wc_YahooImage;

	@KatchFindBy(locatorPath = "page.lander.c_WhyChoose.wc_LosAngelesImage")
	WebElement wc_LosAngelesImage;

	@KatchFindBy(locatorPath = "page.fas.filter.filter_button")
	WebElement filter_button;

	@KatchFindBy(locatorPath = "page.fas.filter.provider_type")
	WebElement provider_type;

	// TODO Add all elements under the lander in general.yml

	public ZipContainerImpl(WebDriver driver) {
		super(driver);
	}

	public ZipContainer clickZipButton() {
		// wrap all click events in this method, we do extra things with it.
		clickElement(zipButton);
		return this;
	}

	public ZipContainer setZipInput(String zipCode) {
		// wrap all send text events in this method, we do extra things with it.
		sendKeys(zipInput, zipCode);
		return this;
	}

}
