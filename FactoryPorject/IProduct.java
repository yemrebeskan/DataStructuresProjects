public interface IProduct {

    public boolean isManufactured(Product anEntry, FactoryLine factory);
    // controls if the product is in the factory
    public boolean isStored(Product anEntry, BedWarehouse bedWarehouse, BookcaseWarehouse bookWarehouse, ChairWarehouse chairWarehouse, DresserWarehouse dresserWarehouse, SofaWarehouse sofaWarehouse, TableWarehouse tableWarehouse);
    // controls if the product is in the warehouse
    public boolean isSold(Product anEntry, BedWarehouse bedWarehouse, BookcaseWarehouse bookWarehouse, ChairWarehouse chairWarehouse, DresserWarehouse dresserWarehouse, SofaWarehouse sofaWarehouse, TableWarehouse tableWarehouse);
    // controls if the product is sold out
}