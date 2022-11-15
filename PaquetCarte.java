import java.util.ArrayList;

public class PaquetCarte {
    private ArrayList<Carte> paquet = new ArrayList<Carte>();
    protected int nbrCartes;

    public PaquetCarte(){
        this.nbrCartes = 0;
    }

    public PaquetCarte(int nbrCartes){
        this.nbrCartes = nbrCartes;
    }
    public PaquetCarte(PaquetCarte other){
        this.paquet = other.getPaquet();
        this.nbrCartes = other.getNbrCartes();
    }

    public ArrayList<Carte> getPaquet() {
        return this.paquet;
    }
    public int getNbrCartes() {
        return this.nbrCartes;
    }

    public void setPaquet(ArrayList<Carte> paquet) {
        this.paquet = paquet;
    }

    public void setNbrCartes(int nbrCartes) {
        this.nbrCartes = nbrCartes;
    }

    public void addCarte(Carte carte){
        paquet.add(carte);
        this.nbrCartes += 1;
    }
}
