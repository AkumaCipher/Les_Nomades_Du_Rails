package engine;

/**
 * Classe qui definit une Carte 
 */
public abstract class Carte {
    /**
     * Attribut type de la carte
     */
    protected String type;
    
    /**
     * Donne le type de la carte
     * @return une chaine de caractère du type
     */
    public String getType() {
        return type;
    }

    /**
     * Definit le type de la carte
     */
    public void setType(String type){
        this.type = type;
    }

    /**
     * Methode abstraite qui donne le lien de la carte
     * @return le lien de l'image correspondant a la carte
     */
    public abstract String getLink();

    /**
     * Donne la couleur pour les carte Wagon
     * @return la couleur de la carte
     */
    public abstract String getCouleur();

    /**
     * Donne le depart pour les carte Destination
     * @return le nom de la Ville de depart
     */
    public abstract String getDepart();

    /**
     * Donne l'arrivé pour les carte Destination
     * @return le nom de la Ville d'arrivée
     */
    public abstract String getArrive();

    /**
     * Donne les villes d'une carte Destination
     * @return un tableau de 2 Ville
     */
    public abstract Ville[] getVilleDestination();

    
    
}
