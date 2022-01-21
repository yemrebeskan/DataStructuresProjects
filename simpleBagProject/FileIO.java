import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FileIO {
    public static InventoryBag<Item> readFiles(String filename) {
        InventoryBag<Item> itemBag = new InventoryBag<Item>(); //create a bag
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String fileLine = myReader.nextLine();
                String[] line = fileLine.split(",");     //separate lines for get names,category,amount attributes.
                String name = line[0];                   //name
                String compartment = line[1];            //category
                int weigth = Integer.parseInt(line[2]);  //amount
                Item item = new Item(name, compartment, weigth); //create a object.
                itemBag.add(item); //add to the bag.
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return itemBag;
    }
}