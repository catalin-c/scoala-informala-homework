package logic;

import exceptions.InvalidDiagonalException;
import exceptions.InvalidLineException;
import exceptions.InvalidRowColumnException;
import exceptions.InvalidSizeException;

import java.util.ArrayList;
import java.util.List;

/**
 * Deals with all the Matrix logic.
 */
public class Matrix<E> {
    private List<List<E>> matrixList = new ArrayList<>();

    /**
     * Populates the matrix with the given values based on the given size.
     *
     * @param size is the size of the matrix given by the user.
     * @param value is the value of the matrix given by the user.
     */
    public Matrix(int size, E value) throws InvalidSizeException {
        if(size < 0) {
            throw new InvalidSizeException();
        }
        for (int i = 0; i < size; i++) {
            matrixList.add(new ArrayList<E>());

            for (int j = 0; j < size; j++) {
                matrixList.get(i).add(value);
            }
        }
    }

    public String toString() {
        String numbers = "";
        for (int i = 0; i < matrixList.size(); i++) {
            for (int j = 0; j < matrixList.size(); j++) {
                numbers += matrixList.get(i).get(j) + " ";
            }
            numbers += "\n        ";
        }
        return "Size: " + matrixList.size() + "\nMatrix: " + numbers;
    }

    /**
     * @return the sum of all the numbers in the matrix.
     */
    public int getSum() {
        int sum = 0;
        List<E> elementList = getAllElementsFromMatrix();
        for (E element : elementList) {
            sum += (Integer) element;
        }
        return sum;
    }

    public int getLineSum(int lineNumber) throws InvalidLineException {
        if(lineNumber < 1 || lineNumber > matrixList.size()) {
            throw new InvalidLineException();
        }
        int sum = 0;
        for (int i = 0; i < matrixList.get(lineNumber - 1).size(); i++) {
            sum += (Integer) matrixList.get(lineNumber - 1).get(i);
        }
        return sum;
    }

    public List<E> getAllElementsFromMatrix() {
        List<E> result = new ArrayList<>();
        for (int i = 0; i < matrixList.size(); i++) {
            for (int j = 0; j < matrixList.size(); j++) {
                result.add(matrixList.get(i).get(j));
            }
        }
        return result;
    }

    public List<List<E>> getMatrixList() {
        return matrixList;
    }

    public int getDiagSum(int diag) throws InvalidDiagonalException {
        if (diag < 1 || diag > 2) {
            throw new InvalidDiagonalException();
        }

        int sum = 0;
        if (diag == 1) {
            for (int i = 0; i < matrixList.size(); i++) {
                sum += (Integer) matrixList.get(i).get(i);
            }
        } else if (diag == 2) {
            for (int i = 0; i < matrixList.size(); i++) {
                sum += (Integer) matrixList.get(i).get(matrixList.size() - 1 - i);
            }
        }
        return sum;
    }

    /**
     * Replaces a value in the matrix based on the given parameters.
     */
    public void addValue(int row, int column, E value) throws InvalidRowColumnException {
        if(row < 1 || column < 1 || row > matrixList.size() || column > matrixList.get(0).size()) {
            throw new InvalidRowColumnException();
        }
        matrixList.get(row - 1).set(column - 1, value);
    }

}
