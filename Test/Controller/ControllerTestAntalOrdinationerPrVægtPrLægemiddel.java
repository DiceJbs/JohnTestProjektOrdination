package Controller;

import controller.Controller;
import ordination.Lægemiddel;
import ordination.Patient;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
class ControllerTestAntalOrdinationerPrVægtPrLægemiddel {

    @org.junit.jupiter.api.Test
    void opretDagligSkævOrdination() {
        Patient patient = new Patient("01-01-19","Sebastian",35);
        Lægemiddel lægemiddel = new Lægemiddel("Methotrexate",0.01,0.015,0.02,"styk");
        LocalDate startDato = LocalDate.of(2025,9,25);
        LocalDate slutDato = LocalDate.of(2025,9,29);

        double resultat = Double.parseDouble(lægemiddel.getEnhedPrKgPrDøgnLet() + lægemiddel.getEnhedPrKgPrDøgnNormal() +
                lægemiddel.getEnhedPrKgPrDøgnTung() + lægemiddel.getEnhed()); ;

                assertEquals(startDato,slutDato, String.valueOf(resultat));
    }
    @org.junit.jupiter.api.Test
    void slutDatoFørStartDato() {
        Patient patient = new Patient("01-01-19","Sebastian",35);
        Lægemiddel lægemiddel = new Lægemiddel("Methotrexate",0.01,0.015,0.02,"styk");
        LocalDate startDato = LocalDate.of(2025,10,1);
        LocalDate slutDato = LocalDate.of(2025,9,26);
        LocalTime[] klokkeset = {LocalTime.of(10,0),LocalTime.of(15,0),LocalTime.of(20,0)};
        double[] antalEnheder = {3};

        double resultat = Double.parseDouble(lægemiddel.getEnhedPrKgPrDøgnLet() + lægemiddel.getEnhedPrKgPrDøgnNormal() +
                lægemiddel.getEnhedPrKgPrDøgnTung() + lægemiddel.getEnhed());

                Exception exception = assertThrows(IllegalArgumentException.class,() -> Controller.opretDagligSkævOrdination(startDato,slutDato,patient,lægemiddel,klokkeset,antalEnheder)); {
            throw new IllegalArgumentException("Ordinationen kan ikke oprettes " + exception.getMessage());
        }
    }
    @org.junit.jupiter.api.Test
    void forskelligeAntalEnhederOgKlokkeset() {
        Patient patient = new Patient("01-01-19","Sebastian",35);
        Lægemiddel lægemiddel = new Lægemiddel("Paracetamol",1,1.5,2,"ML");
        LocalDate startDato = LocalDate.of(2025,9,25);
        LocalDate slutDato = LocalDate.of(2025,9,29);
        double resultat = Double.parseDouble(lægemiddel.getEnhedPrKgPrDøgnLet() + lægemiddel.getEnhedPrKgPrDøgnNormal() +
                lægemiddel.getEnhedPrKgPrDøgnTung() + lægemiddel.getEnhed());
        LocalTime[] klokkeset = {LocalTime.of(10,0),LocalTime.of(15,0),LocalTime.of(20,0)};
        double[] antalEnheder = {2};

        Exception exception = assertThrows(IllegalArgumentException.class,() -> Controller.opretDagligSkævOrdination(startDato,slutDato,patient,lægemiddel,klokkeset,antalEnheder));
        throw new IllegalArgumentException("Ordinationen kan ikke oprettes " + exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void antalOrdinationerPrVægtPrLægemiddel() {
        double vægtStart = 30;
        double vægtSlut = 70;
        Lægemiddel lægemiddel = null;
        double resultat = Double.parseDouble(lægemiddel.getEnhedPrKgPrDøgnLet() + lægemiddel.getEnhedPrKgPrDøgnNormal() + lægemiddel.getEnhedPrKgPrDøgnTung()
                + lægemiddel.getEnhed());
        Exception exception = assertThrows(NullPointerException.class,() -> Controller.antalOrdinationerPrVægtPrLægemiddel(vægtStart,vægtSlut,lægemiddel));
        assertEquals("Lægemiddel null",exception.getMessage());
    }
    @org.junit.jupiter.api.Test
    void vægtStartOgVægtSlutMindreEndNul() {
        double vægtStart = -30;
        double vægtSlut = -70;
        Lægemiddel lægemiddel = new Lægemiddel("Paracetamol",1,1.5,2,"ML");
        Exception exception = assertThrows(IllegalArgumentException.class,() -> Controller.antalOrdinationerPrVægtPrLægemiddel(vægtStart,vægtSlut,lægemiddel));
        assertEquals("Tallene må ikke indtastes med negative tal",exception.getMessage());
    }
    @org.junit.jupiter.api.Test
    void vægtStartOgVægtSlutErLigeMedNul() {
        double vægtStart = 0;
        double vægtSlut = 0;
        Lægemiddel lægemiddel = new Lægemiddel("Paracetamol",1,1.5,2,"ML");
        Exception exception = assertThrows(IllegalArgumentException.class,() -> Controller.antalOrdinationerPrVægtPrLægemiddel(vægtStart,vægtSlut,lægemiddel));
        assertEquals("Tallene skal være større end 0",exception.getMessage());
    }
}