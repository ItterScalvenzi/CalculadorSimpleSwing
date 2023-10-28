package com.itter.calculadora.main;

import javax.swing.SwingUtilities;

import com.itter.calculadora.ui.CalculatorUI;

public class CalculadoraSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorUI calculatorUI = new CalculatorUI();
            calculatorUI.createAndShowGUI();
        });
    }
}
