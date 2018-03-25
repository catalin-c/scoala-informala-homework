package db;

import exceptions.IdNotFoundException;

import java.sql.*;

public class DataSource {
    private Connection conn;
    private final String url = "jdbc:postgresql://localhost:5432/school?user=postgres&password=password";

    /**
     * Open the db connection.
     */
    public void openConnection() {
        DriverManager.setLoginTimeout(60);
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot open the connection: " + e.getMessage());
        }
    }

    /**
     * Close the db connection.
     */
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Cannot close the connection: " + e.getMessage());
        }
    }

    /**
     * Display data for all classes.
     */
    public void displayAllClassesData() {
        try (Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = st.executeQuery("SELECT * FROM classes")) {

            while (rs.next()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    sb.append(rs.getString(i) + " | ");
                }
                System.out.println(sb);
            }

        } catch (SQLException e) {
            System.err.println("Cannot close the database: " + e.getMessage());
        }
    }

    /**
     * Display data for a course with specified id.
     * @param id - specified id by the user.
     * @throws IdNotFoundException - if no data is found by the given id, IdNOtFoundException is thrown.
     */
    public void displayClassesDataById(int id) throws IdNotFoundException {
        try (Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = st.executeQuery("SELECT * FROM classes")) {
            boolean rsContainsClassId = false;
            while (rs.next()) {
                if (rs.getInt("classid") == id) {
                    rsContainsClassId = true;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        sb.append(rs.getString(i) + " | ");
                    }
                    System.out.println(sb);
                }
            }
            if (!rsContainsClassId) {
                throw new IdNotFoundException();
            }
        } catch (SQLException e) {
            System.err.println("Cannot close the statement or result set: " + e.getMessage());
        }
    }

    /**
     * Display data for all classes whose title (when converted to all lowercase letters) begins with "intro".
     */
    public void displayClassesDataByTitle() {
        try (Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = st.executeQuery("SELECT classes.* FROM classes INNER JOIN courses ON " +
                     "classes.courseid = courses.courseid WHERE LOWER(title) LIKE 'intro%';")) {
            while (rs.next()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    sb.append(rs.getString(i) + " | ");
                }
                System.out.println(sb);
            }
        } catch (SQLException e) {
            System.err.println("Cannot close the statement or result set: " + e.getMessage());
        }
    }

    /**
     * Displays all data from classes dept (when converted to all lowercase letters) is "cos"
     * and whose coursenum begins with "3".
     */
    public void displayClassesDataByDept() {
        try (Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = st.executeQuery("SELECT classes.* FROM classes INNER JOIN crosslistings ON " +
                     "classes.courseid = crosslistings.courseid WHERE LOWER(dept)='cos' AND coursenum LIKE '3%';")) {
            while (rs.next()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    sb.append(rs.getString(i) + " | ");
                }
                System.out.println(sb);
            }
        } catch (SQLException e) {
            System.err.println("Cannot close the statement or result set: " + e.getMessage());
        }
    }
}
