package engine;
public class Route {
    private int taille;
    private Ville[] destination = new Ville[2];
    private String couleur;

    public Route() {
        this.taille = 2;
        this.destination[0] = new Ville();
        this.destination[1] = new Ville();
        this.couleur = new String("rouge");
    }

    public Route(int taille, Ville[] destination, String couleur) {
        this.taille = taille;
        this.destination = destination;
        this.couleur = new String(couleur);
    }

    public Route(int taille, Ville destination1, Ville destination2, String couleur) {
        this.taille = taille;
        this.destination[0] = destination1;
        this.destination[1] = destination2;
        this.couleur = new String(couleur);
    }

    public Route(Route other){
        this.taille = other.getTaille();
        this.destination = other.getDestination();
        this.couleur = new String(other.getCouleur());
    }

    public int getTaille() {
        return this.taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public Ville[] getDestination() {
        return this.destination;
    }

    public void setDestination(Ville[] destination) {
        this.destination = destination;
    }

    public String getCouleur() {
        return this.couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

}
