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
        /*PrintWriter out = null;
        BufferedReader in = null;*/

        InetAddress ipAddress = InetAddress.getByName("localhost");
        Socket s = new Socket(ipAddress, 7777);

        /*out = new PrintWriter(s.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));*/

        //принимаем от сервера сюда
        DataInputStream din = new DataInputStream(s.getInputStream());

        //шлем на сервер отсюда
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        System.out.println("Connected..");

        //клавиатурный ввод
        /*BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;*/

        System.out.println(din.readUTF());

        Scanner input = new Scanner(System.in);
        int col;
        int x;
        int y;

        while (true)
         {
            System.out.println("Move Color, x,y");
            col = input.nextInt();
            x = input.nextInt();
            y = input.nextInt();
            if (x > 7 || x < 0 || y > 7 || y < 0) {
                System.out.println("X and Y must be [0-7]");
                continue;
            }
            dout.writeInt(col);
            dout.writeInt(x);
            dout.writeInt(y);
            dout.flush();
        }


        /*din.close();
        dout.close();*/

        /*stdIn.close();*/
    }

}