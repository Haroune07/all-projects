public class App {
    public static void main(String[] args) throws Exception {

        System.out.println(getLockDegrees(0, 0, 0, 0));

    }

    public static int getLockDegrees(int initial, int num1, int num2, int num3){

        //given initial position of a dial, the 3 code numbers respectively in order,
        //return the rotation in degrees;
        int ticks = 40;

        int degrees = 360 / ticks;

        int rotation = 0;

        if (initial <= 20) {
            rotation += initial;
        }else if (initial > 20) {
            rotation += (ticks-initial);
        }

        rotation += 2*ticks;

        rotation += ticks-num1;

        rotation += ticks + (ticks-num1);

        rotation += num2;

        if (num3 < num2) {
            rotation += (num2 - num3);
        }else if (num3 > num2) {
            rotation += num2 + (ticks-num3);
        }

        

        return rotation*degrees;

    }
}
