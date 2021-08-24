package com.company;

import java.util.Date;
import java.sql.*;

public class Invoice {

    //Daten anzeigen
    public static void showInvoices()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","");

            Statement stmt = connect.createStatement();

            ResultSet result = stmt.executeQuery("SELECT * FROM tblinvoice;");

            while(result.next())
            {
                System.out.println("Id: " +"\t" + result.getInt(1) + "\n" + "Date: " + "\t" + result.getDate(2) + "\n" + "Description: " + "\t" + result.getString(3) + "\n" + "Value: " + "\t" + result.getString(4) + "\n" + "Paid: " + "\t" + result.getBoolean(5) + "\n");
            }

            connect.close();
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    //Daten inserten
    public static void insertInvoice(Date date, String description, double value, Boolean paid)
    {

    }

    //Daten updaten
    public static void updateInvoice(int id, Date date, String description, double value, Boolean paid)
    {

    }

    //Daten löschen
    public static void deleteInvoice(int id)
    {

    }

}
