package ru.mrchebik.task8;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.mrchebik.task8.person.info.Address;
import ru.mrchebik.task8.person.info.Name;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Task:
 *      Since there is no JavaFX-specific knowledge in parsing FXML files, come up with an example where you load an
 *  object that has nothing to do with JavaFX, with some nested objects, and set the properties in FXML syntax. Extra
 *  credit if you use injection.
 *
 * Created by mrchebik on 8/24/17.
 */
public class Main extends Application implements Initializable {
    @FXML private Name name;
    @FXML private Address address;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader.load(getClass().getResource("/person.fxml"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(name + " // " + address);
    }
}
