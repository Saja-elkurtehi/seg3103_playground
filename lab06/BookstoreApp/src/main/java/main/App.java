package main;

import java.io.BufferedReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        	ProcessBuilder pb = new ProcessBuilder("java", "-jar", "bookstore5.jar");
        	Process p = pb.start();
            System.out.println("Press Enter to stop server");
            // wait for Enter to terminate
            new BufferedReader(new java.io.InputStreamReader(System.in)).readLine();
            p.destroy();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
