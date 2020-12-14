
package ohtu.kivipaperisakset;

import java.util.Scanner;

public class IO {
    private Scanner scanner = new Scanner(System.in);
    
    /**
     * print output
     */
    public void print(String toPrint) {
        System.out.println(toPrint);
    }
    
    /**
     * read integer
     */
    public int readInt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(scanner.nextLine());
    }
    
    /**
     * read string
     */
    public String readLine() {
        return scanner.nextLine();
    }
    
}