
import java.util.*;

public class Plateau {

    private ArrayList<String> nom_ville = new ArrayList(Arrays.asList("Atlanta", "Boston", "Calgary", "Charleston","Chicago", "Dallas", "Denver","Duluth", "El Paso", "Helena", "Houston", "Kansas City", "Las Vegas", "Little Rock", "Los Angeles","Miami", "Montreal", "Nashville", "New Orleans", "New York", "Oklahoma City", "Omaha","Phoenix", "Pittsburgh", "Portland", "Raleigh", "Saint Louis", "San Francisco", "Santa Fe", "Sault St Marie", "Seattle", "Vancouver", "Washington", "Winnipeg" ));                                           


    private ArrayList<Ville> list_ville = new ArrayList<Ville>();


    public Plateau(){
        for (int i=0;i<this.nom_ville.size();i++){
            list_ville.add(new Ville(this.nom_ville.get(i)));
        }
    }

    public ArrayList<Ville> get_ville(){
        return this.list_ville;
    }

}
