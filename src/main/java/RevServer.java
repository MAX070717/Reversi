<<<<<<< HEAD
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Максим on 13.02.2015.
 */
public class RevServer {
    public static void main(String [] args) throws IOException {
        String mess1= "Ходите";
        String mess2= "Ход противника, ждите!";
        String mess3= "Неверный ход, ходите снова";
        String flag1= "1";
        String flag2= "0";


        Field field = new Field();
        try {
            ServerSocket ss = new ServerSocket(7777);
            Socket p1 = ss.accept();
            System.out.println("Client 1 connected");
            Socket p2 = ss.accept();
            System.out.println("Client 2 connected");

            DataInputStream p1input = new DataInputStream(p1.getInputStream());
            DataOutputStream p1output = new DataOutputStream(p1.getOutputStream());

            DataInputStream p2input = new DataInputStream(p2.getInputStream());
            DataOutputStream p2output = new DataOutputStream(p2.getOutputStream());

       /* p1output.writeUTF(mess1);
        p2output.writeUTF(mess2);*/
            int col,x,y;
            int flag=0;


            while (true) {

                do {
                    Message mq1=new Message(field.getField());
                    mq1.jSend(p1.getOutputStream());
                /*p1output.writeUTF(mess3);*/
                    col = 2;
                    x = p1input.readInt();
                    y = p1input.readInt();
                    System.out.println(col + " " + x + " " + y);

                    if (!field.move(field.checkMove(Field.fromInt(col), x, y), x, y)) {
                        System.out.println("Wrong!! Move again");
                        //p1output.writeUTF(mess3);
                    }
                    else flag=1;
                }
                while (flag!=1);

                field.drawField();
                Message mq1=new Message(field.getField());
                mq1.jSend(p1.getOutputStream());


                do {
                    Message mq2=new Message(field.getField());
                    mq2.jSend(p2.getOutputStream());
                   /* p2output.writeUTF(mess3);*/
                    col = 1;
                    x = p2input.readInt();
                    y = p2input.readInt();
                    System.out.println(col + " " + x + " " + y);
                    if (!field.move(field.checkMove(Field.fromInt(col), x, y), x, y)) {
                        System.out.println("Wrong!! Move again");
                        p2output.writeUTF(mess3);
                    }
                    else flag=2;
                }
                while (flag!=2) ;
                field.drawField();
                Message mq2=new Message(field.getField());
                mq2.jSend(p2.getOutputStream());


            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Неправильный ход, ходите еще");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
=======
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Максим on 03.02.2015.
 */


public class RevServer {

public static void main(String [] args)  {
    Field field = new Field();
    try {
        ServerSocket ss = new ServerSocket(7777);
        Socket p1 = ss.accept();
        Socket p2 = ss.accept();
        System.out.println("Client 1 connected");
        System.out.println("Client 2 connected");


        /*Socket p2= ss.accept();
        System.out.println("Client 2 connected");*/

        /*Scanner p1input = new Scanner(p1.getInputStream());
        Scanner p2input = new Scanner(p2.getInputStream());*/

        /*PrintStream p1output = new PrintStream(p1.getOutputStream());
        PrintStream p2output = new PrintStream(p2.getOutputStream());*/

        /*p1output.println("Ваш ход, черные");
        p2output.println("Ход противника");*/

        DataInputStream p1input = new DataInputStream(p1.getInputStream());
        DataOutputStream p1output = new DataOutputStream(p1.getOutputStream());

        DataInputStream p2input = new DataInputStream(p2.getInputStream());
        DataOutputStream p2output = new DataOutputStream(p2.getOutputStream());

        p1output.writeUTF("Ходите");
        p2output.writeUTF("Ход роивника!");

        int col,x,y;

        while (true) {
            /*col = p1input.nextInt();
            x = p1input.nextInt();
            y = p1input.nextInt();


            System.out.println(col + " " + x + " " + y);*/
            col = p1input.readInt();
            x = p1input.readInt();
            y = p1input.readInt();
            System.out.println(col + " " + x + " " + y);

            if (!field.move(field.checkMove(Field.fromInt(col),x,y),x,y))
                System.out.println("Ходите по новой");

            else
                field.drawField();

            col = p2input.readInt();
            x = p2input.readInt();
            y = p2input.readInt();
            System.out.println(col + " " + x + " " + y);

            if (!field.move(field.checkMove(Field.fromInt(col),x,y),x,y))
                System.out.println("Ходите по новой");
            else
                field.drawField();
        }



    } catch (IndexOutOfBoundsException e) {
        System.out.println("Неправильный ход, ходите еще");
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }


}
>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32
}
