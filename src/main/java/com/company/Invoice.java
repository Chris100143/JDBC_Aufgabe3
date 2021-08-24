package com.company;

//Importieren
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
            stmt.close();
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
            String query = "INSERT INTO userdb.tblinvoice (date, description, value, paid) VALUES (?, ?, ?, ?)";
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
        try
        {
            //Treiber
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Connection
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","");

            //Statement
            String query = "UPDATE userdb.tblinvoice SET date = ?, description = ?, value = ?, paid = ? WHERE id = ?";
            PreparedStatement stmt = connect.prepareStatement(query);

            //Daten setzen
            stmt.setDate(1, date);
            stmt.setString(2, description);
            stmt.setDouble(3, value);
            stmt.setBoolean(4, paid);
            stmt.setInt(5, id);

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

    //Daten löschen
    public static void deleteInvoice(int id)
    {
        try
        {
            //Treiber
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Connection
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","");

            //Statement
            String query = "DELETE FROM userdb.tblinvoice WHERE id = ?";
            PreparedStatement stmt = connect.prepareStatement(query);

            //Daten setzen
            stmt.setInt(1, id);

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
}
