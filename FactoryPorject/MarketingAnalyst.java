public class MarketingAnalyst {

    public static String sendRequest(String productname, FactoryLine factory){
        Product product = new Product(productname);    // creating product by using its name
        factory.enqueue(product);    // adding the product to factory queue
        return "Marketing Analyst requesting " + product.name + ", SUCCESS, " + product.name + " is manufactured.";    // returning the message
    }
}
