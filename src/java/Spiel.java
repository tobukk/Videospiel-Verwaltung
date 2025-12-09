import java.util.ArrayList;
import java.util.List;

public class Spiel {
    private String genre;
    private int altersfreigabe;
    private boolean istMultiplayer;
    private double preis;
    private String titel;


    public Spiel(String titel, String genre, int altersfreigabe, boolean istMultiplayer, double preis) {
        this.genre = genre;
        this.altersfreigabe = altersfreigabe;
        this.istMultiplayer = istMultiplayer;
        this.preis = preis;
        this.titel = titel;
    }

    public String getGenre() {
        return genre;
    }

    public int getAltersfreigabe() {
        return altersfreigabe;
    }

    //Getter erstellen
    public boolean isistMultiplayer() {
        return istMultiplayer;
    }
    public double getPreis() {
        return preis;
    }
    public String getTitel() {
        return titel;
}

//Erstellung der Standardspiele
public static List<Spiel> standartspiele() {
         List<Spiel> liste = new ArrayList<>();
         liste.add(new Spiel("Fortnite","Shooter", 12, true, 0.00));
         liste.add(new Spiel("Minecraft", "Survival", 6, false, 25.99));
         liste.add(new Spiel("Black Ops 7", "Shooter", 18, true, 69.99));
         liste.add(new Spiel("Fallout 4", "Shooter", 18, false, 19.99));
         liste.add(new Spiel("Pacman", "Actionspiel", 0, false, 3.99));

        return liste;

}

//Methode um zu Filtern
    public String FilterSpiele() {
        String janein;

        if (istMultiplayer == true) {
            janein = "Ja";
        } else {
            janein = "Nein";
        }
        return titel + " " + genre + " " + altersfreigabe + " " + janein + " " + preis;
    }

}
