package Opgave6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

    // the car list
    private ListView<Car> carsList = new ListView<>();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(true);
        // set padding of frame
        pane.setPadding(new Insets(20));
        // set horizontal
        pane.setHgap(20);
        // set vertical
        pane.setVgap(20);

        pane.add(carsList, 0, 0);

        Button btnTilføjBil = new Button("Tilføj Bil");
        pane.add(btnTilføjBil, 0, 1, 2, 1);

        btnTilføjBil.setOnAction(event -> addCarWindow());

    }

    private void addCarWindow() {
        Stage carStage = new Stage();
        GridPane carPane = new GridPane();
        initCarContent(carPane, carStage);
        Scene carScene = new Scene(carPane);
        carStage.setScene(carScene);
        carStage.show();

    }


    private void initCarContent(GridPane carPane, Stage carStage) {
        ComboBox<String> cboxMærke = new ComboBox<>();
        TextField txtModel = new TextField();
        CheckBox chbElektrisk = new CheckBox();
        TextField txtPris = new TextField();

        cboxMærke.getItems().addAll("Mercedes", "BMW", "Fiat", "Citroen");

        // layout
        carPane.setGridLinesVisible(true);
        // set padding of frame
        carPane.setPadding(new Insets(20));
        // set horizontal
        carPane.setHgap(20);
        // set vertical
        carPane.setVgap(20);

        // labels creation
        Label lblMærke = new Label("Mærke");
        Label lblModel = new Label("Model");
        Label lblElektrisk = new Label("Elektrisk");
        Label lblPris = new Label("pris");

        // label gui implenention
        carPane.add(lblMærke, 0, 0);
        carPane.add(lblModel, 0, 1);
        carPane.add(lblElektrisk, 0, 2);
        carPane.add(lblPris, 0, 3);

        // input machine
        carPane.add(cboxMærke, 1, 0);
        carPane.add(txtModel, 1, 1, 1, 1);
        carPane.add(chbElektrisk, 1, 2);
        carPane.add(txtPris, 1, 3, 1, 1);

        Button btnOpret = new Button("Opret");
        carPane.add(btnOpret, 1, 4);

        // all local - pass values to opretbil
        btnOpret.setOnAction(event -> {

            String cboxMærkeString = cboxMærke.getValue();
            String txtmodelString = txtModel.getText().trim();
            boolean chbElektriskbool = chbElektrisk.isSelected();
            int txtPrisint = Integer.parseInt(txtPris.getText().trim());

            Car newCar = new Car(cboxMærkeString, txtmodelString, chbElektriskbool, txtPrisint);
            carsList.getItems().add(newCar);

            carStage.close();

        });

    }
}
