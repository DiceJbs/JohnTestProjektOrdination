package ordination;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class PNTest {

    @org.junit.jupiter.api.Test
    void samletDosisNegativeInput() {
        LocalDate DATE1 = LocalDate.of(2022,10,10);
        LocalDate DATE2 = LocalDate.of(2022,11,11);
        PN pn = new PN(DATE1,DATE2,-1.5);
        LocalDate date3 = LocalDate.of(2022,12,10);
        pn.anvendDosis(date3);
        pn.anvendDosis(date3);
        pn.anvendDosis(date3);
        pn.anvendDosis(date3);
        pn.anvendDosis(date3);
        assertEquals(-7.5, pn.samletDosis());
    }
    @org.junit.jupiter.api.Test
    void samletDosisTestIntendedUse() {
        LocalDate DATE1 = LocalDate.of(2022,10,10);
        LocalDate DATE2 = LocalDate.of(2022,11,11);
        PN pn = new PN(DATE1,DATE2,5);
        LocalDate date3 = LocalDate.of(2022,12,10);
        pn.anvendDosis(date3);
        pn.anvendDosis(date3);
        pn.anvendDosis(date3);
        pn.anvendDosis(date3);
        pn.anvendDosis(date3);
        assertEquals(25, pn.samletDosis());
    }
    @org.junit.jupiter.api.Test
    void samletDosisGræneseTest1() {
        LocalDate DATE1 = LocalDate.of(2022,10,10);
        LocalDate DATE2 = LocalDate.of(2022,11,11);
        PN pn = new PN(DATE1,DATE2,2);
        assertEquals(0, pn.samletDosis());
    }
    @org.junit.jupiter.api.Test
    void samletDosisGræneseTest2() {
        LocalDate DATE1 = LocalDate.of(2022,10,10);
        LocalDate DATE2 = LocalDate.of(2022,11,11);
        PN pn = new PN(DATE1,DATE2,0);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        assertEquals(0, pn.samletDosis());
    }

    @org.junit.jupiter.api.Test
    void døgnDosisIntendedUsage() {
        LocalDate DATE1 = LocalDate.of(2020,10,10);
        LocalDate DATE2 = LocalDate.of(2020,10,11);
        PN pn = new PN(DATE1,DATE2,5);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        assertEquals(12.5,pn.døgnDosis());
    }
    @org.junit.jupiter.api.Test
    void døgnDosisDecimalTest() {
        LocalDate DATE1 = LocalDate.of(2020,10,10);
        LocalDate DATE2 = LocalDate.of(2020,10,14);
        PN pn = new PN(DATE1,DATE2,1.5);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        assertEquals(3,pn.døgnDosis());
    }

    @org.junit.jupiter.api.Test
    void døgnDosisgrænseVærdi() {
        LocalDate DATE1 = LocalDate.of(2020,10,10);
        LocalDate DATE2 = LocalDate.of(2020,11,14);
        PN pn = new PN(DATE1,DATE2,0);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        assertEquals(0,pn.døgnDosis());
    }

    @org.junit.jupiter.api.Test
    void døgnDosisDecimal() {
        LocalDate DATE1 = LocalDate.of(2020,11,11);
        LocalDate DATE2 = LocalDate.of(2020,11,9);
        PN pn = new PN(DATE1,DATE2,5);
        pn.anvendDosis(DATE2);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        pn.anvendDosis(DATE1);
        System.out.println(pn.antalDage());
        assertEquals(-25,pn.døgnDosis());
    }



}