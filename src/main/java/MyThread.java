import javafx.application.Platform;
import javafx.scene.layout.GridPane;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Максим on 20.02.2015.
 */
public class MyThread {
    Field clientf;
    public void run( InetAddress ip, int port, GridPane gp) throws IOException {
        Socket s = new Socket( ip, port);
        //принимаем от сервера сюда
        DataInputStream din = new DataInputStream(s.getInputStream());
        //шлем на сервер отсюда
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        Scanner input = new Scanner(System.in);
        System.out.println("Connected..");

        int x;
        int y;
         clientf = new Field();

        while (true) {

            Message priem1 = Message.jRecv(s.getInputStream());
            Square[][] clientSquare = priem1.getField();
            clientf.setField(clientSquare);
            Platform.runLater(clientf.drawFieldWin(gp));

            System.out.println("Move Color, x,y");


            x = input.nextInt();
            y = input.nextInt();
            if (x > 7 || x < 0 || y > 7 || y < 0) {
                System.out.println("X and Y must be [0-7]");
                continue;
            }

            dout.writeInt(x);
            dout.writeInt(y);
            dout.flush();

            Message priem2 = Message.jRecv(s.getInputStream());
            clientSquare = priem2.getField();
            clientf.setField(clientSquare);
            clientf.drawField();
        }
    }

}
