package com.gapps.calculator;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Class simulating the behavior of a basic digital calculator.
 * @author Zamora Cruz Diego Arturo
 * @since 2022-01-12
 */
public class DigitalCalculator {

    /* Queue of operators. */
    private Queue<String> operators;
    /* Queue of operands. */
    private Queue<Double> operands;
    /* Boolean value if a number has point. */
    private boolean hasPoint;
    /* String of a new number. */
    private String creatNumber;
    /* The mathematical operation. */
    private String operation;
    /* Result of a previous operation. */
    private double memory;

    /**
     * Empty constructor.
     */
    public DigitalCalculator() {
        clearData();
    }

    /**
     * Return the mathematical operation.
     * @return the mathematical operation.
     */
    public String getOperation() {
        if (this.operation.equals("")) {
            return "0";
        }
        return this.operation;
    }

    /**
     * Return the boolean value if a number has point.
     * @return the boolean value if a number has point.
     */
    public boolean getHasPoint() {
        return hasPoint;
    }

    /**
     * Sets the boolean value if a number already has a point or not
     * by inverting previous value.
     */
    public void setHasPoint() {
        this.hasPoint = !(this.hasPoint);
    }

    /**
     * Sets the boolean value if a number already has a point or not with
     * the received value.
     * @param hasPoint the new boolean value if a number already has
     * a point or not.
     */
    public void setHasPoint(boolean hasPoint) {
        this.hasPoint = hasPoint;
    }

    /**
     * Return the value of a previous operation.
     * @return the value of a previous operation.
     */
    public double getMemory() {
        return this.memory;
    }

    /**
     * Return the new number.
     * @return the new number.
     */
    public String getNumber() {
        return this.creatNumber;
    }

    /**
     * Clear all data in the calculator.
     */
    public void clearData() {
        this.operators = new LinkedList<String>();
        this.operands = new LinkedList<Double>();
        this.hasPoint = false;
        this.creatNumber = "";
        this.operation = "";
        this.memory = 0;
    }

    /**
     * Return True if the calculator is empty, False in other case.
     * @return True if the calculator is empty, False in other case.
     */
    public boolean isClean() {
        if (this.creatNumber.equals("") &&
                this.operands.isEmpty() &&
                this.operators.isEmpty() &&
                this.memory == 0) {
            return true;
        }
        return  false;
    }

    /**
     * Type the number zero.
     */
    public void enterZero() {
        if (this.creatNumber.equals("0")) {
            return;
        }
        this.operation += "0";
        this.creatNumber += "0";
    }

    /**
     * Type the number one.
     */
    public void enterOne() {
        this.operation += "1";
        this.creatNumber += "1";
    }

    /**
     * Type the number two.
     */
    public void enterTwo() {
        this.operation += "2";
        this.creatNumber += "2";
    }

    /**
     * Type the number three.
     */
    public void enterThree() {
        this.operation += "3";
        this.creatNumber += "3";
    }

    /**
     * Type the number four.
     */
    public void enterFour() {
        this.operation += "4";
        this.creatNumber += "4";
    }

    /**
     * Type the number five.
     */
    public void enterFive() {
        this.operation += "5";
        this.creatNumber += "5";
    }

    /**
     * Type the number six.
     */
    public void enterSix() {
        this.operation += "6";
        this.creatNumber += "6";
    }

    /**
     * Type the number seven.
     */
    public void enterSeven() {
        this.operation += "7";
        this.creatNumber += "7";
    }

    /**
     * Type the number eight.
     */
    public void enterEight() {
        this.operation += "8";
        this.creatNumber += "8";
    }

    /**
     * Type the number nine.
     */
    public void enterNine() {
        this.operation += "9";
        this.creatNumber += "9";
    }

    /**
     * Type the decimal point.
     */
    public void enterPoint() {
        if (this.hasPoint) {
            return;
        }
        this.hasPoint = true;
        if (this.creatNumber.equals("")) {
            this.operation += "0.";
            this.creatNumber += "0.";
        }
        else {
            this.operation += ".";
            this.creatNumber += ".";
        }
    }

    /**
     * Type the addition mathematical operation.
     */
    public void enterAdd() {
        if (!(this.creatNumber.equals(""))) {
            this.operation += "+";
            this.operators.add("+");
            toNumber();
            this.creatNumber = "";
        }
    }

    /**
     * Type the subtraction mathematical operation.
     */
    public void enterSubtraction() {
        if (!(this.creatNumber.equals(""))) {
            this.operation += "-";
            this.operators.add("-");
            toNumber();
            this.creatNumber = "";
        }
    }

    /**
     * Type the product mathematical operation.
     */
    public void enterProduct() {
        if (!(this.creatNumber.equals(""))) {
            this.operation += "x";
            this.operators.add("x");
            toNumber();
            this.creatNumber = "";
        }
    }

    /**
     * Type the division mathematical operation.
     */
    public void enterDivide() {
        if (!(this.creatNumber.equals(""))) {
            this.operation += "/";
            this.operators.add("/");
            toNumber();
            this.creatNumber = "";
        }
    }

    /**
     * Type the percentage of a number.
     */
    public void enterPercentage() {
        if (!(this.creatNumber.equals(""))) {
            this.operation += "%";
            this.operators.add("%");
            toNumber();
            this.creatNumber = "";
        }
    }

    /**
     * Calculates the result of a mathematical operation.
     * @return result of a mathematical operation.
     */

    /*
    5+= --> Exit
    == --> Exit
    */
    public double enterEqual() {
        if (this.operands.size() == this.operators.size() &&
                this.creatNumber.equals("")) {
            Queue<String> newQueue = new LinkedList<String>();
            do {
                String operation = this.operators.poll();
                if (!(this.operators.isEmpty())) {
                    newQueue.add(operation);
                }
            } while (!(this.operators.isEmpty()));
            this.operators = newQueue;
            this.operators.add("+");
            this.creatNumber = "0";

        }
        if (this.operators.isEmpty()) {
            return Double.parseDouble(creatNumber);
        }
        toNumber();
        double number1 = this.operands.poll();
        double number2 = this.operands.poll();
        do {
            number1 = operations(number1, number2, this.operators.poll());
            if (!(this.operands.isEmpty())) {
                number2 = this.operands.poll();
            }
        } while (!(this.operators.isEmpty()));
        clearData();
        this.memory = number1;
        return number1;
    }

    /* Do a mathematical operation. */
    private double operations(double number1, double number2, String operation) {
        double result;
        switch (operation) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "x":
                result = number1 * number2;
                break;
            case "/":
                if (number2 == 0) {
                    throw new ArithmeticException("Divide by zero");
                } else {
                    result = number1 / number2;
                }
                break;
            default:
                result = 0;
        }
        return result;
    }

    /**
     * Coninues calculating with the result of a previous operation.
     */
    public void addMemory() {
        this.creatNumber += this.memory;
        this.operation += this.memory;
        this.memory = 0;
    }

    private void opcional(double number) {
        char[] stringNumber = Double.toString(number).toCharArray();
        for (int i = 0; i < stringNumber.length; i++) {
            char character = stringNumber[i];
            switch (character) {
                case '0':
                    enterZero();
                    break;
                case '1':
                    enterOne();
                    break;
                case '2':
                    enterTwo();
                    break;
                case '3':
                    enterThree();
                    break;
                case '4':
                    enterFour();
                    break;
                case '5':
                    enterFive();
                    break;
                case '6':
                    enterSix();
                    break;
                case '7':
                    enterSeven();
                    break;
                case '8':
                    enterEight();
                    break;
                case '9':
                    enterNine();
                    break;
                default:
                    enterPoint();
            }
        }
    }

    /* Covert a string to double and insert the number in this.opertands */
    private void toNumber() {
        double number = Double.parseDouble(this.creatNumber);
        this.operands.add(number);
    }
}