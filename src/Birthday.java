import java.util.Random;
import java.util.Scanner;
public class Birthday {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Experiment #1");
        System.out.print("Enter the no. of people: ");
        int nPeople = keyboard.nextInt();
        System.out.print("Enter the no. of repititionse: ");
        int nRep = keyboard.nextInt();
        System.out.println("Experimrnt 1");
        System.out.print("Probability Of Hits: ");
        experiment1(nPeople, nRep);
        System.out.println();

        System.out.println("Experiment #2");
        System.out.print("Enter the no. of people again: ");
        nPeople = keyboard.nextInt();
        System.out.println("Experiment 2");
        summarize(oneTrail(nPeople));
    }

    public static int[] oneTrail (int nPeople) {
        int[] theCounts = new int[365];
        Random random = new Random();
        for(int i = 1; i <= nPeople; i++) {
            int date = random.nextInt(365);
            theCounts[date]++;
        }
        return theCounts;
    }

    public static boolean hasAHit (int[] theCounts) {
        for(int i = 0; i < theCounts.length; i++) {
            if(theCounts[i] >= 2) {
                return true;
            }
        }
        return false;
    }

    public static void experiment1 (int nPeople, int nReps) {
        int hitRate = 0;
        for(int i = nReps; i > 0; i--) {
            if(hasAHit(oneTrail(nPeople))) {
                hitRate++;
            }
        }
        double ratio = (double) hitRate / nReps;
        System.out.printf("%.3f", ratio);
    }

    public static void summarize (int[] theCounts) {
        int largest = 0;
        for(int i = 0; i < theCounts.length; i++) {
            if(theCounts[i] > largest) {
                largest = theCounts[i];
            }
        }

        int[] values = new int[largest + 1];
        for(int i = 0; i < theCounts.length; i++) {
            values[theCounts[i]]++;
        }

        for(int i = 0; i <= largest; i++) {
            System.out.printf("%d Hits: %d\n", i, values[i]);
        }
    }
}