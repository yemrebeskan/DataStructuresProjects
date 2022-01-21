public interface IBag<T> {
    // Adds a new entry to this bag.
    // @param newEntry The object to be added as a new entry.
    // @return True if the addition is successful, or false if not.
    public boolean add(T newItem);
    // sees whether this bag is empty.
    // return True if the bag is empty, or false if not.
    public boolean isEmpty();
    // sees whether the bag is full.
    //return True if the bag is full, or false if not.
    public boolean isFull();
    //Removes one unspecified entry from this bag,if possible.
    //@return either the removed entry, if the removal was successful , or null.
    public T remove();
    //Removes one occurrence of a given index from this bag, if possible.
    //@param anEntry The entry to be removed.
    //@return True if the removal was successful, or false if not.
    public T removeEntry (int index);
    //Removes one occurrence of a given entry from this bag, if possible.
    //@param anEntry The entry to be removed.
    //@return True if the removal was successful, or false if not.
    public boolean remove (T anEntry);
    //Counts the number of item in this bag.
    //@return count the number of item.
    public int getItemCount();
    //Find the index's of given anEntry.
    //@return index.
    public int getIndexOf(T item);
    //Counts the number of times a given entry appears in this bag.
    //@param anEntry The entry to locate.
    //@return True if the bag contains anEntry, or false.
    public boolean contains(T anEntry);
    //display items in the bag.
    public void displayItems();
    //Removes all entries from this bag.
    public void dump();
    // Transfer the item to targetBag from IBag.
    // if it is successful return true if it is not return false.
    public boolean transferto(IBag<T> targetBag, T item);

    public T getEntry(int GivenIndex);
}