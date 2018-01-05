import java.util.ArrayList;

public class SmallestNumber {

    /**
     * If the collection is not empty
     * The smallest variable is initialised with the first value from the collection.
     * The method iterates with a for loop through the collection elements.
     * If the smallest variable is bigger than the next element, the smallest variable is assigned the element value.
     * After the for loop, it prints the value of the smallest number from the given collection.
     *
     * @param collection is the collection given by the user.
     */
    public void smallestNumber(ArrayList<Integer> collection) {
        if (collection.isEmpty()) {
            System.out.println("The given collection is empty!");
        } else {
            int smallest = collection.get(0);
            for (int i = 1; i < collection.size(); i++) {
                if (smallest > collection.get(i)) {
                    smallest = collection.get(i);
                }
            }
            System.out.println("The smallest number is: " + smallest);
        }
    }
}
