public class StorageChief {

    public static String store(FactoryLine factory, BedWarehouse bedWarehouse, BookcaseWarehouse bookWarehouse, ChairWarehouse chairWarehouse, DresserWarehouse dresserWarehouse, SofaWarehouse sofaWarehouse, TableWarehouse tableWarehouse){
        if (!(factory.isEmpty())){    // if there is a product in the factory storage chief take it and store it in the related warehouse
            Product product = (Product) factory.dequeue();
            if (product.name.equals("Bed")){
                bedWarehouse.push(product);
            }else if (product.name.equals("Bookcase")){
                bookWarehouse.push(product);
            }else if (product.name.equals("Chair")){
                chairWarehouse.push(product);
            }else if (product.name.equals("Dresser")){
                dresserWarehouse.push(product);
            }else if (product.name.equals("Sofa")){
                sofaWarehouse.push(product);
            }else{
                tableWarehouse.push(product);
            }
            return "Storage Chief storing " + product.name + ", SUCCESS, " + product.name + " is stored in " + product.name + " warehouse.";    // returns the success message
        }else{
            return "Storage Chief storing, FAIL, there is nothing to store.";    // if there is nothing in the factory queue to store, returns the fail message
        }
    }
}