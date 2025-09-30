package Controller;

import controller.Controller;
import ordination.DagligFast;
import ordination.Lægemiddel;
import ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTestOpretDagligFast {

    private Patient patient;
    private Lægemiddel lægemiddel;

    @BeforeEach
    void setup() {
        patient = new Patient("12345678" ,"Test Person", 65);
        lægemiddel = new Lægemiddel("TestMedicin", 0.5, 1.0, 1.5, "ml");
    }

    @Test
    void opretDagligFast_korrektInput_opretterOrdination() {
        DagligFast ordination = Controller.opretDagligFastOrdination(
                LocalDate.of(2025, 9, 26),
                LocalDate.of(2025, 9, 26),
                patient, lægemiddel, 1, 1, 1, 0
        );

        assertNotNull(ordination);
        assertTrue(patient.getOrdinations().contains(ordination));
        assertEquals(3, ordination.døgnDosis());
    }

    @Test
    void opretDagligFast_startDatoEfterSlutDato_Exception() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Controller.opretDagligFastOrdination(
                        LocalDate.of(2025, 9, 26),
                        LocalDate.of(2025, 1, 26),
                        patient, lægemiddel,
                        1, 1, 1, 0
                ));
        assertEquals("Startdato kan ikke være efter slutdato", exception.getMessage());
    }

    @Test
    void opretDagligFast_negativDosis_Exception() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Controller.opretDagligFastOrdination(
                        LocalDate.of(2025, 9, 26),
                        LocalDate.of(2025, 9, 26),
                        patient, lægemiddel,
                        -1, 0, 0, 0
                ));
        assertEquals("Antal doser kan ikke være negative", exception.getMessage());
    }

    @Test
    void opretDagligFast_patientNull_Exception() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Controller.opretDagligFastOrdination(
                   LocalDate.of(2025, 9, 26),
                   LocalDate.of(2025, 9, 26),
                   null, lægemiddel, 1, 0, 0, 0
                ));
        assertEquals("Patient må ikke være null", exception.getMessage());
    }
}