package com.example.myfx;

import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
import java.awt.Desktop;
import java.net.URI;

;

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
        scn1 = new Scene(pane1, 1200, 700);

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
        scn2 = new Scene(pane2, 1200, 700);
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
        scn3= new Scene(pane3,1200,700);
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
        scn4 = new Scene(pane4,1200,700);

        print.setOnAction(e ->stage.setScene(scn4));
        //scene 5 flight schedule //danial

        Button back2 = new Button("Back");
        back2.setOnAction(e ->stage.setScene(scn1));
        back2.setPrefWidth(200);
        setHeight(back2);
        setHoverCustomEffect(back2);
        iconButton(back2);



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
        scn5 = new Scene(vBox5, 1200, 700);
        button2.setOnAction(e ->{stage.setScene(scn5);
            System.out.println(flightlist.size());
        });



        //scene 6 feedback
        Label feedL1 =  new Label("                  Passenger Name");
        TextField tx1= new TextField();
        Label feedL2 =  new Label("                           Rating");
        TextField tx2= new TextField();
        Label feedL3 =  new Label("                          Content");
        TextField tx3= new TextField();
        Label feedL4= new Label();
        GridPane pane6 = new GridPane();

        pane6.add(feedL1,1,0);
        pane6.add(tx1,1,1);
        pane6.add(feedL2,1,2);
        pane6.add(tx2,1,3);
        pane6.add(feedL3,1,4);
        pane6.add(tx3,1,5);
        pane6.add(feedL4,1,6);

        pane6.setHgap(5);
        pane6.setVgap(0);
        Button back3= new Button("Back");
        back3.setOnAction(e ->stage.setScene(scn1));
        iconButton(back3);
        pane6.add(back3,2,6);
        scn6= new Scene(pane6,1200,700);
        button3.setOnAction(e ->stage.setScene(scn6));
        Button feedsub= new Button("Submit");

        TableView<Feedback> tableView = new TableView<>();
        ArrayList<Feedback>feedbackList= new ArrayList<>();

        Label label61= new Label("     Your feedback is valuable for us!");
        pane6.add(label61,1,7);

        feedsub.setOnAction(e -> {
            try {
                String name = tx1.getText();
                int rating = Integer.parseInt(tx2.getText());
                String content = tx3.getText();
                Date d1 = new Date();
                feedbackList.add(new Feedback(name, content, rating, d1));
                label61.setText("        Thank you for your feedback !");
                System.out.println(feedbackList.size());
                tableView.setItems(FXCollections.observableArrayList(feedbackList));
                tx1.setText("");
                tx2.setText("");
                tx3.setText("");

            } catch (NumberFormatException  | invalidRatingException o) {
                // Handling the exception for invalid integer input in the rating field
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setHeaderText("Error !");
                alert.setContentText("invalid rating");
                alert.show();

                tx1.setText("");
                tx2.setText("");
                tx3.setText("");

            }
        });
        Image image3 = new Image("file:/E://algorithms 1//MyFx//src//main//java//com//example//myfx//WhatsApp Image 2023-12-07 at 8.21.22 PM.jpeg");
        ImageView imageView3 = new ImageView(image3);
        Pane pane11 = new Pane();
        tx3.setStyle("-fx-padding: 0;");
        tx3.setStyle("-fx-margin: 0;");
        pane11.getChildren().addAll(imageView3 , back3 , feedsub , pane6);
        scn6 = new Scene(pane11, 800, 750);
        imageView3.fitWidthProperty().bind(scn6.widthProperty());
        imageView3.fitHeightProperty().bind(scn6.heightProperty());
        feedL1.setStyle("-fx-padding: 0; -fx-margin: 0;");
        feedL2.setStyle("-fx-padding: 0; -fx-margin: 0;");

        setHeight(back3);
        back3.setPrefWidth(200);
        back3.setLayoutX(15);
        back3.setLayoutY(400);
        setHoverCustomEffect(back3);
        feedL1.setStyle("-fx-text-fill: black; -fx-background-color: yellow;");
        feedL1.setPrefWidth(200);

        setHeight(feedsub);
        feedsub.setPrefWidth(200);
        feedsub.setLayoutX(15);
        feedsub.setLayoutY(300);
        setHoverCustomEffect(feedsub);
        feedL1.setStyle("-fx-text-fill: black; -fx-background-color: #FFD700; -fx-background-radius: 0;");
        feedL1.setPrefWidth(210);
        feedL1.setPrefHeight(50);
        feedL2.setStyle("-fx-text-fill: black; -fx-background-color: #FFD700; -fx-background-radius: 0;");
        feedL2.setPrefWidth(210);
        feedL2.setPrefHeight(50);
        feedL3.setStyle("-fx-text-fill: black; -fx-background-color: #FFD700; -fx-background-radius: 0;");
        feedL3.setPrefWidth(210);
        feedL3.setPrefHeight(50);
        label61.setStyle("-fx-text-fill: black; -fx-background-color: #FFD700; -fx-background-radius: 0;");
        label61.setPrefWidth(210);
        label61.setPrefHeight(50);
        tx1.setStyle("-fx-background-color: transparent;");
        tx2.setStyle("-fx-background-color: transparent;");
        tx3.setStyle("-fx-background-color: transparent;");


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
        Scene scn7 = new Scene(vbox, 1200, 700);
        button4.setOnAction(e-> stage.setScene(scn7));
        setHeight(back7);
        back7.setPrefWidth(200);
        setHoverCustomEffect(back7);
        back7.setOnAction(e ->stage.setScene(scn1));
        tableView.setItems(FXCollections.observableArrayList(feedbackList));
         //scene 8
        Image image8 = new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/top-view-frame-with-plane-sweets.jpg");
        ImageView imageView8=new ImageView(image8);
        Text text80= new Text("About us ");
        text80.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 50;");
        Text airlineInfo1 = new Text(" Welcome aboard our airline!  We're all about making your travel experience extraordinary .");
         Text airlineInfo2= new Text( " From the moment you step onto our planes,we're here to take you on a journey filled with ") ;
          Text airlineInfo3= new Text("convenience, and a  touch of adventure. At our airline, we believe that flying should be");
          Text airlineInfo4 = new Text(" more than just a means of transportation . It should be a opportunity to explore new");
          Text airlineInfo5 = new Text("It should be a opportunity to explore new  horizons, connect with loved ones,and create" );
          Text airlineInfo6 = new Text(" unforgettable memories. That's why we're committed to  providing top-notch service that" );
          Text airlineInfo7 = new Text(" goes above and beyond your expectations.With a fleet of modern and reliable aircraft, we" );
          Text airlineInfo8 = new Text(" prioritize your safety above all." );
        airlineInfo1.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");
        airlineInfo2.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");
        airlineInfo3.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");
        airlineInfo4.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");
        airlineInfo5.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");
        airlineInfo6.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");
        airlineInfo7.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");
        airlineInfo8.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");


      text80.setFont(Font.font("Serif",50));
      text80.setY(150);
      text80.setX(700);
      airlineInfo1.setX(700);
      airlineInfo1.setY(190);
      airlineInfo2.setX(700);
      airlineInfo2.setY(210);
      airlineInfo3.setX(700);
      airlineInfo3.setY(230);
      airlineInfo4.setX(700);
      airlineInfo4.setY(250);
      airlineInfo5.setX(700);
      airlineInfo5.setY(270);
      airlineInfo6.setX(700);
      airlineInfo6.setY(290);
      airlineInfo7.setX(700);
      airlineInfo7.setY(310);
      airlineInfo8.setX(700);
      airlineInfo8.setY(330);




        Pane pane8 = new Pane();
        Image back8icon = new Image("file:/E:/algorithms%201/MyFx/src/main/java/com/example/myfx/left-arrow.png");
        ImageView imageView8back= new ImageView(back8icon);
        imageView8back.setFitWidth(30);
        imageView8back.setFitHeight(30);
        Button back8= new Button("Back" , imageView8back);
        back8.setGraphicTextGap(90);
        pane8.getChildren().addAll(imageView8,back8,text80,airlineInfo1,airlineInfo2,airlineInfo3,airlineInfo4,airlineInfo5,airlineInfo6,airlineInfo7,airlineInfo8);
        scn8= new Scene(pane8,1200,700);
        imageView8.fitWidthProperty().bind(scn8.widthProperty());
        imageView8.fitHeightProperty().bind(scn8.heightProperty());
        back8.setOnAction(e->stage.setScene(scn1));
        setHeight(back8);
        back8.setPrefWidth(200);
        back8.setLayoutX(700);
        back8.setLayoutY(400);
        setHoverCustomEffect(back8);


        button5.setOnAction(e->stage.setScene(scn8));
        //scene9
        Image image91 = new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/top-view-frame-with-plane-sweets.jpg");
        ImageView imageView91=new ImageView(image91);
        Image back91icon = new Image("file:/E:/algorithms%201/MyFx/src/main/java/com/example/myfx/left-arrow.png");
        ImageView imageView91back= new ImageView(back91icon);
        imageView91back.setFitWidth(30);
        imageView91back.setFitHeight(30);
        Button back91= new Button("Back" , imageView8back);
        back91.setGraphicTextGap(90);
        setHoverCustomEffect(back91);
        setHeight(back91);
        Button citybt1= new Button();
        Button citybt2= new Button();
        Button citybt3= new Button();
        Button citybt4= new Button();
        Button citybt5= new Button();
        //doha
        ImageView cityView1 = new ImageView(new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/360_F_529734392_X8tZTZQHxV35rfShpAbyJ5gzQXxCFzlo.jpg"));
        //islamabad
        ImageView cityView2 = new ImageView(new Image("file:///E:/algorithms%201/MyFx/src/main/java/com/example/myfx/islamabad-skyline-horizontal-banner-black-260nw-2034188513.jpg"));
        //dubai
        ImageView cityView3 = new ImageView(new Image("file:/E://algorithms 1//MyFx//src//main//java//com//example//myfx//dubai.jpg/"));
        //new york
        ImageView cityView4 = new ImageView(new Image("file:///E:/algorithms%201/MyFx/src/main/java/com/example/myfx/newyork.jpg"));
        //london
        ImageView cityView5 = new ImageView(new Image("file:///E:/algorithms%201/MyFx/src/main/java/com/example/myfx/london.jpg"));


        cityView1.setFitWidth(200);
        cityView1.setFitHeight(200);
        cityView2.setFitWidth(200);
        cityView2.setFitHeight(200);
        cityView3.setFitWidth(200);
        cityView3.setFitHeight(200);
        cityView4.setFitWidth(200);
        cityView4.setFitHeight(200);
        cityView5.setFitWidth(200);
        cityView5.setFitHeight(200);

        // Adding ImageViews to buttons
        citybt1.setGraphic(cityView1);
        citybt2.setGraphic(cityView2);
        citybt3.setGraphic(cityView3);
        citybt4.setGraphic(cityView4);
        citybt5.setGraphic(cityView5);

        Text text91= new Text("Click for Details ");
        text91.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 50;");

        text91.setY(150);
        text91.setX(700);



        Pane pane9= new Pane();
        pane9.getChildren().addAll(imageView91 , back91 ,text91,citybt1,citybt2,citybt3,citybt4,citybt5);
        scn9= new Scene(pane9,1200,700);
        imageView91.fitHeightProperty().bind(scn9.heightProperty());
        imageView91.fitWidthProperty().bind(scn9.widthProperty());
        button6.setOnAction(e->stage.setScene(scn9));
        back91.setPrefWidth(200);
        citybt1.setPrefHeight(100);
        citybt1.setPrefWidth(200);
        citybt2.setPrefHeight(100);
        citybt2.setPrefWidth(200);
        citybt3.setPrefHeight(100);
        citybt3.setPrefWidth(200);
        citybt4.setPrefHeight(100);
        citybt4.setPrefWidth(200);
        citybt5.setPrefHeight(100);
        citybt5.setPrefWidth(200);
        back91.setLayoutX(300);
        back91.setLayoutY(400);
        citybt1.setLayoutX(720);
        citybt1.setLayoutY(420);
        citybt2.setLayoutX(980);
        citybt2.setLayoutY(420);
        citybt3.setLayoutX(600);
        citybt3.setLayoutY(200);
        citybt4.setLayoutX(850);
        citybt4.setLayoutY(200);
        citybt5.setLayoutX(1100);
        citybt5.setLayoutY(200);
        back91.setOnAction(e->stage.setScene(scn1));
        iconButton(back91);
        citybt1.setOnAction(e->openWebpage("https://en.wikipedia.org/wiki/Doha"));
        citybt2.setOnAction(e->openWebpage("https://en.wikipedia.org/wiki/Islamabad"));
        citybt3.setOnAction(e->openWebpage("https://en.wikipedia.org/wiki/Dubai"));
        citybt4.setOnAction(e->openWebpage("https://en.wikipedia.org/wiki/New_York_City"));
        citybt5.setOnAction(e->openWebpage("https://en.wikipedia.org/wiki/London"));




        //scn10 contact us
        Image image101 = new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/top-view-frame-with-plane-sweets.jpg");
        ImageView imageView101=new ImageView(image101);
        Text text101= new Text("Contact Us ");
        text101.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 50;");
        text101.setY(150);
        text101.setX(700);
        Pane pane101 = new Pane();
        Image back101icon = new Image("file:/E:/algorithms%201/MyFx/src/main/java/com/example/myfx/left-arrow.png");
        ImageView imageView101back= new ImageView(back101icon);
        imageView101back.setFitWidth(30);
        imageView101back.setFitHeight(30);
        Button back101= new Button("Back" , imageView8back);
        back8.setGraphicTextGap(90);
        iconButton(back8);



        ImageView facebookImageView = new ImageView( new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/5305154_fb_facebook_facebook logo_icon.png"));
        ImageView twitterImageView = new ImageView(new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/11053969_x_logo_twitter_new_brand_icon.png"));
        ImageView instagramImageView = new ImageView(new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/5279112_camera_instagram_social media_instagram logo_icon.png"));
        ImageView emailImageView = new ImageView(new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/134147_mail_email_icon.png"));

        Button facebook= new Button();
        Button twitter= new Button();
        Button instagram= new Button();
        Button email= new Button();
        facebook.setGraphic(facebookImageView);
        twitter.setGraphic(twitterImageView);
        instagram.setGraphic(instagramImageView);
        email.setGraphic(emailImageView);
        facebookImageView.setFitHeight(15);
        facebookImageView.setFitWidth(15);
        twitterImageView.setFitHeight(15);
        twitterImageView.setFitWidth(15);
        instagramImageView.setFitHeight(15);
        instagramImageView.setFitWidth(15);
        emailImageView.setFitHeight(15);
        emailImageView.setFitWidth(15);
        facebook.setOnAction(e->openWebpage("https://www.facebook.com/"));
        twitter.setOnAction(e->openWebpage("https://twitter.com/home?lang=en"));
        instagram.setOnAction(e->openWebpage("https://www.instagram.com/"));
        email.setOnAction(e->openWebpage("https://mail.google.com/mail/u/0/#inbox"));



        Label facebookLabel = new Label("Facebook: facebook.com/BacataticAir");
        Label twitterLabel = new Label("Twitter: twitter.com/Bacatatic");
        Label instagramLabel = new Label("Instagram: instagram.com/Bacatatic");
        Label emailLabel = new Label("Email: BacataticAir@gmail.com");
        facebookLabel.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 10;");
        twitterLabel.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 10;");
        instagramLabel.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 10;");
        emailLabel.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 10;");


        facebook.setLayoutX(680);
        facebook.setLayoutY(160);
        facebookLabel.setLayoutX(720);
        facebookLabel.setLayoutY(165);

        twitter.setLayoutX(680);
        twitter.setLayoutY(190);
        twitterLabel.setLayoutX(720);
        twitterLabel.setLayoutY(195);

        instagram.setLayoutX(680);
        instagram.setLayoutY(220);
        instagramLabel.setLayoutX(720);
        instagramLabel.setLayoutY(225);

        email.setLayoutX(680);
        email.setLayoutY(250);
        emailLabel.setLayoutX(720);
        emailLabel.setLayoutY(255);








        pane101.getChildren().addAll(imageView101,text101,back101,facebook, twitter, instagram, email,
                facebookLabel, twitterLabel, instagramLabel, emailLabel);
        scn10= new Scene(pane101,1200,700);
        imageView101.fitWidthProperty().bind(scn10.widthProperty());
        imageView101.fitHeightProperty().bind(scn10.heightProperty());
        back101.setOnAction(e->stage.setScene(scn1));
        setHeight(back101);
        back101.setPrefWidth(200);
        back101.setLayoutX(700);
        back101.setLayoutY(400);

        setHoverCustomEffect(back101);
        button7.setOnAction(e->stage.setScene(scn10));

        //styling
        DropShadow shadow= new DropShadow();
        Text text10 = new Text("Bcatatic Air");
        Text text11= new Text("Batwings Beyond , Lunacy Unbound");
        text10.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 70;");
        text11.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 20;");

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
         scn1 = new Scene(pane, 1200, 700);
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

        button.setStyle("-fx-background-color: black; -fx-text-fill: yellow; -fx-background-radius: 0; -fx-font-size: 20px;");

        button.setOnMouseEntered(event -> {

            button.setStyle("-fx-background-color: purple; -fx-text-fill: yellow; -fx-background-radius: 0; -fx-font-size: 20px;");
        });

        button.setOnMouseExited(event -> {

            button.setStyle("-fx-background-color: black; -fx-text-fill: yellow; -fx-background-radius: 0; -fx-font-size: 20px;");
        });
    }
    private void iconButton(Button button) {
        Image backIcon = new Image("file:/E:/algorithms%201/MyFx/src/main/java/com/example/myfx/left-arrow.png");
        ImageView imageView = new ImageView(backIcon);


        double graphicTextGap = 90;

        // Set the width and height for the ImageView
        imageView.setFitWidth(24);
        imageView.setFitHeight(24);

        button.setGraphic(imageView);
        button.setGraphicTextGap(graphicTextGap);

        // Set the width and height for the button
        button.setPrefWidth(200);
        button.setPrefHeight(70);
    }
    private void setHoverCustomEffect(Button button) {

        button.setStyle("-fx-background-color: black; -fx-text-fill: yellow; -fx-background-radius: 15; -fx-border-radius: 15; -fx-font-size: 20px;");

        button.setOnMouseEntered(event -> {

            button.setStyle("-fx-background-color: purple; -fx-text-fill: yellow; -fx-background-radius: 15; -fx-border-radius: 15; -fx-font-size: 20px;");
        });

        button.setOnMouseExited(event -> {

            button.setStyle("-fx-background-color: black; -fx-text-fill: yellow; -fx-background-radius: 15; -fx-border-radius: 15; -fx-font-size: 20px;");
        });
    }
    private void openWebpage(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void setHeight(Button button) {
        button.setPrefHeight(70);
    }


    public static void main(String[] args) {
        launch(args);
    }

    }


