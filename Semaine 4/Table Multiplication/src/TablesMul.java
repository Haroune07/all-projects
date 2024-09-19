public class TablesMul {
    public static void main(String[] args) throws Exception {

        for(int i = 1; i <= 10; i++){

            System.out.println("Table de " + i + "\n");

            for(int j = 1; j <= 10; j++){

                int produit = i * j;
                System.out.println("\t" + i + " x " + j + " = " + produit);

            }

            Thread.sleep(1000);
            System.out.println();
        }
    }
}
