public interface QueueInterface<T> {

    public void enqueue(T newEntry);
    // adds a new product to the queue
    public T dequeue();
    // removes the first product from the queue, and returns it
    public T getFront();
    // shows the first product of the queue
    public boolean isEmpty();
    // checks if the queue is empty, and returns true or false
    public int count(String givenEntry);
    // counts the products that is same as given name
}
