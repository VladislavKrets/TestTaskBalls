package com.testtask.balls;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.lwjgl.opengl.GL11.*;

public class Circle {

    private float x, y;
    private float radius;
    private float circleSpeedX;
    private float circleSpeedY;
    private int id = 0;
    private static int count = 0;

    public Circle(float x, float y, float radius) {

        this.x = x;
        this.y = y;
        this.radius = radius;
        id = count;
        count++;
    }


    public void update(float dx, float dy) {
        x = x + dx;
        y = y + dy;
    }

    public void drawFilledCircle() {

        int i;
        int triangleAmount = 20;

        double twicePi = 2.0f * PI;

        glBegin(GL_TRIANGLE_FAN);
        glVertex2f(x, y);
        for (i = 0; i <= triangleAmount; i++) {
            glVertex2f(
                    x + (float) (radius * cos(i * twicePi / triangleAmount)),
                    y + (float) (radius * sin(i * twicePi / triangleAmount))
            );
        }
        glEnd();
    }

    public int getId() {
        return id;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRadius() {
        return radius;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getCircleSpeedX() {
        return circleSpeedX;
    }

    public float getCircleSpeedY() {
        return circleSpeedY;
    }

    public void setCircleSpeedX(float circleSpeedX) {
        this.circleSpeedX = circleSpeedX;
    }

    public void setCircleSpeedY(float circleSpeedY) {
        this.circleSpeedY = circleSpeedY;
    }

    public static void setCount(int count) {
        Circle.count = count;
    }
}

