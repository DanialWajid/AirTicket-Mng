package com.example.myfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Desktop;
import java.net.URI;



public class HelloApplication extends Application {
    Scene scn1, scn2, scn3, scn4, scn5, scn6, scn8, scn9, scn10, scn11,scn12;
    String selectedFlightNumber;
    ArrayList<Flight> flightlist = new ArrayList<>();
    ArrayList<Passenger> passengersList = new ArrayList<>();
    ArrayList<Ticket> TicketList = new ArrayList<>();
    ArrayList<Reservation> ReservationList = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Bcatatic Air Booking System");
////////////////////Scene 1/////////////////////////////////////////////////////////
        Button button0 = new Button();
        Button button1 = new Button("Booking");
        Button button2 = new Button("Flight Schedule");
        Button button3 = new Button("Give Feedback");
        Button button4 = new Button("Our reviews");
        Button button5 = new Button("About Us ");
        Button button6 = new Button("Our Destination");
        Button button7 = new Button("Contact Us");
        Button button8 = new Button("Cargo");

        GridPane pane1 = new GridPane();
        pane1.add(button0, 0, 0);
        pane1.add(button1, 1, 0);
        pane1.add(button2, 2, 0);
        pane1.add(button3, 3, 0);
        pane1.add(button4, 4, 0);

        scn1 = new Scene(pane1, 1200, 700);

        button1.setOnAction(e -> {
            displayForm(stage);


        });


        TableView tableView5 = new TableView<>();
        TableColumn<Flight, String> flightno = new TableColumn<>("Flight Number");
        flightno.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));

        TableColumn<Flight, String> DestinationAirport = new TableColumn<>("Destination Airport");
        DestinationAirport.setCellValueFactory(new PropertyValueFactory<>("destinationAirport"));

        TableColumn<Flight, String> DepartureAirport = new TableColumn<>("Departure Airport");
        DepartureAirport.setCellValueFactory(new PropertyValueFactory<>("departueAirport"));

        TableColumn<Flight, Date> ArrivalTime = new TableColumn<>("Arrival Time");
        ArrivalTime.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));

        TableColumn<Flight, Date> DepartureTime = new TableColumn<>("Departure Time");
        DepartureTime.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
        ArrayList<Airport> ArrivalAirportList = Airport.getArrivalAirports();
        ArrayList<Airport> DepartueAirportList = Airport.getDepartureAirports();
        Date df = new Date();
        int flightNumberCounter = 100;
        double[] flightDuration = {1.5, 2.6, 3.8, 9.8, 15.6, 17.9, 20.2, 5.7, 5.9, 8.34};
        for (int i = 0; i < ArrivalAirportList.size(); i++) {// Assigning unique flight number and flight duration to eacg flight
            for (int j = 0; j < DepartueAirportList.size(); j++) {
                double duration = flightDuration[flightNumberCounter % flightDuration.length];
                flightNumberCounter++;
                String flightNumber = "LH" + flightNumberCounter;
                flightlist.add(new Flight(flightNumber, df, df, duration, ArrivalAirportList.get(i).getAirportName(), DepartueAirportList.get(j).getAirportName()));
            }
        }

        tableView5.getColumns().addAll(flightno, DestinationAirport, DepartureAirport, ArrivalTime, DepartureTime);
        tableView5.setItems(FXCollections.observableArrayList(flightlist));

        Button back2 = new Button("Back");
        back2.setOnAction(e -> stage.setScene(scn1));
        VBox vBox5 = new VBox(tableView5, back2);
        scn5 = new Scene(vBox5, 1200, 700);


        button2.setOnAction(e -> {
            stage.setScene(scn5);
            System.out.println(flightlist.size());
        });
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //scene 6 feedback
        Label feedL1 = new Label("                  Passenger Name");
        TextField tx1 = new TextField();
        Label feedL2 = new Label("                           Rating");
        TextField tx2 = new TextField();
        Label feedL3 = new Label("                          Content");
        TextField tx3 = new TextField();
        Label feedL4 = new Label();
        GridPane pane6 = new GridPane();

        pane6.add(feedL1, 1, 0);
        pane6.add(tx1, 1, 1);
        pane6.add(feedL2, 1, 2);
        pane6.add(tx2, 1, 3);
        pane6.add(feedL3, 1, 4);
        pane6.add(tx3, 1, 5);
        pane6.add(feedL4, 1, 6);

        pane6.setHgap(5);
        pane6.setVgap(0);
        Button back3 = new Button("Back");
        back3.setOnAction(e -> stage.setScene(scn1));
        iconButton(back3);
        pane6.add(back3, 2, 6);
        scn6 = new Scene(pane6, 1200, 700);
        button3.setOnAction(e -> stage.setScene(scn6));
        Button feedsub = new Button("Submit");

        TableView<Feedback> tableView = new TableView<>();
        ArrayList<Feedback> feedbackList = new ArrayList<>();

        Label label61 = new Label("     Your feedback is valuable for us!");
        pane6.add(label61, 1, 7);

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

            } catch (NumberFormatException ex) {
                // Handling the exception for invalid input in the rating field
                ErrorAlertMethod("Error", "Invalid rating. Please enter a valid rating.");

                tx1.setText("");
                tx2.setText("");
                tx3.setText("");

            } catch (Exception ex) {
                // Handle other exceptions if needed
                ErrorAlertMethod("Error", "An unexpected error occurred.");
                ex.printStackTrace();
            }
        });

        Image image3 = new Image("file:/E://algorithms 1//MyFx//src//main//java//com//example//myfx//WhatsApp Image 2023-12-07 at 8.21.22 PM.jpeg");
        ImageView imageView3 = new ImageView(image3);
        Pane pane11 = new Pane();
        tx3.setStyle("-fx-padding: 0;");
        tx3.setStyle("-fx-margin: 0;");
        pane11.getChildren().addAll(imageView3, back3, feedsub, pane6);
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
        Button back7 = new Button("Back");
        tableView.getColumns().addAll(nameColumn, contentColumn, ratingColumn, dateColumn);
        tableView.getItems().addAll(feedbackList);
        VBox vbox = new VBox(tableView, back7);
        Scene scn7 = new Scene(vbox, 1200, 700);
        button4.setOnAction(e -> stage.setScene(scn7));
        setHeight(back7);
        back7.setPrefWidth(200);
        setHoverCustomEffect(back7);
        back7.setOnAction(e -> stage.setScene(scn1));
        tableView.setItems(FXCollections.observableArrayList(feedbackList));
        //scene 8
        Image image8 = new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/top-view-frame-with-plane-sweets.jpg");
        ImageView imageView8 = new ImageView(image8);
        Text text80 = new Text("About us ");
        text80.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 50;");
        Text airlineInfo1 = new Text(" Welcome aboard our airline!  We're all about making your travel experience extraordinary .");
        Text airlineInfo2 = new Text(" From the moment you step onto our planes,we're here to take you on a journey filled with ");
        Text airlineInfo3 = new Text("convenience, and a  touch of adventure. At our airline, we believe that flying should be");
        Text airlineInfo4 = new Text(" more than just a means of transportation . It should be a opportunity to explore new");
        Text airlineInfo5 = new Text("It should be a opportunity to explore new  horizons, connect with loved ones,and create");
        Text airlineInfo6 = new Text(" unforgettable memories. That's why we're committed to  providing top-notch service that");
        Text airlineInfo7 = new Text(" goes above and beyond your expectations.With a fleet of modern and reliable aircraft, we");
        Text airlineInfo8 = new Text(" prioritize your safety above all.");
        airlineInfo1.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");
        airlineInfo2.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");
        airlineInfo3.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");
        airlineInfo4.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");
        airlineInfo5.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");
        airlineInfo6.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");
        airlineInfo7.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");
        airlineInfo8.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");


        text80.setFont(Font.font("Serif", 50));
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
        ImageView imageView8back = new ImageView(back8icon);
        imageView8back.setFitWidth(30);
        imageView8back.setFitHeight(30);
        Button back8 = new Button("Back", imageView8back);
        Button next8= new Button("Next");
        setHoverCustomEffect(next8);
        back8.setGraphicTextGap(90);
        pane8.getChildren().addAll(imageView8, back8,next8, text80, airlineInfo1, airlineInfo2, airlineInfo3, airlineInfo4, airlineInfo5, airlineInfo6, airlineInfo7, airlineInfo8);
        scn8 = new Scene(pane8, 1200, 700);
        imageView8.fitWidthProperty().bind(scn8.widthProperty());
        imageView8.fitHeightProperty().bind(scn8.heightProperty());
        back8.setOnAction(e -> stage.setScene(scn1));
        setHeight(back8);
        back8.setPrefWidth(200);
        back8.setLayoutX(700);
        back8.setLayoutY(400);
        next8.setPrefWidth(200);
        next8.setPrefHeight(70);
        next8.setLayoutX(1000);
        next8.setLayoutY(400);
        setHoverCustomEffect(back8);
        next8.setOnAction(e->stage.setScene(scn12));


        button5.setOnAction(e -> stage.setScene(scn8));
        //scene9
        Image image91 = new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/top-view-frame-with-plane-sweets.jpg");
        ImageView imageView91 = new ImageView(image91);
        Image back91icon = new Image("file:/E:/algorithms%201/MyFx/src/main/java/com/example/myfx/left-arrow.png");
        ImageView imageView91back = new ImageView(back91icon);
        imageView91back.setFitWidth(30);
        imageView91back.setFitHeight(30);
        Button back91 = new Button("Back", imageView8back);
        back91.setGraphicTextGap(90);
        setHoverCustomEffect(back91);
        setHeight(back91);
        Button citybt1 = new Button();
        Button citybt2 = new Button();
        Button citybt3 = new Button();
        Button citybt4 = new Button();
        Button citybt5 = new Button();
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

        Text text91 = new Text("Click for Details ");
        text91.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 50;");

        text91.setY(150);
        text91.setX(700);


        Pane pane9 = new Pane();
        pane9.getChildren().addAll(imageView91, back91, text91, citybt1, citybt2, citybt3, citybt4, citybt5);
        scn9 = new Scene(pane9, 1200, 700);
        imageView91.fitHeightProperty().bind(scn9.heightProperty());
        imageView91.fitWidthProperty().bind(scn9.widthProperty());
        button6.setOnAction(e -> stage.setScene(scn9));
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
        back91.setOnAction(e -> stage.setScene(scn1));
        iconButton(back91);
        citybt1.setOnAction(e -> openWebpage("https://en.wikipedia.org/wiki/Doha"));
        citybt2.setOnAction(e -> openWebpage("https://en.wikipedia.org/wiki/Islamabad"));
        citybt3.setOnAction(e -> openWebpage("https://en.wikipedia.org/wiki/Dubai"));
        citybt4.setOnAction(e -> openWebpage("https://en.wikipedia.org/wiki/New_York_City"));
        citybt5.setOnAction(e -> openWebpage("https://en.wikipedia.org/wiki/London"));


        //scn10 contact us
        Image image101 = new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/top-view-frame-with-plane-sweets.jpg");
        ImageView imageView101 = new ImageView(image101);
        Text text101 = new Text("Contact Us ");
        text101.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 50;");
        text101.setY(150);
        text101.setX(700);
        Pane pane101 = new Pane();
        Image back101icon = new Image("file:/E:/algorithms%201/MyFx/src/main/java/com/example/myfx/left-arrow.png");
        ImageView imageView101back = new ImageView(back101icon);
        imageView101back.setFitWidth(30);
        imageView101back.setFitHeight(30);
        Button back101 = new Button("Back", imageView8back);
        back8.setGraphicTextGap(90);
        iconButton(back8);


        ImageView facebookImageView = new ImageView(new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/5305154_fb_facebook_facebook logo_icon.png"));
        ImageView twitterImageView = new ImageView(new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/11053969_x_logo_twitter_new_brand_icon.png"));
        ImageView instagramImageView = new ImageView(new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/5279112_camera_instagram_social media_instagram logo_icon.png"));
        ImageView emailImageView = new ImageView(new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/134147_mail_email_icon.png"));

        Button facebook = new Button();
        Button twitter = new Button();
        Button instagram = new Button();
        Button email = new Button();
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
        facebook.setOnAction(e -> openWebpage("https://www.facebook.com/"));
        twitter.setOnAction(e -> openWebpage("https://twitter.com/home?lang=en"));
        instagram.setOnAction(e -> openWebpage("https://www.instagram.com/"));
        email.setOnAction(e -> openWebpage("https://mail.google.com/mail/u/0/#inbox"));


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


        pane101.getChildren().addAll(imageView101, text101, back101, facebook, twitter, instagram, email,
                facebookLabel, twitterLabel, instagramLabel, emailLabel);
        scn10 = new Scene(pane101, 1200, 700);
        imageView101.fitWidthProperty().bind(scn10.widthProperty());
        imageView101.fitHeightProperty().bind(scn10.heightProperty());
        back101.setOnAction(e -> stage.setScene(scn1));
        setHeight(back101);
        back101.setPrefWidth(200);
        back101.setLayoutX(700);
        back101.setLayoutY(400);

        setHoverCustomEffect(back101);
        button7.setOnAction(e -> stage.setScene(scn10));

        //Scene 11
        Image image111 = new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/top-view-frame-with-plane-sweets.jpg");
        ImageView imageView111 = new ImageView(image101);
        Label l000= new Label("");
        Label l111 = new Label("Enter Parcel Weight ");
        TextField t111 = new TextField();
        ObservableList<String> destination = FXCollections.observableArrayList();
        destination.add("islamabad");
        destination.add("london");
        destination.add("newyork");
        destination.add("doha");
        destination.add("dubai");

        ObservableList<String> origin = FXCollections.observableArrayList();
        origin.add("lahore");
        origin.add("faisalabad");
        origin.add("karachi");
        origin.add("multan");

        ComboBox comboBox111 = new ComboBox(destination);
        ComboBox comboBox112 = new ComboBox(origin);
        comboBox112.setPromptText("Select Origin");
        comboBox111.setPromptText("Select Destination");
        RadioButton r111 = new RadioButton("Fast Track");
        RadioButton r112 = new RadioButton("Regular");
        ToggleGroup tg111 = new ToggleGroup();
        r111.setToggleGroup(tg111);
        r112.setToggleGroup(tg111);
        GridPane pane111 = new GridPane();
        Text t1113= new Text("Bacatatic Cargo");
        Text t1114 = new Text("Batwings Beyond , Lunacy Unbound");
        t1113.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 70;");
        t1114.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 20;");
        pane111.add(t1113,4,6);
        pane111.add(t1114,4,7);

        pane111.add(l000,5,8);
        pane111.add(l111, 6, 10);
        setDefaultFont(l111);
        pane111.add(t111, 7, 10);
        pane111.add(r111, 7, 12);
        pane111.add(r112, 7, 14);
        pane111.add(comboBox111, 7, 16);
        pane111.add(comboBox112, 7, 18);

        Button back111 = new Button("Back");
        Button submit111 = new Button("Calculate");
        pane111.add(back111, 7, 19);
        pane111.add(submit111, 7, 25);


        setHoverCustomEffect(back111);
        StackPane sp111 = new StackPane();
        sp111.getChildren().addAll(imageView111, pane111);
        Label l113= new Label("Visit our offices to book your cargo");
        Label l114= new Label("> Lahore");
        Label l115= new Label("> Islamabad");
        Label l116= new Label("> Karachi");
        Label l117= new Label("> Multan");
        Label l118= new Label("> New York");
        Label l119= new Label("> London ");
        Label l1110= new Label("> Faisalabad");
        Label l1111= new Label("> Doha");
        Label l1112= new Label("> Dubai");

        pane111.add(l113,20,1);
        pane111.add(l114,22,2);
        pane111.add(l115,22,3);
        pane111.add(l116,22,4);
        pane111.add(l117,22,5);
        pane111.add(l118,22,6);
        pane111.add(l119,22,7);
        pane111.add(l1110,22,8);
        pane111.add(l1111,22,9);
        pane111.add(l1112,22,10);

        setDefaultFont(l1111);
        setDefaultFont(l1112);

        setDefaultFont(l113);
        setDefaultFont(l114);
        setDefaultFont(l115);
        setDefaultFont(l116);
        setDefaultFont(l117);
        setDefaultFont(l118);
        setDefaultFont(l119);
        setDefaultFont(l1110);


        scn11 = new Scene(sp111, 700, 700);
        setHoverCustomEffect(submit111);
        imageView111.fitHeightProperty().bind(scn11.heightProperty());
        imageView111.fitWidthProperty().bind(scn11.widthProperty());
        back111.setOnAction(e->stage.setScene(scn1));
        submit111.setOnAction(e -> {
            String dest = null;
            double weight = 0;
            boolean type = false;
            String origi = null;

            try {
                weight = Double.parseDouble(t111.getText());
                dest = comboBox111.getValue().toString();
                origi = comboBox112.getValue().toString();
                RadioButton selectedtype = (RadioButton) tg111.getSelectedToggle();
                type = Boolean.parseBoolean(selectedtype.getText());
                Label l112 = new Label("Your Fare will be ");
                Text fare = new Text();
                double f = Cargo.cargofare(weight, dest, type, origi);
                fare.setText(Double.toString(f));
                pane111.add(l112, 7, 20);
                pane111.add(fare, 7, 22);
                t111.setText("");
                if (weight < 1 || weight > 100) {
                    throw new InvalidWeightException("Weight must be between 1-100kg");
                }


            } catch (NumberFormatException | InvalidWeightException o) {
                ErrorAlertMethod("Error !", "Enter valid weight (1-100kg)");
                o.printStackTrace();
                t111.setText("");
            } catch (Exception eo) {
                ErrorAlertMethod("Error", "fill all the field please");
                eo.printStackTrace();
            }


        });
        //scene12
        Image image121 = new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/top-view-frame-with-plane-sweets.jpg");
        ImageView imageView121 = new ImageView(image101);
        ImageView hitlerview= new ImageView(new Image("file:E:/algorithms 1/MyFx/src/main/java/com/example/myfx/hitler.jpg"));
        Button hitler= new Button("Back");
        setHoverCustomEffect(hitler);

        hitlerview.setFitWidth(300);
        hitlerview.setFitHeight(500);
//        hitler.setPrefHeight(200);
//        hitler.setPrefWidth(200);
        Text t121= new Text("Our Founder's Vision");
        Text t122= new Text("Today our world suffers from a cancer called Zionism . It is my dream to create an Airline ");
        Text t123= new Text("named Bacatatic Air . This airline will provide safe and comfortable airtravel to anti-semites .");
        Text t124= new Text("Special discounts will be provided to anti-semites and jews are not welcome here . I am not ashamed ");
        Text t125= new Text("of my action against the jews . what i did is a blessing to all mankind . Killing the jews in the gas ");
        Text t126= new Text("Chamber was the best part of it . So grab your nearest jew and gas him !");
        Text t127= new Text("----Adolf Hitler (late) ");
        Text t128= new Text("Disclaimer ! No jews were hurt in the development of the System (except Kanz-ul-Eman)");
       t121.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 30;");
       t122.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 15;");
       t123.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 15;");
       t124.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 15;");
       t125.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 15;");
       t126.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 15;");
       t127.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12;");
        t128.setStyle("-fx-font-family: 'Lucida Handwriting'; -fx-font-size: 12; -fx-text-fill: red;");
        t128.setFill(Color.RED);

        t121.setX(500);
        t121.setY(190);
        t122.setX(500);
        t122.setY(210);
        t123.setX(500);
        t123.setY(230);
        t124.setX(500);
        t124.setY(250);
        t125.setX(500);
        t125.setY(270);
       t126.setX(500);
       t126.setY(290);
        t127.setX(500);
        t127.setY(310);
        t128.setX(500);
        t128.setY(330);
        hitler.setLayoutY(370);
        hitler.setLayoutX(500);
//
        StackPane.setMargin(hitlerview, new Insets(0, 750, 0, 0));
        hitler.setOnAction(e->stage.setScene(scn1));



Pane pane121= new Pane(t121,t122,t123,t124,t125,t126,t127,t128,hitler);
StackPane sp121= new StackPane(imageView121,hitlerview,pane121);
scn12= new Scene(sp121,700,700);
imageView121.fitWidthProperty().bind(scn12.widthProperty());
imageView121.fitHeightProperty().bind(scn12.heightProperty());





        //styling
        DropShadow shadow = new DropShadow();
        Text text10 = new Text("Bcatatic Air");
        Text text11 = new Text("Batwings Beyond , Lunacy Unbound");
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
        button8.setLayoutY(600);
        button8.setLayoutX(1000);
        setHoverCustomEffect(button8);
        setHeight(button8);
        button8.setPrefWidth(314);
        button8.setOnAction(e->stage.setScene(scn11));




        Image image = new Image("file:/E://algorithms 1//MyFx//src//main//java//com//example//myfx//top-view-frame-with-plane-sweets.jpg");
        ImageView imageView = new ImageView(image);
        Pane pane = new Pane();
        pane.getChildren().addAll(imageView, text11, text10, button5, button6, button7, button8, pane1);
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

    private Flight getSelectedFlight(String flightNumber, ArrayList<Flight> flightlist) {
        for (Flight flight : this.flightlist) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }
    private void ErrorAlertMethod(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText("Error!");
        alert.setContentText(content);
        alert.show();
    }

    public void displayForm(Stage stage){

        Label label1 = new Label("Name :");
        TextField tf1 = new TextField();
        Label label2 = new Label("Age :");
        TextField tf2 = new TextField();
        Label label3 = new Label("Email:");
        TextField tf3 = new TextField();
        Label label4 = new Label("Phone:");
        TextField tf4 = new TextField();
        Label label5 = new Label("Ticket Class:");
        RadioButton rbt1 = new RadioButton("Economy");
        RadioButton rbt2 = new RadioButton("FirstClass");
        RadioButton rbt3 = new RadioButton("Business");
        ToggleGroup toggleGroup = new ToggleGroup();
        rbt1.setToggleGroup(toggleGroup);
        rbt2.setToggleGroup(toggleGroup);
        rbt3.setToggleGroup(toggleGroup);
        Label label6 = new Label("Enter Departure Airport:");
        String[] departureList = {"Allama Iqbal Airport", "Jinnah International", "Multan International", "Faisalabad International"};
        ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(departureList));
        combo_box.setPromptText("Select Airport");
        Button submitForm = new Button("Submit form"); // submit 1 of combobox
        Button backForm = new Button("Back form");
        setHoverCustomEffect(submitForm);
        setHoverCustomEffect(backForm);


        GridPane pane2= new GridPane();
        pane2.getChildren().clear();
        pane2.setVgap(5);
        pane2.setHgap(5);
        pane2.add(label1, 0, 0);
        pane2.add(tf1, 1, 0);
        pane2.add(label2, 0, 1);
        pane2.add(tf2, 1, 1);
        pane2.add(label3, 0, 2);
        pane2.add(tf3, 1, 2);
        pane2.add(label4, 0, 3);
        pane2.add(tf4, 1, 3);
        pane2.add(label5, 0, 4);
        pane2.add(rbt1, 1, 4);
        pane2.add(rbt2, 2, 4);
        pane2.add(rbt3, 3, 4);
        pane2.add(label6, 0, 5);
        pane2.add(combo_box, 1, 5);
        pane2.add(submitForm, 1, 6);
        pane2.add(backForm, 0, 6);



        backForm.setOnAction(e ->{
            pane2.getChildren().clear();
            stage.setScene(scn1);
        });

        submitForm.setOnAction(e -> {


            String name = tf1.getText();
            String ageText = tf2.getText();
            String email = tf3.getText();
            String phoneText = tf4.getText();

            if (name.isEmpty() || ageText.isEmpty() || email.isEmpty() || phoneText.isEmpty()) {
                ErrorAlertMethod("Empty Fields", "Please fill in all the required fields.");
                return;
            }

            int age;
            try {
                age = Integer.parseInt(ageText);
                if (age < 18) {
                    ErrorAlertMethod("Invalid Age", "Please enter a valid age (age should be greater than 18.");
                    return;
                }
            } catch (NumberFormatException ex) {
                ErrorAlertMethod("Invalid Age", "Please enter a valid age.");
                return;
            }

            Long phone;
            try {
                phone = Long.parseLong(phoneText);
                if (phone < 1999999999) {
                    ErrorAlertMethod("Invalid Phone Number", "Please enter a valid phone number(11 digit).");
                    return;
                }
            } catch (NumberFormatException ex) {
                ErrorAlertMethod("Invalid Phone Number", "Please enter a valid phone number (non-negative integer).");
                return;
            }
            displayDepartureSchedule(stage,combo_box,toggleGroup,tf1,tf2,tf3,tf4);
        });
        Image image2 = new Image("file:/E://algorithms 1//MyFx//src//main//java//com//example//myfx//WhatsApp Image 2023-12-07 at 8.21.22 PM.jpeg");
        ImageView imageView2 = new ImageView(image2);
        StackPane pane21 = new StackPane();
        pane21.getChildren().addAll(imageView2,pane2);
        setDefaultFont(label1);
        setDefaultFont(label2);
        setDefaultFont(label3);
        setDefaultFont(label4);
        setDefaultFont(label5);
        setDefaultFont(label6);


        scn2 = new Scene(pane21, 1200, 700);
        imageView2.fitWidthProperty().bind(scn2.widthProperty());
        imageView2.fitHeightProperty().bind(scn2.heightProperty());
        stage.setScene(scn2);
    }

    public void displayDepartureSchedule(Stage stage,ComboBox combo_box,ToggleGroup toggleGroup,TextField tf1,TextField tf2,TextField tf3,TextField tf4){

        GridPane pane3 = new GridPane();
        pane3.setVgap(10);
        pane3.setHgap(10);
        Label l51 = new Label("Flight number");
        Label l52 = new Label("Flight Departure");
        Label l53 = new Label("Flight Destination");
        Label l54 = new Label("Flight Departure Time");
        Label l55 = new Label("Flight Arrival Time");
        pane3.add(l51,0,0);
        pane3.add(l52,1,0);
        pane3.add(l53,2,0);
        pane3.add(l54,3,0);
        pane3.add(l55,4,0);

        int counter = 1;
        for (int i = 0; i < flightlist.size(); i++) {
            if (flightlist.get(i).getDepartueAirport().equals(combo_box.getValue().toString())) {
                System.out.println(i);
                String flightNumber = flightlist.get(i).getFlightNumber();
                String destinationAirport = flightlist.get(i).getDestinationAirport();
                Date arrivalTime = flightlist.get(i).getArrivalTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate1 = dateFormat.format(arrivalTime);
                Date departureTime = flightlist.get(i).getDepartureTime();
                String formattedDate2 = dateFormat.format(departureTime);
                Label lbl0 = new Label();
                Label lbl1 = new Label();
                Label lbl2 = new Label();
                Label lbl3 = new Label();
                Label lbl4 = new Label();

                lbl0.setText(flightNumber);
                lbl1.setText(flightlist.get(i).getDepartueAirport());
                lbl2.setText(destinationAirport);
                lbl3.setText(formattedDate1);
                lbl4.setText(formattedDate2);

                pane3.add(lbl0, 0, counter);
                pane3.add(lbl1, 1, counter);
                pane3.add(lbl2, 2, counter);
                pane3.add(lbl3, 3, counter);
                pane3.add(lbl4, 4, counter);
                counter++;
            }
        }
        Label l56 = new Label("Enter Flight Number you want :");
        TextField txt56=new TextField();
        pane3.add(l56,0,counter+1);
        pane3.add(txt56,1,counter+1);


        Button backFlight = new Button("Back flight");
        Button  submitFlight = new Button("submit flight");
        pane3.add(backFlight, 0, counter+2);
        pane3.add(submitFlight, 1, counter+2);

        Label l57 = new Label("Flight Duration: ");//display flight duration
        Label l58= new Label("Total Fare: ");///display fare
        Button print= new Button("Print Ticket");
        pane3.add(l57,0,counter+5);
        pane3.add(l58,0,counter+6);
        pane3.add(print,0,counter+7);
        l57.setVisible(false);
        l58.setVisible(false);
        print.setVisible(false);

        backFlight.setOnAction(e -> {
            pane3.getChildren().clear();
            displayForm(stage);
        });

        int finalCounter = counter;
        submitFlight.setOnAction(e -> {

            String passname = tf1.getText();
            int ageText = Integer.parseInt(tf2.getText());
            String email = tf3.getText();
            Long phone = Long.valueOf(tf4.getText());
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            String ticketClass = selectedRadioButton.getText();

            selectedFlightNumber = txt56.getText();
            String selectedDepartureAirport = combo_box.getValue().toString();
            if (selectedDepartureAirport == null || selectedDepartureAirport.isEmpty()) {
                ErrorAlertMethod("Invalid Departure Airport", "Please select a departure airport first.");
                return;
            }
            Flight selectedFlight = getSelectedFlight(selectedFlightNumber, flightlist);
            if (selectedFlight == null || !selectedFlight.getDepartueAirport().equalsIgnoreCase(selectedDepartureAirport)) {
                ErrorAlertMethod("Invalid Flight Number", "Please enter a valid flight number for the selected departure airport.");
                return;
            }

            Passenger newPassenger = new Passenger(passname,email,phone,ageText,ticketClass);
            passengersList.add(newPassenger);
            Ticket newTicket = new Ticket("LH00000092",passengersList,flightlist);
            TicketList.add(newTicket);

            selectedFlight = getSelectedFlight(selectedFlightNumber, flightlist);
            if (selectedFlight != null) {

                double fare = Ticket.handleTicketClass(passname, email, phone, ageText, ticketClass, selectedFlight.getFlightDuration());

                print.setVisible(true);
                l57.setVisible(true);
                l58.setVisible(true);

                Label lblDuration = new Label();
                String flightduration = String.valueOf(selectedFlight.getFlightDuration());
                lblDuration.setText(flightduration);
                pane3.add(lblDuration, 1, finalCounter +5);
                Label lblFare = new Label();
                lblFare.setText("$ "+(fare));
                pane3.add(lblFare, 1, finalCounter +6);

            } else {
                // Handle case where the selected flight is not found
                System.out.println("Selected flight not found");
            }


        });

        print.setOnAction(e -> {
            printTicket(stage);
            stage.setScene(scn4);
        });
        Image image3 = new Image("file:/E://algorithms 1//MyFx//src//main//java//com//example//myfx//WhatsApp Image 2023-12-07 at 8.21.22 PM.jpeg");
        ImageView imageView3 = new ImageView(image3);
        StackPane pane31 = new StackPane();
        pane31.getChildren().addAll(imageView3,pane3);
        scn3= new Scene(pane31,750,650);
        imageView3.fitHeightProperty().bind(scn3.heightProperty());
        imageView3.fitWidthProperty().bind(scn3.widthProperty());
        setHoverCustomEffect(backFlight);
        setHoverCustomEffect(submitFlight);
        setHoverCustomEffect(print);
        stage.setScene(scn3);

    }
    private void setDefaultFont(Label label) {
        String defaultFontFamily = "Lucida Handwriting";
        double defaultFontSize = 13;

        label.setStyle(
                "-fx-font-family: '" + defaultFontFamily + "'; " + "-fx-font-size: " + defaultFontSize + "px;"
        );
    }

    public void printTicket(Stage stage){
        Label lf0= new Label("");
        Label lf1= new Label("");
        Label lb1 = new Label();
        Label lf2= new Label("");
        Label lb2 = new Label();
        Label lf3= new Label("");
        Label lb3 = new Label();
        Label lf4= new Label("");
        Label lb4 = new Label();
        Label lf5= new Label("");
        Label lb5 = new Label();
        Label lf6= new Label("");
        Label lb6 = new Label();
        Label lf7 = new Label("");
        Label lb7 = new Label();
        Label lf8 = new Label("");
        Label lb8 = new Label();
        Label lf9 = new Label("");
        Label lb9 = new Label();
        setDefaultFont(lf1);
        setDefaultFont(lf2);
        setDefaultFont(lf3);
        setDefaultFont(lf4);
        setDefaultFont(lf5);
        setDefaultFont(lf6);
        setDefaultFont(lf7);
        setDefaultFont(lf8);
        setDefaultFont(lf9);
        Reservation newReservation = new Reservation("LH00000092", flightlist, passengersList, TicketList);
        ReservationList.add(newReservation);
        for (Reservation res : ReservationList) {
            for (Passenger passenger : res.getPassengersList()) {
                for (Flight flight : res.getFlightList()) {
                    if (selectedFlightNumber.equalsIgnoreCase(flight.getFlightNumber())) {
                        lb1.setText(flight.getFlightNumber());

                        lb3.setText(flight.getDepartueAirport());
                        lb4.setText(flight.getDestinationAirport());
                        lb5.setText(newReservation.getReservationNumber());
                        lb6.setText(passenger.getName());
                        LocalDate currentDate = LocalDate.now();
                        lb7.setText(currentDate.toString());
                        lb8.setText(currentDate.toString());
                        lb9.setText(passenger.getTicketClass());
                    }
                }
            }
        }

        GridPane pane4= new GridPane();
        pane4.setVgap(5);
        pane4.setHgap(10);
        pane4.add(lf0,0,0);
        pane4.add(lf1,0,1);
        pane4.add(lb1,28,21);
        pane4.add(lf2,0,3);
        pane4.add(lb2,0,4);
        pane4.add(lf3,0,5);
        pane4.add(lb3,19,26);
        pane4.add(lf4,0,0);
        pane4.add(lb4,19,31);
        pane4.add(lf5,0,9);
        pane4.add(lb5,40,21);
        pane4.add(lf6,0,11);
        pane4.add(lb6,19,21);
        pane4.add(lf7,0,13);
        pane4.add(lb7,36,31);
        pane4.add(lf8,0,15);
        pane4.add(lb8,36,26);
        pane4.add(lf9,0,17);
        pane4.add(lb9,36,21);
        Button exit = new Button("Exit");
        pane4.add(exit,0,30);
        setDefaultFont(lf0);


        setHoverCustomEffect(exit);
        Image image4 = new Image("file:/E://algorithms 1//MyFx//src//main//java//com//example//myfx//WhatsApp Image 2023-12-07 at 8.21.22 PM.jpeg");
        ImageView imageView4= new ImageView(image4);
        Image image42= new Image("file:/E://algorithms 1//MyFx//src//main//java//com//example//myfx//42192421.jpg/");
        ImageView imageView42= new ImageView(image42);

        StackPane pane41= new StackPane();
        pane41.getChildren().addAll(imageView4,imageView42,pane4);
        scn4 = new Scene(pane41,750,650);


        exit.setOnAction(e ->{
            pane4.getChildren().clear();
            stage.setScene(scn1);
        });


    }
}