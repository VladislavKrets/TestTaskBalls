package com.testtask.balls.listeners;

import com.testtask.balls.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        Utils.isBtnPressed.set(1);
    }
}
