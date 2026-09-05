import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.awt.MenuBar;
import java.awt.MenuItem;
import java.lang.classfile.Label;
import java.time.LocalDate;

public class MenuGui extends BankAccount{
  @Override
  // launch the application
    public void start(Stage primaryStage){
      primaryStage.setTitle("creating CustomMenu");
        //create a title pane
        TilePane r = new TilePane();
        // Create a label
        Label description_label =
                    new Label("This is a CustomMenu example ");
        // create a menu
        Menu menu = new Menu("Menu");
   

      
      pane = new Pane();                   // Create an empty pane     
      scene = new Scene(pane);             // Create a scene containing the pane
        // create menuitems
        MenuItem date = new MenuItem("Display Date");
        MenuItem file = new MenuItem("Download text file");
        MenuItem color = new MenuItem("Change color")
        MenuItem exit = new MenuItem("Exit");

        // add menu items to menu
        menu.getItems().add(date);
        menu.getItems().add(file);
        menu.getItems().add(color);
        menu.getItems().add(exit);

        // label to display events
        Label l = new Label("\t\t\t\t"
                            + "no menu item selected");

        // create events for menu items
        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                l.setText("\t\t\t\t" + ((MenuItem)e.getSource()).getText() + 
                                                               " selected");
            }
        };

        // add event
        date.setOnAction(event);
        file.setOnAction(event);
        color.setOnAction(event);
        exit.setOnAction(event);
     
        // Create a menubar
        MenuBar menubar = new MenuBar();
        // add menu to menubar
        menubar.getMenus().add(menu);

        // create a VBox
        VBox vbox = new VBox(menu, l);

        // Create a scene
        Scene scene = new Scene(vbox, 600, 600);

        // set the scene
         // Set the scene
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String args[])
    {
        // launch the application
        launch(args);
    }
}

