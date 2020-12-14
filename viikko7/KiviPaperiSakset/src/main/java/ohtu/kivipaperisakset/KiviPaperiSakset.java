package ohtu.kivipaperisakset;

public abstract class KiviPaperiSakset {

    IO io = new IO();
    Tuomari tuomari;

    
    public void pelaa() {
        this.tuomari = new Tuomari();
        System.out.println("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.readLine();
        asetaSiirto(ekanSiirto);
        String tokanSiirto = this.annaSiirto();
            while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
                tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
                System.out.println(tuomari);
                System.out.println();

                System.out.println("Ensimmäisen pelaajan siirto: ");
                ekanSiirto = io.readLine();
            
                System.out.println("Toisen pelaajan siirto: ");
                this.annaSiirto();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    abstract protected String annaSiirto();

    protected void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }
}