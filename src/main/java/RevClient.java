import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Максим on 06.02.2015.
 */
public class RevClient {

    public static void main(String[] args) throws IOException {
        PrintWriter out = null;
        BufferedReader in = null;

        InetAddress ipAddress = InetAddress.getByName("localhost");
        Socket s = new Socket(ipAddress, 7777);

        out = new PrintWriter(s.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        System.out.println("Connected..");

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        System.out.println(in.readLine());

        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
        }

        out.close();
        in.close();
        stdIn.close();
    }


   /* Scanner input = new Scanner(System.in);
        int col;
        int x;
        int y;

        while (true) {
            System.out.println("Move Color, x,y");
            col = input.nextInt();
            x = input.nextInt();
            y = input.nextInt();
            if (x > 7 || x < 0 || y > 7 || y < 0) {
                System.out.println("X and Y must be [0-7]");
                continue;
            }*/
          /*  out.print(col);
            out.print(x);
            out.print(y);
            out.flush();*/
}