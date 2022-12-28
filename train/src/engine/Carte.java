package engine;
public abstract class Carte {
    protected String type;
    
    public String getType() {
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public abstract String getLink();
    
}
