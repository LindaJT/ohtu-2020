
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Summa extends Komento {

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        this.arvo = 0;
        try {
            this.arvo = Integer.parseInt(this.syotekentta.getText());
        } catch (Exception e) {
            
        }
        this.sovellus.plus(this.arvo);
        int laskunTulos = this.sovellus.tulos();
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + laskunTulos);
    }

    @Override
    public void peru() {
        int uusi = Integer.parseInt(this.tuloskentta.getText()) - this.arvo;
        this.tuloskentta.setText("" + uusi);
    }
    
}
