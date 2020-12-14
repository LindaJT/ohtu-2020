 
package ohtu.kivipaperisakset;


public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {
    

    
    @Override
    public String annaSiirto() {
        System.out.println("Toisen pelaajan siirto: ");
        String vastaus = io.readLine();
        return vastaus;
    }
}