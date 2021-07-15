package unsw.loopmania;

import java.io.File;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MStore {
    private Stage buyStage;
    private Stage sellStage;
    private Stage currentStage;
    private Timeline timeline;
    static Image[] images = {
        new Image((new File("src/images/armour.png")).toURI().toString()),
        new Image((new File("src/images/shield.png")).toURI().toString()),
        new Image((new File("src/images/helmet.png")).toURI().toString()),
        new Image((new File("src/images/basic_sword.png")).toURI().toString()),
        new Image((new File("src/images/staff.png")).toURI().toString()),
        new Image((new File("src/images/stake.png")).toURI().toString()),
        new Image((new File("src/images/brilliant_blue_new.png")).toURI().toString())
    };
    public MStore(int x,int y, Timeline timeline){        
        initBuyStage(x, y);
        initSellStage(x, y);
        currentStage = buyStage;
        this.timeline = timeline;
    }
    /**
     * buy interface
     */
    public void initBuyStage(int x,int y){
        String[] str = {
            "20 gold","20 gold","20 gold","10 gold","15 gold","10 gold"
        };

        buyStage = new Stage();
        buyStage.setX(x);
        buyStage.setY(y);
        int width =  250;
        int height = 500;
        VBox box = new VBox();
        box.setStyle("-fx-opacity: 0.9;");
        Scene scene = new Scene(box, width, height);
        scene.setFill(null);
        buyStage.initStyle(StageStyle.TRANSPARENT);
        buyStage.setScene(scene);

        // title
        HBox hBox = new HBox();
        hBox.setPrefHeight(100);
        hBox.setAlignment(Pos.CENTER);
        Label title = new Label("STORE-Click to buy/sell");
        title.setFont(new Font(15));
        hBox.getChildren().add(title);
        box.getChildren().add(hBox);


        // equipments
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(50);
        gridPane.setVgap(30);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2;j++){
                VBox vBox = new VBox();
                vBox.setAlignment(Pos.CENTER);
                ImageView imageView = new ImageView();
                imageView.setImage(images[i*2+j]);
                vBox.getChildren().add(imageView);
                Text text = new Text(str[i*2+j]);
                vBox.getChildren().add(text);
                gridPane.add(vBox, j, i);
            }
        }
        box.getChildren().add(gridPane);

        // health potion

        hBox = new HBox();
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        ImageView imageView = new ImageView();
        imageView.setImage(images[6]);
        vBox.getChildren().add(imageView);
        Text text = new Text("10 gold");
        vBox.getChildren().add(text);
        hBox.getChildren().add(vBox);
        box.getChildren().add(hBox);


        // buttions
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(60);
        Button toSellBtn = new Button("To Buy");
        gridPane.add(toSellBtn, 0, 0);

        Button closeBtn = new Button("Close");
        gridPane.add(closeBtn, 1, 0);

        toSellBtn.setOnAction((ActionEvent e)->{
            sellStage.show();
            close();
            currentStage = sellStage;
        });
        closeBtn.setOnAction((ActionEvent e)->{
            close();
            timeline.play();
        });
        box.getChildren().add(gridPane);
    }
    /**
     * sell interface
     */
    public void initSellStage(int x,int y){
        sellStage = new Stage();
        sellStage.setX(x);
        sellStage.setY(y);
        int width =  250;
        int height = 500;
        VBox box = new VBox();
        box.setStyle("-fx-opacity: 0.9;");
        Scene scene = new Scene(box, width, height);
        scene.setFill(null);
        sellStage.initStyle(StageStyle.TRANSPARENT);
        sellStage.setScene(scene);

        // title
        HBox hBox = new HBox();
        hBox.setPrefHeight(100);
        hBox.setAlignment(Pos.CENTER);
        Label title = new Label("STORE-Click to buy/sell");
        title.setFont(new Font(15));
        hBox.getChildren().add(title);
        box.getChildren().add(hBox);


        // equipments
        



        // buttions
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(60);
        Button toSellBtn = new Button("To Sell");
        gridPane.add(toSellBtn, 0, 0);

        Button closeBtn = new Button("Close");
        gridPane.add(closeBtn, 1, 0);

        toSellBtn.setOnAction((ActionEvent e)->{
            buyStage.show();
            close();
            currentStage = buyStage;
        });
        closeBtn.setOnAction((ActionEvent e)->{
            close();
            timeline.play();
        });
        box.getChildren().add(gridPane);
    }

    
    public void show(){
        currentStage.show();
    }
    public void close(){
        currentStage.close();
    }
}
