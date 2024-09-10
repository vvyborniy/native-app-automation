package com.aqa.mobile;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class FirstTest extends BaseTest {


    @Test
    public void test() {
        log.info("test start");
    }
}
