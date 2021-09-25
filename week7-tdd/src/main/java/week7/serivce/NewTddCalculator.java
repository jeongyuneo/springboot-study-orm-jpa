package week7.serivce;

import week7.domain.*;
import week7.util.Converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewTddCalculator {

    private static final int CUSTOM_DELIMITER_LOCATION = 1;
    private static final String CUSTOM_PATTERN = "//(.)\n";
    private static final Action DEFAULT_ACTION = new DefaultDelimiter();
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_PATTERN);

    public int add(String data) {
        if (data.isEmpty()) {
            return 0;
        }
        Matcher matcher = PATTERN.matcher(data);
        if (matcher.lookingAt()) {
            Action customizedAction = new CustomizedDelimiter(DelimiterExtractor.makeDelimiter(matcher.group(CUSTOM_DELIMITER_LOCATION)));
            return new Numbers(Converter.toNumberList(customizedAction.split(data.substring(matcher.end())))).sum();
        }
        return new Numbers(Converter.toNumberList(DEFAULT_ACTION.split(data))).sum();
    }
}
