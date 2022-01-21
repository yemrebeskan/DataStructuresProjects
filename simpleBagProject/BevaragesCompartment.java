public class BevaragesCompartment<T> implements IBag<T> {

    private final T[] bevacomp;
    private int index;
    private static final int DEFAULT_CAPACITY = 4000;
    private boolean initialized = false;
    private static final int MAX_CAPACITY = 10000;
    public BevaragesCompartment() {
        this(DEFAULT_CAPACITY);
    } // end default constructor
    public BevaragesCompartment(int desiredCapacity) {
        if (desiredCapacity <= MAX_CAPACITY) {

            // The cast is safe because the new array contains null entries.
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity]; // Unchecked cast
            bevacomp = tempBag;
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
            bevacomp[index] = newItem;
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
        // TODO Auto-generated method stub
        return index == 0;
    }

    @Override
    public boolean isFull() {
        // TODO Auto-generated method stub
        int Comp_Capacity = 0;
        for(int i = 0; i < index;i++) {
            String[] info = bevacomp[i].toString().split(",");
            Comp_Capacity += Integer.parseInt(info[2]);
        }
        return Comp_Capacity >= bevacomp.length;
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
        int inBeva = 0;
        for (int i = 0; i < index; i++){
            String[] info = bevacomp[i].toString().split(",");
            inBeva += Integer.parseInt(info[2]);
        }
        if ((bevacomp.length - inBeva) < 0){
            System.out.println("Beverages: 0");
        }else {
            System.out.println("Beverages: " + (bevacomp.length - inBeva));
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
