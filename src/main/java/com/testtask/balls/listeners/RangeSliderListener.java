package com.testtask.balls.listeners;

import com.testtask.balls.Utils;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RangeSliderListener implements ChangeListener{
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        Utils.sliderState.set(slider.getValue());
    }
}
