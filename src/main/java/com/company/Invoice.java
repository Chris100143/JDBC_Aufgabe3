package com.company;

import java.sql.Date;
import java.sql.*;

public class Invoice {

    //Daten anzeigen
    public static void showInvoices()
    {
        try
        {
            //Treiber
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Connection
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","");

            //Statement
            Statement stmt = connect.createStatement();

            //SQL ausführen
            ResultSet result = stmt.executeQuery("SELECT * FROM userdb.tblinvoice;");

            //Ergebnis ausgeben
            while(result.next())
            {
                System.out.println("Id: " +"\t" + result.getInt(1) + "\n" + "Date: " + "\t" + result.getDate(2) + "\n" + "Description: " + "\t" + result.getString(3) + "\n" + "Value: " + "\t" + result.getString(4) + "\n" + "Paid: " + "\t" + result.getBoolean(5) + "\n");
            }

            //Verbindung schließen
            connect.close();
        }

        //Fehlermeldung
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    //Daten einfügen
    public static void insertInvoice(Date date, String description, double value, Boolean paid)
    {
        try
        {
            //Treiber
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Connection
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","");

            //Statement
            String query = "insert into userdb.tblinvoice (date, description, value, paid) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connect.prepareStatement(query);

            //Daten setzen
            stmt.setDate(1, date);
            stmt.setString(2, description);
            stmt.setDouble(3, value);
            stmt.setBoolean(4, paid);

            //SQL ausführen
            stmt.executeUpdate();

            //Verbindung schließen
            stmt.close();
            connect.close();
        }

        //Fehlermeldung
        catch(Exception e)
        {
            System.out.println(e);
        }
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
