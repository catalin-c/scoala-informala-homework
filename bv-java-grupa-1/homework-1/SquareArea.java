public class SquareArea {

    /**
     * The area variable is initialised with the area of the square.
     * It checks if the size of the given side is smaller than 0.
     * If it is, the if statement prints an error message.
     * Otherwise it prints the area.
     *
     * @param squareSideLength is the size of one square side given by the user.
     */
    public void squareArea(int squareSideLength) {
        int area = squareSideLength * squareSideLength;

        if (squareSideLength < 0) {
            System.out.println("Error!");
        } else {
            System.out.println("The area is: " + area);
        }
    }
}
