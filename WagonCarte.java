public class WagonCarte extends Carte {
    private String couleurWagon;
    private boolean joker;

    public WagonCarte() {
        this.couleurWagon = new String("red");
        this.joker = false;
    }

    public WagonCarte(String couleur) {
        this.couleurWagon = new String(couleur);
        this.joker = false;
    }

    public WagonCarte(String couleur, boolean joker) {
        this.couleurWagon = new String(couleur);
        this.joker = joker;
    }

    public WagonCarte(WagonCarte other) {
        this.couleurWagon = new String(other.getCouleurWagon());
        this.joker = other.isJoker();
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

}
