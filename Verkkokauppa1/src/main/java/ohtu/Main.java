package ohtu;

import ohtu.verkkokauppa.Bank;
import ohtu.verkkokauppa.Bookkeeping;
import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Kirjanpito;
import ohtu.verkkokauppa.Pankki;
import ohtu.verkkokauppa.ReferenceGenerator;
import ohtu.verkkokauppa.Varasto;
import ohtu.verkkokauppa.Viitegeneraattori;
import ohtu.verkkokauppa.Warehouse;

public class Main {

    public static void main(String[] args) {
        Bookkeeping kirjanpito = new Kirjanpito();
        Warehouse varasto = new Varasto(kirjanpito);
        Bank pankki = new Pankki(kirjanpito);
        ReferenceGenerator viitegen = new Viitegeneraattori();
        Kauppa kauppa = new Kauppa(varasto, pankki, viitegen);

        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        // kirjanpito
        for (String tapahtuma : kauppa.getTapahtumat()) {
            System.out.println(tapahtuma);
        }
    }
}
