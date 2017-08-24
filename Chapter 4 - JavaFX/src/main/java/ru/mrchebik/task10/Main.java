package ru.mrchebik.task10;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Task:
 *      Using the web viewer, implement a browser with a URL bar and a back button. Hint: 'WebEngine.getHistory()'.
 *
 * Created by mrchebik on 8/24/17.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();

        WebView browser = new WebView();
        WebEngine engine = browser.getEngine();

        HBox controls = new HBox();
        TextField location = new TextField();
        location.textProperty().setValue("http://google.com");
        location.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                if (!location.getText().startsWith("http://")) {
                    location.setText("http://" + location.getText());
                }
                engine.load(location.getText());
            }
        });
        Button back = new Button("Back");
        back.setOnAction(event -> {
            engine.getHistory().go(-1);
            location.textProperty().setValue(engine.getLocation());
        });
        back.disableProperty().bind(Bindings.createBooleanBinding(
                () -> engine.getHistory().getCurrentIndex() == 0,
                engine.getHistory().currentIndexProperty()));
        HBox.setHgrow(location, Priority.ALWAYS);
        controls.getChildren().addAll(back, location);

        pane.setTop(controls);
        pane.setCenter(browser);

        engine.load(location.getText());

        primaryStage.setScene(new Scene(pane));
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();

    }
}
