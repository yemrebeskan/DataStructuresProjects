public class Customer {

    public static String buy(String productname, BedWarehouse bedWarehouse, BookcaseWarehouse bookWarehouse, ChairWarehouse chairWarehouse, DresserWarehouse dresserWarehouse, SofaWarehouse sofaWarehouse, TableWarehouse tableWarehouse){
        String message;
        message = "Customer buying " + productname;
        if (productname.equals("Bed")){    // buying the product from the related warehouse by its name
            if (bedWarehouse.isEmpty()){    // customer cannot buy if warehouse is empty
                message += ", FAIL, Bed warehouse is empty.";
            }else{
                bedWarehouse.pop();    // if it is not empty customer can buy the product and remove it from the warehouse
                message += ", SUCCESS, Customer bought Bed.";
            }
        }else if (productname.equals("Bookcase")){
            if (bookWarehouse.isEmpty()) {
                message += ", FAIL, Bookcase warehouse is empty.";
            }else{
                bookWarehouse.pop();
                message += ", SUCCESS, Customer bought Bookcase.";
            }
        }else if (productname.equals("Chair")){
            if (chairWarehouse.isEmpty()) {
                message += ", FAIL, Chair warehouse is empty.";
            }else{
                chairWarehouse.pop();
                message += ", SUCCESS, Customer bought Chair.";
            }
        }else if (productname.equals("Dresser")){
            if (dresserWarehouse.isEmpty()) {
                message += ", FAIL, Dresser warehouse is empty.";
            }else{
                dresserWarehouse.pop();
                message += ", SUCCESS, Customer bought Dresser.";
            }
        }else if (productname.equals("Sofa")){
            if (sofaWarehouse.isEmpty()) {
                message += ", FAIL, Sofa warehouse is empty.";
            }else{
                sofaWarehouse.pop();
                message += ", SUCCESS, Customer bought Sofa.";
            }
        }else if (productname.equals("Table")) {
            if (tableWarehouse.isEmpty()) {
                message += ", FAIL, Table warehouse is empty.";
            } else {
                tableWarehouse.pop();
                message += ", SUCCESS, Customer bought Table.";
            }
        }
        return message;    // returning the message
    }
}
