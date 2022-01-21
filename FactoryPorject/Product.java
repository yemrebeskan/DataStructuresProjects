public class Product implements IProduct {

    String name;

    Product(String name){    // creates products by name
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean isManufactured(Product anEntry, FactoryLine factory) {
        if (factory.count(anEntry.name) > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isStored(Product anEntry, BedWarehouse bedWarehouse, BookcaseWarehouse bookWarehouse, ChairWarehouse chairWarehouse, DresserWarehouse dresserWarehouse, SofaWarehouse sofaWarehouse, TableWarehouse tableWarehouse) {
        if ((anEntry.name.equals("Bed")) && (!(bedWarehouse.isEmpty()))){
            return true;
        }else if ((anEntry.name.equals("Bookcase")) && (!(bookWarehouse.isEmpty()))){
            return true;
        }else if ((anEntry.name.equals("Chair")) && (!(chairWarehouse.isEmpty()))){
            return true;
        }else if ((anEntry.name.equals("Dresser")) && (!(dresserWarehouse.isEmpty()))){
            return true;
        }else if ((anEntry.name.equals("Sofa")) && (!(sofaWarehouse.isEmpty()))){
            return true;
        }else if ((anEntry.name.equals("Table")) && (!(tableWarehouse.isEmpty()))){
            return true;
        }else{
        return false;
        }
    }

    @Override
    public boolean isSold(Product anEntry, BedWarehouse bedWarehouse, BookcaseWarehouse bookWarehouse, ChairWarehouse chairWarehouse, DresserWarehouse dresserWarehouse, SofaWarehouse sofaWarehouse, TableWarehouse tableWarehouse) {
        if ((anEntry.name.equals("Bed")) && (bedWarehouse.sold)>0){
            return true;
        }else if ((anEntry.name.equals("Bookcase")) && (bookWarehouse.sold)>0){
            return true;
        }else if ((anEntry.name.equals("Chair")) && (chairWarehouse.sold)>0){
            return true;
        }else if ((anEntry.name.equals("Dresser")) && (dresserWarehouse.sold)>0){
            return true;
        }else if ((anEntry.name.equals("Sofa")) && (sofaWarehouse.sold)>0){
            return true;
        }else if ((anEntry.name.equals("Table")) && (tableWarehouse.sold)>0){
            return true;
        }else {
            return false;
        }
    }
}
