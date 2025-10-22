package CounterUpDown;

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

    private final TextField Number = new TextField("0");

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        // set padding of frame
        pane.setPadding(new Insets(20));
        // set horizontal
        pane.setHgap(20);
        // set vertical
        pane.setVgap(20);

        // Label
        Label label = new Label("Nummer:");
        pane.add(label, 0, 1);

        pane.add(Number, 1, 1, 1, 1);
        Number.setEditable(false);

        Button buttonUp = new Button("+1");
        pane.add(buttonUp, 1, 0);
        buttonUp.setOnAction(event -> addUp());

        Button buttonDown = new Button("-1");
        pane.add(buttonDown, 2, 0);
        buttonDown.setOnAction(event -> addDown());



    }

    private void addDown() {
        int value = Integer.parseInt(Number.getText());
        value--;
        Number.setText(String.valueOf(value));
    }

    private void addUp() {
        int value = Integer.parseInt(Number.getText());
        value++;
        Number.setText(String.valueOf(value));
    }


}
