/* 
 * GroceryStore.java
 * Date: Oct 6, 2022
 * Authors: Javier, Andy, Mithun
 * SOFE 3650U
 * This class contians the main program where the users can create new product objects through the abstract class factory and factory method
 */

import java.util.*;

public class GroceryStore {
    public static void main(String []args) {
        
        //initialize runAddProduct that is true if the use wnats to add another product
        boolean runAddProduct = true;

        //initialze varialbes used for they type of factory and type of factory product
        boolean snack = false;
        String productType = "";

        //intialize scanner
        Scanner input = new Scanner(System.in);

        while(runAddProduct){

            //user can only select 2 factories to build
            boolean invalidFactory = true;
            int productClass = 0; //intialize user input for factory 

            while(invalidFactory){
                //get input of product class (either snack or drink)
                System.out.println("What class of product would you like to add (SNACK - 1) or (DRINK - 2)?: ");
                productClass = input.nextInt();
                if(productClass == 1){
                    snack = true;
                    invalidFactory = false;

                }else if(productClass == 2){
                    snack = false;
                    invalidFactory = false;

                }else{
                    invalidFactory = true;
                }
            }
            //convert the user input into snak boolean value



            //create the factory of the generalized product that was selected from the user input
            AbstractFactory groceryFac = GroceryProductFactory.getFactory(snack);

            boolean userSelInvalid = true;

            while(userSelInvalid){
                //get user input for the type of product they want to create
                System.out.println("Enter your product | 1 - CHIPS | 2 - APPLE | 3 - NAKEDJUICE | 4 - BEER | : ");
                int productInput = input.nextInt();

                //checking if the user selected a valid product
                if(productInput == 1 ){
                    if(productClass == 1){
                        productType = "CHIPS";
                        userSelInvalid = false;
                    }else{
                        System.out.println("The product selected does not match with the product type. Please select another product");  
                        userSelInvalid = true;
                    }
                }

                if(productInput == 2 ){
                    if(productClass == 1){
                        productType = "APPLE";
                        userSelInvalid = false;
                    }else{
                        System.out.println("The product selected does not match with the product type. Please select another product");  
                        userSelInvalid = true;
                    }
                }

                if(productInput == 3 ){
                    if(productClass == 2){
                        productType = "JUICE";
                        userSelInvalid = false;
                    }else{
                        System.out.println("The product selected does not match with the product type. Please select another product");  
                        userSelInvalid = true;
                    }
                }

                if(productInput == 4 ){
                    if(productClass == 2){
                        productType = "BEER";
                        userSelInvalid = false;
                    }else{
                        System.out.println("The product selected does not match with the product type. Please select another product");  
                        userSelInvalid = true;
                    }
                }
                
            }

            //create the product that is selected from user input 
            Products snack1 = groceryFac.getProduct(productType);

            snack1.setprice();

            //promt the user if they want to add another product
            input.nextLine();
            System.out.println("Do you want to add another product? ( Y / N ): ");
            String addAnotherProduct = input.nextLine();
            if(addAnotherProduct.equalsIgnoreCase("Y")){
                runAddProduct = true;
            }else if(addAnotherProduct.equalsIgnoreCase("N")){
                runAddProduct = false;
                System.out.println("Program will not close. Have a good day!");
            }
        }

        input.close();
    }
}
