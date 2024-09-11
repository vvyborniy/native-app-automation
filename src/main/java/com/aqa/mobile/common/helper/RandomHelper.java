package com.aqa.mobile.common.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RandomHelper {

    private final static Faker faker = new Faker();
    private final static Random random = new Random();

    public static int randomInt(int from, int to) {
        return from + random.nextInt(to);
    }

    public static String randomString() {
        return faker.lorem().word();

    }
}
