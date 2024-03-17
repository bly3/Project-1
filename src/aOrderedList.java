import java.util.Arrays;
/**
 * Represents an ordered list of Comparable objects.
 *
 * CSC 1351 Programming Project No 1
 * Section 2
 *
 * @author Benny Ly
 * @since 3/17/24
 * */
public class aOrderedList {
    final int SIZEINCREMENTS = 20;
    private Comparable[] oList;
    private int listSize;
    private int numObjects;
    private int curr;
    /**
     * Constructs an empty ordered list with a default initial capacity.
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public aOrderedList(){
        numObjects = 0;
        listSize = SIZEINCREMENTS;
        oList = new Comparable[listSize];
        curr = -1;

    }
    /**
     * Adds a new Comparable object to the ordered list while maintaining the order.
     *
     * @param newObject The new Comparable object to add
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public void add (Comparable newObject){
        if (numObjects == listSize){
            listSize += SIZEINCREMENTS;
            oList = Arrays.copyOf(oList, listSize);

        }
        int index = 0;
        while (index < numObjects && newObject.compareTo(oList[index]) > 0) {
            index++;
        }

        for (int i = numObjects; i > index; i--) {
            oList[i] = oList[i - 1];
        }

        oList[index] = newObject;
        numObjects++;
    }
    /**
     * Returns a string representation of the ordered list.
     *
     * @return A string representation of the ordered list
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public String toString(){
        String output = "";
        for (int i = 0; i < numObjects; i++) {
            if (oList[i] != null) {
                output += "[" + oList[i].toString() + "]";
                if (i < numObjects - 1) {
                    output += ", ";
                }
            }
        }
        return output;
    }
    /**
     * Returns the number of objects in the ordered list.
     *
     * @return The number of objects in the ordered list
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public int size(){
    return numObjects;
    }
    /**
     * Returns the object at the specified index in the ordered list.
     *
     * @param index The index of the object to retrieve
     * @return The object at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public Comparable get(int index){
        if (index < 0 || index >= numObjects) {
            throw new IndexOutOfBoundsException();
        }
        return oList[index];
    }
    /**
     * Checks if the ordered list is empty.
     *
     * @return true if the ordered list is empty, false otherwise
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public boolean isEmpty(){
        return numObjects == 0;
    }
    /**
     * Removes the object at the specified index from the ordered list.
     *
     * @param index The index of the object to remove
     * @throws IndexOutOfBoundsException if the index is out of bounds
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public void remove(int index) {
        if (index <= numObjects) {
            for (int i = index; i < numObjects; i++) {
                oList[i] = oList[i + 1];
            }
            oList[numObjects] = null;
            numObjects--;
        }
        else{
            throw new IndexOutOfBoundsException("Out of bounds");
        }
    }
    /**
     * Resets the current position in the ordered list to the beginning.
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public void reset(){
        curr = -1;
    }
    /**
     * Returns the next object in the ordered list and advances the current position.
     *
     * @return The next object in the ordered list
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public Comparable next(){
            curr++;
            return oList[curr];
    }
    /**
     * Checks if there are more objects in the ordered list after the current position.
     *
     * @return true if there are more objects, false otherwise
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public boolean hasNext(){
        return curr + 1 < numObjects ;
    }
    /**
     * Removes the object at the current position from the ordered list.
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public void remove(){
       if(curr>= 0) remove(curr);
    }

}

