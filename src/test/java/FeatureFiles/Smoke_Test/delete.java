package FeatureFiles.Smoke_Test;


import org.testng.Assert;

import java.time.LocalDate;


public class delete {


    public static void main(String[] args) {
        LocalDate datum = LocalDate.now();
        int huidigeJaar = datum.getYear();
        int huidigeMaand = datum.getMonthValue();

        System.out.println(huidigeJaar + " " + huidigeMaand);
        int jaarCheck = 0;
        if (huidigeMaand == 8) {
            jaarCheck = datum.getYear();
            System.out.println("a");
        } else {
            jaarCheck = datum.getYear() - 1;
            System.out.println(jaarCheck);
        }
    }
}
