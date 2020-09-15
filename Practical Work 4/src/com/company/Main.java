package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class App {
    private int i=0, j=0;
    private JFrame frame = new JFrame();
    private JLabel result = new JLabel(i +" × "+ j);
    private JLabel last = new JLabel("Last Scorer: N/A");
    private JLabel winner = new JLabel("Winner: DRAW");
    private JButton btn1 = new JButton("AC Milan");
    private JButton btn2 = new JButton("Real Madrid");

    public void Location() {
        frame.setSize(450,450);
        frame.setLocation(560,250);

        frame.setLayout(new GridLayout(4,1));
        frame.add(result).setLocation(1,1);
        frame.add(last).setLocation(2,1);
        frame.add(winner).setLocation(3, 1);

        JPanel temp = new JPanel();
        temp.add(btn1);
        temp.add(btn2);
        temp.setBackground(Color.black);

        frame.add(temp).setLocation(4,1);
        frame.setVisible(true);
    }

    public void Design() {
        Font font =new Font("Montserrat Light", Font.CENTER_BASELINE, 20);
        Font res =new Font("Montserrat", Font.BOLD, 24);
        result.setFont(res);
        winner.setFont(font);
        last.setFont(font);
        btn1.setFont(font);
        btn2.setFont(font);

        result.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        result.setHorizontalAlignment(SwingConstants.CENTER);
        last.setHorizontalAlignment(SwingConstants.CENTER);
        winner.setHorizontalAlignment(SwingConstants.CENTER);
        btn1.setHorizontalTextPosition(SwingConstants.CENTER);
        btn2.setHorizontalTextPosition(SwingConstants.CENTER);

        result.setForeground(Color.white);
        last.setForeground(Color.white);
        winner.setForeground(Color.white);
        btn1.setForeground(Color.white);
        btn2.setForeground(Color.white);

        btn1.setBackground(Color.black);
        btn2.setBackground(Color.black);

        frame.getContentPane().setBackground(Color.black);

    }

    public void App()  {
        Location();
        Design();
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
                result.setText(i +" × "+ j);
                last.setText("Last Scorer: "+btn1.getText());
                if (i>j) winner.setText("Winner: "+btn1.getText());
                else if (i  ==  j) winner.setText("Winner: N/A");
                else winner.setText("Winner: "+btn2.getText());
            }
            //public mouse
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j++;
                result.setText(i +" × "+ j);
                last.setText("Last Scorer: "+btn2.getText());
                if (i>j) winner.setText("Winner: "+btn1.getText());
                else if (i  ==  j) winner.setText("Winner: N/A");
                else winner.setText("Winner: "+btn2.getText());
            }
        });
    }

}

public class Main {

    public static void main(String[] args) {
    App window = new App();
    window.App();

    }
}
