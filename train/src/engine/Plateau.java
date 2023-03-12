package engine;
import java.util.*;

public class Plateau {

    /**
     * Attribut : les noms des villes
     */
    private ArrayList<String> nom_ville = new ArrayList(Arrays.asList("Dolk","Aillk","Kuri","Rimu","Kolg","Guine","Varass","Trarbe","Nita","Solis","Xewood","Fefield","Brosa","Erbolis","Danir","Ouaïbe","Virusse","Bafao","Sandre","Motlen","Soles","Draille","Qimyss"));                                          
    /**
     * Attribut : liste des villes
     */
    private ArrayList<Ville> list_ville = new ArrayList<Ville>();
    /**
     * Attribut : liste des routes
     */
    private ArrayList<Route> list_route= new ArrayList<Route>();
    /**
     * Attribut : paquet de carte wagon
     */
    private PaquetCarte wagon_carte ;
    /**
     * Attribut : paquet de carte destination
     */
    private PaquetCarte destination_carte ;
    /**
     * Attribut : paquet de carte des wagons face révélés
     */
    private PaquetCarte wagon_face ;

    /**
     * Constructeur par défaut
     */
    public Plateau(){
        for (int i=0;i<this.nom_ville.size();i++){
            list_ville.add(new Ville(this.nom_ville.get(i)));
        }

        // Definition des routes 
        list_route.add(new Route(3,list_ville.get(22),list_ville.get(20),"rouge"));
        list_route.add(new Route(3,list_ville.get(22),list_ville.get(21),"bleu"));
        list_route.add(new Route(1,list_ville.get(20),list_ville.get(21),"violet"));
        list_route.add(new Route(3,list_ville.get(20),list_ville.get(12),"noire"));
        list_route.add(new Route(4,list_ville.get(19),list_ville.get(21),"orange"));
        list_route.add(new Route(2,list_ville.get(18),list_ville.get(21),"vert"));
        list_route.add(new Route(4,list_ville.get(19),list_ville.get(18),"noire"));
        list_route.add(new Route(4,list_ville.get(18),list_ville.get(17),"blanc"));
        list_route.add(new Route(1,list_ville.get(19),list_ville.get(13),"blanc"));
        list_route.add(new Route(1,list_ville.get(19),list_ville.get(11),"jaune"));

        list_route.add(new Route(3,list_ville.get(11),list_ville.get(12),"rouge"));
        list_route.add(new Route(4,list_ville.get(3),list_ville.get(12),"blanc"));
        list_route.add(new Route(3,list_ville.get(3),list_ville.get(11),"vert"));
        list_route.add(new Route(2,list_ville.get(11),list_ville.get(10),"bleu"));
        list_route.add(new Route(1,list_ville.get(10),list_ville.get(13),"rouge"));
        list_route.add(new Route(2,list_ville.get(13),list_ville.get(9),"vert"));
        list_route.add(new Route(2,list_ville.get(13),list_ville.get(16),"orange"));
        list_route.add(new Route(2,list_ville.get(17),list_ville.get(16),"bleu"));
        list_route.add(new Route(3,list_ville.get(3),list_ville.get(1),"violet"));
        list_route.add(new Route(4,list_ville.get(3),list_ville.get(2),"jaune"));

        list_route.add(new Route(3,list_ville.get(10),list_ville.get(2),"violet"));
        list_route.add(new Route(2,list_ville.get(2),list_ville.get(1),"noire"));
        list_route.add(new Route(2,list_ville.get(15),list_ville.get(16),"jaune"));
        list_route.add(new Route(2,list_ville.get(16),list_ville.get(9),"violet"));
        list_route.add(new Route(4,list_ville.get(17),list_ville.get(14),"vert"));
        list_route.add(new Route(2,list_ville.get(14),list_ville.get(15),"noire"));
        list_route.add(new Route(2,list_ville.get(9),list_ville.get(7),"jaune"));
        list_route.add(new Route(3,list_ville.get(0),list_ville.get(1),"orange"));
        list_route.add(new Route(2,list_ville.get(0),list_ville.get(2),"vert"));
        list_route.add(new Route(3,list_ville.get(2),list_ville.get(7),"orange"));

        list_route.add(new Route(3,list_ville.get(7),list_ville.get(4),"rouge"));
        list_route.add(new Route(3,list_ville.get(4),list_ville.get(0),"bleu"));
        list_route.add(new Route(2,list_ville.get(4),list_ville.get(5),"jaune"));
        list_route.add(new Route(1,list_ville.get(5),list_ville.get(6),"vert"));
        list_route.add(new Route(2,list_ville.get(6),list_ville.get(7),"blanc"));
        list_route.add(new Route(2,list_ville.get(6),list_ville.get(8),"rouge"));
        list_route.add(new Route(2,list_ville.get(8),list_ville.get(15),"bleu"));
        list_route.add(new Route(3,list_ville.get(7),list_ville.get(8),"violet"));


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

        this.wagon_carte = new PaquetCarte("Wagon",this);
        this.destination_carte = new PaquetCarte("Destination",this);
        // Calcul des points de la carte
        for (Carte element:this.get_destination_carte().getPaquet()){
            int i =this.get_index_ville(element.getDepart());
            int i2 =this.get_index_ville(element.getArrive());
            String points =this.dijkstra(this.get_ville().get(i), this.get_ville().get(i2))[0]+"";
            element.setPoint(Integer.parseInt(points));
        }

        this.wagon_face= new PaquetCarte(5, new String("Wagon"));
        this.wagon_face.pioche(5, this.wagon_carte);
        this.checkNbJoker();
    }

    /**
     * Getter de la liste de ville
     * @return
     */
    public ArrayList<Ville> get_ville(){
        return this.list_ville;
    }

    /**
     * Getter de la liste de route
     * @return
     */
    public ArrayList<Route> get_route(){
        return this.list_route;
    }

    /**
     * Getter des carte wagons
     * @return
     */
    public PaquetCarte get_wagon_carte(){
        return this.wagon_carte;
    }

    /**
     * Getter des carte destination
     * @return
     */
    public PaquetCarte get_destination_carte(){
        return this.destination_carte;
    }
    /**
     * Getter des carte wagon révélés
     * @return
     */
    public PaquetCarte get_wagon_face(){
        return this.wagon_face;
    }

    /**
     * Getter de l'index d'une ville
     * @param ville
     * @return
     */
    public int get_index_ville(String ville){
        for (int i=0;i<nom_ville.size();i++){
            if (nom_ville.get(i)==(ville)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Verifie la presence d'une ville dans une liste
     * @param ville
     * @param liste
     * @return
     */
    public Boolean parcouru (Object ville , ArrayList<Ville> liste){
        for (int i=0; i<liste.size();i++){
            if (ville.equals(liste.get(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * Affichage to String
     * @param tab
     */
    public void tabString (ArrayList<Ville> tab){
        String chaine = "[ ";
        for (int i=0;i<tab.size();i++){
            // System.out.println(tab.get(i));
            chaine += tab.get(i)+", ";
        } 
        chaine+="]";
        // System.out.println(chaine);
    }

    /**
     * Enleve une carte des face révélés
     * @param indice
     */
    public void removeCarteFace(int indice){
        this.get_wagon_face().getPaquet().remove(indice);
    }

    /**
     * Verifie le nombre de joker sur les cartes révélés
     */
    public void checkNbJoker(){
        while(this.get_wagon_face().nbcarte("joker",this.get_wagon_face())>=3){
            this.wagon_face.getPaquet().clear();
            this.wagon_face.pioche(5, this.wagon_carte);
        }
    }

    /**
     * Donne l'index d'une Ville
     * @param source
     * @return
     */
    public int getIndexVille(Ville source){
        for (int i=0;i< this.list_ville.size();i++){
            if (this.list_ville.get(i).getName().equals(source.getName())){
                return i;
            }
        }
        return 0;
    }

    /**
     * Donne l'index de la ville avec la distance la plus courte (dijkstra)
     * @param tab
     * @param Q
     * @return
     */
    public int indexDistMini(int tab[],ArrayList<Ville> Q){
        int min = Integer.MAX_VALUE;
        int index=0;
        for (int i =0;i<this.list_ville.size();i++){
            if (tab[i]< min && Q.contains(this.list_ville.get(i))){
                index =i;
                min=tab[i];
            }
        }
        return index;
    }

    /**
     * Algorithme de dijkstra donnant le chemin le plus court entre 2 point
     * @param depart
     * @param arrivé
     * @return
     */
    public Object[] dijkstra(Ville depart,Ville arrivé){
        ArrayList<Ville> Q = new ArrayList<>();
        int dist[] = new int[this.list_ville.size()];
        Ville prev[] = new Ville[this.list_ville.size()];

        for (int i=0;i< this.list_ville.size();i++){
            dist[i]= 1000;
            prev[i]= null;
            Q.add(this.list_ville.get(i));
        }

        dist[this.getIndexVille(depart)]=0;

        while (Q.size()!=0){
            Ville now =this.list_ville.get(this.indexDistMini(dist,Q));
            int index = this.indexDistMini(dist,Q);
            Q.remove(now);
    
            // Parcours des voisins
            for (Map.Entry<Ville,Integer> voisin: now.getVoisins().entrySet()){
                    int alt = dist[index] + voisin.getValue();
                    int v = this.getIndexVille(voisin.getKey());
                    if (alt<dist[v]){
                        dist[v] = alt;
                        prev[v] = now;
                    }
                
            }
        }

        // Reconstitution du chemin
        ArrayList<Ville> chemin = new ArrayList<>();
        chemin.add(arrivé);
        int j=this.getIndexVille(arrivé);
        while (prev[j].equals(depart)==false){
            chemin.add(prev[j]);
            j=this.getIndexVille(prev[j]);
        }
        chemin.add(depart);
        return new Object[] {dist[this.getIndexVille(arrivé)],chemin};
        
    }   

    public Route getOneRoute(Ville depart, Ville arrive){
        for (Route route: this.list_route){
            if ((route.getDestination()[0].equals(depart) && route.getDestination()[1].equals(arrive)) || (route.getDestination()[1].equals(depart) && route.getDestination()[0].equals(arrive))){
                return route;
            }
        }
        return new Route();
    }

    
}
