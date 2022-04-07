
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.util.Callback;

public class Controller {
    public void initialize() {
        datePicker.setValue(LocalDate.now());
    }

    @FXML
    private Button addButton;

    @FXML
    private TextField addItemField;

    @FXML
    private DatePicker datePicker;

    // list of tasks with buttons
    @FXML
    private ListView<String> list;

    ObservableList<String> listview = FXCollections.observableArrayList("addItemField.getText()");

    @FXML
    private Label todolabel;

    static class Cell extends ListCell<String> {
        HBox hbox = new HBox();
        Button removeButton = new Button("Remove");
        Button markCompleteButton = new Button("Mark Complete");
        Label taskDescription = new Label("Some Text");
        Separator separate = new Separator();
        Region region = new Region();

        public Cell() {
            super();
            hbox.getChildren().addAll(taskDescription, markCompleteButton,
                    removeButton);
            // hbox.setHgrow(taskDescription, Priority.ALWAYS);
        }

        @Override
        public void updateItem(String task, boolean empty) {
            super.updateItem(task, empty);
            setText(null);
            setGraphic(null);

            if (task != null && !empty) {
                taskDescription.setText(task);
                // TaskHboxController customCell = new TaskHboxController();
                // customCell.setLabelText(task);

                setGraphic(hbox);
            }
        }
    }

    @FXML
    void addButtonClicked(ActionEvent event) {

        list.setItems(listview);
        list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new Cell();
            }
        });
        // list.setCellFactory(param -> new ListCell<String>());

    }

}

// TaskHboxController task = new TaskHboxController();
// task.setLabelText(addItemField.getText());

// tasks.add(task);
// System.out.println(task.getTasklabel().getText());

// listView = new ListView<TaskHboxController>(tasks);
// uncomment
// lvMain.setItems();

// lvMain.setCellFactory(new Callback<ListView<TaskHboxController>,
// ListCell<TaskHboxController>>() {
// @Override
// public ListCell call(ListView param) {
// return new ListViewCell();
// }

// });

// uncomment
// tasks.add(new Task(addItemField.getText(), datePicker.getValue()));
// tasksListView.setItems(tasks);
