package week7.domain;

public abstract class Delimiter implements Action {

    private String value;

    @Override
    public String[] split(String input) {
        return input.split(getDelimiter());
    };

    protected abstract String getDelimiter();
}
