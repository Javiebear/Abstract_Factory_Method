public class GroceryProductFactory {
    
    public static AbstractFactory getFactory(boolean snack) {
        if (snack) {
            return new SnackFactory();
        } else {
            return new DrinkFactory();
        }
    }

}
