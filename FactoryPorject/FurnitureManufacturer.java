import java.util.Random;
import java.util.Scanner;

public class FurnitureManufacturer {
    public static void main(String[] args) {
        FactoryLine<Product> factory = new FactoryLine<>();    // creating warehouses and factory
        BedWarehouse<Product> bedWarehouse = new BedWarehouse<>();
        BookcaseWarehouse<Product> bookWarehouse = new BookcaseWarehouse<>();
        ChairWarehouse<Product> chairWarehouse = new ChairWarehouse<>();
        DresserWarehouse<Product> dresserWarehouse = new DresserWarehouse<>();
        SofaWarehouse<Product> sofaWarehouse = new SofaWarehouse<>();
        TableWarehouse<Product> tableWarehouse = new TableWarehouse<>();
        String[] products = {"Bed", "Bookcase", "Chair", "Dresser", "Sofa", "Table"};    // products list for random selection
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Enter the number of random request cycles: ");    // getting input from the user
        int input = scanner.nextInt();
        for (int i = 0; i < input; i++) {    // loop for random requests
            int r1 = random.nextInt(3);    // random number to choose between people to do their job
            int r2 = random.nextInt(6);    // random number to choose the product
            String message;
            if (r1 == 0) {    // triggers marketing analyst to manufacture the product
                message = MarketingAnalyst.sendRequest(products[r2], factory);    // getting message to print
            } else if (r1 == 1) {    // triggers storage chief to store the product
                message = StorageChief.store(factory, bedWarehouse, bookWarehouse, chairWarehouse, dresserWarehouse, sofaWarehouse, tableWarehouse);    // getting message to print
            } else {    // triggers the customer to buy a product
                message = Customer.buy(products[r2], bedWarehouse, bookWarehouse, chairWarehouse, dresserWarehouse, sofaWarehouse, tableWarehouse);    // getting message to print
            }
            System.out.println(i + 1 + ". " + message);    // prints the message
        }

        System.out.println("\nREPORT:");    // report message for each category
        System.out.println("\nAmount of Bed in Factory Line: " + factory.count("Bed") +
                "\nAmount of Bookcase in Factory Line: " + factory.count("Bookcase") +
                "\nAmount of Chair in Factory Line: " + factory.count("Chair") +
                "\nAmount of Dresser in Factory Line: " + factory.count("Dresser") +
                "\nAmount of Sofa in Factory Line: " + factory.count("Sofa") +
                "\nAmount of Table in Factory Line: " + factory.count("Table"));

        System.out.println("\nAmount of Bed in Bed Warehouse: " + bedWarehouse.inIt +
                "\nAmount of Bookcase in Bookcase Warehouse: " + bookWarehouse.inIt +
                "\nAmount of Chair in Chair Warehouse: " + chairWarehouse.inIt +
                "\nAmount of Dresser in Dresser Warehouse: " + dresserWarehouse.inIt +
                "\nAmount of Sofa in Sofa Warehouse: " + sofaWarehouse.inIt +
                "\nAmount of Table in Table Warehouse: " + tableWarehouse.inIt);

        System.out.println("\nAmount of Bed sold: " + bedWarehouse.sold +
                "\nAmount of Bookcase sold: " + bookWarehouse.sold +
                "\nAmount of Chair sold: " + chairWarehouse.sold +
                "\nAmount of Dresser sold: " + dresserWarehouse.sold +
                "\nAmount of Sofa sold: " + sofaWarehouse.sold +
                "\nAmount of Table sold: " + tableWarehouse.sold);
    }
}
