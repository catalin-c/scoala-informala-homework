package test;

import exceptions.InvalidDiagonalException;
import exceptions.InvalidLineException;
import exceptions.InvalidRowColumnException;
import exceptions.InvalidSizeException;
import logic.Matrix;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest {

    @Test
    public void getSumTest() {
        Matrix<Integer> matrix = null;

        try {
            matrix = new Matrix<>(3, 5);
        } catch (InvalidSizeException e) {
            System.out.println(e.getMessage());
        }

        int sum = matrix.getSum();
        assertEquals(45, sum);
    }

    @Test
    public void getLineSumTest() throws InvalidLineException {
        Matrix<Integer> matrix = null;

        try {
            matrix = new Matrix<>(3, 5);
        } catch (InvalidSizeException e) {
            System.out.println(e.getMessage());
        }

        int lineSum = matrix.getLineSum(2);
        assertEquals(15, lineSum);
    }

    @Test
    public void getDiag1SumTest() throws InvalidDiagonalException {
        Matrix<Integer> matrix = null;

        try {
            matrix = new Matrix<>(3, 5);
        } catch (InvalidSizeException e) {
            System.out.println(e.getMessage());
        }

        int diagSum = matrix.getDiagSum(1);
        assertEquals(15, diagSum);
    }

    @Test
    public void getDiagS2umTest() throws InvalidDiagonalException {
        Matrix<Integer> matrix = null;

        try {
            matrix = new Matrix<>(3, 5);
        } catch (InvalidSizeException e) {
            System.out.println(e.getMessage());
        }

        int diagSum = matrix.getDiagSum(2);
        assertEquals(15, diagSum);
    }

    @Test(expected = InvalidSizeException.class)
    public void InvalidMatrixSizeTest() throws InvalidSizeException {
        Matrix<Integer> matrix = new Matrix<>(-4, 5);

    }

    @Test(expected = InvalidLineException.class)
    public void invalidLineTest() throws InvalidLineException {
        Matrix<Integer> matrix = null;

        try {
            matrix = new Matrix<>(3, 5);
        } catch (InvalidSizeException e) {
            System.out.println(e.getMessage());
        }

        matrix.getLineSum(5);
    }

    @Test
    public void addValueTest() throws InvalidRowColumnException {
        Matrix<Integer> matrix = null;

        try {
            matrix = new Matrix<>(3, 5);
        } catch (InvalidSizeException e) {
            System.out.println(e.getMessage());
        }

        matrix.addValue(1, 3, 7);
        int test = matrix.getMatrixList().get(0).get(2);
        assertEquals(7, test);
    }

    @Test (expected = InvalidRowColumnException.class)
    public void addValueInvalidRowTest() throws InvalidRowColumnException {
        Matrix<Integer> matrix = null;

        try {
            matrix = new Matrix<>(3, 5);
        } catch (InvalidSizeException e) {
            System.out.println(e.getMessage());
        }

        matrix.addValue(-5, 3, 7);
    }

    @Test (expected = InvalidRowColumnException.class)
    public void addValueInvalidColumnTest() throws InvalidRowColumnException {
        Matrix<Integer> matrix = null;

        try {
            matrix = new Matrix<>(3, 5);
        } catch (InvalidSizeException e) {
            System.out.println(e.getMessage());
        }

        matrix.addValue(1, 6, 7);
    }
}
