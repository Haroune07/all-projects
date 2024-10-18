
public class App {
    public static void main(String[] args) throws Exception {
        
        
        System.out.println(returnCountry(2, 2, 2, 2));
        
    }

    public static String returnCountry(int x0, int y0, int x, int y){

        StringBuilder sb = new StringBuilder("");

        if (y > y0) {
            sb.append('N');
        }else if(y < y0){
            sb.append('S');
        }if(x > x0){
            sb.append('E');
        }else if(x > x0){
            sb.append('O');
        }

        if (sb.toString().isBlank()) {
            return "Center";
        }

        return sb.toString();

    }


}
