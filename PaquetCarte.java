import java.util.*;

public class PaquetCarte {
    private ArrayList<Carte> paquet = new ArrayList<Carte>();
    protected int nbrCartes;
    protected String typeCarte;

    public PaquetCarte(){
        this.nbrCartes = 0;
        this.typeCarte = new String("Wagon");
    }

    public PaquetCarte(int nbrCartes, String carte){
        this.nbrCartes = nbrCartes;
        this.typeCarte = new String(carte);

    }

    public PaquetCarte(PaquetCarte other){
        this.paquet = other.getPaquet();
        this.nbrCartes = other.getNbrCartes();
        this.typeCarte = other.getTypeCarte();
    }

    // Definit un paquet de carte wagon au debut de la partie
    public PaquetCarte(String carte){
        ArrayList<String> couleur = new ArrayList(Arrays.asList("white", "blue", "yellow", "green", "red", "purple", "black", "brown"));
        this.typeCarte = new String(carte);
        if (carte.equals(new String("Wagon"))){
            this.nbrCartes = 110;
            for (int i = 0; i<8; i++){
                for (int j = 0; j<12; j++){
                    this.paquet.add(new WagonCarte(couleur.get(i)));
                }
            }
            for (int k = 0; k<14;k++){
                this.paquet.add(new WagonCarte(true));
            }
        }
        if(carte.equals(new String("Destination"))){
            ArrayList<String[]> liste = new ArrayList<String[]>();
            ArrayList<String> nom_ville = new ArrayList(Arrays.asList("Atlanta", "Boston", "Calgary", "Charleston","Chicago", "Dallas", "Denver","Duluth", "El Paso", "Helena", "Houston", "Kansas City", "Las Vegas", "Little Rock", "Los Angeles","Miami", "Montreal", "Nashville", "New Orleans", "New York", "Oklahoma City", "Omaha","Phoenix", "Pittsburgh", "Portland", "Raleigh", "Saint Louis", "San Francisco", "Santa Fe", "Sault St Marie", "Seattle", "Vancouver", "Washington", "Winnipeg" ));                                           
            this.nbrCartes = 30;
            for (int i = 0; i < this.nbrCartes; i++){
                String[] temp = new String[2];
                temp[0] = nom_ville.get(0);
                for (int j = 0; j < nom_ville.size() - 1; j++){
                    temp[1] = nom_ville.get(1);
                    liste.add(temp);
                }
                nom_ville.remove(0);
            }
        }
    }

    public ArrayList<Carte> getPaquet() {
        return this.paquet;
    }
    public int getNbrCartes() {
        return this.nbrCartes;
    }
    public String getTypeCarte() {
        return this.typeCarte;
    }

    public void setPaquet(ArrayList<Carte> paquet) {
        this.paquet = paquet;
    }

    public void setTypeCarte(String typeCarte) {
        this.typeCarte = typeCarte;
    }
    public void setNbrCartes(int nbrCartes) {
        this.nbrCartes = nbrCartes;
    }

    public void addCarte(Carte carte){
        if (this.typeCarte.equals(carte.getType())){
            paquet.add(carte);
            this.nbrCartes += 1;
        }
        else{
            System.out.println(new String("Un probléme de type est survenue, le type attendu est ") + new String(this.typeCarte) + new String(" mais nous avons recu ce type : ") + new String(carte.getType()));
        }
    }
}
