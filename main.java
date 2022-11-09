import java.util.*;

public class main {

    public static void main(String[] args){

        Plateau plat = new Plateau();
        
        ArrayList<Ville> ville = plat.get_ville();

        for (int i=0;i<ville.size();i++){
            System.out.println(ville.get(i).getName());
        }
    } 
}
