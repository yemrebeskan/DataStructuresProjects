public class SnacksCompartment<T> implements IBag<T> {

    private final T[] snackscomp;
    private int index;
    private static final int DEFAULT_CAPACITY = 2000;
    private boolean initialized = false;
    private static final int MAX_CAPACITY = 10000;
    public SnacksCompartment() {
        this(DEFAULT_CAPACITY);
    } // end default constructor
    public SnacksCompartment(int desiredCapacity) {
        if (desiredCapacity <= MAX_CAPACITY) {

            // The cast is safe because the new array contains null entries.
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity]; // Unchecked cast
            snackscomp = tempBag;
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
            snackscomp[index] = newItem;
            index++;
        }
        return result;
    }

    private void CheckInitialization() {
        if(!initialized)
            throw new SecurityException("ArrayBag object is not initialized " +
                    "properly.");
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public boolean isFull() {
        int Comp_Capacity = 0;
        for(int i = 0; i < index;i++) {
            String[] info = snackscomp[i].toString().split(",");
            Comp_Capacity += Integer.parseInt(info[2]);
        }
        return Comp_Capacity >= snackscomp.length;
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
        int inSnacks = 0;
        for (int i = 0; i < index; i++){
            String[] info = snackscomp[i].toString().split(",");
            inSnacks += Integer.parseInt(info[2]);
        }
        if ((snackscomp.length - inSnacks) < 0){
            System.out.println("Snacks: 0");
        }else {
            System.out.println("Snacks: " + (snackscomp.length - inSnacks));
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
