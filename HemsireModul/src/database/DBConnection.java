/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author seeda
 */
public class DBConnection {

    public Connection connect() {
        Connection connection = null;
   
        try {

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your  JDBC Driver?");
            e.printStackTrace();

        }

  
        try {

            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HemsireModul", "seda", "123");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (connection != null) {
            System.out.println("Bağlanti basarili");
        } else {
            System.out.println("Başarisiz baglanti!");
        }
        return connection;
    }

}
