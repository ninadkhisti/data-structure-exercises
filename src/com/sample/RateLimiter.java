package com.sample;

/**
 * http://stackoverflow.com/questions/667508/whats-a-good-rate-limiting-algorithm - token bucket
 */
public class RateLimiter {

    private static final int rate = 5; // num of messages
    private static final int per = 8; //time unit
    private long lastChecked; // time in millis
    private int allowance = rate;

    public RateLimiter() {
        this.lastChecked = System.currentTimeMillis();
    }

    public void rateLimitedCall(String input) throws InterruptedException {
        long current = System.currentTimeMillis();
        long timeElapsed = current - lastChecked;
        lastChecked = current;

        allowance += timeElapsed * (rate / per);
        if (allowance > rate) {
            allowance = rate; //throttling
        }
        if (allowance < 1.0) {
            discardMessage(input);
            return;
        } else {
            allowance -= 1;
            call(input);
            return;
        }
    }

    private void discardMessage(String input) throws InterruptedException {
        // do some logging if needed
        Thread.sleep((1 - allowance) * (per / rate));
    }

    public String call(String input) {
        System.out.println("Called " + input + "\n");
        return "success " + input;
    }
}
