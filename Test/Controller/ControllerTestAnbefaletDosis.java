package Controller;

import controller.Controller;
import ordination.Lægemiddel;
import ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTestAnbefaletDosis {

    private Patient patient;
    private Lægemiddel lægemiddel;

    @BeforeEach
    void setup() {
        lægemiddel = new Lægemiddel("TestMedicin", 0.5, 1.0, 1.5, "ml");
    }

    @Test
    void anbefaletDosisPrDøgn_letPatient() {
        patient = new Patient("1234567-8910", "Barn", 20);
        double dosis = Controller.anbefaletDosisPrDøgn(patient, lægemiddel);
        assertEquals(10.0, dosis);
    }

    @Test
    void anbefaletDosisPrDøgn_normalPatient() {
        patient = new Patient("123456-8910", "Voksen", 80);
        double dosis = Controller.anbefaletDosisPrDøgn(patient, lægemiddel);
        assertEquals(80.0, dosis);
    }

    @Test
    void anbefaletDosisPrDøgn_tungPatient() {
        patient = new Patient("123456-8910", "Stor", 150);
        double dosis = Controller.anbefaletDosisPrDøgn(patient, lægemiddel);
        assertEquals(225.0, dosis);
    }

    @Test
    void anbefaletDosisPrDøgn_vægtNull_Exception() {
        patient = new Patient("123456-8910", "Barn", 0);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () ->  Controller.anbefaletDosisPrDøgn(patient, lægemiddel)
        );
        assertEquals("Vægt skal være > 0", exception.getMessage());
    }

    @Test
    void anbefaletDosisPrDøgn_patientNull_Exception() {
        patient = null;
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Controller.anbefaletDosisPrDøgn(patient, lægemiddel)
        );
        assertEquals("Patient må ikke være null", exception.getMessage());
    }
}