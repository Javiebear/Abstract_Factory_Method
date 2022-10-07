/* 
 * GroceryStore.java
 * Date: Oct 6, 2022
 * Authors: Javier, Andy, Mithun
 * SOFE 3650U
 * This class is a DrinkFactory that creates a drink product
 */

public class DrinkFactory extends AbstractFactory{
    
    public Products getProduct(String drinkType) {
        if (drinkType.equalsIgnoreCase("BEER")) {
            
            return new Beer();

        } else if (drinkType.equalsIgnoreCase("JUICE")){
            
            return new NakedJuice();

        }
        return null;
    }
}