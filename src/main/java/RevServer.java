import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Максим on 03.02.2015.
 */


public class RevServer {

public static void main(String [] args) {
    Field field = new Field();
    try {
        ServerSocket ss = new ServerSocket(7777);
        Socket p1 = ss.accept();
        System.out.println("Client 1 connected");
        Socket p2= ss.accept();
        System.out.println("Client 2 connected");

        Scanner p1input = new Scanner(p1.getInputStream());
        Scanner p2input = new Scanner(p2.getInputStream());

        PrintStream p1output = new PrintStream(p1.getOutputStream());
        PrintStream p2output = new PrintStream(p2.getOutputStream());

        p1output.println("Ваш ход, черные");
        p2output.println("Ход противника");
        int col,x,y;

        while (true) {
            col = p1input.nextInt();
            x = p1input.nextInt();
            y = p1input.nextInt();

            System.out.println(col + " " + x + " " + y);

            /*col = p1input.nextInt();
            x = p1input.nextInt();
            y = p1input.nextInt();
            field.move(field.checkMove(Field.fromInt(col),x,y),x,y);

            field.drawField();
            col = p2input.nextInt();
            x = p2input.nextInt();
            y = p2input.nextInt();
            field.move(field.checkMove(Field.fromInt(col),x,y),x,y);

            field.drawField();*/

        }



    } catch (IOException e) {
        e.printStackTrace();
    }


}
}
