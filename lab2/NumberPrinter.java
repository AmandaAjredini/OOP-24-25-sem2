import java.util.Random;

class NumberPrinter {
    // Private method to print numbers from smallest number to bigger number
    private void printFromAtoB(int a, int b) {
        int min = Math.min(a, b); // Find minimum of both numbers since we aren't guaranteed which order the min and max will be
        int max = Math.max(a, b); // Find maximum of both numbers 

        for (int i = min; i <= max; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    // Public method to print y integers starting from x
    public void printFromXYtimes(int x, int y) {
        printFromAtoB(x, x + y - 1); // The last number printed is 1 less than both numbers added
        System.out.println();
        
    }

    // Public method converting two strings to integers and passing them to printFromAtoB method
    public void printFromStrings(String str1, String str2) {
        int num1 = Integer.parseInt(str1); // Convert str1 to integer
        int num2 = Integer.parseInt(str2); // Convert str2 to integer

        printFromAtoB(num1, num2);
        System.out.println();
    }

    // Public method to get two random integers and passing them to printFromAtoB
    public void printFromRandom() {
        Random rand = new Random();

        int num1 = rand.nextInt(100); // Random number between 0 - 99
        int num2 = rand.nextInt(100);

        printFromAtoB(num1, num2);
        System.out.println();
    }
};