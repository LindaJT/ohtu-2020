package ohtu.kivipaperisakset;


public class KPSTekoaly extends KiviPaperiSakset {
    
    int siirto = 0;

    @Override
    protected String annaSiirto() {
        siirto++;
        siirto = siirto % 3;
        String vastaus;
        if (siirto == 0) {
            vastaus = "k";
        } else if (siirto == 1) {
            vastaus = "p";
        } else {
            vastaus = "s";
        }
        System.out.println("Tietokone valitsi: " + vastaus);
        return vastaus;
    }

}