import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Zoo{
	
	    private final File file = new File("src\\saveFile.txt");
	
	    private final Map<String, Animal> map = new HashMap<>();
	
	    public Zoo(){
	        load();
	    }
	
	    public void ajouterNouvelAnimal(Animal animal){
	        map.put(animal.getName(), animal);
	    }
	
	    public Animal get(String name){
	        for (Animal animal : map.values()){
	            if (animal.getName().equalsIgnoreCase(name)){
	                return animal;
	            }
	        }
	        return null;
	    }
	
	    public int calculerTotalVisiteursZoo(){
	        int compte = 0;
	
	        for (Animal animal : map.values()){
	            compte += animal.getVisitors();
	        }
	        return compte;
	    }
	
	    public float calculerPoidsMoyenAnimaux(){
	        float masseTotale = 0;
	
	        for (Animal animal : map.values()){
	            masseTotale += animal.getWeight();
	        }
	
	        return masseTotale / map.size();
	    }
	
	    public Animal[] trouverAnimauxExtremes(){
	
	        Animal lourd = null;
	        Animal leger = null;
	
	        for (Animal a : map.values()){
	
	            if (leger == null || leger.getWeight() < a.getWeight()){
	                leger = a;
	            }
	
	            if (lourd == null || lourd.getWeight() > a.getWeight()){
	                lourd = a;
	            }
	        }
	
	        return new Animal[] {leger, lourd};
	
	    }
	
	    public void afficherResumeCompletZoo(){
	
	        System.out.println("Résumé complet du zoo:\n");
	
	        System.out.println("Nombre total des visiteurs du zoo: " + calculerTotalVisiteursZoo() + "\n");
	
	        System.out.println("Liste complète des animaux:\n");
	        afficherListeAnimaux();
	
	        System.out.println("\nLa masse moyenne des animaux du zoo est de: " + calculerPoidsMoyenAnimaux() + "kg");
	
	        System.out.println("\nL'animal le plus léger:");
	        System.out.println(trouverAnimauxExtremes()[0]);
	
	        System.out.println("\nL'animal le plus lourd:");
	        System.out.println(trouverAnimauxExtremes()[1]);
	
	    }
	
	    public boolean contient(String nom){
	
	        for(Animal animal : map.values()){
	            if(animal.getName().equalsIgnoreCase(nom)){
	                return true;
	            }
	        }
	
	        return false;
	    }
	
	    public void save(){
	        try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	
	            for (Animal animal : map.values()) {
	                writer.write(animal.toFileString());
	            }
	
	            writer.close();
	
	            System.out.println("Saved");
	
	        } catch (IOException e) {
	            System.out.println("File not found.");
	        }
	    }
	
	    private void load(){
	        try {
	            Scanner scanner = new Scanner(file);
	
	            while (scanner.hasNextLine()) {
	
	                String line = scanner.nextLine();
	
	                if (!line.isEmpty()) {
	                    String[] split = line.split(" && ");
	
	                    Animal animal = new Animal(split[0], split[1], Float.parseFloat(split[2]));
	
	                    ajouterNouvelAnimal(animal);
	                }
	                
	                scanner.close();
	
	            }
	
	        }catch (FileNotFoundException e) {
	            System.out.println("File not found.");
	        }
	    }
	
	    public void afficherListeAnimaux(){
	        for (Animal animal : map.values()) {
	            System.out.println(animal);
	        }
	    }
	
	    public void showInstructions(){
	        System.out.println("\n1. -> Ajouter un nouvel animal");
	        System.out.println("2. -> Afficher la liste des animaux et leurs informations");
	        System.out.println("3. -> Vérifier si un animal est dans le zoo");
	        System.out.println("4. -> Modifier le poids d’un animal");
	        System.out.println("5. -> Ajouter des visiteurs pour une journée");
	        System.out.println("6. -> Afficher le nombre total de visiteurs");
	        System.out.println("7. -> Afficher le poids moyen des animaux");
	        System.out.println("8. -> Trouver l’animal le plus lourd et le plus léger");
	        System.out.println("9. -> Afficher un résumé complet du zoo (visiteurs et animaux)");
	        System.out.println("10. -> Quitter le programme");
	
	    }
	
	    public void rechercherAnimal(String prefix){
	
	        List<Animal> list = new ArrayList<>();
	
	        for (Animal animal : map.values()) {
	
	            if (animal.getName().equalsIgnoreCase(prefix)) {
	                System.out.println(animal);
	                return;
	            }
	
	            if (animal.getName().startsWith(prefix) || animal.getSpecies().startsWith(prefix)) {
	                list.add(animal);
	            }
	        }
	
	        for (Animal animal : list) {
	            System.out.println(animal);
	        }
	
	        if(list.isEmpty()){
	            System.out.println("Aucun animal trouvé...");
	        }
	
	    }
	
	}

