/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartresturant;


import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Gib
 */
public class SmartResturant extends Application {
    ArrayList<Dish> dishes = new ArrayList<>();
    
    String name,
            description,
            picture,
            price;
    static int count = 0;
    static ArrayList<Scene> scenes = new ArrayList<>();
    static ArrayList<GridPane> panes = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage) {
        try{ 
            Scanner sc = new Scanner(getClass().getResourceAsStream("/resources/config.txt"));
  
            while(sc.hasNextLine()){
                //collect dish information from config file
                name = sc.nextLine().substring(6);
                System.out.println(name);
                description = sc.nextLine().substring(13);
                System.out.println(description);
                picture = sc.nextLine().substring(9);
                System.out.println(picture);
                price = sc.nextLine().substring(7);
                System.out.println(price);
                //create dish objects and add to the arraylist
                Dish newDish = new Dish(name, description, picture, price);
                dishes.add(newDish);
            } //end while loop
            
            //Fill GridPanes

            for(int i = 0; i <dishes.size(); i++){
                GridPane gp = new GridPane();
                Dish dish = new Dish();
                dish = dishes.get(i);
                //Name Label
                Label dishName = new Label(dish.getName());
                gp.add(dishName, 1, 1, 2, 1);
                //Desc Label
                Label dishDesc = new Label(dish.getDescription());
                dishDesc.setWrapText(true);
                dishDesc.setMaxWidth(400);
                gp.add(dishDesc, 2, 2);
                //Price Label
                Label dishPrice = new Label(dish.getPrice());
                gp.add(dishPrice, 2, 3);
                //Import Picture
                ImageView picView = new ImageView();
                Image pic = new Image(dish.getPicture());
                System.out.println("picture loaded");
                picView.setImage(pic);
                picView.setFitHeight(300);
                picView.setFitWidth(300);
                gp.add(picView, 1, 2);  
                //Buttons
                Button nextButton = new Button("Next");
                gp.add(nextButton, 2, 4);
                Button prevButton = new Button("Previous");
                gp.add(prevButton, 1, 4);
                
                
                //Button handles
                nextButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        if(count != dishes.size() - 1){
                            //primaryStage.close();
                            count++;
                            //Scene scene = new Scene(panes.get(count), 800, 800);
                            
                            primaryStage.setScene(scenes.get(count));
                            primaryStage.show();
                        } else {
                            count = 0;
                            //primaryStage.close();
                            //count++;
                            //Scene scene = new Scene(panes.get(0), 800, 800);
                            
                            primaryStage.setScene(scenes.get(count));
                            primaryStage.show();
                        }
                    }
                });
                prevButton.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e){
                        if (count != 0){
                            //primaryStage.close();
                            count--;
                            //Scene scene = new Scene(panes.get(count), 800, 800);
                            
                            primaryStage.setScene(scenes.get(count));
                            primaryStage.show();
                        } else {
                            count = dishes.size() - 1;
                            //primaryStage.close();
                            //count--;
                            //Scene scene = new Scene(panes.get(3), 800, 800);
                            
                            primaryStage.setScene(scenes.get(count));
                            primaryStage.show();
                        }
                       
                    }
                });
                panes.add(gp);
                scenes.add(new Scene(panes.get(i), 700, 400));
            }// End for
            //Set beginning scene
            primaryStage.setTitle("Menu");
            //Scene set = new Scene(panes.get(0), 800, 800);
            primaryStage.setScene(scenes.get(0));
            primaryStage.show();
        } catch(Exception ex) {
            System.out.println("Execption:" + ex + "Caught");
        }
    } //End start

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } //End main
    
}//End class
