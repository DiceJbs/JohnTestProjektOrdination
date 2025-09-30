package Controller;

import controller.Controller;
import ordination.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTestOpretPN {

    @org.junit.jupiter.api.Test
    void opretPNOrdinationIntended() {

        LocalDate date1 = LocalDate.of(2020,10,10);
        LocalDate date2 = LocalDate.of(2020,10,25);
        Patient patient = new Patient("08119832","Peter",145);
        Lægemiddel lægemiddel = new Lægemiddel("oxy",12,15,17,"MG");
        PN ordination = Controller.opretPNOrdination(date1,date2,patient,lægemiddel,20);

        assertEquals(lægemiddel,ordination.getLægemiddel());
        assertEquals(ordination,patient.getOrdinations().getLast());
    }

    @org.junit.jupiter.api.Test
    void opretPNOrdinationStartFørSlut() {

        LocalDate date1 = LocalDate.of(2020,10,25);
        LocalDate date2 = LocalDate.of(2020,10,10);
        Patient patient = new Patient("08119832","Peter",145);
        Lægemiddel lægemiddel = new Lægemiddel("oxy",12,15,17,"MG");
      //  PN ordination = Controller.opretPNOrdination(date1,date2,patient,lægemiddel,20);
        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> Controller.opretPNOrdination(date1,date2,patient,lægemiddel,20)
        );
        assertEquals("Start dato er efter slut dato", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void opretPNOrdinationNegativeAntalEnhedder() {
        LocalDate date1 = LocalDate.of(2020,10,10);
        LocalDate date2 = LocalDate.of(2020,10,25);
        Patient patient = null;
        Lægemiddel lægemiddel = new Lægemiddel("oxy",12,15,17,"MG");
      //  PN ordination = Controller.opretPNOrdination(date1,date2,patient,lægemiddel,-2147);
        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> Controller.opretPNOrdination(date1,date2,patient,lægemiddel,-2147)
        );
     assertEquals("antal under 0", exception.getMessage());
    }


}