import java.util.HashMap;
import java.util.Map;

public class Ville {

    private String name;
    private Map<Ville, Integer> voisins;

    public Ville() {
        this.voisins = new HashMap<>();
        this.name = "defaut";
    }

    public Ville(String nom) {
        this.voisins = new HashMap<>();
        this.name = nom;
    }

    public void setVoisin(Ville voisin, int distance) {
        this.voisins.put(voisin, distance);
    }

    public Map<Ville, Integer> getVoisins() {
        return this.voisins;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}