package Opgave4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("CounterUpDown.Gui tester");
        GridPane pane = new GridPane();
        initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextField celcius = new TextField();
    private final TextField fahrenheit = new TextField();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(true);
        // set padding of frame
        pane.setPadding(new Insets(20));
        // set horizontal
        pane.setHgap(20);
        // set vertical
        pane.setVgap(20);

        Label lblcelcius = new Label("Celcius");
        pane.add(lblcelcius, 0, 0);
        pane.add(celcius,0,1,1,1);

        Label lblFahrenheit = new Label("Fahrenheit");
        pane.add(lblFahrenheit,2,0);
        pane.add(fahrenheit,2,1,1,1);

        Button toFahrenheit = new Button(">>");
        Button toCelcius = new Button("<<");

        pane.add(toFahrenheit,1,1);
        pane.add(toCelcius,1,2);

        toFahrenheit.setOnAction(event -> toFahrenheit());
        toCelcius.setOnAction(event -> toCelcius());

    }

    private void toCelcius() {
        double fahrenheitDouble = Double.parseDouble(fahrenheit.getText());
        fahrenheitDouble = (fahrenheitDouble - 32) / 1.8;

        celcius.setText(String.format("%.2f",fahrenheitDouble));
    }

    private void toFahrenheit() {
        double celciusDouble = Double.parseDouble(celcius.getText());
        celciusDouble = celciusDouble * 1.8 + 32;

        fahrenheit.setText(String.format("%.2f",celciusDouble));
    }

}
