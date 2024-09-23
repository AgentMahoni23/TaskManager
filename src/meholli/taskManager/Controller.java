package meholli.taskManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    // Referenzen zu den UI-Komponenten
    @FXML
    private TextField taskInput;

    @FXML
    private ListView<String> taskList;

    // Liste zur Speicherung der Aufgaben
    private ObservableList<String> tasks = FXCollections.observableArrayList();

    // Initialisierungsmethode
    @FXML
    public void initialize() {
        taskList.setItems(tasks);
    }

    // Methode zum Hinzufügen einer Aufgabe
    @FXML
    private void handleAddTask() {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()) {
            tasks.add(task);
            taskInput.clear();
        } else {
            showAlert("Fehler", "Aufgabenfeld ist leer!", Alert.AlertType.WARNING);
        }
    }

    // Methode zum Markieren einer Aufgabe als erledigt
    @FXML
    private void handleMarkDone() {
        int selectedIndex = taskList.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            String task = tasks.get(selectedIndex);
            if (!task.endsWith(" (Erledigt)")) {
                tasks.set(selectedIndex, task + " (Erledigt)");
            } else {
                showAlert("Info", "Aufgabe ist bereits erledigt.", Alert.AlertType.INFORMATION);
            }
        } else {
            showAlert("Fehler", "Keine Aufgabe ausgewählt.", Alert.AlertType.WARNING);
        }
    }

    // Methode zum Löschen einer Aufgabe
    @FXML
    private void handleDeleteTask() {
        int selectedIndex = taskList.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tasks.remove(selectedIndex);
        } else {
            showAlert("Fehler", "Keine Aufgabe ausgewählt.", Alert.AlertType.WARNING);
        }
    }

    // Hilfsmethode zur Anzeige von Alerts
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
