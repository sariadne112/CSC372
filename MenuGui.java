import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.lang.classfile.Label;
import java.time.LocalDate;

public class MenuGui extends Application{
  @Override
  // launch the application
    public void start(Stage primaryStage){
      primaryStage.setTitle("MENU GUI");
      // Main layout
      BorderPane pane = new BorderPane(); 
      // create a menu
      Menu menu = new Menu("Menu");

      // create menuitems
      MenuItem date = new MenuItem("Display Date & Time");
      MenuItem file = new MenuItem("Save text file");
      MenuItem color = new MenuItem("Change color");
      MenuItem exit = new MenuItem("Exit");

      // add menu items to menu
      menu.getItems().add(date);
      menu.getItems().add(file);
      menu.getItems().add(color);
      menu.getItems().add(exit);

      // Create menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

        // menu on top
        pane.setTop(menuBar);

        // create events for menu items
        // action event
        /*EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
              l.setText("\t\t\t\t" + ((MenuItem)e.getSource()).getText() + " selected");
            }
        }; */

        // add event
        /*date.setOnAction(event);
        file.setOnAction(event);
        color.setOnAction(event);
        exit.setOnAction(event); */
     
      
        
       // Create scene
        Scene scene = new Scene(pane, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        // launch the application
        launch(args);
    }
}

