package Controller;

import controller.Controller;
import ordination.Lægemiddel;
import ordination.PN;
import ordination.Patient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ControllerTestAnvendOrdinationPn {
    @org.junit.jupiter.api.Test
    void anvendOrdinationPnNulledOrdination() {

        LocalDate date1 = LocalDate.of(2020,12,12);
        PN ordination = null;

        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> Controller.anvendOrdinationPN(ordination,date1)
        );
        assertEquals("No ordination found", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void anvendOrdinationPnValidCase() {


        LocalDate date1 = LocalDate.of(2020,12,12);
        LocalDate date2 = LocalDate.of(2020,11,11);
        LocalDate date3 = LocalDate.of(2020,12,15);
        Patient patient = new Patient("08119832","Peter",145);
        Lægemiddel lægemiddel = new Lægemiddel("oxy",12,15,17,"MG");
        PN ordination = Controller.opretPNOrdination(date2,date3,patient,lægemiddel,20);
        Controller.anvendOrdinationPN(ordination,date1);

      assertEquals(date1,ordination.getDatoerHvorOrdinationIndtaget().getLast());
    }

    @org.junit.jupiter.api.Test
    void anvendOrdinationPnDatoFørStart() {


        LocalDate date1 = LocalDate.of(2020,12,12);
        LocalDate date2 = LocalDate.of(2020,12,13);
        LocalDate date3 = LocalDate.of(2020,12,17);
        Patient patient = new Patient("08119832","Peter",145);
        Lægemiddel lægemiddel = new Lægemiddel("oxy",12,15,17,"MG");
        PN ordination = Controller.opretPNOrdination(date2,date3,patient,lægemiddel,20);


        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> Controller.anvendOrdinationPN(ordination,date1)
        );
        assertEquals("Not a valid date", exception.getMessage());
    }
    @org.junit.jupiter.api.Test
    void anvendOrdinationPnDatoEfterSlut() {


        LocalDate date1 = LocalDate.of(2020,12,12);
        LocalDate date2 = LocalDate.of(2020,11,11);
        LocalDate date3 = LocalDate.of(2020,11,15);
        Patient patient = new Patient("08119832","Peter",145);
        Lægemiddel lægemiddel = new Lægemiddel("oxy",12,15,17,"MG");
        PN ordination = Controller.opretPNOrdination(date2,date3,patient,lægemiddel,20);


        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> Controller.anvendOrdinationPN(ordination,date1)
        );
        assertEquals("Not a valid date", exception.getMessage());
    }

}

