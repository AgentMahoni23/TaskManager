package meholli.taskManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Laden der FXML-Datei
            Parent root = FXMLLoader.load(getClass().getResource("/resources/TaskManager.fxml"));
            primaryStage.setTitle("Task Manager");
            primaryStage.setScene(new Scene(root, 400, 300));
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Start der Anwendung
    public static void main(String[] args) {
        launch(args);
    }
}
