import java.util.ArrayList;

public class PaquetCarte {
    private ArrayList<Carte> paquet = new ArrayList<Carte>();

    public PaquetCarte(){

    }


    public ArrayList<Carte> getPaquet() {
        return this.paquet;
    }

    public void setPaquet(ArrayList<Carte> paquet) {
        this.paquet = paquet;
    }

    public void addCarte(Carte carte){
        paquet.add(carte);
    }
}
