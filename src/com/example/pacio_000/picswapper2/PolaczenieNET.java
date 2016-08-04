package com.example.pacio_000.picswapper2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Patryk on 28.07.2016.
 */
public class PolaczenieNET {
    public static Connection c=null;
    public static void polaczZNet() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c= DriverManager.getConnection("jdbc:sqlserver://localhost;user=root;password=123;");
            System.out.println("Polaczono");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        System.out.println("Testowanie polaczenia z .NET");
        polaczZNet();
    }
}
