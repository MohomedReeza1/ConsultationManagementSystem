package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class WelcomeForm extends JFrame {

    public WelcomeForm() {
        JPanel panel = new JPanel();
        JButton bookAppointmentButton = new JButton();
        JLabel picLabel = new JLabel();
        JLabel welcomeLabel = new JLabel();

        panel.setBackground(new Color(214, 217, 224));
        picLabel.setBackground(new Color(214, 217, 224));
        welcomeLabel.setBackground(new Color(214, 217, 224));

        panel.setBorder(new EmptyBorder(new Insets(30,0,50,0)));

        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
        welcomeLabel.setText("Welcome to Westminster Skin Consultation Center");
        panel.add(welcomeLabel);

        picLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        picLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("Resources/doctor6.jpg"))));
        picLabel.setSize(800, 400);
        panel.add(picLabel);

        bookAppointmentButton.setHorizontalTextPosition(SwingConstants.CENTER);
        bookAppointmentButton.setText("Book an appointment");
        panel.add(bookAppointmentButton);

        picLabel.getAccessibleContext().setAccessibleName("picLabel");

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(welcomeLabel)
                        .addComponent(picLabel)
                        .addComponent(bookAppointmentButton)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(welcomeLabel)
                ).addGap(50,50,50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(picLabel)
                ).addGap(200,200,200)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(bookAppointmentButton)
                )
        );

        add(panel);

        pack();

        MyListener handler = new MyListener();
        bookAppointmentButton.addActionListener(handler);

    }

        private class MyListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evt) {
                BookDoctor.main();
                dispose();
            }
        }



    public static void main(String[] args)  {
        WelcomeForm welcome = new WelcomeForm();
        welcome.setTitle("Welcome");
        welcome.setSize(800, 800);
        welcome.setVisible(true);
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
