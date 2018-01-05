public class RectangleAreaAndPerimeter {

    /**
     * The area variable is initialised with the area of the rectangle.
     * The perimeter variable is initialised with the perimeter of the rectangle.
     * At the end, the method prints the area and the perimeter of the rectangle.
     *
     * @param width is the width size of the rectangle given by the user.
     * @param height is the height size of the rectangle given by the user.
     */
    public void rectangleAreaAndPerimeter (int width, int height) {
        int area = width * height;
        int perimeter = (width + height) * 2;

        System.out.println("The area is: " + area);
        System.out.println("The perimeter is: " + perimeter);
    }
}
