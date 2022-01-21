import java.util.Arrays;
import java.util.EmptyStackException;

public class BookcaseWarehouse<T> implements StackInterface<T>{
    private T[] bookstack;
    private int topIndex;
    public int sold;
    public int inIt;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public BookcaseWarehouse() {
        this(DEFAULT_CAPACITY);
    }

    public BookcaseWarehouse(int initialCapacity) {
        if (initialCapacity <= MAX_CAPACITY) {
            T[] tempstack = (T[])new Object[initialCapacity];
            bookstack = tempstack;
            topIndex = -1;
            initialized = true;
        }
    }


    public void push(T newEntry) {
        checkInitialization();
        ensureCapacity();
        bookstack[topIndex + 1] = newEntry;
        topIndex++;
        inIt++;
    }

    private void checkInitialization(){
        if (!initialized)
            throw new SecurityException("ArrayBag object is not initialized " +
                    "properly.");
    }

    private void ensureCapacity() {
        if (topIndex == bookstack.length - 1) {
            int newLength = 2 * bookstack.length;
            bookstack = Arrays.copyOf(bookstack, newLength);
        }
    }

    public T pop() {
        checkInitialization();
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            T top = bookstack[topIndex];
            bookstack[topIndex] = null;
            topIndex--;
            sold++;
            inIt--;
            return top;
        }
    }


    public T peek() {
        checkInitialization();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return bookstack[topIndex];
    }


    public boolean isEmpty() {
        boolean a = true;
        if (topIndex > -1) {
            a = false;
        }
        return a;
    }
}
