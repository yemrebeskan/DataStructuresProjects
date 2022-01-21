import java.util.Scanner;

public class ShoppingApp {
    public static void main(String[] args) {
        ShoppingBasket<Item> Shop_Basket = new ShoppingBasket<>();    //We created basket bag for shopping.
        BevaragesCompartment<Item> BevaragesComp = new BevaragesCompartment<>();    //We used these compartments to fill the fridge.
        VegetablesFruitsCompartment<Item> VegFruComp = new VegetablesFruitsCompartment<>();
        SnacksCompartment<Item> SnackComp = new SnacksCompartment<>();
        MeatsCompartment<Item> MeatComp = new MeatsCompartment<>();
        InventoryBag<Item> InventoryBag = FileIO.readFiles("inventory.txt");    //We called the method we created to read file and send the information to Item constructor.
        Scanner scanner = new Scanner(System.in);    //We used this to get inputs from user.
        System.out.println("Welcome to The Shopping App");    //Opening

        while (true) {    //We used infinite while loop for the user to shop as long as user wants.
            System.out.println("Please select an option:\n" + "[1]Go to shopping\n" + "[2]See the status of the fridge\n" + "[3]Exit");    //These are the options.
            int option = scanner.nextInt();    //Here is the user input.
            if (option == 1) {    //If user wants to go to shopping;
                while(true){    //This is another infinite loop to keep the user in the shop and give the user a chance to quit.
                    System.out.println("Please select an option:\n" + "[1]Add an item to the basket\n" + "[2]See the basket\n" + "[3]Finish shopping");    //These are the options when the user choose to shop.
                    int option3 = scanner.nextInt();    //User input
                    if(option3 == 1) {
                        System.out.print(Item.items);    //We printed items.
                        System.out.println("Please select an item:");
                        int option2 = scanner.nextInt();    //User chooses item.
                        if (Shop_Basket.contains(InventoryBag.getEntry(option2 - 1))){    //We didn't want user to put same thing twice at once, but they can add after filling the fridge.
                            InventoryBag.transferto(Shop_Basket, InventoryBag.getEntry(option2 - 1));    //Transfers item from inventory to basket.
                        }else{     //This is the message if user wants to add same thing again to the same basket.
                            System.out.println("You have already had that in your basket");
                        }
                        if (Shop_Basket.isFull()) {    //After basket gets full
                            System.out.println("Basket is full now.");
                            System.out.println("Shopping is finished and going to fill the fridge.");
                            int i = 0;
                            int b = Shop_Basket.getItemCount();
                            while (i != b) {
                                Item item = Shop_Basket.getEntry(i);
                                if (item != null) {    //We send items to related fridge compartment and remove them from basket.
                                    if (item.category.equals("vegetables and fruits")) {
                                        Shop_Basket.transferto(VegFruComp, item);
                                        Shop_Basket.remove(item);
                                    } else if (item.category.equals("meats")) {
                                        Shop_Basket.transferto(MeatComp, item);
                                        Shop_Basket.remove();
                                    } else if (item.category.equals("beverages")) {
                                        Shop_Basket.transferto(BevaragesComp, item);
                                        Shop_Basket.remove(item);
                                    } else if (item.category.equals("snacks")) {
                                        Shop_Basket.transferto(SnackComp, item);
                                        Shop_Basket.remove(item);
                                    }
                                }
                                i++;
                            }
                            Shop_Basket.dump();    //We cleared the basket to make sure.
                            System.out.println("The fridge is filled.");
                        }
                        //}
                    }
                    else if(option3 == 2) {    //This option shows the items in the basket.
                        Shop_Basket.displayItems();
                    }
                    else if(option3 == 3) {    //This option again sends the items to the fridge and clears the basket.
                        System.out.println("Shopping is finished and going to fill the fridge.");
                        int i = 0;
                        int b = Shop_Basket.getItemCount();
                        while (i != b) {
                            Item item = Shop_Basket.getEntry(i);
                            if (item != null) {
                                if (item.category.equals("vegetables and fruits")) {
                                    Shop_Basket.transferto(VegFruComp, item);
                                    Shop_Basket.remove(item);
                                } else if (item.category.equals("meats")) {
                                    Shop_Basket.transferto(MeatComp, item);
                                    Shop_Basket.remove();
                                } else if (item.category.equals("beverages")) {
                                    Shop_Basket.transferto(BevaragesComp, item);
                                    Shop_Basket.remove(item);
                                } else if (item.category.equals("snacks")) {
                                    Shop_Basket.transferto(SnackComp, item);
                                    Shop_Basket.remove(item);
                                }
                            }
                            i++;
                        }
                        Shop_Basket.dump();
                        System.out.println("The fridge is filled.");
                        break;
                    }
                }
            }
            else if(option == 2) {    //This option shows the remaining capacity.
                System.out.println("Remaining capacities of each compartments:");
                VegFruComp.displayItems();
                MeatComp.displayItems();
                BevaragesComp.displayItems();
                SnackComp.displayItems();
            }
            else if(option == 3) {    //This is to quit.
                break;
            }
        }
    }
}
