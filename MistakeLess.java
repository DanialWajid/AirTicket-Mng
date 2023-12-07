package com.example.myfx;

import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MistakeLess extends Application {
    Scene scn1, scn2, scn3, scn4,scn5,scn6,scn7,scn8,scn9,scn10;
    GridPane pane7= new GridPane();
    Stage stage;


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Bcatatic Air Booking System");
        // Scene 1
        Button button0= new Button();
        Button button1 = new Button("Booking");
        Button button2 = new Button("Flight Schedule");
        Button button3 = new Button("Give Feedback");
        Button button4= new Button(  "Our reviews");
        Button button5= new Button("About Us ");
        Button button6= new Button("Our Destination");
        Button button7= new Button("Contact Us");



        GridPane pane1 = new GridPane();
        pane1.add(button0,0,0);
        pane1.add(button1, 1, 0);
        pane1.add(button2, 2, 0);
        pane1.add(button3, 3,0 );
        pane1.add(button4,4,0);


        //*
//        pane1.setHgap(0);
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

        Button back2 = new Button("Back");
        back2.setOnAction(e ->stage.setScene(scn1));


        ArrayList<Flight>flightlist= new ArrayList<>();
        TableView tableView5 = new TableView<>();

        TableColumn<Flight , String> flightno = new TableColumn<>("Flight Number");
        flightno.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));

        TableColumn<Flight , String> DestinationAirport = new TableColumn<>("Destination Airport");
        DestinationAirport.setCellValueFactory(new PropertyValueFactory<>("destinationAirport"));

        TableColumn<Flight , String> DepartureAirport = new TableColumn<>("Departure Airport");
        DepartureAirport.setCellValueFactory(new PropertyValueFactory<>("departueAirport"));

        TableColumn<Flight, Date> ArrivalTime = new TableColumn<>("Arrival Time");
        ArrivalTime.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));

        TableColumn<Flight, Date> DepartureTime = new TableColumn<>("Departure Time");
        DepartureTime.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
        ArrayList<Airport> ArrivalAirportList = Airport.getArrivalAirports();
        ArrayList<Airport> DepartueAirportList = Airport.getDepartureAirports();
        Date df= new Date();
        int flightNumberCounter = 100;
        double[] flightDuration = {1.5,2.6,3.8,9.8,15.6,17.9,20.2,5.7,5.9,8.34};
        for (int i = 0; i < ArrivalAirportList.size(); i++) {// Assigning unique flight number and flight duration to eacg flight
            for (int j = 0; j < DepartueAirportList.size(); j++) {
                double duration= flightDuration[flightNumberCounter%flightDuration.length];
                flightNumberCounter++;
                String flightNumber = "LH" + flightNumberCounter;
                flightlist.add(new Flight(flightNumber, df, df, duration, ArrivalAirportList.get(i).getAirportName(), DepartueAirportList.get(j).getAirportName()));
            } }

        tableView5.getColumns().addAll(flightno, DestinationAirport, DepartureAirport, ArrivalTime, DepartureTime);
        tableView5.setItems(FXCollections.observableArrayList(flightlist));
        VBox vBox5=new VBox(tableView5,back2);
        scn5 = new Scene(vBox5, 300, 200);
        button2.setOnAction(e ->{stage.setScene(scn5);
            System.out.println(flightlist.size());
        });



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
        TableView<Feedback> tableView = new TableView<>();
        ArrayList<Feedback>feedbackList= new ArrayList<>();

        Label label61= new Label("Thank you for your feedback !");
        pane6.add(label61,1,7);
         label61.setVisible(false);
        feedsub.setOnAction(e -> {
            try {
                String name = tx1.getText();
                int rating = Integer.parseInt(tx2.getText());
                String content = tx3.getText();

                Date d1 = new Date();
                feedbackList.add(new Feedback(name, content, rating, d1));
                label61.setVisible(true);
                System.out.println(feedbackList.size());
                tableView.setItems(FXCollections.observableArrayList(feedbackList));

            } catch (NumberFormatException exp) {
                // Handling the exception for invalid integer input in the rating field
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Error !");
                alert.setContentText("Incorrect Data Type or a Field left Empty");
                alert.show();

                tx1.setText("");
                tx2.setText("");
                tx3.setText("");

            }
        });
        //scene 7 reviews
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
        tableView.setItems(FXCollections.observableArrayList(feedbackList));
         //scene 8
        Image image8 = new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/top-view-frame-with-plane-sweets.jpg");
        ImageView imageView8=new ImageView(image8);
        Text text80= new Text("About us ");
        Text text81= new Text("Bcatatic Air established in 2023 is a new born organization that is working to bring inovatation in the airline industry ");
        Text text82= new Text("We are trying hard to give quality services to our passenger");
        Pane pane8 = new Pane();
        Button back8= new Button("Back");
        pane8.getChildren().addAll(imageView8,back8);
        scn8= new Scene(pane8,500,500);
        imageView8.fitWidthProperty().bind(scn8.widthProperty());
        imageView8.fitHeightProperty().bind(scn8.heightProperty());
        back8.setOnAction(e->stage.setScene(scn1));
        setHeight(back8);
        back8.setPrefWidth(200);
        back8.setLayoutX(400);
        back8.setLayoutY(400);
        setHoverCustomEffect(back8);


        button5.setOnAction(e->stage.setScene(scn8));
        //scene9
        Image image9= new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/top-view-frame-with-plane-sweets.jpg");
        ImageView imageView9= new ImageView(image9);
        Button back9= new Button("Back");
        Pane pane9= new Pane();
        pane9.getChildren().addAll(imageView9,back9);
        scn9= new Scene(pane9,500,500);
        imageView9.fitWidthProperty().bind(scn9.widthProperty());
        imageView9.fitHeightProperty().bind(scn9.heightProperty());
        setHeight(back9);
        back9.setPrefWidth(200);
        back9.setLayoutX(400);
        back9.setLayoutY(400);
        setHoverCustomEffect(back9);
        back9.setOnAction(e->stage.setScene(scn1));
        button6.setOnAction(e->stage.setScene(scn9));
        //scn10
        Image image10= new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/top-view-frame-with-plane-sweets.jpg");
        ImageView imageView10= new ImageView(image9);
        Button back10= new Button("Back");
        Pane pane10= new Pane();
        pane10.getChildren().addAll(imageView9,back9);
        scn10= new Scene(pane10,500,500);
        imageView9.fitWidthProperty().bind(scn10.widthProperty());
        imageView9.fitHeightProperty().bind(scn10.heightProperty());
        setHeight(back10);
        back9.setPrefWidth(200);
        back9.setLayoutX(400);
        back9.setLayoutY(400);
        setHoverCustomEffect(back10);
        back10.setOnAction(e->stage.setScene(scn1));
        button7.setOnAction(e->stage.setScene(scn10));





        //styling
        DropShadow shadow= new DropShadow();
        Text text10 = new Text("Bcatatic Air");
        Text text11= new Text("Batwings Beyond , Lunacy Unbound");
        text10.setFont(Font.font("Serif",100));
        text11.setFont(Font.font("Serif",30));
        text10.setX(310);
        text11.setX(320);
        text10.setY(400);
        text11.setY(430);
        button5.setLayoutX(1000);
        button6.setLayoutX(1000);
        button7.setLayoutX(1000);
        button5.setLayoutY(300);
        button6.setLayoutY(400);
        button7.setLayoutY(500);


        Image image = new Image("file:/E://algorithms 1//MyFx//src//main//java//com//example//myfx//top-view-frame-with-plane-sweets.jpg");
        ImageView imageView = new ImageView(image);
        Pane pane = new Pane();
        pane.getChildren().addAll(imageView,text11, text10,button5,button6,button7, pane1);
         scn1 = new Scene(pane, 800, 750);
        imageView.fitWidthProperty().bind(scn1.widthProperty());
        imageView.fitHeightProperty().bind(scn1.heightProperty());
        //new
        stage.getIcons().add(new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/631546_bat_batman_hero_man_saver_icon.png"));
        button0.setStyle(
                "-fx-background-image: url('file:///E:/algorithms%201/MyFx/src/main/java/com/example/myfx/bcatatic-air-high-resolution-logo.png');" +
                        "-fx-background-size: cover;" +
                        "-fx-background-repeat: no-repeat;" +
                        "-fx-background-position: center;" +
                        "-fx-padding: 0px 0px 30px 0px;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 0);" 

        );





        setHeight(button0);
        setHeight(button1);
        setHeight(button2);
        setHeight(button3);
        setHeight(button4);
        setHeight(button5);
        setHeight(button6);
        setHeight(button7);
        button0.setPrefSize(113, 70);

        button1.setPrefWidth(314);
        button2.setPrefWidth(313);
        button3.setPrefWidth(313);
        button4.setPrefWidth(314);
        button5.setPrefWidth(314);
        button6.setPrefWidth(314);
        button7.setPrefWidth(314);
        button1.toFront();
         button2.toFront();
          button3.toFront();


    setHoverEffect(button1);
    setHoverEffect(button2);
    setHoverEffect(button3);
    setHoverEffect(button4);
    setHoverCustomEffect(button5);
    setHoverCustomEffect(button6);
    setHoverCustomEffect(button7);

        stage.setScene(scn1);
        stage.show();

    }
    private void setHoverEffect(Button button) {
        button.setStyle("-fx-background-color: black; -fx-text-fill: yellow;-fx-background-radius: 0;");

        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color: purple; -fx-text-fill: yellow;-fx-background-radius: 0;");
        });

        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color: black; -fx-text-fill: yellow;-fx-background-radius: 0;");
        });
    }
    private void setHoverCustomEffect(Button button) {
        button.setStyle("-fx-background-color: black; -fx-text-fill: yellow;"+"-fx-background-radius: 15;" +
                "-fx-border-radius: 15;");

        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color: purple; -fx-text-fill: yellow;"+"-fx-background-radius: 15;" +
                    "-fx-border-radius: 15;");
        });

        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color: black; -fx-text-fill: yellow;"+"-fx-background-radius: 15;" +
                    "-fx-border-radius: 15;");
        });
    }
    private void setHeight(Button button) {
        button.setPrefHeight(70); 
    }


    public static void main(String[] args) {
        launch(args);
    }

    }


