package engine;
import java.util.ArrayList;

public class DestinationCarte extends Carte {
    protected Ville[] villeDestination = new Ville[2];
    protected int point;
    protected String type = new String("Destination");

    public DestinationCarte(){
        this.villeDestination[0] = new Ville();
        this.villeDestination[1] = new Ville();
    }
    
    public DestinationCarte(Ville[] villeDestination, int point){
        this.villeDestination = villeDestination;
        this.point = point;
    }

    public DestinationCarte(Ville destination1, Ville destination2, Plateau p){
        this.villeDestination[0] = destination1;
        this.villeDestination[1] = destination2;
        this.point = p.get_chemin_court(destination1.getName(), destination2.getName(), new ArrayList<>());
    }

    public DestinationCarte(DestinationCarte other){
        this.villeDestination = other.getVilleDestination();
        this.point = other.getPoint();
    }

    public String toString(){
        return this.type+" : "+this.villeDestination[0]+" -> "+this.villeDestination[1]+" = "+this.point+" points" ;
    }

    public Ville[] getVilleDestination() {
        return this.villeDestination;
    }

    public void setVilleDestination(Ville[] villeDestination) {
        this.villeDestination = villeDestination;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getType(){
        return this.type;
    }

    public String getLink(){
        return "error";
    }

    public String getCouleur(){
        return "error";
    }
}
