public class VegetablesFruitsCompartment<T> implements IBag<T>{

    private final T[] vegfrucomp;
    private int index;
    private static final int DEFAULT_CAPACITY = 3000;
    private boolean initialized = false;
    private static final int MAX_CAPACITY = 10000;
    public VegetablesFruitsCompartment() {
        this(DEFAULT_CAPACITY);
    } // end default constructor
    public VegetablesFruitsCompartment(int desiredCapacity) {
        if (desiredCapacity <= MAX_CAPACITY) {

            // The cast is safe because the new array contains null entries.
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity]; // Unchecked cast
            vegfrucomp = tempBag;
            index = 0;
            initialized = true;
        }
        else
            throw new IllegalStateException("Attempt to create a bag " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
        // TODO Auto-generated constructor stub
    }







    @Override
    public boolean add(T newItem) {
        // TODO Auto-generated method stub
        CheckInitialization();
        boolean result = true;
        if (isFull()) {
            result = false;
        }
        else {
            vegfrucomp[index] = newItem;
            index++;
        }
        // TODO Auto-generated method stub
        return result;
    }

    private void CheckInitialization() {
        if(!initialized)
            throw new SecurityException("ArrayBag object is not initialized " +
                    "properly.");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return index == 0;
    }

    @Override
    public boolean isFull() {
        int Comp_Capacity = 0;
        for(int i = 0; i < index;i++) {
            String[] info = vegfrucomp[i].toString().split(",");
            Comp_Capacity += Integer.parseInt(info[2]);
        }
        return Comp_Capacity >= vegfrucomp.length;
    }


    @Override
    public T remove() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T removeEntry(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getItemCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getIndexOf(T item) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean contains(T anEntry) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void displayItems() {
        int inVegFru = 0;
        for (int i = 0; i < index; i++){
            String[] info = vegfrucomp[i].toString().split(",");
            inVegFru += Integer.parseInt(info[2]);
        }
        if ((vegfrucomp.length - inVegFru) < 0){
            System.out.println("Vegetables and Fruits: 0");
        }else {
            System.out.println("Vegetables and Fruits: " + (vegfrucomp.length - inVegFru));
        }
    }

    @Override
    public void dump() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean transferto(IBag<T> targetBag, T item) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T getEntry(int GivenIndex) {
        // TODO Auto-generated method stub
        return null;
    }



}
