/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartresturant;

/**
 *
 * @author Gib
 */
public class Dish {
    String name, description, picture, price;
    
    public Dish(String name ,String description ,String picture, String price){
        this.name =  name;
        this.description = description;
        this.picture = picture;
        this.price = price;
    }
    
    public Dish(){
        name = "";
        description = "";
        picture = "";
        price = "0.0";
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public String getPicture(){
        return picture;
    }
    public String getPrice(){
        return price;
    }
    
}
