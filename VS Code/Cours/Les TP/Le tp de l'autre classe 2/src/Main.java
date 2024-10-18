import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<Integer, List<Boisson>> commandes = new HashMap<>();
        Scanner clavier = new Scanner(System.in);

        ///////////////////////////

        printMenu();

        int idCommande = 1;

        int choix = 0;

        while (choix != 3) {
            choix = clavier.nextInt();
            clavier.nextLine();

            switch (choix) {
                case 1 -> {
                    boolean terminer = false;

                    List<Boisson> élémentsDeCommande = new ArrayList<>();
                    commandes.put(idCommande, élémentsDeCommande);

                    idCommande++;

                    while (!terminer) {
                        System.out.println("Type de boisson : (C)afé, (T)hé, (H)Chocolat chaud : ");
                        String nom = clavier.nextLine().toLowerCase();

                        System.out.println("Entrez la quantité");
                        int nombre = clavier.nextInt();
                        clavier.nextLine();

                        System.out.println("Entrez la taille : petit, moyen ou grand");
                        String taille = clavier.nextLine();

                        if (!nom.equals("c") && !nom.equals("t") && !nom.equals("h")) {
                            System.out.println("Boisson invalide, réessayez.");
                            continue;
                        }

                        Boisson boisson = null;

                        switch (nom) {
                            case "c" -> {
                                boisson = new Café(taille, nombre);
                            }
                            case "t" -> {
                                boisson = new Thé(taille, nombre);
                            }
                            case "h" -> {
                                boisson = new CC(taille, nombre);
                            }
                        }

                        boolean found = false;

                        for (Boisson b : élémentsDeCommande) {
                            if (b.getClass() == boisson.getClass() && b.getTaille().equals(taille)) {
                                found = true;
                                b.ajouter(nombre);
                                break;
                            }
                        }

                        if (!found) {
                            élémentsDeCommande.add(boisson);
                        }

                        System.out.println("Voulez vous continuer à ajouter des boissons? oui/non");

                        String continuer = clavier.nextLine();
                        if (continuer.equals("non")) {
                            terminer = true;
                        }
                    }
                }
                case 2 -> {

                    int totalJournée = 0;
                    
                    for(Map.Entry<Integer, List<Boisson>> entry : commandes.entrySet()){
                        System.out.println("Commande " + entry.getKey() + ":");

                        for(Boisson b : entry.getValue()){
                            System.out.print(b.toString() + ", ");
                        }

                        int totalParCommande = 0;

                        for(Boisson b : entry.getValue()){
                            totalParCommande += b.getPrix();
                            totalJournée += b.getPrix();
                        }

                        System.out.println("Total : " + totalParCommande + '$');
                    }

                    System.out.println("Total de la journée: " + totalJournée);
                    
                }
                case 3 -> {
                    System.out.println("Au revoir!");
                }
                default -> {
                    System.out.println("Erreur, veuillez entrer un nombre valide.");
                }
            }
            
            printMenu();
        }

        clavier.close();
    }

    public static void printMenu() {
        String line = "*********************";
        String menu = "Menu";
        int spaceCount = line.length() - menu.length() % 2 == 0 ? (line.length() - menu.length()) / 2
                : (line.length() - menu.length() - 1) / 2;
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < spaceCount; i++) {
            spaces.append(' ');
        }
        System.out.println(line);
        System.out.println(spaces.toString().concat(menu));
        System.out.println(line);
        System.out.println("1. Prendre une commande");
        System.out.println("2. Consulter les ventes");
        System.out.println("3. Quitter");
    }
}
