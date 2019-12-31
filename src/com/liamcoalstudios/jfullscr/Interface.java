package com.liamcoalstudios.jfullscr;

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    private JPanel panel1;
    private JButton toggleButton;
    private boolean fullscr = false;
    private Window wmWindow;

    public static void showInterface() {
        Interface i = new Interface();
        i.setTitle("JFullScr - Liam's Fullscreen Example.");
        i.setSize(640, 480);
        i.setDefaultCloseOperation(EXIT_ON_CLOSE);
        i.toggleButton.addActionListener(actionEvent -> {
            i.fullscr = !i.fullscr;
            if(i.fullscr) {
                i.wmWindow = i.getGraphicsConfiguration().getDevice().getFullScreenWindow();
                i.getGraphicsConfiguration().getDevice().setFullScreenWindow(i);
            } else {
                i.getGraphicsConfiguration().getDevice().setFullScreenWindow(i.wmWindow);
            }
        });
        if(!i.getGraphicsConfiguration().getDevice().isFullScreenSupported()) {
            i.toggleButton.setEnabled(false);
            i.toggleButton.setText("Unsupported.");
        }
        i.add(i.panel1);
        i.setVisible(true);
    }
}
