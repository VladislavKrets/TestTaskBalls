package com.testtask.balls;

import java.util.concurrent.atomic.AtomicInteger;

public class Utils {
    public static AtomicInteger isBtnPressed = new AtomicInteger(0);
    public static AtomicInteger sliderState = new AtomicInteger(10);
    public static AtomicInteger closeRequest = new AtomicInteger(0);
}
