package Opgave6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(true);
        // set padding of frame
        pane.setPadding(new Insets(20));
        // set horizontal
        pane.setHgap(20);
        // set vertical
        pane.setVgap(20);

        ListView<Car> carsList = new ListView<Car>();
        pane.add(carsList,0,0);

        Button btnTilføjBil = new Button("Tilføj Bil");
        pane.add(btnTilføjBil,0,1,2,1);

        btnTilføjBil.setOnAction(event -> addCar());
    }

    private void addCar() {
        Stage carStage = new Stage();
        GridPane carPane = new GridPane();
        initCarContent(carPane);
        Scene carScene = new Scene(carPane);
        carStage.setScene(carScene);
        carStage.show();

    }
    private void initCarContent(GridPane carPane){
        carPane.setGridLinesVisible(true);
        // set padding of frame
        carPane.setPadding(new Insets(20));
        // set horizontal
        carPane.setHgap(20);
        // set vertical
        carPane.setVgap(20);

        Label lblMærke = new Label("Mærke");
        Label lblModel = new Label("Model");
        Label lblElektrisk = new Label("Elektrisk");
        Label lblPris = new Label("pris");
        carPane.add(lblMærke,0,0);
        carPane.add(lblModel,0,1);
        carPane.add(lblElektrisk,0,2);
        carPane.add(lblPris,0,3);

        ComboBox<String> cboxMærke = new ComboBox<>();
        cboxMærke.getItems().addAll("Mercedes","BMW","Fiat","Citroen");
        carPane.add(cboxMærke,1,0);

    }


}
