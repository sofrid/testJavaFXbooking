package com.example.inlamning3javafx;

/**
 * Biobokningssystem i JavaFx.
 * Användaren ska kunna välja film,
 * antal biljetter,
 * se pris
 * samt välja till tilltugg.
 *
 * @author Sofia Ridderstad
 * @version 1.0
 * @since 2018-12-27
 */

// För att visa olika funktioner och hur de fungarar,
// samt att programet fungerar med olika typer av funktionalitet kombinerad,
// valde jag att låta viss funktionalitet så som att man kan se totalpris gå förlorat.

// Jag ansåg att det gav mer för uppgiften och framtida programmering
// att fokusera på att få med alla olika typer av funktionalitet
// i programet samt visa att jag får programmet att fungera med de olika delarna i,
// än att göra ett optimalt bokningssystem i första skedet.

import javafx.application.*;
import javafx.beans.Observable;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.collections.*;

public class Inlamning3JavaFx extends Application {

    Label response;
    Label response2;
    Label response3;
    Label selected3;
    TextField tf;
    CheckBox cbFanta;
    CheckBox cbSprite;
    CheckBox cbChoklad;
    CheckBox cbGlass;
    CheckBox cbCola;
    CheckBox cbLoka;
    CheckBox cbPopCorn;
    CheckBox cbGottBlandat;
    String bioVal;

    public static void main(String[] args) {

        // Start the application by calling launch().
        launch(args);
    }

    /**
     * JavaFx body and structure to make the programme work.
     * A list to chose from for films.
     * A interaktive textfield for number of tickets.
     * A list of checkboxes for a choice of extras.
     * @param myStage
     */

    // Override the start() method.
    public void start(Stage myStage) {

        // Stage Title
        myStage.setTitle("Bio Bokning JavaFX");

        // I´m using a FlowPane for the root Node. In this case,
        // vertical and horizontal gaps of 10.
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);

        // Center the controls in the scene.
        rootNode.setAlignment(Pos.CENTER);

        // Creating the scene.
        Scene myScene = new Scene(rootNode, 500, 650);
        myScene.getStylesheets().add("Stylesheet.css");

        // Setting the Scene on the Stage.
        myStage.setScene(myScene);

        Label headingTopp = new Label("Steg 1. Välj film:");
        headingTopp.setId("headOne"); // Set Id CSS

        // Create a label for chosing movie.
        response = new Label("Ingen film vald:");
        response.setId("label1"); // Set Id CSS

        // Create an ObservableList of entries for the list view.
        ObservableList<String> bioFilmer =
                FXCollections.observableArrayList("Frost 100kr/st", "007 Skyfall 120kr/st",
                        "Batman 120kr/st", "Sensless 100kr/st");

        // Create the list view.
        ListView<String> lvBioFilmer = new ListView<>(bioFilmer);
        lvBioFilmer.getStyleClass().add("lista1"); // Get CSS Class

        // Set the preferd width and height.
        lvBioFilmer.setPrefSize(50, 80);

        // Get the list view selection model.
        MultipleSelectionModel<String> lvSelModel =
                lvBioFilmer.getSelectionModel();

        // Use a change listener to respond to a change of selection within a list view.
        lvSelModel.selectedItemProperty().addListener(
                new ChangeListener<String>() {

                    public void changed(ObservableValue<? extends String> changed,
                                        String oldVal, String newVal) {

                        //Display the selection.
                        response.setText("Film vald: " + newVal);
                    }
                });

        // Create Label for choosing number of tickets
        Label headingMitt = new Label("Steg 2. Välj antal Biljetter:");
        headingMitt.setId("headTwo"); // Set Id CSS

        // Create a label that will report the state of the
        // selected check box.
        response3 = new Label("Antal biljetter ej valt.");
        response3.setId("label3"); // Set Id CSS

        // Create a button that get the text.
        Button btnGetText = new Button("Bekräfta antal Biljetter");
        btnGetText.getStyleClass().add("button1"); // Get CSS class

        // Create a text field
        tf = new TextField();

        // Set the prompt.
        tf.setPromptText("Välj antal Biljetter");

        // Set preferred column count.
        tf.setPrefColumnCount(15);

        // Use a lambda expression to handle action events for the text field.
        //Action events are generated when ENTER is pressed while the text field
        // has input focus. In this case, the text in the field is obtained
        // and displayed.
        tf.setOnAction( (ae) -> response3.setText("Antal valda biljetter är: " + tf.getText()));

        // Use a lambda expression to get text from the text field when the button is pressed.
        btnGetText.setOnAction( (ae) ->
                response3.setText("Antal valda biljetter är: " + tf.getText()));

        Label headingBotten = new Label("Steg 3. Välj tillbehör:");
        headingBotten.setId("headThree"); // Set Id CSS

        // Create a label that will report the state change of a checkbox.
        response2 = new Label("");
        response2.setId("label2"); // Set Id CSS

        // Create a label that will report all selected check boxes.
        selected3 = new Label("");
        selected3.setId("label4"); // Set Id CSS

        // Create the check boxes.
        cbFanta = new CheckBox("Fanta 15kr");
        cbSprite = new CheckBox("Sprite 15kr");
        cbChoklad = new CheckBox("Chokladkaka 20kr");
        cbGlass = new CheckBox("Glasspinne 10kr");
        cbCola = new CheckBox("Coca-Cola 15kr");
        cbLoka = new CheckBox("Loka 15kr");
        cbPopCorn = new CheckBox("Popcorn 20kr");
        cbGottBlandat = new CheckBox("Gott & Blandat 20kr");

        // Handle action events or the checkboxes.
        cbFanta.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cbFanta.isSelected())
                    response2.setText("Fanta vald.");
                else
                    response2.setText("Fanta borttagen.");

                showAll();
            }
        });

        cbSprite.setOnAction(new EventHandler<ActionEvent>() {
           public void handle(ActionEvent ae) {
               if(cbSprite.isSelected())
                   response2.setText("Sprite vald.");
               else
                   response2.setText("Sprite borttagen.");

               showAll();
            }
        });

        cbChoklad.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cbChoklad.isSelected())
                    response2.setText("Chokladkaka vald.");
                else
                    response2.setText("Chokladkaka borttagen.");

                showAll();
            }
        });

        cbGlass.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cbGlass.isSelected())
                    response2.setText("Glasspinne vald.");
                else
                    response2.setText("Glasspinne borttagen.");

                showAll();
            }
        });

        cbCola.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cbCola.isSelected())
                    response2.setText("Coca-Cola vald.");
                else
                    response2.setText("Coca-Cola borttagen.");

                showAll();
            }
        });

        cbLoka.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cbLoka.isSelected())
                    response2.setText("Loka vald.");
                else
                    response2.setText("Loka borttagen.");

                showAll();
            }
        });

        cbPopCorn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cbPopCorn.isSelected())
                    response2.setText("Popcorn vald.");
                else
                    response2.setText("Popcorn borttagen.");

                showAll();
            }
        });

        cbGottBlandat.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cbGottBlandat.isSelected())
                    response2.setText("Gott & Blandat vald.");
                else
                    response2.setText("Gott & Blandat borttagen.");

                showAll();
            }
        });

        // Use a separators to better organize the layout.
        Separator separator = new Separator();
        separator.setPrefWidth(320);

        Separator separatorEtt = new Separator();
        separator.setPrefWidth(320);

        Separator separatorTva = new Separator();
        separator.setPrefWidth(320);

        Separator separatorTre = new Separator();
        separator.setPrefWidth(320);


        // Add the label and the list view to change the scene graph.
        rootNode.getChildren().addAll(separator, headingTopp, lvBioFilmer, response,
                separatorEtt, headingMitt, tf, btnGetText, response3,
                separatorTva, headingBotten, cbFanta, cbSprite, cbChoklad, cbGlass, cbCola,
                cbLoka, cbPopCorn, cbGottBlandat, response2, selected3, separatorTre);

        // Show the stage and its scene.
        myStage.show();
    }

    /**
     * Update and show the selections.
     * In order as the user changes choices.
     */

    // Update and show the selections.
    void showAll() {
        bioVal = "";
        if(cbFanta.isSelected()) bioVal = "Fanta ";
        if(cbSprite.isSelected()) bioVal += "Sprite ";
        if(cbChoklad.isSelected()) bioVal += "Chokladkaka ";
        if(cbGlass.isSelected()) bioVal += "Glasspinne ";
        if(cbCola.isSelected()) bioVal += "Coca-Cola ";
        if(cbLoka.isSelected()) bioVal += "Loka ";
        if(cbPopCorn.isSelected()) bioVal += "Popcorn ";
        if(cbGottBlandat.isSelected()) bioVal += "Gott & Blandat ";

        selected3.setText("Valda tillbehör är: " + bioVal);
    }
}
