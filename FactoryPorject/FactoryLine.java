
public class FactoryLine<T> implements QueueInterface<T>{
	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public FactoryLine() {
		this(DEFAULT_CAPACITY);
	}
	
	public FactoryLine(int initialCapacity) {
		if (initialCapacity < MAX_CAPACITY) {
			T[] tempQueue = (T[]) new Object[initialCapacity + 1];
			queue = tempQueue;
			frontIndex = 0;
			backIndex = -1;
			initialized = true;
		}
	}
	private void checkInitialization()
    {
        if (!initialized)
            throw new SecurityException("ArrayBag object is not initialized " +
                    "properly.");
    }
	
	public void enqueue(T newEntry) {
		checkInitialization();
		ensureCapacity();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
	}
		
	
	public T dequeue() {
		checkInitialization();
		if(isEmpty()) {
			return null;
		}
		else {
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			return front;
		}
	}

	
	public T getFront() {
		checkInitialization();
		if (!isEmpty()){
            return queue[0];
        }
        else{
            return null;
        }
	}
	
	private void ensureCapacity() {
		if (frontIndex == ((backIndex + 2) % queue.length)) {
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			for(int index = 0; index < oldSize - 1;index++) {
				queue[index] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			frontIndex = 0;
			backIndex = oldSize - 2;
		}
	}

	
	public boolean isEmpty() {
		 return frontIndex == ((backIndex + 1) % queue.length);
	}


	public int count(String name) {
		int index1 = frontIndex;
		int countOfEntry = 0;
		int index2 = backIndex;
		if (isEmpty()) {
			return 0;

		} else {
			while (index1 != index2 + 1) {
				if (queue[index1].toString().equals(name)) {
					countOfEntry += 1;
				}
				index1++;
			}
			return countOfEntry;
		}
	}

}
