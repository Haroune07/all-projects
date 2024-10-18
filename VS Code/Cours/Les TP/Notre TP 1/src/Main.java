
import java.util.Scanner;

public class Main {

    

    public static void main(String[] args) {

        Zoo zoo = new Zoo();
        Scanner scanner = new Scanner(System.in);

        int choix = -1;

        System.out.println("Bienvenue au zoo!");
        System.out.println("tapez 0 pour les instructions.");

        while (choix != 10) {

            System.out.print("\nChoisissez une option: ");

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {

                case 0 -> {
                    zoo.showInstructions();
                }

                case 1 -> {

                    System.out.println("Entrez le nom de l'animal");
                    String nom = scanner.nextLine();

                    System.out.println("Entrez son espèce");
                    String species = scanner.nextLine();

                    System.out.println("Entrez sa masse");
                    float mass = scanner.nextFloat();

                    Animal animal = new Animal(nom, species, mass);

                    zoo.ajouterNouvelAnimal(animal);

                    System.out.println("Animal ajouté avec succès!");

                }
                case 2 -> {
                    zoo.afficherListeAnimaux();
                }
                case 3 -> {
                    System.out.println("Entrez le nom de l'animal que vous souhaitez chercher:");
                    String nom = scanner.nextLine();

                    zoo.rechercherAnimal(nom);

                }
                case 4 -> {

                    System.out.println("Entrez le nom de l'animal dont vous souhaitez modifier la masse");
                    String nom = scanner.nextLine();

                    if (zoo.contient(nom)) {

                        Float mass = Float.parseFloat(scanner.nextLine());

                        zoo.get(nom).modifierPoidsAnimal(mass);

                        System.out.println("Masse modifiée avec succès!");
                    } else {
                        System.out.println("Animal introuvable");
                    }

                }
                case 5 -> {

                    System.out.println("Entrez le nom de l'animal dont vous souhaitez ajouter des visiteurs");

                    String nom = scanner.nextLine();
                    if (zoo.contient(nom)) {
                        int visitors = scanner.nextInt();

                        zoo.get(nom).addVisitors(visitors);

                        int total = zoo.get(nom).getVisitors();

                        switch (visitors) {
                            case 0 -> {
                                System.out.println("Aucun visiteur ajouté");
                                System.out.println("Total des visiteurs pour cet animal : " + total);
                            }
                            case 1 -> {
                                System.out.println("Un visiteur ajouté");
                                System.out.println("Total des visiteurs pour cet animal : " + total);
                            }
                            default -> {
                                System.out.println(visitors + " visiteurs ajoutés");
                                System.out.println("Total des visiteurs pour cet animal : " + total);
                            }
                        }
                    } else {
                        System.out.println("Animal introuvable");
                    }

                }
                case 6 -> {
                    System.out.println("Le total des visiteurs du Zoo est de " + zoo.calculerTotalVisiteursZoo());
                }
                case 7 -> {
                    System.out.println("La masse moyenne des animaux du zoo est de " + zoo.calculerPoidsMoyenAnimaux() + "kg");
                }
                case 8 -> {

                    Animal[] légerLourd = zoo.trouverAnimauxExtremes();

                    System.out.println("L'animal le plus léger:");
                    System.out.println(légerLourd[0]);

                    System.out.println("L'animal le plus lourd:");
                    System.out.println(légerLourd[1]);

                }
                case 9 -> {
                    zoo.afficherResumeCompletZoo();
                }
                case 10 -> {
                    System.out.println("Au revoir");
                }
            }

            if (choix < 0 || choix > 10) {
                System.out.println("Entrez un chiffre allant de 1 à 10");
            }
        }


        zoo.save();
        scanner.close();
    }

}