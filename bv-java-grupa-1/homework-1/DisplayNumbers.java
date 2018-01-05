public class DisplayNumbers {

    /**
     * If the starting point is lower than the finish point, the for loop
     * prints each number from start to finish in ascending order.
     * If the starting point is higher than the finish point, the for loop
     * prints each number from start to finish in a descending order.
     * Otherwise, if the starting and finishing points are equal, it prints the starting point.
     *
     * @param start is the starting point number(int) given by the user.
     * @param finish is the finishing point number(int) given by the user.
     */
    public void displayNumbers(int start, int finish) {
        if (start < finish) {
            for (int i = start; i <= finish; i++) {
                System.out.println(i);
            }
        } else if (start > finish) {
            for (int i = start; i >= finish; i--) {
                System.out.println(i);
            }
        } else {
            System.out.println(start);
        }
    }
}
