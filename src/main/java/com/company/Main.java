package com.company;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        //Methoden ausführen
//        Invoice.showInvoices();
//        Invoice.insertInvoice(Date.valueOf(LocalDate.now()), "Rechnung4", 30.50, false);
       Invoice.updateInvoice(4,Date.valueOf(LocalDate.now()), "Rechnung20", 0.50, true);
//        Invoice.deleteInvoice();
    }
}
