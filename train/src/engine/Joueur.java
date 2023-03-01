package engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Classe qui definit un joueur
 */
public class Joueur {
    /**
     * Attribut : nom du joueur
     */
    String nom;
    /**
     * Attribut : paquet de carte destination
     */
    PaquetCarte cartesDestination;
    /**
     * Attribut : paquet de carte wagon
     */
    PaquetCarte cartesWagon;
    /**
     * Attribut : Nombre de wagon
     */
    int wagons;
    /**
     * Attribut : Nombre de points
     */
    int point;
    /**
     * Attribut : couleur du joueur
     */
    String couleur;
    /**
     * Attribut: IA
     */
    boolean IA = false;
    /**
     * Attribut: Liste des couleurs
     */
    public ArrayList<String> couleurList = new ArrayList(Arrays.asList("blanc", "bleu", "jaune", "vert", "rouge", "violet", "noire", "orange"));

    /**
     * Constructeur par défaut
     */
    public Joueur(){
        this.nom = new String("Defaut");
        this.cartesDestination = new PaquetCarte(3, new String("Destination"));
        this.cartesWagon = new PaquetCarte(4, new String("Wagon"));
        this.point = 0;
        this.wagons=45;
        this.couleur="rouge";
    }
    /**
     * Constructeur par son nom et pioche ses cartes de base on lui fait connaitre les pioches
     * @param nom
     * @param couleur
     * @param wagonPioche
     * @param destinationPioche
     */
    public Joueur(String nom,String couleur,PaquetCarte wagonPioche,PaquetCarte destinationPioche){
        this.nom = new String(nom);
        this.cartesDestination = new PaquetCarte(3, new String("Destination"));
        this.cartesWagon = new PaquetCarte(4, new String("Wagon"));
        this.cartesWagon.pioche(4, wagonPioche);
        this.cartesDestination.pioche(3,destinationPioche);
        this.point = 0;
        this.wagons=45;
        this.couleur=couleur;
    }

    /**
     * Constructeur par touts les paramètres
     * @param nom
     * @param couleur
     * @param cartesDestination
     * @param cartesWagon
     * @param point
     */
    public Joueur(String nom,String couleur, PaquetCarte cartesDestination, PaquetCarte cartesWagon, int point){
        this.nom = new String(nom);
        this.cartesDestination = new PaquetCarte(cartesDestination);
        this.cartesWagon = new PaquetCarte(cartesWagon);
        this.point = point;
        this.wagons=45;
        this.couleur=couleur;
    }

    /**
     * Constructeur par copie
     * @param other
     */
    public Joueur(Joueur other){
        this.nom = new String(other.getNom());
        this.cartesDestination = new PaquetCarte(other.getCartesDestination());
        this.cartesWagon = new PaquetCarte(other.getCartesWagon());
        this.point = other.getPoint();
        this.wagons=other.getWagons();
        this.couleur=other.couleur;
    }

    /**
     * Constructeur de l'IA
     * @param intelligence
     * @param wagonPioche
     * @param destinationPioche
     * @param couleur
     */
    public Joueur(boolean intelligence,PaquetCarte wagonPioche,PaquetCarte destinationPioche,String couleur){
        this.IA=true;
        this.nom="IA";
        this.cartesDestination = new PaquetCarte(3, new String("Destination"));
        this.cartesWagon = new PaquetCarte(4, new String("Wagon"));
        this.cartesWagon.pioche(4, wagonPioche);
        this.cartesDestination.pioche(3,destinationPioche);
        this.point = 0;
        this.wagons=45;
        this.couleur=this.couleurIA(couleur);
    }

    /**
     * Getter du nom
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Setter du nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Setter de la couleur
     * @param couleur
     */
    public void setCouleur(String couleur){
        this.couleur=couleur;
    }

    /**
     * Getter de la couleur
     * @return
     */
    public String getCouleur(){
        return this.couleur;
    }

    /**
     * Getter des carte destination
     * @return
     */
    public PaquetCarte getCartesDestination() {
        return this.cartesDestination;
    }

    /**
     * Setter des carte destination
     * @param cartesDestination
     */
    public void setCartesDestination(PaquetCarte cartesDestination) {
        this.cartesDestination = cartesDestination;
    }

    /**
     * Getter des carte wagon
     * @return
     */
    public PaquetCarte getCartesWagon() {
        return this.cartesWagon;
    }

    /**
     * Setter des carte wagon
     * @return
     */
    public void setCartesWagon(PaquetCarte cartesWagon) {
        this.cartesWagon = cartesWagon;
    }

    /**
     * Getter des points
     */
    public int getPoint() {
        return this.point;
    }

    /**
     * Setter des points
     * @param point
     */
    public void setPoint(int point) {
        this.point = point;
    }

    /**
     * Ajoute des points
     * @param point
     */
    public void addPoint(int point) {
        this.point += point;
    }

    /**
     * Setter du nombre de wagon
     * @param nb
     */
    public void setWagons(int nb){
        this.wagons=nb;
    }

    /**
     * Getter du nombre de wagons
     * @return
     */
    public int getWagons(){
        return this.wagons;
    }

    /**
     * Retire des wagons
     * @param nb
     */
    public void retireWagons(int nb){
        this.wagons=this.wagons-nb;
    }

    /**
     * methode equals
     * @param j
     * @return
     */
    public boolean equals(Joueur j){
        if (this.nom==j.nom && this.couleur.equals(this.couleur)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Permet de choisir une couleur qui n'a pas été prise pour l'IA
     * @param couleur
     * @return
     */
    public String couleurIA(String couleur){
        String newCouleur = couleur;
        while(newCouleur.equals(couleur)){
            Random random = new Random();
            int nb;
            nb = random.nextInt(couleurList.size());
            newCouleur=couleurList.get(nb);
        }
        return newCouleur;
    }

    /**
     * Renvoit si le joueur est une IA
     * @return
     */
    public boolean getIA(){
        return this.IA;
    }

}
