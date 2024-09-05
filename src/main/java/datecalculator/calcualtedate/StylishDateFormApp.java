package datecalculator.calcualtedate;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/public class StylishDateFormApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create DatePicker with a style
        DatePicker datePicker = new DatePicker();
        datePicker.setStyle("-fx-font-size: 14px; -fx-background-color: #f0f0f0;");

        // Create TextFields for Date 1 and Date 2 with styles
        TextField date1Field = createStyledTextField();
        TextField date2Field = createStyledTextField();

        // Create RadioButtons for Yes and No options with styles
        RadioButton yesOption = new RadioButton("Yes");
        RadioButton noOption = new RadioButton("No");
        yesOption.setStyle("-fx-font-size: 14px;");
        noOption.setStyle("-fx-font-size: 14px;");

        ToggleGroup toggleGroup = new ToggleGroup();
        yesOption.setToggleGroup(toggleGroup);
        noOption.setToggleGroup(toggleGroup);

        // Event Handling for RadioButtons
        yesOption.setOnAction(event -> updateDates(datePicker, date1Field, date2Field, true));
        noOption.setOnAction(event -> updateDates(datePicker, date1Field, date2Field, false));

        // Create Labels with styles
        Label pickDateLabel = createStyledLabel("Pick the Date:");
        Label date1Label = createStyledLabel("Date 1:");
        Label date2Label = createStyledLabel("Date 2:");
        Label selectOptionLabel = createStyledLabel("Select Option:");

        // Create layout containers
        VBox datePickerBox = new VBox(10, pickDateLabel, datePicker);
        datePickerBox.setAlignment(Pos.CENTER_LEFT);

        VBox date1Box = new VBox(10, date1Label, date1Field);
        date1Box.setAlignment(Pos.CENTER_LEFT);

        VBox date2Box = new VBox(10, date2Label, date2Field);
        date2Box.setAlignment(Pos.CENTER_LEFT);

        HBox radioButtonBox = new HBox(20, yesOption, noOption);
        radioButtonBox.setAlignment(Pos.CENTER_LEFT);
        
        VBox optionsBox = new VBox(10, selectOptionLabel, radioButtonBox);
        optionsBox.setAlignment(Pos.CENTER_LEFT);

        // Main layout container
        VBox mainLayout = new VBox(20, datePickerBox, date1Box, date2Box, optionsBox);
        mainLayout.setPadding(new Insets(30));
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setStyle("-fx-background-color: #ffffff; -fx-border-color: #dedede; -fx-border-radius: 10; -fx-border-width: 2; -fx-background-radius: 10;");

        // Set up the Stage and Scene
        Scene scene = new Scene(mainLayout, 400, 400);
        scene.getStylesheets().add("style.css"); // Add custom stylesheet if needed

        primaryStage.setTitle("Stylish Date Picker Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to create a styled TextField
    private TextField createStyledTextField() {
        TextField textField = new TextField();
        textField.setEditable(false);
        textField.setFont(Font.font("Arial", 14));
        textField.setStyle("-fx-background-color: #f5f5f5; -fx-border-color: #cccccc; -fx-border-radius: 5; -fx-padding: 5 10 5 10;");
        return textField;
    }

    // Method to create a styled Label
    private Label createStyledLabel(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("Arial", 14));
        label.setTextFill(Color.DARKSLATEGRAY);
        return label;
    }

    // Method to update Date1 and Date2 fields based on user selection
    private void updateDates(DatePicker datePicker, TextField date1Field, TextField date2Field, boolean isYesSelected) {
        LocalDate selectedDate = datePicker.getValue();
        if (selectedDate != null) {
            LocalDate date1;
            LocalDate date2;

            if (isYesSelected) {
                date1 = selectedDate.plusDays(15);
                date2 = selectedDate.plusDays(30);
            } else {
                date1 = selectedDate.plusDays(10);
                date2 = selectedDate.plusDays(20);
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date1Field.setText(date1.format(formatter));
            date2Field.setText(date2.format(formatter));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}