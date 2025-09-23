package ordination;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PN extends Ordination {
    private final double antalEnheder;
    private ArrayList<LocalDate> datoerHvorOrdinationIndtaget = new ArrayList<>();

    public PN(LocalDate startDato, LocalDate slutDato, double antalEnheder) {
        super(startDato, slutDato);
        this.antalEnheder = antalEnheder;
    }
    public double getAntalEnheder() {
        return antalEnheder;
    }

    /**
     * Registrer datoen for en anvendt dosis.
     */
public void registerDate (LocalDate date){
    datoerHvorOrdinationIndtaget.add(date);
}
    public void anvendDosis(LocalDate dato) {
        registerDate(dato);
    }

    /** Returner antal gange ordinationen er anvendt. */
    public double antalGangeAnvendt() {
        return datoerHvorOrdinationIndtaget.size();
    }

    @Override
    public double samletDosis() {
        return antalGangeAnvendt()*antalEnheder;
    }

    @Override
    public double døgnDosis() {
        return (antalGangeAnvendt()*antalEnheder)/ ChronoUnit.DAYS.between(datoerHvorOrdinationIndtaget.getFirst(),datoerHvorOrdinationIndtaget.getLast());
    }

    @Override
    public String getType() {
        return "PN";
    }
}
