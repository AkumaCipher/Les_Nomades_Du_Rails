package engine;
import java.util.*;

/**
 * Classe du paquet de Carte
 */
public class PaquetCarte {
    /**
     * Attribut : paquet
     */
    private ArrayList<Carte> paquet = new ArrayList<Carte>();
    /**
     * Attribut : nombre de carte
     */
    protected int nbrCartes;
    /**
     * Attribut : type de la carte
     */
    protected String typeCarte;
    /**
     * Attribut : liste des couleurs
     */
    public ArrayList<String> couleur = new ArrayList(Arrays.asList("blanc", "bleu", "jaune", "vert", "rouge", "violet", "noire", "orange"));
    /**
     * Attribut : liste des villes
     */
    ArrayList<String> nom_ville = new ArrayList(Arrays.asList("Dolk","Aillk","Kuri","Rimu","Kolg","Guine","Varass","Trarbe","Nita","Solis","Xewood","Fefield","Brosa","Erbolis","Danir","Ouaïbe","Virusse","Bafao","Sandre","Motlen","Soles","Draille","Qimyss" ));

    /**
     * Constructeur par défaut
     */
    public PaquetCarte(){
        this.nbrCartes = 0;
        this.typeCarte = new String("Wagon");
    }

    /**
     * Constructeur par nombre et par type
     * @param nbrCartes
     * @param carte
     */
    public PaquetCarte(int nbrCartes, String carte){
        this.nbrCartes = nbrCartes;
        this.typeCarte = new String(carte);
    }

    /**
     * Constructeur par copie
     * @param other
     */
    public PaquetCarte(PaquetCarte other){
        this.paquet = other.getPaquet();
        this.nbrCartes = other.getNbrCartes();
        this.typeCarte = other.getTypeCarte();
    }

    /**
     * Constructeur spécifique au paquet de carte du jeu
     * @param carte
     * @param p
     */
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

    /**
     * Methode to String
     */
    public String toString(){
        String chaine = new String();
        for (int i =0;i<this.nbrCartes;i++){
            chaine = chaine + this.getCarte(i).toString() + "| "; 
        }
        return chaine;
    }

    /**
     * Getter Paquet
     * @return
     */
    public ArrayList<Carte> getPaquet() {
        return this.paquet;
    }
    /**
     * Getter nombre de carte
     * @return
     */
    public int getNbrCartes() {
        return this.nbrCartes;
    }
    /**
     * Getter du type de la carte
     * @return
     */
    public String getTypeCarte() {
        return this.typeCarte;
    }
    /**
     * Getter de la carte selon l'indice
     * @param indice
     * @return
     */
    public Carte getCarte(int indice){
        return this.paquet.get(indice);
    }
    /**
     * Setter du paquet
     * @param paquet
     */
    public void setPaquet(ArrayList<Carte> paquet) {
        this.paquet = paquet;
    }
    /**
     * Setter du type de la carte
     * @param typeCarte
     */
    public void setTypeCarte(String typeCarte) {
        this.typeCarte = typeCarte;
    }
    /**
     * Setter du nombre de Carte
     * @param nbrCartes
     */
    public void setNbrCartes(int nbrCartes) {
        this.nbrCartes = nbrCartes;
    }

    /**
     * Supprime une carte donné par indice
     * @param indice
     */
    public void removeCarte(int indice){
        this.paquet.remove(this.paquet.get(indice));
        this.setNbrCartes(this.getNbrCartes()-1);
        if (this.nbrCartes == 0){
            System.out.println("Paquet vide");
        }
    }

    /**
     * Pioche un nombre de carte donné dans une pioche donnée
     * @param nbcarte
     * @param pioche
     */
    public void pioche(int nbcarte,PaquetCarte pioche){
        for (int i=0 ; i<nbcarte ; i++){
            int alea = (int)(Math.random() * pioche.getNbrCartes());
            this.addCarte(pioche.getCarte(alea));
            pioche.removeCarte(alea);
        }
    }

    /**
     * Retourne le nombre de carte Wagon d'une couleur donné
     * @param couleur
     * @param main
     * @return
     */
    public int nbcarte(String couleur,PaquetCarte main){
        int nb =0;
        if (this.typeCarte.equals("Wagon")){
            for(Carte carte : main.getPaquet()){
                if(carte.getCouleur().equals(couleur)){
                    nb+=1;
                }
            }
        }
        return nb;
    }


    /**
     * Ajoute une carte au paquet
     * @param carte
     */
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
