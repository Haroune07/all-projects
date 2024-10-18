public class CarréDeNombres {
    public static void main(String[] args) throws Exception {
        int x = 10;
        int y = 10;

        int firstnum = 0;

        for(int i = 0; i < y; i++){


            for(int j = firstnum; j < (x + firstnum); j++){

                if (j < 10) {
                    System.out.print("00" + j + " ");
                }
                else if(j < 100){
                    System.out.print("0" + j + " ");
                }

                else{
                    System.out.print(j + " ");
                }
                
            }

            firstnum += x;
            System.out.println();
        }
    }
}
