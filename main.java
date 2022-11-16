import java.util.*;

public class main {

    public static void main(String[] args){

        Plateau plat = new Plateau();
        
        ArrayList<Ville> ville = plat.get_ville();
        ArrayList<Carte> carte = plat.get_wagon_carte();

        for (int i=0;i<carte.size();i++){
            System.out.println(carte.get(i).getType());
        }
    }           
}
