package calc.simplecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Stack;

import java.util.Hashtable;

public class CalcController {

    @FXML
    private Button clearButton;

    @FXML
    private TextField display;

    @FXML
    private Button divideButton;

    @FXML
    private Button eightButton;

    @FXML
    private Button equalsButton;

    @FXML
    private Button fiveButton;

    @FXML
    private Button fourButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button negativeButton;

    @FXML
    private Button nineButton;

    @FXML
    private Button oneButton;

    @FXML
    private Button plusButton;

    @FXML
    private Button sevenButton;

    @FXML
    private Button sixButton;

    @FXML
    private Button subButton;

    @FXML
    private Button threeButton;

    @FXML
    private Button twoButton;

    @FXML
    private Button zeroButton;

    private Hashtable<String, Button> buttonHashtable;

    @FXML
    private void initialize() {
        buttonHashtable = new Hashtable<>();

        // Add buttons to the Hashtable
        buttonHashtable.put("clearButton", clearButton);
        buttonHashtable.put("divideButton", divideButton);
        buttonHashtable.put("eightButton", eightButton);
        buttonHashtable.put("equalsButton", equalsButton);
        buttonHashtable.put("fiveButton", fiveButton);
        buttonHashtable.put("fourButton", fourButton);
        buttonHashtable.put("multiplyButton", multiplyButton);
        buttonHashtable.put("negativeButton", negativeButton);
        buttonHashtable.put("nineButton", nineButton);
        buttonHashtable.put("oneButton", oneButton);
        buttonHashtable.put("plusButton", plusButton);
        buttonHashtable.put("sevenButton", sevenButton);
        buttonHashtable.put("sixButton", sixButton);
        buttonHashtable.put("subButton", subButton);
        buttonHashtable.put("threeButton", threeButton);
        buttonHashtable.put("twoButton", twoButton);
        buttonHashtable.put("zeroButton", zeroButton);
    }


    @FXML
    void buttonClicked(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        performAction(clickedButton);

    }


    void performAction(Button buttonClicked) {
        switch (buttonClicked.getText()) {
            case "Clear":
                display.setText("");
                break;
            case "=":
                // Handle equals button action
                String expression = display.getText();
                try {
                    double result = evaluateExpression(expression);
                    display.setText(String.valueOf(result));
                } catch (ArithmeticException e) {
                    display.setText("Error: " + e.getMessage());
                }
                break;
            case "+":
                // Handle plus button action
                display.appendText(" + ");
                break;
            case "-":
                // Handle minus button action
                display.appendText(" - ");
                break;
            case "*":
                // Handle minus button action
                display.appendText(" * ");
                break;
            case "-/+":
                // Handle negation button action
                String currentText = display.getText();
                if (!currentText.isEmpty()) {
                    char firstChar = currentText.charAt(0);
                    if (firstChar == '-') {
                        display.setText(currentText.substring(1));
                    } else {
                        display.setText("-" + currentText);
                    }
                }
                break;
            default:
                // Handle other buttons or unknown actions
                display.appendText(buttonClicked.getText());
                break;
        }
    }

    private double evaluateExpression(String expression) throws ArithmeticException {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder num = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    num.append(expression.charAt(i));
                    i++;
                }
                i--;
                numbers.push(Double.parseDouble(num.toString()));
            } else if (isOperator(ch)) {
                while (!operators.isEmpty() && hasPrecedence(ch, operators.peek())) {
                    double result = performOperation(numbers.pop(), numbers.pop(), operators.pop());
                    numbers.push(result);
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            double result = performOperation(numbers.pop(), numbers.pop(), operators.pop());
            numbers.push(result);
        }

        if (numbers.size() == 1) {
            return numbers.pop();
        } else {
            throw new ArithmeticException("Invalid expression");
        }
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
    }

    private double performOperation(double operand2, double operand1, char operator) throws ArithmeticException {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return operand1 / operand2;
            default:
                throw new ArithmeticException("Invalid operator: " + operator);
        }
    }


}