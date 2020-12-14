package ohtu.kivipaperisakset;

import java.util.Scanner;
import ohtu.kivipaperisakset.PeliTyyppi.HelppoTekoaly;
import ohtu.kivipaperisakset.PeliTyyppi.PelaajaVsPelaaja;
import ohtu.kivipaperisakset.PeliTyyppi.VaikeaTekoaly;

public class Paaohjelma {

    static IO io = new IO();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.readLine();
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            if (vastaus.endsWith("a")) {
                PelaajaVsPelaaja kaksinpeli = new PelaajaVsPelaaja();
                kaksinpeli.aloita();
            } else if (vastaus.endsWith("b")) {
                HelppoTekoaly yksinpeli = new HelppoTekoaly();
                yksinpeli.aloita();
            } else if (vastaus.endsWith("c")) {
                VaikeaTekoaly pahaYksinpeli = new VaikeaTekoaly();
                pahaYksinpeli.aloita();
            } else {
                break;
            }

        }

    }
}
