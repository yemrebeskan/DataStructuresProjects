import java.util.Arrays;
import java.util.EmptyStackException;

public class ChairWarehouse<T> implements StackInterface<T>{
    private T[] chairstack;
    private int topIndex;
    public int sold;
    public int inIt;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ChairWarehouse() {
        this(DEFAULT_CAPACITY);
    }

    public ChairWarehouse(int initialCapacity) {
        if (initialCapacity <= MAX_CAPACITY) {
            T[] tempstack = (T[])new Object[initialCapacity];
            chairstack = tempstack;
            topIndex = -1;
            initialized = true;
        }
    }


    public void push(T newEntry) {
        checkInitialization();
        ensureCapacity();
        chairstack[topIndex + 1] = newEntry;
        topIndex++;
        inIt++;
    }

    private void checkInitialization(){
        if (!initialized)
            throw new SecurityException("ArrayBag object is not initialized " +
                    "properly.");
    }

    private void ensureCapacity() {
        if (topIndex == chairstack.length - 1) {
            int newLength = 2 * chairstack.length;
            chairstack = Arrays.copyOf(chairstack, newLength);
        }
    }

    public T pop() {
        checkInitialization();
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            T top = chairstack[topIndex];
            chairstack[topIndex] = null;
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
            return chairstack[topIndex];
    }


    public boolean isEmpty() {
        boolean a = true;
        if (topIndex > -1) {
            a = false;
        }
        return a;
    }
}
