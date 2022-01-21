public class InventoryBag<T> implements IBag<T> {
    private final T[] mybag;
    private int index;
    private static final int DEFAULT_CAPACITY = 25;
    private boolean initialized = false;
    private static final int MAX_CAPACITY = 10000;
    public InventoryBag() {
        this(DEFAULT_CAPACITY);
    } // end default constructor
    public InventoryBag(int desiredCapacity) {
        if (desiredCapacity <= MAX_CAPACITY) {

            // The cast is safe because the new array contains null entries.
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity]; // Unchecked cast
            mybag = tempBag;
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
        checkInitialization();
        boolean result = true;
        if (isFull()) {
            result = false;
        }
        else {
            mybag[index] = newItem;
            index ++;
        }
        return result;
    }
    private void checkInitialization()
    {
        if (!initialized)
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
        return index >= mybag.length;
    }

    @Override
    public T remove() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T removeEntry(int Given_index) {
        T result = null;
        if (!isEmpty() && (Given_index >= 0)) {
            result = mybag[Given_index];
            mybag[Given_index] = null;
            index--;
        }
        // TODO Auto-generated method stub
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        checkInitialization();
        int index_2 = getIndexOf(anEntry);
        T result = removeEntry(index_2);
        return anEntry.equals(result);
        // TODO Auto-generated method stub
    }

    @Override
    public int getItemCount() {
        // TODO Auto-generated method stub
        return index;
    }

    @Override
    public int getIndexOf(T item) {
        int where = -1;
        boolean stillLooking = true;
        int index3 = 0;
        while ( stillLooking && (index3 < index)) {
            if (item.equals(mybag[index3])) {
                stillLooking = false;
                where = index3;
            } // end if
            index3++;
        } // end for
        // TODO Auto-generated method stub
        return where;
    }

    @Override
    public boolean contains(T anEntry) {
        checkInitialization();

        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void displayItems() {
        if (isEmpty()) {
            System.out.println("yok");
        }
        else {
            String names = " ";
            for (int i = 0; i< index;i++) {
                names += mybag[i];
            }
            System.out.println(names);
        }
    }

    @Override
    public void dump() {

    }


    public boolean transferto(IBag<T> targetBag, T item) {
        boolean result = true;
        if(targetBag.add(item)) {
            return result;
        }
        else {
            result = false;
        }
        return result;
    }

    @Override
    public T getEntry(int GivenIndex) {
        T result;
        result = mybag[GivenIndex];
        return result;
    }
}