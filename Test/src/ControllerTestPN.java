package src;

import controller.Controller;
import ordination.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import storage.Storage;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTestPN {

    @org.junit.jupiter.api.Test
    void opretPNOrdinationIntended() {

        LocalDate date1 = LocalDate.of(2020,10,10);
        LocalDate date2 = LocalDate.of(2020,10,25);
        Patient patient = new Patient("08119832","Peter",145);
        Lægemiddel lægemiddel = new Lægemiddel("oxy",12,15,17,"MG");
        PN ordination = Controller.opretPNOrdination(date1,date2,patient,lægemiddel,20);
        assert (ordination instanceof PN);
    }

    @org.junit.jupiter.api.Test
    void opretPNOrdinationStartFørSlut() {

        LocalDate date1 = LocalDate.of(2020,10,25);
        LocalDate date2 = LocalDate.of(2020,10,10);
        Patient patient = new Patient("08119832","Peter",145);
        Lægemiddel lægemiddel = new Lægemiddel("oxy",12,15,17,"MG");
        PN ordination = Controller.opretPNOrdination(date1,date2,patient,lægemiddel,20);
        assert (ordination instanceof PN);
    }

    @org.junit.jupiter.api.Test
    void opretPNOrdinationInvalidDate() {

        LocalDate date1 = LocalDate.of(2020,15,37);
        LocalDate date2 = LocalDate.of(2020,10,99);
        Patient patient = new Patient("08119832","Peter",145);
        Lægemiddel lægemiddel = new Lægemiddel("oxy",12,15,17,"MG");
        PN ordination = Controller.opretPNOrdination(date1,date2,patient,lægemiddel,20);
        assert (ordination instanceof PN);
    }

    @org.junit.jupiter.api.Test
    void opretPNOrdinationNulledPatient() {

        LocalDate date1 = LocalDate.of(2020,10,10);
        LocalDate date2 = LocalDate.of(2020,10,25);
        Patient patient = null;
        Lægemiddel lægemiddel = new Lægemiddel("oxy",12,15,17,"MG");
        PN ordination = Controller.opretPNOrdination(date1,date2,patient,lægemiddel,20);
        assert (ordination instanceof PN);
    }

// tc5
    @org.junit.jupiter.api.Test
    void opretPNOrdinationNegativeAntalEnhedder() {

        LocalDate date1 = LocalDate.of(2020,10,10);
        LocalDate date2 = LocalDate.of(2020,10,25);
        Patient patient = null;
        Lægemiddel lægemiddel = new Lægemiddel("oxy",12,15,17,"MG");
        PN ordination = Controller.opretPNOrdination(date1,date2,patient,lægemiddel,-2147);

        //how do i assert that it throws what i want it to throw IE exceptions shiiit
    }


    @Test
    void anvendOrdinationPN() {
    }
}