/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author linjokin
 */
public class Nollaa extends Komento {

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        this.arvo = 0;
        try {
            this.arvo = Integer.parseInt(this.tuloskentta.getText());
        } catch (Exception e) {
            
        }
        this.sovellus.nollaa();
        int laskunTulos = this.sovellus.tulos();
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + laskunTulos);
    }

    @Override
    public void peru() {
        this.tuloskentta.setText("" + this.arvo);
    }
    
}
