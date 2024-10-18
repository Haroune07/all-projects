public class Boisson {
    protected String taille;
    protected double prix;
    protected int nombre;
    protected String nom;

    public Boisson(String taille, int nombre) {
        this.taille = taille;
        this.nombre = nombre;
    }

    public void calculerPrix(double petit, double moyen, double grand) {
        switch (taille) {
            case "petit" -> this.prix = petit;
            case "moyen" -> this.prix = moyen;
            case "grand" -> this.prix = grand;
        }
        this.prix *= nombre;
    }

    public int getNombre() {
        return this.nombre;
    }

    public double getPrix() {
        return this.prix;
    }

    public void ajouter(int nombre) {
        double prixParUnité = this.prix / this.nombre;
        this.nombre += nombre;
        this.prix += nombre * prixParUnité;
    }

    public String getTaille() {
        return this.taille;
    }

    @Override
    public String toString() {
        return "{ " + this.nom + " : " + this.nombre + " , " + this.taille + " }";
    }
}
