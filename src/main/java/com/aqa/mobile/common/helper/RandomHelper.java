package com.aqa.mobile.common.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RandomHelper {


    private final static Random random = new Random();

    public static int randomInt(int from, int to) {
        return from + random.nextInt(to);
    }
}
