public class Animal {
	    private final String name;
	    private final String species;
	    private float weight;
	    private int visitors;
	
	    public Animal(String name, String species, Float weight){
	        this.name = name;
	        this.species = species;
	        this.weight = weight;
	        this.visitors = 0;
	    }
	
	    public String getName(){
	        return name;
	    }
	
	    public String getSpecies(){
	        return species;
	    }
	
	    public Float getWeight(){
	        return weight;
	    }
	
	    public int getVisitors(){
	        return visitors;
	    }
	
	    public void  modifierPoidsAnimal(Float weight){
	        this.weight = weight;
	    }
	
	    public void addVisitors(int number){
	        this.visitors += number;
	    }
	
	    @Override
	    public String toString(){
	        return name + ", " + species + ", " + weight + " kg";
	    }
	
	    public String toFileString(){
	        return name + " && " + species + " && " + weight + "\n";
	    }
	
	}
