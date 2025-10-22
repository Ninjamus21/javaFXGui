package Opgave5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.security.auth.kerberos.KeyTab;

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

    private final TextField navn = new TextField();
    private final TextArea textArea = new TextArea();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(true);
        // set padding of frame
        pane.setPadding(new Insets(20));
        // set horizontal
        pane.setHgap(10);
        // set vertical
        pane.setVgap(15);

        Label lblnavn = new Label("Name");
        pane.add(lblnavn, 0, 0);
        pane.add(navn, 0, 1, 1, 1);

        pane.add(textArea, 0, 3, 2, 1);
        textArea.setEditable(false);

        Button btnTilføjNavn = new Button("Tilføj navn");
        pane.add(btnTilføjNavn, 0, 2, 2, 1);

        Button btnFjernSidste = new Button("Fjern sidste navn");
        pane.add(btnFjernSidste, 1, 2, 2, 1);

        btnTilføjNavn.setOnAction(event -> tilføjNavn());
        navn.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER){
                tilføjNavn();
            }
        });
        btnFjernSidste.setOnAction(event -> fjernSidsteNavn());
    }

    private void fjernSidsteNavn() {
        String allText = textArea.getText().trim();

        if (allText.isEmpty()) {
            return;
        }
        String[] lines = allText.split("\n");

        StringBuilder newText = new StringBuilder();
        for (int index = 0; index < lines.length -1 ; index++) {
            newText.append(lines[index]).append("\n");
        }
        textArea.setText(newText.toString());
    }

    private String tilføjNavn() {
        String navnString = navn.getText().trim();

        if (!navnString.isEmpty()) {
            textArea.appendText(navnString + "\n");
            navn.clear();
        }

        return navnString;
    }

}
