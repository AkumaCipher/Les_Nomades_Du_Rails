import java.util.*;

public class Ia {
    private Joueur ia;

    public Ia (){
        this.ia = new Joueur(new String("Ia"), new PaquetCarte(4, new String("Wagon")), new PaquetCarte(3, new String("Destination")));
    }


    public Joueur getIa() {
        return this.ia;
    }

    public void setIa(Joueur ia) {
        this.ia = ia;
    }


    public void jouer(ArrayList<Ville> list_villes) {
        Random r = new Random();
        int n;
        //Si route peut être posé
        if(true/* Condition a changé*/){
            n = 3;
        }
        //Sinon pioche une carte destination ou wagon aléatoirement 
        else{
            n = r.nextInt(3);
        }

        if (n == 1){// pioche une carte wagon

        }
        else if(n == 2){ //pioche une carte destination

        }
        else{ //construit une route

        }
    }

    private void pioche_wagon (){
        Random r = new Random();
        int n = r.nextInt(2);
    }
}
