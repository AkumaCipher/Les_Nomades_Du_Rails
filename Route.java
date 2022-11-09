public class Route {
    private int taille;
    private Ville[] destination = new Ville[2];
    private String couleur;

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
