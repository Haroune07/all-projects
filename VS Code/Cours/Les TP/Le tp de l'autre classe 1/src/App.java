import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        int[] valeursSouches = { 10, 7, 13, 24 };
        int rawKey = 0;

        for (int i : valeursSouches) {
            int somme0_149 = 0;
            for (int j = 0; j < 150; j++) {
                if (j % i == 0) {
                    somme0_149 += j;
                }
            }
            rawKey += somme0_149 * i;
        }

        System.out.println(rawKey);

        int ASCIISum = 0;

        for (char c : String.valueOf(rawKey).toCharArray()) {
            ASCIISum += c;
        }

        char[] sumChar = String.valueOf(ASCIISum).toCharArray();
        int finalKey = Character.getNumericValue(sumChar[sumChar.length - 1]);

        System.out.println(ASCIISum);
        System.out.println(finalKey);

        String message = "HAODE>K  QTMQE @EO=EAJP MQ=J@APLKQNMQK EKJPPKQO@E O L=NQ*EH JANAO  PALHQO=Q FKQN@―DQE  MQA?AQ TMQE@EO AJPK Q*";
        String newMessage = message.replace(" ", "");

        char[] newWordCharArray = new char[newMessage.length()];

        for (int i = 0; i < newMessage.length(); i++) {
            int newDecValue = newMessage.charAt(i) + finalKey;
            newWordCharArray[i] = (char) newDecValue;
        }
        
        String decryptedMessage = String.valueOf(newWordCharArray);

        System.out.println(decryptedMessage);

        int thousand = 1000;
        int countToNeg = 0;

        for (char c : newWordCharArray) {
            switch (c) {
                case 'H' -> {
                    thousand -= 150;
                }
                case 'E' -> {
                    thousand -= 200;
                }
                default -> {
                    thousand += 5;
                }
            }
            countToNeg++;
            if (thousand < 0) {
                break;
            }
        }
        System.out.println(countToNeg);
    }
}