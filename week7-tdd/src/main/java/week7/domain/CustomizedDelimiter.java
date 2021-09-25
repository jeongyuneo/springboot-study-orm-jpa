package week7.domain;

public class CustomizedDelimiter extends Delimiter{

    private String customizedDelimiter;

    public CustomizedDelimiter(String customizedDelimiter) {
        this.customizedDelimiter = customizedDelimiter;
    }

    @Override
    protected String getDelimiter() {
        return customizedDelimiter;
    }
}
