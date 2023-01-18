package engine;

public class main {
    public static void main(String[] args) {
        Plateau p =  new Plateau();
        System.out.println(p.dijkstra(p.get_ville().get(22), p.get_ville().get(0)));
        p.getIndexVille(p.get_ville().get(11));
    }
}
