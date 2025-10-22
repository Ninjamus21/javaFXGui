package NameKombi;

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
        stage.setTitle("NameKombi.Gui tester");
        GridPane pane = new GridPane();
        initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    // test opgave-----------------------------------------------------------
    private final TextField txfName = new TextField();
    private final TextField txfLastName = new TextField();
    private final TextField txfFullName = new TextField();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        // set padding of frame
        pane.setPadding(new Insets(20));
        // set horizontal
        pane.setHgap(20);
        // set vertical
        pane.setVgap(20);

        // creating a label
        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);
        pane.add(txfName, 1, 0, 2, 1);

        Label lblLastName = new Label("Last Name:");
        pane.add(lblLastName, 0, 1);
        pane.add(txfLastName, 1, 1, 2, 1);

        // full name
        Label lblFullName = new Label("Full Name");
        pane.add(lblFullName, 0, 3);
        pane.add(txfFullName, 1, 3, 2, 1);
        txfFullName.setEditable(false);

        // add a button for kombination
        Button kombiButton = new Button("Kombinere navn");
        pane.add(kombiButton, 1, 2);
        GridPane.setMargin(kombiButton, new Insets(1, 3, 2, 1));

        // create button action
        kombiButton.setOnAction(event -> stringKombine());

    }

    private void stringKombine() {
        String first = txfName.getText();
        String last = txfLastName.getText();
        String full = (first + " " + last);

        txfFullName.setText(full);
    }
}


