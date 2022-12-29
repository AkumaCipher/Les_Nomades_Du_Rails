import java.util.*;

public class main {

    public static void main(String[] args){

        // Pour jouer a 2

        Plateau p = new Plateau();
        int joueur = 0;
        int tour = 0;
        Joueur j0 = new Joueur("Bob",p.get_wagon_carte(),p.get_destination_carte());
        Joueur j1 = new Joueur("John",p.get_wagon_carte(),p.get_destination_carte());


        // On demande aux joueurs quelles carte ils rendent
        if (tour==0){

            System.out.println("    --- "+j0.getNom()+" ---");
            System.out.println(j0.getCartesDestination().toString());
            System.out.println(j0.getCartesWagon().toString()+"\n");
            Scanner lecteur = new Scanner(System.in);
            System.out.println(j0.getNom()+", quelle carte destination souhaitez vous rendre ? (1,2 ou 3)");
            j0.getCartesDestination().removeCarte(Integer.parseInt(lecteur.nextLine())-1);

            System.out.println("    --- "+j1.getNom()+" ---");
            System.out.println(j1.getCartesDestination().toString());
            System.out.println(j1.getCartesWagon().toString()+"\n");
            System.out.println(j1.getNom()+", quelle carte destination souhaitez vous rendre ? (1,2 ou 3)");
            j1.getCartesDestination().removeCarte(Integer.parseInt(lecteur.nextLine())-1);

            tour+=1;
        }

        


    }           
}
