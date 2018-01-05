public class SumOfNumbers {

    /**
     * The sum variable is initialised with the value 0.
     * The method iterates with a for loop from 1 to 100 and adds every number to the sum variable.
     * Then it prints the sum variable.
     */
    public void sumOfNumbers() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
