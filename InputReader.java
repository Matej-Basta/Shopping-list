import java.util.Scanner;

public class InputReader { 
    
    public void readInput() {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            String input = scanner.next();
        }
        scanner.close();
    }
    
}
