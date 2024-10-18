
public class CpuGuessNum {
    public static void main(String[] args) throws InterruptedException {
        long min = 0;
        long max = 1000000000000l;

        long randNum = (long) (Math.random() * (max-min));

        long guess = (max+min) / 2;

        long steps = 0;

        while (randNum != guess) {
            
            if (guess > randNum) {
                max = guess;
            }

            else if (guess < randNum) {
                min = guess;
            }

            if (guess > randNum) {
                Thread.sleep(250);
                System.out.println("plus petit");
            }

            if (guess < randNum) {
                Thread.sleep(250);
                System.out.println("plus grand");
            }

            guess = (max + min) / 2;

            steps ++;
        }

        System.out.println("correct");
        System.out.println(steps);

    }
}
