import java.util.*;

public class main {

    public static void main(String[] args){

        // Pour jouer a 2

        Plateau p = new Plateau();
        Joueur j1 = new Joueur("Bob",p.get_wagon_carte(),p.get_destination_carte());
        Joueur j2 = new Joueur("John",p.get_wagon_carte(),p.get_destination_carte());

        System.out.println("    --- Joueur 1 ---");
        System.out.println(j1.getCartesDestination().toString());
        System.out.println(j1.getCartesWagon().toString()+"\n");

        System.out.println("    --- Joueur 2 ---");
        System.out.println(j2.getCartesDestination().toString());
        System.out.println(j2.getCartesWagon().toString()+"\n");

        ArrayList<Ville> liste = new ArrayList();
        System.out.println(p.get_chemin_court("Kolg", "Qimyss",liste ));
    }           
}
