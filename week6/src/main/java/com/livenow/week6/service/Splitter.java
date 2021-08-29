package com.livenow.week6.service;

import com.livenow.week6.domain.Delimiter;
import com.livenow.week6.domain.Number;
import com.livenow.week6.domain.Numbers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Splitter {

    private static final String SEPARATOR_START = "//";
    private static final String SEPARATOR_END = "\\n";
    private static String delimiter = new Delimiter().getValue();

    private Splitter() {

    }

    public static Numbers split(String formula) {
        if (formula.isEmpty()) {
            return createZeroList();
        }
        if (formula.contains(SEPARATOR_START) && formula.contains(SEPARATOR_END)) {
            delimiter = DelimiterExtractor.creatCustomDelimiter(formula).getValue();
            formula = formula.substring(5);
        }
        return new Numbers(Arrays.stream(formula.split(delimiter))
                .map(Number::new)
                .collect(Collectors.toList()));
    }

    private static Numbers createZeroList() {
        return new Numbers(Arrays.stream(new Number[]{new Number("0")})
                .collect(Collectors.toList()));
    }
}
