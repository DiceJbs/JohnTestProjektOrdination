package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination {
    private Dosis[] doser;

    public DagligFast(LocalDate startDato, LocalDate slutDato, double morgenAntal,
                      double middagAntal, double aftenAntal, double natAntal) {
        super(startDato, slutDato);
        doser = new Dosis[4];

        doser[0] = new Dosis(LocalTime.of(8, 0), morgenAntal);
        doser[1] = new Dosis(LocalTime.of(12, 0), middagAntal);
        doser[2] = new Dosis(LocalTime.of(18, 0), aftenAntal);
        doser[3] = new Dosis(LocalTime.of(22, 0), natAntal);
    }

    @Override
    public double samletDosis() {
        return døgnDosis() * antalDage();
    }

    @Override
    public double døgnDosis() {
        double sum = 0;

        for (Dosis d : doser) {
            sum += d.getAntal();
        }

        return sum / antalDage();
    }

    @Override
    public String getType() {
        return "DagligFast";
    }


}
