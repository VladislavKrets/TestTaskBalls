package com.testtask.balls;


import java.io.File;

public class Main{


    public static void main(String[] args) {
        System.setProperty("org.lwjgl.librarypath", new File("native/windows").getAbsolutePath());
        new BallsFrame();
    }


}