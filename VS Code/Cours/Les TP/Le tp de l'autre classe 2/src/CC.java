public class CC extends Boisson{
    public CC(String taille, int nombre){
        super(taille, nombre);
        this.nom = "Chocolat chaud";
        calculerPrix(2.75, 3.75, 4.25);
    }
}
