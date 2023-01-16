package engine;
import java.util.*;

public class PaquetCarte {
    private ArrayList<Carte> paquet = new ArrayList<Carte>();
    protected int nbrCartes;
    protected String typeCarte;
    public ArrayList<String> couleur = new ArrayList(Arrays.asList("blanc", "bleu", "jaune", "vert", "rouge", "violet", "noire", "orange"));
    ArrayList<String> nom_ville = new ArrayList(Arrays.asList("Dolk","Aillk","Kuri","Rimu","Kolg","Guine","Varass","Trarbe","Nita","Solis","Xewood","Fefield","Brosa","Erbolis","Danir","Ouaïbe","New Varass","Bafao","Sandre","Motlen","Soles","Draille","Qimyss" ));

    
    public PaquetCarte(){
        this.nbrCartes = 0;
        this.typeCarte = new String("Wagon");
    }

    // Definit un paquet de carte vide d'un joueur avec sa taille et le type de carte qu'il doit recevoir
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
    public PaquetCarte(String carte,Plateau p){
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
            this.nbrCartes = 30;
            ArrayList<String> paquetMelange = nom_ville;
            int taille=0;
            while (taille<30){
                Collections.shuffle(paquetMelange);
                for (int i=0;i<paquetMelange.size()/2;i++){
                    if (taille<30){
                        this.paquet.add(new DestinationCarte(new Ville(paquetMelange.get(i*2)),new Ville(paquetMelange.get(i*2+1)), p));
                        taille+=1;
                    }
                }
            }
        }
    }

    public String toString(){
        String chaine = new String();
        for (int i =0;i<this.nbrCartes;i++){
            chaine = chaine + this.getCarte(i).toString() + "| "; 
        }
        return chaine;
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
    
    public Carte getCarte(int indice){
        return this.paquet.get(indice);
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

    public void removeCarte(int indice){
        this.paquet.remove(this.paquet.get(indice));
        this.setNbrCartes(this.getNbrCartes()-1);
        if (this.nbrCartes == 0){
            System.out.println("Paquet vide");
        }
    }

    public void pioche(int nbcarte,PaquetCarte pioche){
        for (int i=0 ; i<nbcarte ; i++){
            int alea = (int)(Math.random() * pioche.getNbrCartes());
            this.addCarte(pioche.getCarte(alea));
            pioche.removeCarte(alea);
        }
    }

    public int nbcarte(String couleur){
        int nb =0;
        if (this.typeCarte.equals("Wagon")){
            for(Carte carte : this.paquet){
                if(carte.getCouleur().equals(couleur)){
                    nb+=1;
                }
            }
        }
        return nb;
    }

    public void addCarte(Carte carte){
        if (this.typeCarte.equals(carte.getType())){
            this.paquet.add(carte);
            //this.nbrCartes += 1;
        }
        else{
            System.out.println(new String("Un probléme de type est survenue, le type attendu est ") + new String(this.typeCarte) + new String(" mais nous avons recu ce type : ") + new String(carte.getType()));
        }
    }
    
}
