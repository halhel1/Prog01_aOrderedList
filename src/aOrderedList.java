import java.util.Arrays;
/**
 * <aOrderedList class>
 *
 * CSC 1351 Programming Project No <1>
 * Section <002>
 *
 * @author <Hussain Alhelfi>
 * @since <10/23/23>
 * */
public  class aOrderedList {
    final int SIZEINCREMENTS = 20;
    //constant variable that will be used to help manage the size of array oList
    private int listSize;
    //variable representing the current size of array oList
    private int curr;
    //variable refers to the current index of the array, helps while iterating
    private Comparable<Car>[] oList;
    //variable represents the array in question which will be modified
    private int numObjects;
    //variable that represents the number of objects stored in array oList, not the size
    public aOrderedList(){
        numObjects = 0;
        listSize = SIZEINCREMENTS;
        oList = new Comparable[listSize];

    }
    /**
     * <Add elements of type Car to an Array oList, listSize should not be larger
     * than numObjects so whenever numObjects approaches it in size,listSize increases.
     * Otherwise the object that is passed through the argument(newCar in main method)
     * will be added to the array>
     *
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author <Hussain Alhelfi>
     * @since <10/23/23>
     *
     */

    //newObject represents is the object that will be entered into oList(it would be newCar in main)
    void add(Comparable newObject){
        if (numObjects >= listSize) {
            listSize += SIZEINCREMENTS;
            oList = Arrays.copyOf(oList, listSize);

        }
        oList[numObjects] = newObject;
        numObjects++;
        Arrays.sort(oList, 0, numObjects);
    }

    public String toString(){
        return Arrays.toString(oList);
    }
    /**
     * <Allows other classes to access the value of numObjects upon call>
     *
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author <Hussain Alhelfi>
     * @since <10/23/23>
     *
     */
    int size(){
        return numObjects;
    }
    Comparable get(int index){
        return oList[index];
    }
    boolean isEmpty(){
        if(oList==null){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * <removes elements of type Car from Array oList at a
     * specific index and decrements size of the Array.>
     *
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author <Hussain Alhelfi>
     * @since <10/23/23>
     *
     */
    void remove(int index){
        if (index >= 0 && index < numObjects) {
            for (int i = index; i < numObjects - 1; i++) {
                oList[i] = oList[i + 1];
            }
            oList[numObjects - 1] = null;
            numObjects--;
        }
    }


    void reset(){
        curr=0;
    }


    Comparable next(){
        return oList[curr++];
    }
    boolean hasNext() {
        return curr < listSize;
    }
    public void remove() {
    }
}

