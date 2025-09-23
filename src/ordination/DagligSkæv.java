package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public abstract class DagligSkæv extends Ordination {
    private List<Dosis> dosisList;

    public DagligSkæv(LocalDate startDato, LocalDate slutDato, List<Dosis> dosisList) {
        super(startDato,slutDato);
        this.dosisList = dosisList;

    }

    public List<Dosis> getDosisList() {
        return dosisList;
    }
    @Override
    public double samletDosis() {
        double totalDosis = 0;
        for (Dosis dosis : dosisList) {
            totalDosis += dosis.getAntal();
        }
        return totalDosis;
    }
    @Override
    public double døgnDosis() {
        double døgnDo = 0;
        for (Dosis dosis : dosisList) {
            døgnDo += dosis.getAntal();
        }
        return døgnDo/antalDage();
    }
    @Override
    public String getType() {
        return " DagligSkæv ";
    }


}
