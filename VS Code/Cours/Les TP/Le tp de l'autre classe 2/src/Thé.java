public class Thé extends Boisson{
    public Thé(String taille, int nombre){
        super(taille, nombre);
        this.nom = "Thé";
        calculerPrix(2.0, 3.0, 3.5);
    }
}
