package ordination;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DagligFastTest {

    private DagligFast dagligFast;

    // ------------- Tests for døgnDosis() -------------

    @Test
    void døgnDosis_alleDoserNull_returnNull() {
        dagligFast = new DagligFast(
                LocalDate.of(2025, 9, 26),
                LocalDate.of(2025, 9, 26),
                0, 0, 0, 0
        );
        assertEquals(0, dagligFast.døgnDosis());
    }

    @Test
    void døgnDosis_alleEtterDoser_returnererSum() {
        dagligFast = new DagligFast(
          LocalDate.of(2025, 9, 26),
          LocalDate.of(2025, 9, 26),
          1, 1, 1, 1
        );
        assertEquals(4, dagligFast.døgnDosis());
    }

    @Test
    void døgnDosis_blandedeDoser_returnererSum() {
        dagligFast = new DagligFast(
                LocalDate.of(2025, 9, 26),
                LocalDate.of(2025, 9, 26),
                2, 1, 0, 1
        );
        assertEquals(4, dagligFast.døgnDosis());
    }

    @Test
    void døgnDosis_storeDoser_returnererSum() {
        dagligFast = new DagligFast(
                LocalDate.of(2025, 9, 26),
                LocalDate.of(2025, 9, 26),
                10, 30, 10, 50
        );
        assertEquals(100, dagligFast.døgnDosis());
    }

    // ------------- Tests for samletDosis() -------------

    @Test
    void samletDosis_enDag_beregnerSum() {
        dagligFast = new DagligFast(
                LocalDate.of(2025, 9, 26),
                LocalDate.of(2025, 9, 26),
                1, 1, 1, 1
        );
        assertEquals(4, dagligFast.samletDosis());
    }

    @Test
    void samletDosis_treDage_beregnerSum() {
        dagligFast = new DagligFast(
                LocalDate.of(2025, 9, 26),
                LocalDate.of(2025, 9, 29),
                1, 1, 1, 1
        );
        assertEquals(16, dagligFast.samletDosis());
    }

    @Test
    void samletDosis_treDage_blandedeDoser() {
        dagligFast = new DagligFast(
                LocalDate.of(2025, 9, 26),
                LocalDate.of(2025, 9, 29),
                2, 1, 0, 1
        );
        assertEquals(16, dagligFast.samletDosis());
    }

    @Test
    void samletDosis_syvDage_storerDoser() {
        dagligFast = new DagligFast(
                LocalDate.of(2025, 9, 26),
                LocalDate.of(2025, 10, 2),
                10, 30, 10, 50
        );
        assertEquals(700, dagligFast.samletDosis());
    }
}