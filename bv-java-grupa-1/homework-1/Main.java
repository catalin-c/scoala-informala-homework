import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SumOfNumbers firstExercise = new SumOfNumbers();                                //#1
        firstExercise.sumOfNumbers();

        ArrayList<Integer> collection = new ArrayList<>();                              //#2
        collection.add(5);
        collection.add(319);
        collection.add(-6);
        collection.add(62);
        collection.add(1);
        SmallestNumber secondExercise = new SmallestNumber();
        secondExercise.smallestNumber(collection);

        MaxDigit thirdExercise = new MaxDigit();                                        //#3
        thirdExercise.maxDigit(512887);

        IsPalindrome forthExercise = new IsPalindrome();                                //#4
        forthExercise.isPalindrome(1221);
        forthExercise.isPalindrome(1223);

        PrintLowerPrimeNumbers fifthExercise = new PrintLowerPrimeNumbers();            //#5
        fifthExercise.printLowerPrimeNumbers(12);

        RectangleAreaAndPerimeter sixthExercise = new RectangleAreaAndPerimeter();      //#6
        sixthExercise.rectangleAreaAndPerimeter(14, 10);

        SquareArea seventhExercise = new SquareArea();                                  //#7
        seventhExercise.squareArea(4);

        TheBiggestNumber eighthExercise = new TheBiggestNumber();                       //#8
        eighthExercise.theBiggestNumber(8,3,16);

        DisplayNumbers ninthExercise = new DisplayNumbers();                            //#9
        ninthExercise.displayNumbers(-5, 10);
    }
}
