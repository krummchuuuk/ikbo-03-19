package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.removeMouseListener;

class Game {
    private JFrame main_win = new JFrame("Угадайка");
    private JTextField tries = new JTextField();
    private JLabel title = new JLabel("Давайте начнём.");
    private JButton btn = new JButton("Send");
    String value = Integer.toString((int) (Math.random() * 20));
    int num_tries=0;


    public void view() {
        main_win.setSize(500,400);
        main_win.setLocation(500,200);

        GridBagLayout lay = new GridBagLayout();
        main_win.setLayout(lay);
        GridBagConstraints setting1 = new GridBagConstraints();
        setting1.fill = GridBagConstraints.HORIZONTAL;
        setting1.gridx=0;
        setting1.gridy=0;
        setting1.gridwidth=2;
        setting1.weightx=500;
        setting1.weighty=200;
        main_win.add(title, setting1);
        GridBagConstraints setting2 = new GridBagConstraints();
        setting2.fill = GridBagConstraints.HORIZONTAL;
        setting2.gridx=1;
        setting2.gridy=1;
        setting2.weightx=250;
        setting2.weighty=300;
        main_win.add(tries, setting2);
        GridBagConstraints setting3 = new GridBagConstraints();
        setting3.fill = GridBagConstraints.HORIZONTAL;
        setting3.gridx=2;
        setting3.gridy=1;
        setting3.weightx=250;
        setting3.weighty=300;
        main_win.add(btn, setting3);

        main_win.getContentPane().setBackground(Color.decode("#ffec8b"));
        Font font = new Font("Montserrat", Font.BOLD, 24);
        btn.setBorderPainted(false);
        btn.setBackground(Color.decode("#ffec8b"));
        btn.setForeground(Color.white);
        btn.setFont(font);

        title.setFont(font);
        title.setHorizontalAlignment(SwingConstants.RIGHT);
        title.setForeground(Color.white);

        tries.setFont(font);
        tries.setHorizontalAlignment(JTextField.CENTER);
        tries.setBackground(Color.decode("#ffec8b"));
        tries.setForeground(Color.white);
        tries.setBorder(null);
    }

    class Mouse_Reader implements MouseListener {
        public void mouseClicked(MouseEvent event) {
            num_tries++;
            if (num_tries <= 3) {
                String input = tries.getText();
                if (input == "") num_tries--;
                else if (Integer.parseInt(input) == Integer.parseInt(value)) {
                    title.setText("Вы снова меня победили!");
                    removeMouseListener(this);
                }
                else if (Integer.parseInt(input) < Integer.parseInt(value)) {
                    title.setText("Загаданное число больше.");
                    tries.setText("");
                } else if (Integer.parseInt(input) > Integer.parseInt(value)) {
                    title.setText("Загаданное число меньше.");
                    tries.setText("");
                }
            }
            else if (num_tries==4) {
                title.setText("В следующий раз повезёт!");
                removeMouseListener(this);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }

    public void app() {
        view();
        System.out.print(value);
        Mouse_Reader reader = new Mouse_Reader();
        btn.addMouseListener(reader);
        main_win.setVisible(true);
    }
}

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.app();
    }
}
