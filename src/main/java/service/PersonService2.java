package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;

import Model.Person;
import jdbc.DBConnector;

public class PersonService2{
	
	public static ArrayList<Person> readAll() {
        String sql = "SELECT * FROM Personen";
        ArrayList<Person> persons = new ArrayList<Person>();
        try (Connection conn = DBConnector.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Person p = new Person(
                		rs.getString("uuid"),
                        rs.getString("vorname"),
                        rs.getString("nachname")
                );
                persons.add(p);
 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }
	public static boolean insert(Person person) {
        PreparedStatement preparedStatement = null;
 
        Connection conn = DBConnector.getInstance();
 
        String insertSQL = "INSERT INTO personen (Vorname, Nachname, UUID) VALUES (?, ?, ?)";
        try {
            preparedStatement = conn.prepareStatement(insertSQL);
 
            preparedStatement.setString(1, person.getVorname());
            preparedStatement.setString(2, person.getNachname());
            preparedStatement.setString(3, person.getUuid());
 
            int updatedRowCount = preparedStatement.executeUpdate();
 
            if (updatedRowCount > 0) {
                System.out.println("Wert erfolgreich eingefügt.");
                conn.commit();
                return true;
            } else {
                conn.rollback();
                System.out.println("Wert wurde nicht erfolgreich eingefügt.");
            }
 
 
        } catch (SQLException e) {
            try{
                conn.rollback();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBConnector.closeResources(preparedStatement, null);
        }
 
        return false;
    }
    
    public static void delete(String uuid) {
 
 
        try {
        	PreparedStatement preparedStatement = null;
        	 
            Connection conn = DBConnector.getInstance();
            
            String sql = "DELETE FROM Personen WHERE UUID = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, uuid);
            System.out.println("Autocommit = " + conn.getAutoCommit());
            int rowsDeleted = preparedStatement.executeUpdate();
 
            if (rowsDeleted > 0) {
                conn.commit();
                System.out.println("A row was deleted successfully.");
            }
            else{
                conn.rollback();
            }
 
            preparedStatement.close();
 
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
    }
    
    public static boolean update(String vorname, String nachname, String uuid) {
 
    	System.out.println("vorname: " + vorname);
    	System.out.println("nachname: " + nachname);
    	System.out.println("uuid: " + uuid);
        try {
        	PreparedStatement preparedStatement = null;
       	 	
            Connection conn = DBConnector.getInstance();
            
            String sql = "UPDATE Personen SET Vorname = ?, Nachname = ? WHERE UUID = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, vorname);
            preparedStatement.setString(2, nachname);
            preparedStatement.setString(3, uuid);
            System.out.println("Autocommit = " + conn.getAutoCommit());
            int rowsDeleted = preparedStatement.executeUpdate();
 
            if (rowsDeleted > 0) {
            	conn.commit();
                System.out.println("A row was updated successfully.");
                return true;
            }
            else{
            	conn.rollback();
            }
 
            preparedStatement.close();
 
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}