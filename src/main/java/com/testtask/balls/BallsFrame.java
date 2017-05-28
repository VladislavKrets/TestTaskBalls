package com.testtask.balls;

import com.testtask.balls.listeners.ExitActionListener;
import com.testtask.balls.listeners.RangeSliderListener;
import com.testtask.balls.listeners.SubmitActionListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lollipop on 28.05.2017.
 */
public class BallsFrame extends JFrame{
    public BallsFrame() {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        Dimension dimension = getSize();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canvas canvas = new Canvas();

        JPanel panel = new JPanel();
        JButton buttonExit = new JButton("Exit");
        buttonExit.addActionListener(new ExitActionListener());
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new SubmitActionListener()
        );
        JSlider rangeSlider = new JSlider(0, 100, 10);
        rangeSlider.addChangeListener(new RangeSliderListener());
        panel.setLayout(new BorderLayout());


        panel.add(buttonExit, BorderLayout.EAST);
        panel.add(btnSubmit, BorderLayout.WEST);
        panel.add(rangeSlider, BorderLayout.CENTER);

        setLayout(new BorderLayout());

        add(canvas, BorderLayout.CENTER);

        add(panel, BorderLayout.NORTH);

        setVisible(true);
        System.out.println(dimension.getWidth());
        System.out.println(dimension.getHeight());
        DisplayThread thread = new DisplayThread(canvas, getWidth(), getHeight());
        thread.start();

    }

}
