package calc.simplecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
        String buttonText = clickedButton.getText();
        System.out.println("Button clicked: " + buttonText);
        display.setText(display.getText() + " " + buttonText);
    }

}