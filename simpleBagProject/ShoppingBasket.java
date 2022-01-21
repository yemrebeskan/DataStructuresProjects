public class ShoppingBasket<T> implements IBag<T>{
    private final T[] shopbasket;
    private int index;
    private static final int DEFAULT_CAPACITY = 2000;
    private boolean initialized = false;
    private static final int MAX_CAPACITY = 10000;
    public ShoppingBasket() {
        this(DEFAULT_CAPACITY);
    } // end default constructor
    public ShoppingBasket(int desiredCapacity) {
        if (desiredCapacity <= MAX_CAPACITY) {

            // The cast is safe because the new array contains null entries.
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity]; // Unchecked cast
            shopbasket = tempBag;
            index = 0;
            initialized = true;
        }
        else
            throw new IllegalStateException("Attempt to create a bag " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
        // TODO Auto-generated constructor stub
    }

    public boolean add(T newItem) {
        CheckInitialization();
        boolean result = true;
        if (isFull()) {
            result = false;
        }
        else {
            shopbasket[index] = newItem;
            String[] info = shopbasket[index].toString().split(",");
            System.out.println(info[0]+ " is added to the basket");
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
        int inBasket = 0;
        for(int i = 0; i < index;i++) {
            if (shopbasket[i] != null) {
                String[] info = shopbasket[i].toString().split(",");
                inBasket += Integer.parseInt(info[2]);
            }
        }
        return inBasket >= shopbasket.length;
    }

    @Override
    public T remove() {
        // TODO Auto-generated method stub
        CheckInitialization();
        T result = removeEntry(index-1);
        return result;
    }

    @Override
    public T removeEntry(int Given_index) {
        T result = null;
        if (!isEmpty() && (Given_index >= 0)) {
            result = shopbasket[Given_index];
            shopbasket[Given_index] = null;
            index--;
        }
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        CheckInitialization();
        int index2 = getIndexOf(anEntry);
        T result = removeEntry(index2);
        return anEntry.equals(result);
    }

    @Override
    public int getItemCount() {
        return index;
    }

    @Override
    public int getIndexOf(T item) {
        int where = -1;
        boolean stillLooking = true;
        int index3 = 0;
        while ( stillLooking && (index3 < index)) {
            if (item.equals(shopbasket[index3])) {
                stillLooking = false;
                where = index3;
            } // end if
            index3++;
        } // end for
        return where;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean result = true;
        for(int i = 0;i < index;i++) {
            if(shopbasket[i] == anEntry) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public void displayItems() {
        String result ="basket contains "+  index + " items\n";
        for (int i = 0; i < index; i++) {
            if (shopbasket[i] != null) {
                String[] info = shopbasket[i].toString().split(",");
                result += info[0] + "\n";
            }
        }

        System.out.println(result);
    }

    @Override
    public void dump() {
        int i = 0;
        while(i < index){
            removeEntry(i);
            i++;
        }
        index = 0;
    }

    @Override
    public boolean transferto(IBag<T> targetBag, T item) {
        if(targetBag.add(item)) {
            return true;
        }
        else {
            System.out.println(item.toString().split(",")[0] + " cannot be added to the fridge." );
            return false;
        }
    }

    @Override
    public T getEntry(int GivenIndex) {
        T result;
        result = shopbasket[GivenIndex];
        return result;
    }
}