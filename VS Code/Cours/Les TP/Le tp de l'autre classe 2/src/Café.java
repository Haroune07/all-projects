public class Café extends Boisson{
    
    public Café(String taille, int nombre){
        super(taille, nombre);
        this.nom = "café";
        calculerPrix(2.5, 3.5, 4);
    }
}
