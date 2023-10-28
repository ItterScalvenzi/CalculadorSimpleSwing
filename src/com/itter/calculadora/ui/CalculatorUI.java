package com.itter.calculadora.ui;

import javax.swing.*;

import com.itter.calculadora.logic.CalculatorLogic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI {
    private JFrame frame;
    private JTextField display;
    private JPanel buttonPanel;
    private CalculatorLogic calculatorLogic;

    public CalculatorUI() {
        frame = new JFrame("Calculadora Swing");
       
        display = new JTextField(12);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        buttonPanel = new JPanel();
        calculatorLogic = new CalculatorLogic(this);

        display.setEditable(false);
        frame.setLayout(new BorderLayout());
        frame.add(display, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        String[] buttonLabels = {
        	"CE", " "," "," ",
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        buttonPanel.setLayout(new GridLayout(5, 4));
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    calculatorLogic.buttonClick(label);
                }
            });
            buttonPanel.add(button);
        }
    }

    public void createAndShowGUI() {
    	frame.setSize(300, 400);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void updateDisplay(String text) {
        display.setText(text);
    }
}
