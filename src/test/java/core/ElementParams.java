package core;

/**
 * Created by william.russell on 7/3/17.
 */
class ElementParams {

    String expectedColorId;
    String expectedColorType;
    String expectedText;
    String expectedPlaceholder;

    /**
     * Params loaded from the site.yml files
     * @param params
     */
    ElementParams(Object params) {

        if(params == null){
            this.expectedText = "hello IM HARDCODED";
        }else {
//            this.expectedColorId     = params["color"]["color-id"];
//            this.expectedColorType   = params["color"]["type"];
//            this.expectedText        = params["text"];
//            this.expectedPlaceholder = params["placeholder"];
        }


    }

    String getExpectedColorId() {
        return expectedColorId;
    }

    void setExpectedColorId(String expectedColorId) {
        this.expectedColorId = expectedColorId;
    }

    String getExpectedColorType() {
        return expectedColorType;
    }

    void setExpectedColorType(String expectedColorType) {
        this.expectedColorType = expectedColorType;
    }

    String getExpectedText() {
        return expectedText;
    }

    void setExpectedText(String expectedText) {
        this.expectedText = expectedText;
    }

    String getExpectedPlaceholder() {
        return expectedPlaceholder;
    }

    void setExpectedPlaceholder(String expectedPlaceholder) {
        this.expectedPlaceholder = expectedPlaceholder;
    }
}
