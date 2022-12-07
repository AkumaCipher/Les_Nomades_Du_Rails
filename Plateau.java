
import java.util.*;

public class Plateau {

    private ArrayList<String> nom_ville = new ArrayList(Arrays.asList("Dolk","Aillk","Kuri","Rimu","Kolg","Guine","Varass","Trarbe","Nita","Solis","Xewood","Fefield","Brosa","Erbolis","Danir","Ouaïbe","New Varass","Bafao","Sandre","Motlen","Soles","Draille","Qimyss"));                                          

    private ArrayList<Ville> list_ville = new ArrayList<Ville>();
    private PaquetCarte wagon_carte ;
    private PaquetCarte destination_carte ;

    public Plateau(){
        for (int i=0;i<this.nom_ville.size();i++){
            list_ville.add(new Ville(this.nom_ville.get(i)));
        }
        this.wagon_carte = new PaquetCarte("Wagon");
        this.destination_carte = new PaquetCarte("Destination");
    }

    public ArrayList<Ville> get_ville(){
        return this.list_ville;
    }

    public PaquetCarte get_wagon_carte(){
        return this.wagon_carte;
    }
    public PaquetCarte get_destination_carte(){
        return this.destination_carte;
    }

}
