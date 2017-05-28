package com.testtask.balls;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
import org.lwjgl.opengl.DisplayMode;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;

public class DisplayThread extends Thread {
    private Canvas canvas;
    private int WIDTH;
    private int HEIGHT;

    private static List<Circle> circles = new ArrayList<>();

    public DisplayThread(Canvas canvas, int width, int height) {
        this.canvas = canvas;
        this.WIDTH = width;
        this.HEIGHT = height;

    }

    @Override
    public void run() {
        try {

            initializeDisplay();

            makeCircle(Utils.sliderState.get());
            while (!Display.isCloseRequested()) {
                glClear(GL_COLOR_BUFFER_BIT);
                if (Utils.isBtnPressed.get() == 1) {
                    Circle.setCount(0);
                    circles.clear();
                    makeCircle(Utils.sliderState.get());
                    Utils.isBtnPressed.set(0);
                }
                for (Circle circle : circles) {
                    circle.drawFilledCircle();
                }

                checkBorders();
                for (Circle circle : circles) {
                    collide(circle);
                }

                Display.update();
                Display.sync(60);

            }
            Display.destroy();

        } catch (LWJGLException e) {
            e.printStackTrace();
        }

    }

    private void initializeDisplay() throws LWJGLException {

        Display.setParent(canvas);
        Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
        Display.setTitle("Display");
        Display.create();
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
    }

    private void checkBorders() {
        for (Circle circle : circles) {
            if (circle.getX() + circle.getRadius() >= WIDTH ||
                    circle.getX() - circle.getRadius() <= 0 ||
                    circle.getY() + circle.getRadius() >= HEIGHT ||
                    circle.getY() - circle.getRadius() <= 0) {
                circle.setCircleSpeedX(circle.getCircleSpeedX() * -1);
                circle.setCircleSpeedY(circle.getCircleSpeedY() * -1);
            }

            circle.update(circle.getCircleSpeedX(), circle.getCircleSpeedY());

        }
    }

    public void collide(Circle currentCircle) {


        for (Circle circle : circles) {
            if (circle.getId() != currentCircle.getId()) {

                if ((currentCircle.getX() + currentCircle.getRadius() >= circle.getX()) &&
                        (currentCircle.getX() <= circle.getX() + circle.getRadius()) &&
                        (currentCircle.getY() + currentCircle.getRadius() >= circle.getY()) &&
                        (currentCircle.getY() <= circle.getY() + circle.getRadius())) {
                    circle.setCircleSpeedX(circle.getCircleSpeedX() * -1);
                    circle.setCircleSpeedY(circle.getCircleSpeedY() * -1);
                    currentCircle.setCircleSpeedX(currentCircle.getCircleSpeedX() * -1);
                    currentCircle.setCircleSpeedY(currentCircle.getCircleSpeedY() * -1);
                    circle.update(circle.getCircleSpeedX(), circle.getCircleSpeedY());
                    currentCircle.update(currentCircle.getCircleSpeedX(), currentCircle.getCircleSpeedY());
                }
            }
        }
    }

    public void makeCircle(float count) {
        float radius = 20;

        for (int i = 0; i < count; i++) {
            Circle circle = new Circle((float) ((radius * 4 + 1) + Math.random() * (WIDTH - radius * 4 - 1)),
                    (float) ((radius * 4 + 1) + Math.random() * (HEIGHT - radius * 4 - 1)), radius);

            circle.setCircleSpeedX((float) (-1 + Math.random()));
            circle.setCircleSpeedY((float) (-1 + Math.random()));
            System.out.println(circle.getId());
            circles.add(circle);
        }


    }

}
