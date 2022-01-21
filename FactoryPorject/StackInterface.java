public interface StackInterface<T> {

    public void push(T newEntry);
    // adds a new product to the stack
    public T pop();
    // removes the top product from the stack, and returns it
    public T peek();
    // shows the last product of stack
    public boolean isEmpty();
    // checks if then stack is empty and returns true or false
}
