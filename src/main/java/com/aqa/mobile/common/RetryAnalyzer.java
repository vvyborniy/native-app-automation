package com.aqa.mobile.common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public final class RetryAnalyzer implements IRetryAnalyzer {
    private static final int MAX_COUNT = 0;
    private int currentCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (this.currentCount < MAX_COUNT) {
            ++this.currentCount;
            return true;
        } else {
            return false;
        }
    }
}