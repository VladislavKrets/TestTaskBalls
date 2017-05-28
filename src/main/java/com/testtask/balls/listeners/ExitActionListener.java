package com.testtask.balls.listeners;

import com.testtask.balls.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        Utils.closeRequest.set(1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.exit(0);
    }
}
