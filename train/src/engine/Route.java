package engine;
/**
 * Classe d'une route
 */
public class Route {
    /**
     * Attribut : taille 
     */
    private int taille;
    /**
     * Attribut : tableau des villes
     */
    private Ville[] destination = new Ville[2];
    /**
     * Attribut : couleur de la route
     */
    private String couleur;
    /**
     * Attribut : proprietaire
     */
    private Joueur proprietaire;

    /**
     * Constructeur par copie
     */
    public Route() {
        this.taille = 2;
        this.destination[0] = new Ville();
        this.destination[1] = new Ville();
        this.couleur = new String("rouge");
    }

    /**
     * Constructeur par tableau de ville
     * @param taille
     * @param destination
     * @param couleur
     */
    public Route(int taille, Ville[] destination, String couleur) {
        this.taille = taille;
        this.destination = destination;
        this.couleur = new String(couleur);
    }

    /**
     * Constructeur par 2 villes
     * @param taille
     * @param destination1
     * @param destination2
     * @param couleur
     */
    public Route(int taille, Ville destination1, Ville destination2, String couleur) {
        this.taille = taille;
        this.destination[0] = destination1;
        this.destination[1] = destination2;
        this.couleur = new String(couleur);
    }

    /**
     * Constructeur par copie
     * @param other
     */
    public Route(Route other){
        this.taille = other.getTaille();
        this.destination = other.getDestination();
        this.couleur = new String(other.getCouleur());
    }

    /**
     * Getter de la taille
     * @return
     */
    public int getTaille() {
        return this.taille;
    }

    /**
     * Setter de la taille
     * @param taille
     */
    public void setTaille(int taille) {
        this.taille = taille;
    }

    /**
     * Getter du tableau de destination
     * @return
     */
    public Ville[] getDestination() {
        return this.destination;
    }

    /**
     * Setter du tableau de destination
     * @param destination
     */
    public void setDestination(Ville[] destination) {
        this.destination = destination;
    }

    /**
     * Setter du proprietaire
     * @param j
     */
    public void setProprietaire(Joueur j){
        this.proprietaire=j;
    }

    /**
     * Getter du proprietaire
     * @return
     */
    public Joueur getProprietaire(){
        return this.proprietaire;
    }

    /**
     * Getter de la couleur
     * @return
     */
    public String getCouleur() {
        return this.couleur;
    }

    /**
     * Setter de la couleur
     * @param couleur
     */
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    /**
     * Getter du nombre de points
     * @return
     */
    public int getPoints(){
        if (this.taille==1){
            return 1;
        }if (this.taille==2){
            return 2;
        }if (this.taille==3){
            return 4;
        }
        return 7;
    }

}
