package engine;
import java.util.ArrayList;

/**
 * Classe Carte Destination qui hérite de Carte
 */
public class DestinationCarte extends Carte {
    /**
     * Attribut : Tableau des 2 villes de la carte
     */
    protected Ville[] villeDestination = new Ville[2];
    /**
     * Attribut : Nombre de point de la carte
     */
    protected int point;
    /**
     * Attribut : Type de la carte
     */
    protected String type = new String("Destination");

    /**
     * Constructeur par défaut
     */
    public DestinationCarte(){
        this.villeDestination[0] = new Ville();
        this.villeDestination[1] = new Ville();
    }
    
    /**
     * Constructeur avec le tableau des villes et le nombre de point
     * @param villeDestination
     * @param point
     */
    public DestinationCarte(Ville[] villeDestination, int point){
        this.villeDestination = villeDestination;
        this.point = point;
    }

    /**
     * Constructeur avec 2 villes et un plateau
     * @param destination1
     * @param destination2
     * @param p
     */
    public DestinationCarte(Ville destination1, Ville destination2, Plateau p){
        this.villeDestination[0] = destination1;
        this.villeDestination[1] = destination2;
        
    }

    /**
     * Constructeur par copie
     * @param other
     */
    public DestinationCarte(DestinationCarte other){
        this.villeDestination = other.getVilleDestination();
        this.point = other.getPoint();
    }

    /**
     * Methode toString
     */
    public String toString(){
        return this.type+" : "+this.villeDestination[0]+" -> "+this.villeDestination[1]+" = "+this.point+" points" ;
    }

    /**
     * Getter du tableau de ville
     */
    public Ville[] getVilleDestination() {
        return this.villeDestination;
    }

    /**
     * Setter du tableau de ville
     * @param villeDestination
     */
    public void setVilleDestination(Ville[] villeDestination) {
        this.villeDestination = villeDestination;
    }

    /**
     * Getteur du nombre de point
     * @return
     */
    public int getPoint() {
        return this.point;
    }

    /**
     * Setter du nombre de points
     * @param point
     */
    public void setPoint(int point) {
        this.point = point;
    }

    /**
     * Getter du type
     */
    public String getType(){
        return this.type;
    }

    /**
     * Methode abstraite
     */
    public String getLink(){
        return "error";
    }

    /**
     * Methode abstraite
     */
    public String getCouleur(){
        return "error";
    }

    /**
     * Getter de la ville de depart
     */
    public String getDepart(){
        return this.villeDestination[0].getName();
    }

    /**
     *  Getter de la ville d'arrivée
     */
    public String getArrive(){
        return this.villeDestination[1].getName();
    }
}
