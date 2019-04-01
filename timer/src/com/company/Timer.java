package com.company;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Timer extends Application{
    Button start;
    Button stop;

    Label display;

    HBox container;

    BorderPane window = new BorderPane();

    Instant inceput;
    Instant sfarsit;

    public Instant a;
    public Instant b;

    public static List<Label> label = new ArrayList<>();

    public static laps lap = new laps();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TIMER");

        start = new Button("start");
        stop = new Button("stop");

        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                a = inceput.now();
                if(label.size()>0){
                    label.get(0).setText("");
                }
            }
        });
        stop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                b = sfarsit.now();
                Duration duration = Duration.between(a,b);

                long mil = duration.toMillis();
                long second = duration.getSeconds();

                String seconds = Long.toString(second);
                String milis = Long.toString(mil);

                String msg = seconds + "."+ milis + " seconds";
                if(label.size() < 1){
                    display = new Label(msg);
                    label.add(display);
                    container.getChildren().add(display);
                }
                else{
                    label.get(0).setText(msg);
                }
                String lapCount = Integer.toString(lap.labels.size()+1);
                lap.create("Lap "+lapCount+"=" + msg,window);
            }
        });

        container = new HBox(15);
        container.setStyle("-fx-background-color: #B1C7B4;");
        container.getChildren().addAll(start,stop);
        window.setTop(container);
        lap.generate_butons(window);
        Scene scene = new Scene(window,350,500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
