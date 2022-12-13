
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
        
        // Definition des liaisons entre les villes 
        list_ville.get(0).setVoisin(list_ville.get(1), 3);
        list_ville.get(0).setVoisin(list_ville.get(2), 2);
        list_ville.get(0).setVoisin(list_ville.get(4), 3);

        list_ville.get(1).setVoisin(list_ville.get(0), 3);
        list_ville.get(1).setVoisin(list_ville.get(2), 2);
        list_ville.get(1).setVoisin(list_ville.get(3), 3);

        list_ville.get(2).setVoisin(list_ville.get(0), 2);
        list_ville.get(2).setVoisin(list_ville.get(1), 2);
        list_ville.get(2).setVoisin(list_ville.get(3), 4);
        list_ville.get(2).setVoisin(list_ville.get(7), 3);
        list_ville.get(2).setVoisin(list_ville.get(10), 3);
        
        list_ville.get(3).setVoisin(list_ville.get(1), 3);
        list_ville.get(3).setVoisin(list_ville.get(2), 4);
        list_ville.get(3).setVoisin(list_ville.get(11), 3);
        list_ville.get(3).setVoisin(list_ville.get(12), 4);

        list_ville.get(4).setVoisin(list_ville.get(0), 3);
        list_ville.get(4).setVoisin(list_ville.get(7), 3);
        list_ville.get(4).setVoisin(list_ville.get(5), 2);

        list_ville.get(5).setVoisin(list_ville.get(4), 2);
        list_ville.get(5).setVoisin(list_ville.get(6), 1);

        list_ville.get(6).setVoisin(list_ville.get(5), 1);
        list_ville.get(6).setVoisin(list_ville.get(7), 2);
        list_ville.get(6).setVoisin(list_ville.get(8), 2);

        list_ville.get(7).setVoisin(list_ville.get(2), 3);
        list_ville.get(7).setVoisin(list_ville.get(4), 3);
        list_ville.get(7).setVoisin(list_ville.get(6), 2);
        list_ville.get(7).setVoisin(list_ville.get(8), 3);
        list_ville.get(7).setVoisin(list_ville.get(9), 2);

        list_ville.get(8).setVoisin(list_ville.get(6), 2);
        list_ville.get(8).setVoisin(list_ville.get(7), 3);
        list_ville.get(8).setVoisin(list_ville.get(15), 2);

        list_ville.get(9).setVoisin(list_ville.get(7), 2);
        list_ville.get(9).setVoisin(list_ville.get(13), 2);
        list_ville.get(9).setVoisin(list_ville.get(16), 2);

        list_ville.get(10).setVoisin(list_ville.get(2), 3);
        list_ville.get(10).setVoisin(list_ville.get(11), 2);
        list_ville.get(10).setVoisin(list_ville.get(13), 1);

        list_ville.get(11).setVoisin(list_ville.get(3), 3);
        list_ville.get(11).setVoisin(list_ville.get(10), 2);
        list_ville.get(11).setVoisin(list_ville.get(12), 3);
        list_ville.get(11).setVoisin(list_ville.get(19), 1);

        list_ville.get(12).setVoisin(list_ville.get(3), 4);
        list_ville.get(12).setVoisin(list_ville.get(11), 3);
        list_ville.get(12).setVoisin(list_ville.get(20), 3);

        list_ville.get(13).setVoisin(list_ville.get(9), 2);
        list_ville.get(13).setVoisin(list_ville.get(10), 1);
        list_ville.get(13).setVoisin(list_ville.get(16), 2);
        list_ville.get(13).setVoisin(list_ville.get(19), 1);

        list_ville.get(14).setVoisin(list_ville.get(15), 2);
        list_ville.get(14).setVoisin(list_ville.get(17), 4);

        list_ville.get(15).setVoisin(list_ville.get(8), 2);
        list_ville.get(15).setVoisin(list_ville.get(14), 2);
        list_ville.get(15).setVoisin(list_ville.get(16), 2);

        list_ville.get(16).setVoisin(list_ville.get(9), 2);
        list_ville.get(16).setVoisin(list_ville.get(13), 2);
        list_ville.get(16).setVoisin(list_ville.get(15), 2);
        list_ville.get(16).setVoisin(list_ville.get(17), 2);

        list_ville.get(17).setVoisin(list_ville.get(14), 4);
        list_ville.get(17).setVoisin(list_ville.get(16), 2);
        list_ville.get(17).setVoisin(list_ville.get(18), 4);

        list_ville.get(18).setVoisin(list_ville.get(17), 4);
        list_ville.get(18).setVoisin(list_ville.get(19), 4);
        list_ville.get(18).setVoisin(list_ville.get(21), 2);

        list_ville.get(19).setVoisin(list_ville.get(11), 1);
        list_ville.get(19).setVoisin(list_ville.get(13), 1);
        list_ville.get(19).setVoisin(list_ville.get(18), 4);
        list_ville.get(19).setVoisin(list_ville.get(21), 4);

        list_ville.get(20).setVoisin(list_ville.get(12), 3);
        list_ville.get(20).setVoisin(list_ville.get(21), 1);
        list_ville.get(20).setVoisin(list_ville.get(22), 3);

        list_ville.get(21).setVoisin(list_ville.get(18), 4);
        list_ville.get(21).setVoisin(list_ville.get(19), 2);
        list_ville.get(21).setVoisin(list_ville.get(20), 1);
        list_ville.get(21).setVoisin(list_ville.get(22), 3);

        list_ville.get(22).setVoisin(list_ville.get(20), 3);
        list_ville.get(22).setVoisin(list_ville.get(21), 3);

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
