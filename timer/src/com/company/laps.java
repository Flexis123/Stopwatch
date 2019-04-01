package com.company;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import java.util.List;
import java.util.ArrayList;

public class laps{
    public static List<Label> labels = new ArrayList<>();
    VBox lap_container = new VBox(10);
    VBox del = new VBox(10);
    Label lap;


    public void create(String msg, BorderPane window){
        lap = new Label(msg);
        lap_container.getChildren().add(lap);
        lap_container.setStyle("-fx-background-color: #84939B;");
        labels.add(lap);
        window.setRight(lap_container);
    }
    public void delete(int amount){
        int until = labels.size()-(amount+1);

        for(int i = labels.size()-1; i >= until; i--){
            lap_container.getChildren().remove(labels.get(i));
            labels.remove(i);
        }
    }
    public void generate_butons(BorderPane window){
        Button delete = new Button("delete");
        Button deleteAll = new Button("delete all");

        delete.setOnAction(e -> delete(0));
        deleteAll.setOnAction(e -> delete(labels.size()-1));

        del.getChildren().addAll(delete,deleteAll);
        del.setStyle("-fx-background-color: #232724;");
        window.setCenter(del);
    }
}
