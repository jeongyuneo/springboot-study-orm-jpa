package week7.domain;

public class DefaultDelimiter extends Delimiter{

    private static final String DEFAULT_DELIMITER = ",|:";

    @Override
    protected String getDelimiter() {
        return DEFAULT_DELIMITER;
    }
}
