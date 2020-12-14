
package ohtu.kivipaperisakset;


public interface PeliTyyppi {
    void aloita();  


    public class PelaajaVsPelaaja implements PeliTyyppi{
        @Override
        public void aloita() {
            KPSPelaajaVsPelaaja kaksinpeli = new KPSPelaajaVsPelaaja();
        kaksinpeli.pelaa();
        }
    }
    
    public class HelppoTekoaly implements PeliTyyppi{
        @Override
        public void aloita() {
            KPSTekoaly yksinpeli = new KPSTekoaly();
            yksinpeli.pelaa();
        }
    }
    
    public class VaikeaTekoaly implements PeliTyyppi{
        @Override
        public void aloita() {
            KPSParempiTekoaly pahaYksinpeli = new KPSParempiTekoaly();
            pahaYksinpeli.pelaa();
        }
    }

}
