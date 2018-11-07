package ohtu.verkkokauppa;

import java.util.ArrayList;

public class Pankki implements Bank {

    private Bookkeeping kirjanpito;

    public Pankki(Bookkeeping bookkeeping) {
        kirjanpito = bookkeeping;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tililta + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
    
    public ArrayList<String> getTapahtumat() {
        return kirjanpito.getTapahtumat();
    }
}
