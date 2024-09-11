package com.aqa.mobile.common.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TextHelper {


    public static int getFirstNumberFromText(String withNumbers) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(withNumbers);

        if (matcher.find()) {
            String numberStr = matcher.group();
            return Integer.parseInt(numberStr);
        } else {
            throw new NoSuchElementException(format("Can't find any digits in text {%s}", withNumbers));
        }
    }
}
