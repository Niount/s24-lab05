package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList extends SortedIntList{
    // Write your implementation below with API documentation
    private int totalAdded = 0;

    /**
     * Adds the specified int to the list in sorted order.
     * Overrides the add method to increment the totalAdded counter.
     *
     * @param num an integer to be added to the list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean add(int num) {
        boolean added = super.add(num);
        if (added) {
            totalAdded++;
        }
        return added;
    }


    /**
     * Adds all of the elements of the specified IntegerList to the list in sorted order.
     * Overrides the addAll method to increment the totalAdded counter
     * based on the size of the list being added.
     *
     * @param list IntegerList containing elements to be added to this list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean addAll(IntegerList list) {
        boolean changed = super.addAll(list);
        if (changed) {
            totalAdded += list.size();
        }
        return changed;
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