public class MaxMinTableau {
    public static void main(String[] args) throws Exception {
        int[] array = { 15, 28, -5, 42, 9, 0 };

        int max = array[0];
        int min = array[0];

        for(int i = 0; i < array.length; i++){
            
            max = Math.max(max, array[i]);

            min = Math.min(min, array[i]);
        }

        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }
}