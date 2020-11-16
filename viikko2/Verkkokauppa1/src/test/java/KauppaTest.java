

import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Pankki;
import ohtu.verkkokauppa.Tuote;
import ohtu.verkkokauppa.Varasto;
import ohtu.verkkokauppa.Viitegeneraattori;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {
    
    Kauppa k;
    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    
    @Before
    public void setUp() {
        pankki = mock(Pankki.class);

        viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).thenReturn(42);

        varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(2)).thenReturn(10); 
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipä", 2));
        k = new Kauppa(varasto, viite, pankki);   
    }
    
    
    @Test
   public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeallaTilinumerollajaSummalla() {
                 
        k.aloitaAsiointi();
        k.lisaaKoriin(1); 
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));   

    }
   
    @Test
   public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
                     

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }
   
   @Test
   public void PankinMetodiaTilisiirtoKutsutaanOikeallaTilinumerollajaSummallaKunKorissaOnKaksiTuotetta() {
       k.aloitaAsiointi();
       k.lisaaKoriin(1);
       k.lisaaKoriin(2);
       k.tilimaksu("pekka", "12345");
       
       verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(7)); 
       
   }
   
   @Test
   public void PankinMetodiaTilisiirtoKutsutaanOikeallaTilinumerollajaSummallaKunKorissaOnKaksiSamaaTuotetta() {
       k.aloitaAsiointi();
       k.lisaaKoriin(1);
       k.lisaaKoriin(1);
       k.tilimaksu("pekka", "12345");
       
       verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(10)); 
       
   }
   
   @Test
   public void PankinMetodiaTilisiirtoKutsutaanOikeallaTilinumerollajaSummallaKunKoriinOnLisättyLoppunuttaTuotetta() {
       k.aloitaAsiointi();
       k.lisaaKoriin(1);
       when(varasto.saldo(2)).thenReturn(0);
       k.lisaaKoriin(2);
       k.tilimaksu("pekka", "12345");
       
       verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5)); 
       
   }
   
   @Test
   public void asioinninAloittaminenNollaaEdellisenOstoksenTiedot() {
       k.aloitaAsiointi();
       k.lisaaKoriin(1);
       k.tilimaksu("markku", "54321");
       
       k.aloitaAsiointi();
       k.lisaaKoriin(1);
       k.lisaaKoriin(2);
       k.tilimaksu("pekka", "12345");
       
       verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(7)); 
   }
    
   @Test
   public void pyydetaanUusiViiteJokaiseenMaksuun() {
       k.aloitaAsiointi();
       k.lisaaKoriin(1);
       k.tilimaksu("pekka", "1111");

        // tarkistetaan että tässä vaiheessa viitegeneraattorin metodia seuraava()
        // on kutsuttu kerran
        verify(viite, times(1)).uusi();

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("nguyen", "1234");


        verify(viite, times(2)).uusi();

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("linda", "4321");;

      
        verify(viite, times(3)).uusi();
   }
   
   @Test
   public void koristaPystyyPoistamaanTuotteen() {
       k.aloitaAsiointi();
       k.lisaaKoriin(1);
       k.lisaaKoriin(2);
       k.poistaKorista(1);
       k.tilimaksu("pekka", "12345");
       
       verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(2)); 
   }

}
