public class Joueur {
    String nom;
    PaquetCarte cartesDestination;
    PaquetCarte cartesWagon;
    int point;
    
    public Joueur(){
        this.nom = new String("Defaut");
        this.cartesDestination = new PaquetCarte(3);
        this.cartesWagon = new PaquetCarte(5);
        this.point = 0;
    }
    public Joueur(String nom){
        this.nom = new String(nom);
        this.cartesDestination = new PaquetCarte(3);
        this.cartesWagon = new PaquetCarte(5);
        this.point = 0;
    }
    public Joueur(String nom, PaquetCarte cartesDestination, PaquetCarte cartesWagon, int point){
        this.nom = new String(nom);
        this.cartesDestination = new PaquetCarte(cartesDestination);
        this.cartesWagon = new PaquetCarte(cartesWagon);
        this.point = point;
    }
    public Joueur(Joueur other){
        this.nom = new String(other.getNom());
        this.cartesDestination = new PaquetCarte(other.getCartesDestination());
        this.cartesWagon = new PaquetCarte(other.getCartesWagon());
        this.point = other.getPoint();
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public PaquetCarte getCartesDestination() {
        return this.cartesDestination;
    }

    public void setCartesDestination(PaquetCarte cartesDestination) {
        this.cartesDestination = cartesDestination;
    }

    public PaquetCarte getCartesWagon() {
        return this.cartesWagon;
    }

    public void setCartesWagon(PaquetCarte cartesWagon) {
        this.cartesWagon = cartesWagon;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

}
