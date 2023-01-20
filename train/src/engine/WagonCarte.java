package engine;
/**
 * Classe Carte Wagon qui hérite de Carte
 */
public class WagonCarte extends Carte {
    /**
     * Attribut : couleur du wagon
     */
    private String couleurWagon;
    /**
     * Attribut : joker
     */
    private boolean joker;
    /**
     * Attribut : type
     */
    protected String type = new String("Wagon");

    /**
     * Constructeur par défaut
     */
    public WagonCarte() {
        this.couleurWagon = new String("red");
        this.joker = false;
    }

    /**
     * Constructeur par couleur
     * @param couleur
     */
    public WagonCarte(String couleur) {
        this.couleurWagon = new String(couleur);
        this.joker = false;
    }

    /**
     * Constructeur d'un joker
     * @param joker
     */
    public WagonCarte(boolean joker) {
        this.couleurWagon = new String("joker");
        this.joker = joker;
    }

    /**
     * Constructeur par copie
     * @param other
     */
    public WagonCarte(WagonCarte other) {
        this.couleurWagon = new String(other.getCouleur());
        this.joker = other.isJoker();
    }

    /**
     * Methode to String
     */
    public String toString(){
        return this.type+" : "+this.couleurWagon+" " ;
    }

    /**
     * Getter de la couleur
     */
    public String getCouleur() {
        return this.couleurWagon;
    }

    /**
     * Setter de la couleur
     * @param couleurWagon
     */
    public void setCouleurWagon(String couleurWagon) {
        this.couleurWagon = couleurWagon;
    }

    /**
     * Verification du joker
     * @return
     */
    public boolean isJoker() {
        return this.joker;
    }

    /**
     * Setter du joker
     * @param joker
     */
    public void setJoker(boolean joker) {
        this.joker = joker;
    }

    /**
     * Getter du type
     */
    public String getType(){
        return this.type;
    }

    /**
     * Getter du lien
     */
    public String getLink(){
        if (this.couleurWagon.equals("joker")){
            return ".\\wagon\\joker.png";
        }else{
            return ".\\wagon\\"+this.couleurWagon+".png";
        }
    }

    /**
     * Methode abstraite
     */
    public String getDepart(){
        return "error";
    }
    /**
     * Methode abstraite
     */
    public String getArrive(){
        return "error";
    }

    /**
     * Methode abstraite
     */
    @Override
    public Ville[] getVilleDestination() {
        return null;
        
    }
}
