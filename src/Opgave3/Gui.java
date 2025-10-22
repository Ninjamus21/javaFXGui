package Opgave3;

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
        stage.setTitle("Opgave3.Gui tester");
        GridPane pane = new GridPane();
        initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextField indskud = new TextField();
    private final TextField rente = new TextField();
    private final TextField antalRenteTilskrivninger = new TextField();
    private final Label fremtidigeVærdi = new Label();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(true);
        // set padding of frame
        pane.setPadding(new Insets(20));
        // set horizontal
        pane.setHgap(20);
        // set vertical
        pane.setVgap(20);

        Label lblIndskud = new Label("Indskud");
        pane.add(lblIndskud, 0, 0);
        pane.add(indskud, 1, 0, 1, 1);

        Label lblRente = new Label("Rente");
        pane.add(lblRente, 0, 1);
        pane.add(rente, 1, 1, 1, 1);

        Label lblantalRenteTilskrivninger = new Label("AntalRenteTilskrivninger");
        pane.add(lblantalRenteTilskrivninger, 0, 2);
        pane.add(antalRenteTilskrivninger, 1, 2, 1, 1);

        Label lblFremtidigVærdi = new Label("Fremtidige værdi");
        pane.add(lblFremtidigVærdi, 0, 4);
        pane.add(fremtidigeVærdi, 1, 4);


        Button btnUdregn = new Button("udregn");
        pane.add(btnUdregn, 1, 3);
        btnUdregn.setOnAction(event -> udregnRente());
    }

    private void udregnRente() {

        double indskudDouble = Double.parseDouble(indskud.getText());
        double renteDouble = Double.parseDouble(rente.getText()) / 100;
        int antalRenteIndskudInt = Integer.parseInt(antalRenteTilskrivninger.getText());

        double fremtidigeVærdiInt = (indskudDouble * Math.pow((1 + renteDouble), antalRenteIndskudInt));

        fremtidigeVærdi.setText(String.format("%.2f",fremtidigeVærdiInt));
    }

}
