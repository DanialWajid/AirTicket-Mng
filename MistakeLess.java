package com.example.myfx;

import javafx.application.Application;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;

public class MistakeLess extends Application {
    Scene scn1, scn2, scn3, scn4,scn5,scn6;


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Airline Management System");
        // Scene 1
        Button button1 = new Button("Booking");
        Button button2 = new Button("Flight Schedule");
        Button button3 = new Button("Give Feedback");
        Button button4= new Button(("Our reviews "));
        GridPane pane1 = new GridPane();
        pane1.add(button1, 0, 0);
        pane1.add(button2, 0, 1);
        pane1.add(button3, 0, 2);
        pane1.add(button4,0,3);
        scn1 = new Scene(pane1, 300, 200);

        // Scene 2 (Booking)//husnain
        Label label1 = new Label(" Name :");
        TextField tf1 = new TextField();
        Label label2 = new Label("Age :");
        TextField tf2 = new TextField();
        Label label3 = new Label("Email:");
        TextField tf3 = new TextField();
        Label label4 = new Label("Phone:");
        TextField tf4 = new TextField();
        Label label5 = new Label("Ticket Class:");
        TextField tf5 = new TextField();
        Label label6 = new Label("Enter Departure Airport:");
        TextField tf6 = new TextField();
        Button btn1 = new Button("Submit");
        GridPane pane2= new GridPane();
        pane2.add(label1, 0, 0);
        pane2.add(tf1, 1, 0);
        pane2.add(label2, 0, 1);
        pane2.add(tf2, 1, 1);
        pane2.add(label3, 0, 2);
        pane2.add(tf3, 1, 2);
        pane2.add(label4, 0, 3);
        pane2.add(tf4, 1, 3);
        pane2.add(label5, 0, 4);
        pane2.add(tf5, 1, 4);
        pane2.add(label6, 0, 5);
        pane2.add(tf6, 1, 5);
        pane2.add(btn1, 1, 6);
        pane2.setVgap(5);
        pane2.setHgap(5);
        Button back1= new Button("Back");
        pane2.add(back1,0,7);
        back1.setOnAction(e ->stage.setScene(scn1));
        scn2 = new Scene(pane2, 300, 200);
        button1.setOnAction(e ->stage.setScene(scn2));
        //scene3//husnain
        GridPane pane3 = new GridPane();
        //departure airport schedule displayed after entering departure airport
        Label l51 = new Label("Flight number :");
        Label l52 = new Label("Flight Departure :");
        Label l53 = new Label("Flight Destination :");
        Label l54 = new Label("Flight Departure Time :");
        Label l55 = new Label("Flight Arrival Time :");
        Label l56 = new Label("Enter Flight Number you want :");
        TextField txt56=new TextField();
        Button btn56= new Button("Submit");///if flight number exists show another button to print ticket
        Label l57 = new Label("Flight Duration :");//display flight duration
        Label l58= new Label("Total Fare");///display fare
        Button print= new Button("Print Ticket");
        pane3.add(l51,0,1);
        pane3.add(l52,0,2);
        pane3.add(l53,0,3);
        pane3.add(l54,0,4);
        pane3.add(l55,0,5);
        pane3.add(l56,0,6);
        pane3.add(txt56,0,7);
        pane3.add(btn56,0,8);
        pane3.add(l57,0,9);
        pane3.add(l58,0,10);
        pane3.add(print,0,11);
        Button back4= new Button("Back");
        pane3.add(back4,0,12);

        back4.setOnAction(e ->stage.setScene(scn1));
        scn3= new Scene(pane3,200,300);
        btn1.setOnAction(e ->stage.setScene(scn3));
        l57.setVisible(false);
        l58.setVisible(false);
        print.setVisible(false);
        btn56.setOnAction(e ->{
            print.setVisible(true);
            l57.setVisible(true);
            l58.setVisible(true);

        });
        //husnain
        //scene 4 ticket printing//later add exit button that will lead to thank u details
        Label lf1= new Label("Flight Number:");
        Label lf2= new Label("Flight Duration");
        Label lf3= new Label("Departure Airport:");
        Label lf4= new Label("Destination Airport");
        Label lf5= new Label("Ticket Number");
        Label lf6= new Label("Reservation Number");
        Label lf7 = new Label("Age");
        Label lf8 = new Label("Contact Number");
        Label lf9 = new Label("Ticket Class");
        GridPane pane4= new GridPane();
        pane4.add(lf1,0,1);
        pane4.add(lf2,0,2);
        pane4.add(lf3,0,3);
        pane4.add(lf4,0,4);
        pane4.add(lf5,0,5);
        pane4.add(lf6,0,6);
        pane4.add(lf7,0,7);
        pane4.add(lf8,0,8);
        pane4.add(lf9,0,9);
        Button exit = new Button("Exit");
        pane4.add(exit,0,10);
        exit.setOnAction(e ->stage.setScene(scn1));
        scn4 = new Scene(pane4,200,300);

        print.setOnAction(e ->stage.setScene(scn4));
        //scene 5 flight schedule //danial
        Label l1 = new Label("Flight number :");
        Label l2 = new Label("Flight Departure :");
        Label l3 = new Label("Flight Destination :");
        Label l4 = new Label("Flight Duration :");
        Button back2 = new Button("Back");
        back2.setOnAction(e ->stage.setScene(scn1));
        GridPane pane5= new GridPane();
        pane5.add(l1, 1, 0);
        pane5.add(l2, 1, 1);
        pane5.add(l3, 1, 2);
        pane5.add(l4, 1, 3);
        pane5.add(back2,1,4);
        pane5.setVgap(5);
        pane5.setHgap(5);
        scn5 = new Scene(pane5, 300, 200);
        button2.setOnAction(e ->stage.setScene(scn5));
        //scene 6 feedback
        Label feedL1 =  new Label("Passenger Name");
        TextField tx1= new TextField();
        Label feedL2 =  new Label("Rating");
        TextField tx2= new TextField();
        Label feedL3 =  new Label("Content");
        TextField tx3= new TextField();
        GridPane pane6 = new GridPane();
        pane6.add(feedL1,1,0);
        pane6.add(tx1,1,1);
        pane6.add(feedL2,1,2);
        pane6.add(tx2,1,3);
        pane6.add(feedL3,1,4);
        pane6.add(tx3,1,5);
        pane6.setHgap(5);
        pane6.setVgap(5);
        Button back3= new Button("Back");
        back3.setOnAction(e ->stage.setScene(scn1));
        pane6.add(back3,2,6);
        scn6= new Scene(pane6,300,200);
        button3.setOnAction(e ->stage.setScene(scn6));
        Button feedsub= new Button("Submit");
        pane6.add(feedsub, 1, 6);
        ArrayList<Feedback> feedbackList = new ArrayList<>();
        Label label61= new Label("Thank you for your feedback !");
        pane6.add(label61,1,7);
         label61.setVisible(false);
        feedsub.setOnAction(e -> {
            String name = tx1.getText();
            int rating = Integer.parseInt(tx2.getText());
            String content = tx3.getText();
            Date d1 = new Date();
            feedbackList.add(new Feedback(name, content, rating, d1));
            label61.setVisible(true);
            System.out.println(feedbackList.size());
        });
        //scene 7 reviews

        Date d2 = new Date();
         feedbackList.add(new Feedback("danial","bad",3,d2));
         feedbackList.add(new Feedback("wajid","verybad",9,d2));
        TableView<Feedback> tableView = new TableView<>();
        TableColumn<Feedback, String> nameColumn = new TableColumn<>("Passenger Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("passengerName"));

        TableColumn<Feedback, String> contentColumn = new TableColumn<>("Feedback Content");
        contentColumn.setCellValueFactory(new PropertyValueFactory<>("feedbackContent"));

        TableColumn<Feedback, Integer> ratingColumn = new TableColumn<>("Rating");
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

        TableColumn<Feedback, Date> dateColumn = new TableColumn<>("Submission Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("submissionDate"));
        Button back7= new Button("Back");
        tableView.getColumns().addAll(nameColumn, contentColumn, ratingColumn, dateColumn);
        tableView.getItems().addAll(feedbackList);
        VBox vbox = new VBox(tableView , back7);
        Scene scn7 = new Scene(vbox, 600, 400);
        button4.setOnAction(e-> stage.setScene(scn7));
        back7.setOnAction(e ->stage.setScene(scn1));






        //styling
        DropShadow shadow= new DropShadow();
        button1.setEffect(shadow);
        Image image = new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/bcatatic-air-high-resolution-logo.png");
        ImageView imageView = new ImageView(image);
        Pane pane = new Pane();
        pane.getChildren().addAll(imageView,pane1);
         scn1 = new Scene(pane, 200, 300);
        imageView.fitWidthProperty().bind(scn1.widthProperty());
        imageView.fitHeightProperty().bind(scn1.heightProperty());

        button1.toFront();
         button2.toFront();
          button3.toFront();


        stage.setScene(scn1);
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
