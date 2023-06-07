module calc.simplecalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens calc.simplecalculator to javafx.fxml;
    exports calc.simplecalculator;
}