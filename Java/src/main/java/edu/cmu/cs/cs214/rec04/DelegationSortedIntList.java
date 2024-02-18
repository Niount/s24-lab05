package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList{
    // Write your implementation below with API documentation
    private final SortedIntList sortedList = new SortedIntList();
    private int totalAdded = 0;

    /**
     * Adds the specified int to the internal SortedIntList in sorted order.
     * Increments the totalAdded counter if the list changes as a result.
     *
     * @param num an integer to be added to the list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean add(int num) {
        boolean added = sortedList.add(num);
        if (added) {
            totalAdded++;
        }
        return added;
    }

    /**
     * Adds all of the elements of the specified IntegerList to the internal SortedIntList in sorted order.
     * Increments the totalAdded counter based on the size of the list being added if the list changes.
     *
     * @param list IntegerList containing elements to be added to this list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean addAll(IntegerList list) {
        boolean changed = sortedList.addAll(list);
        if (changed) {
            totalAdded += list.size();
        }
        return changed;
    }

    /**
     * Retrieves the integer at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public int get(int index) {
        return sortedList.get(index);
    }

    /**
     * Removes the first occurrence of the specified element from the list,
     * if it is present. Delegates to the sortedList instance.
     *
     * @param num an integer to be removed from the list, if present
     * @return true if an element was removed as a result of this call
     */
    @Override
    public boolean remove(int num) {
        return sortedList.remove(num);
    }

    /**
     * Removes from the list all of its elements that are contained in the
     * specified IntegerList. Delegates to the sortedList instance.
     *
     * @param list IntegerList containing elements to be removed from this list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean removeAll(IntegerList list) {
        return sortedList.removeAll(list);
    }

    /**
     * Returns the number of elements in this list. Delegates to the sortedList instance.
     *
     * @return number of elements in the list
     */
    @Override
    public int size() {
        return sortedList.size();
    }

    /**
     * Returns the total number of attempted element insertions.
     *
     * @return the total number of elements attempted to be added
     */
    public int getTotalAdded() {
        return totalAdded;
    }
}