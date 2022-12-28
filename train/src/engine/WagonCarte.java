package engine;
public class WagonCarte extends Carte {
    private String couleurWagon;
    private boolean joker;
    protected String type = new String("Wagon");

    public WagonCarte() {
        this.couleurWagon = new String("red");
        this.joker = false;
    }

    public WagonCarte(String couleur) {
        this.couleurWagon = new String(couleur);
        this.joker = false;
    }

    // Les joker n'ont pas de couleur
    public WagonCarte(boolean joker) {
        this.couleurWagon = new String("joker");
        this.joker = joker;
    }

    public WagonCarte(WagonCarte other) {
        this.couleurWagon = new String(other.getCouleurWagon());
        this.joker = other.isJoker();
    }

    public String toString(){
        return this.type+" : "+this.couleurWagon+" " ;
    }

    public String getCouleurWagon() {
        return this.couleurWagon;
    }

    public void setCouleurWagon(String couleurWagon) {
        this.couleurWagon = couleurWagon;
    }

    public boolean isJoker() {
        return this.joker;
    }

    public void setJoker(boolean joker) {
        this.joker = joker;
    }

    public String getType(){
        return this.type;
    }

    public String getLink(){
        if (this.isJoker()){
            return ".\\wagon\\joker.png";
        }else{
            return ".\\wagon\\"+this.couleurWagon+".png";
        }
    }
}
