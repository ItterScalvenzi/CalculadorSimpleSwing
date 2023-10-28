package com.itter.calculadora.logic;

import com.itter.calculadora.ui.CalculatorUI;

public class CalculatorLogic {
    private CalculatorUI ui;
    private String entrada = "";
    private String operador = "";
    private double resultado = 0.0;

    public CalculatorLogic(CalculatorUI ui) {
        this.ui = ui;
    }

    public void buttonClick(String label) {
        if(label.equals("CE")) {
        	
        	entrada = "";
        	ui.updateDisplay(entrada);
        	resultado = 0;
        } else {
        	if (label.matches("[0-9.]")) {
                entrada += label;
                ui.updateDisplay(entrada);
            } else if (label.matches("[-+*/=]")) {
                if (!entrada.isEmpty()) {
                    if (!operador.isEmpty()) {
                        calculateResult();
                        ui.updateDisplay(Double.toString(resultado));
                    } else {
                        resultado = Double.parseDouble(entrada);
                    }
                    operador = label;
                    entrada = "";
                }
            }
        }
     
    }

    private void calculateResult() {
        double number = Double.parseDouble(entrada);
        switch (operador) {
            case "+" ->{
                resultado += number;
                break;
            }
            case "-" ->{
                resultado -= number;
                break;
            }
            case "*" ->{
                resultado *= number;
                break;
            }
            case "/" ->{
                if (number != 0) {
                    resultado /= number;
                } else {
                    resultado = 0; // Manejo de división por cero
                }
                break;
            }
       
        }
        entrada = "";
    }
}
