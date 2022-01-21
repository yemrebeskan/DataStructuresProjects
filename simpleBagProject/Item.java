public class Item {

    String name;
    String category;
    static int a;
    int amount;
    public static String items = "";

    Item(String name,String category,int amount){    //This instructor for creating items with name, category and amount.
        this.name = name;
        this.category = category;
        this.amount = amount;
        a++;
        items += "[" + a + "]" + this.name + "\n";    //This variable to display all of the items together.
    }
    public String toString(){    //We used this to get information about items in the bags.
        return name + "," + category + "," + amount;
    }
}
