<<<<<<< HEAD
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

import static javafx.application.Application.launch;
import static javafx.scene.control.LabelBuilder.*;

/**
 * Created by Максим on 10.02.2015.
 */



public class RevClient extends Application {
    public static String ip;

    public static GridPane gp;

    public static String port;
    private int windowWidth = 600;
    private int windowHeight = 600;


/*
    public Label createLabel(){
        Label label = create()    // создание билдера для Label
                .text("SomeText")             // текстовое значение
                .prefWidth(100)                // возможная ширина
                .prefHeight(50)                // возможная высота
                .alignment(Pos.CENTER)         // выравнивание содержимого по центру
                .layoutX( 100) // задание  коорд. Х
                .layoutY(50)  // задание  коорд. Y
                .style("-fx-background-color: orange;")  // зарисуем фон в оранжевый
                .build(); // создадим из билдера сам объект класса Label
 extends Application
        return label;
    }
*/










    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Pane child = (Pane) root.getChildrenUnmodifiable().get(1);
        gp = (GridPane) child.getChildren().get(0);
       // gp.add(createCircle(2), 1, 0); // column=1 row=0

       // Group root = new Group();
        primaryStage.setScene (new Scene(root, windowWidth, windowHeight));

        //((Pane) root).getChildren().add(createCircle());

        primaryStage.setTitle("Simple Application");
        primaryStage.show();


        InetAddress ipAddress = InetAddress.getByName(ip);
        Socket s = new Socket(ipAddress, Integer.parseInt(port));
        Field clientf = new Field();

=======
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
>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32

        //принимаем от сервера сюда
        DataInputStream din = new DataInputStream(s.getInputStream());

<<<<<<< HEAD

=======
>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32
        //шлем на сервер отсюда
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        System.out.println("Connected..");

<<<<<<< HEAD

        Scanner input = new Scanner(System.in);

        //System.out.println(din.readUTF());








            /*    int x;
                int y;

                while (true) {

                    Message priem1 = Message.jRecv(s.getInputStream());
                    Square[][] clientSquare = priem1.getField();
                    clientf.setField(clientSquare);
                    clientf.drawField();

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

                }*/






    }


    public static void main(String args[]) throws IOException, InterruptedException {
        ip = args[0];
        port = args[1];


        launch(args);
    }
=======
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

>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32
}