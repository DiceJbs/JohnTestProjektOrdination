package ordination;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DagligSkævTest {

    @Test
    void samletDosisTC1() {

        LocalDate startDato = LocalDate.of(2025,9,26);
        LocalDate slutdato = LocalDate.of(2025,9,26);
        List<Dosis> doser = new ArrayList<>();
        Dosis dose = new Dosis(LocalTime.of(10,30),2);
        Dosis dose2 = new Dosis(LocalTime.of(20,30),1);
        doser.add(dose);
        doser.add(dose2);
        doser.add(dose);
        doser.add(dose2);
        doser.add(dose);
        doser.add(dose2);
    DagligSkæv dagligSkæv = new DagligSkæv(startDato,slutdato,doser);

    assertEquals(9,dagligSkæv.samletDosis());
    }
@Test
    void samletDosisTC2() {

        LocalDate startDato = LocalDate.of(2025,9,26);
        LocalDate slutdato = LocalDate.of(2025,9,30);
        List<Dosis> doser = new ArrayList<>();
        Dosis dose = new Dosis(LocalTime.of(10,30),2);
        Dosis dose2 = new Dosis(LocalTime.of(20,30),1);
        doser.add(dose);
        doser.add(dose2);
        doser.add(dose);
        doser.add(dose2);
        doser.add(dose);
        doser.add(dose2);
        DagligSkæv dagligSkæv = new DagligSkæv(startDato,slutdato,doser);

        assertEquals(45,dagligSkæv.samletDosis());
    }

    @Test
    void samletDosisTC3() {

        LocalDate startDato = LocalDate.of(2025,9,26);
        LocalDate slutdato = LocalDate.of(2025,10,3);
        List<Dosis> doser = new ArrayList<>();
        Dosis dose = new Dosis(LocalTime.of(10,30),2);
        Dosis dose2 = new Dosis(LocalTime.of(20,30),1);
        doser.add(dose);
        doser.add(dose2);
        doser.add(dose);
        doser.add(dose2);
        doser.add(dose);
        doser.add(dose2);
        DagligSkæv dagligSkæv = new DagligSkæv(startDato,slutdato,doser);

        assertEquals(72,dagligSkæv.samletDosis());
    }

    @Test
    void samletDosisTC1GrænseVærdier() {

        LocalDate startDato = LocalDate.of(2025,9,26);
        LocalDate slutdato = LocalDate.of(2025,9,30);
        List<Dosis> doser = new ArrayList<>();
        Dosis dose = new Dosis(LocalTime.of(10,30),2);
        Dosis dose2 = new Dosis(LocalTime.of(20,30),1);
        doser.add(dose);
        doser.add(new Dosis(LocalTime.of(19,30),-1));
        doser.add(dose);
        doser.add(dose2);
        doser.add(dose);
        doser.add(dose2);
        DagligSkæv dagligSkæv = new DagligSkæv(startDato,slutdato,doser);

        // expected an exception

    }

    @Test
    void samletDosisTC2GrænseVærdier() {

        LocalDate startDato = LocalDate.of(2025,9,26);
        LocalDate slutdato = LocalDate.of(2025,10,3);
        List<Dosis> doser = new ArrayList<>();
        Dosis dose = new Dosis(LocalTime.of(10,30),0);
        Dosis dose2 = new Dosis(LocalTime.of(20,30),0);
        doser.add(dose);
        doser.add(new Dosis(LocalTime.of(19,30),0));
        doser.add(dose);
        doser.add(dose2);
        doser.add(dose);
        doser.add(dose2);
        DagligSkæv dagligSkæv = new DagligSkæv(startDato,slutdato,doser);

        assertEquals(0,dagligSkæv.samletDosis());
        // expected an exception

    }



    @Test
    void døgnDosisTc1() {
        LocalDate startDato = LocalDate.of(2025,9,26);
        LocalDate slutdato = LocalDate.of(2025,9,26);
        List<Dosis> doser = new ArrayList<>();
        doser.add(new Dosis(LocalTime.of(19,30),2));
        doser.add(new Dosis(LocalTime.of(19,30),1));
        doser.add(new Dosis(LocalTime.of(19,30),2));
        doser.add(new Dosis(LocalTime.of(19,30),2));
        DagligSkæv dagligSkæv = new DagligSkæv(startDato,slutdato,doser);

            assertEquals(7,dagligSkæv.døgnDosis());
    }

    @Test
    void døgnDosisTc2() {
        LocalDate startDato = LocalDate.of(2025,9,26);
        LocalDate slutdato = LocalDate.of(2025,9,26);
        List<Dosis> doser = new ArrayList<>();
        doser.add(new Dosis(LocalTime.of(19,30),0));
        doser.add(new Dosis(LocalTime.of(19,30),0));
        doser.add(new Dosis(LocalTime.of(19,30),0));
        doser.add(new Dosis(LocalTime.of(19,30),0));
        DagligSkæv dagligSkæv = new DagligSkæv(startDato,slutdato,doser);

        assertEquals(0,dagligSkæv.døgnDosis());
    }

    @Test
    void døgnDosisTc3() {
        LocalDate startDato = LocalDate.of(2025,9,28);
        LocalDate slutdato = LocalDate.of(2025,9,28);
        List<Dosis> doser = new ArrayList<>();
        doser.add(new Dosis(LocalTime.of(19,30),3));
        doser.add(new Dosis(LocalTime.of(19,30),1));
        doser.add(new Dosis(LocalTime.of(19,30),1));
        doser.add(new Dosis(LocalTime.of(19,30),1));
        DagligSkæv dagligSkæv = new DagligSkæv(startDato,slutdato,doser);

        assertEquals(6,dagligSkæv.døgnDosis());
    }

    @Test
    void døgnDosisTc4() {
        LocalDate startDato = LocalDate.of(2025,9,28);
        LocalDate slutdato = LocalDate.of(2025,9,28);
        List<Dosis> doser = new ArrayList<>();
        doser.add(new Dosis(LocalTime.of(19,30),-3));
        doser.add(new Dosis(LocalTime.of(19,30),1));
        doser.add(new Dosis(LocalTime.of(19,30),1));
        doser.add(new Dosis(LocalTime.of(19,30),1));
        DagligSkæv dagligSkæv = new DagligSkæv(startDato,slutdato,doser);
// excepted an exception
        assertEquals("dosis må ikke være negativt",dagligSkæv.døgnDosis());
    }
}