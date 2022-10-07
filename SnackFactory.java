public class SnackFactory extends AbstractFactory{
    
    public Products getProduct(String snackType) {
        if (snackType.equalsIgnoreCase("APPLE")) {

            return new Apple();
        } else if (snackType.equalsIgnoreCase("CHIPS")) {
            
            return new Chips();

        }
        return null;
    }
}