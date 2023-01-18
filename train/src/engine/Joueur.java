package engine;
public class Joueur {
    String nom;
    PaquetCarte cartesDestination;
    PaquetCarte cartesWagon;
    int wagons;
    int point;
    String couleur;

    
    public Joueur(){
        this.nom = new String("Defaut");
        this.cartesDestination = new PaquetCarte(3, new String("Destination"));
        this.cartesWagon = new PaquetCarte(4, new String("Wagon"));
        this.point = 0;
        this.wagons=45;
        this.couleur="rouge";
    }

    // Definit un joueur par son nom et pioche ses cartes de base on lui fait connaitre les pioches
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


    public Joueur(String nom,String couleur, PaquetCarte cartesDestination, PaquetCarte cartesWagon, int point){
        this.nom = new String(nom);
        this.cartesDestination = new PaquetCarte(cartesDestination);
        this.cartesWagon = new PaquetCarte(cartesWagon);
        this.point = point;
        this.wagons=45;
        this.couleur=couleur;
    }

    public Joueur(Joueur other){
        this.nom = new String(other.getNom());
        this.cartesDestination = new PaquetCarte(other.getCartesDestination());
        this.cartesWagon = new PaquetCarte(other.getCartesWagon());
        this.point = other.getPoint();
        this.wagons=other.getWagons();
        this.couleur=other.couleur;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCouleur(String couleur){
        this.couleur=couleur;
    }

    public String getCouleur(){
        return this.couleur;
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

    public void setWagons(int nb){
        this.wagons=nb;
    }

    public int getWagons(){
        return this.wagons;
    }

    public void retireWagons(int nb){
        this.wagons=this.wagons-nb;
    }

    public boolean equals(Joueur j){
        if (this.nom==j.nom && this.wagons==j.wagons && this.point==j.point){
            return true;
        }else{
            return false;
        }
    }

}
