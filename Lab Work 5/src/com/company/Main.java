package com.company;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String[] names= new String[9];
        for (int i = 0;i<9;i++) {
            names[i] = (i+1)+".jpg";
        }
        JFrame win = new JFrame();
        win.setSize(840,475);
        win.setLocation(300,200);
        win.setTitle("Animation");
        JLabel gif = new JLabel();
        win.add(gif);
        win.setVisible(true);
        while(true) {
            for (int i = 0; i < 9; i++) {
                gif.setIcon(new ImageIcon("C:\\Users\\Арина\\IdeaProjects\\Lab Work 5\\gif\\"+names[i]));
                try { Thread.sleep(100); }
                catch (InterruptedException hren) {}
                gif.removeAll();
            }
            for (int i = 8; i >-1; i--) {
                gif.setIcon(new ImageIcon("C:\\Users\\Арина\\IdeaProjects\\Lab Work 5\\gif\\"+names[i]));
                try { Thread.sleep(100); }
                catch (InterruptedException hren) {}
                gif.removeAll();
            }
        }
    }
}
