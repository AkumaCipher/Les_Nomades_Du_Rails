public class DestinationCarte {
    private Ville[] villeDestination = new Ville[2];
    private int point;
    protected String type = new String("Destination");

    public DestinationCarte(){
        this.villeDestination[0] = new Ville();
        this.villeDestination[1] = new Ville();
    }
    
    public DestinationCarte(Ville[] villeDestination, int point){
        this.villeDestination = villeDestination;
        this.point = point;
    }

    public DestinationCarte(Ville destination1, Ville destination2, int point){
        this.villeDestination[0] = destination1;
        this.villeDestination[1] = destination2;
        this.point = point;
    }

    public DestinationCarte(DestinationCarte other){
        this.villeDestination = other.getVilleDestination();
        this.point = other.getPoint();
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
}
