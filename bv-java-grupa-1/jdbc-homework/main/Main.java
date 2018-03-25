package main;

import db.DataSource;
import exceptions.IdNotFoundException;

public class Main {
    public static void main(String[] args) {
        DataSource ds = new DataSource();
        ds.openConnection();

        ds.displayAllClassesData();
        try {
            ds.displayClassesDataById(1);
        } catch (IdNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ds.displayClassesDataByTitle();
        ds.displayClassesDataByDept();

        ds.closeConnection();
    }
}
