package engine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe d'une Ville
 */
public class Ville {

    /**
     * Attribut : nom
     */
    private String name;
    /**
     * Attribut : liste de voisins
     */
    private Map<Ville, Integer> voisins;

    /**
     * Constructeur par défaut
     */
    public Ville() {
        this.voisins = new HashMap<>();
        this.name = "defaut";
    }

    /**
     * Constructeur par nom
     * @param nom
     */
    public Ville(String nom) {
        this.voisins = new HashMap<>();
        this.name = nom;
    }

    /**
     * Constructeur global
     * @param nom
     * @param voisin
     * @param distance
     */
    public Ville(String nom, Ville voisin, int distance) {
        this.name = nom;
        this.voisins = new HashMap<>();
        this.voisins.put(voisin, distance);
    }

    /**
     * Methode to String
     */
    public String toString(){
        return this.name;
    }

    /**
     * Setter d'un voisin
     * @param voisin
     * @param distance
     */
    public void setVoisin(Ville voisin, int distance) {
        this.voisins.put(voisin, distance);
    }

    /**
     * Getter des voisins
     * @return
     */
    public Map<Ville, Integer> getVoisins() {
        return this.voisins;
    }

    /**
     * Getter du nom
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter du nom
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Verifie la presence d'une ville dans les voisins
     * @param v
     * @return
     */
    public boolean verifVoisin (Ville v){
        for (Map.Entry<Ville,Integer> voisins: this.getVoisins().entrySet()){
            if (voisins.getKey().equals(v)){
                return true;
            }
        }
        return false;
    }

    public Map<Ville,Integer> getVraiVoisins(Plateau p,Joueur j){
        Map<Ville, Integer> vraiVoisin = new HashMap<>(); 
        for (Map.Entry<Ville,Integer> voisin : this.voisins.entrySet()){
            if (p.getOneRoute(this,voisin.getKey()).getProprietaire()== null || p.getOneRoute(this,voisin.getKey()).getProprietaire().equals(j)){
                vraiVoisin.put(voisin.getKey(), voisin.getValue());
            }
        }
        return vraiVoisin;
    }

}