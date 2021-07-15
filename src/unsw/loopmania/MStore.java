package unsw.loopmania;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    private LoopManiaWorldController loopManiaWorldController;
    private ImageView[] buyImageView;
    private ImageView[] equippedImageView;
    private ImageView[] unequippedImageView;
    private VBox mBox;
    private enum ITEM_TYPE{
        ARMOUR, SHIELD, HELMET,STAKE,STAFF, SWORD,HEALTHPOTION, THEONERING, ARMOUR_SLOT, SHIELD_SLOT,HELMET_SLOT,SWORD_SLOT,EMPTY_SLOT
    };
    private Map<ITEM_TYPE,Image> itemsImages;
    static Image[] images = {
        new Image((new File("src/images/armour.png")).toURI().toString()),
        new Image((new File("src/images/shield.png")).toURI().toString()),
        new Image((new File("src/images/helmet.png")).toURI().toString()),
        new Image((new File("src/images/basic_sword.png")).toURI().toString()),
        new Image((new File("src/images/staff.png")).toURI().toString()),
        new Image((new File("src/images/stake.png")).toURI().toString()),
        new Image((new File("src/images/brilliant_blue_new.png")).toURI().toString()),
        new Image((new File("src/images/the_one_ring.png")).toURI().toString()),
        new Image((new File("src/images/amour_slot.png")).toURI().toString()),
        new Image((new File("src/images/helmet_slot.png")).toURI().toString()),
        new Image((new File("src/images/sword_unequipped.png")).toURI().toString()),
        new Image((new File("src/images/shield_unequipped.png")).toURI().toString()),
        new Image((new File("src/images/empty_slot.png")).toURI().toString())
    };

    public MStore(int x,int y, LoopManiaWorldController loopManiaWorldController){       
        // items
        itemsImages = new HashMap<>();
        itemsImages.put(ITEM_TYPE.ARMOUR, images[0]);
        itemsImages.put(ITEM_TYPE.SHIELD, images[1]);
        itemsImages.put(ITEM_TYPE.HELMET, images[2]);
        itemsImages.put(ITEM_TYPE.SWORD, images[3]);
        itemsImages.put(ITEM_TYPE.STAFF, images[4]);
        itemsImages.put(ITEM_TYPE.STAKE, images[5]);
        itemsImages.put(ITEM_TYPE.HEALTHPOTION, images[6]);
        itemsImages.put(ITEM_TYPE.THEONERING, images[7]);
        itemsImages.put(ITEM_TYPE.ARMOUR_SLOT, images[8]);
        itemsImages.put(ITEM_TYPE.HELMET_SLOT, images[9]);
        itemsImages.put(ITEM_TYPE.SWORD_SLOT, images[10]);
        itemsImages.put(ITEM_TYPE.SHIELD_SLOT, images[11]);
        itemsImages.put(ITEM_TYPE.EMPTY_SLOT, images[12]);

        buyImageView = new ImageView[7];
        equippedImageView = new ImageView[4];
        unequippedImageView = new ImageView[16];
        this.loopManiaWorldController = loopManiaWorldController;

        initBuyStage(x, y);
        initSellStage(x, y);
        currentStage = buyStage;

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
        Label title = new Label("STORE-Click to buy / sell");
        title.setFont(new Font(15));
        hBox.getChildren().add(title);
        box.getChildren().add(hBox);


        // items which can be bought
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(50);
        gridPane.setVgap(30);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2;j++){
                VBox vBox = new VBox();
                vBox.setAlignment(Pos.CENTER);
                buyImageView[i*2+j] = new ImageView();
                buyImageView[i*2+j].setImage(images[i*2+j]);
                vBox.getChildren().add(buyImageView[i*2+j]);
                Text text = new Text(str[i*2+j]);
                vBox.getChildren().add(text);
                gridPane.add(vBox, j, i);

                // set mouse click events
                buyImageView[i*2+j].setOnMouseClicked(new ImageViewClick(1, i*2+j,null));
            }
        }
        box.getChildren().add(gridPane);

        // health potion

        hBox = new HBox();
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        buyImageView[6] = new ImageView();
        buyImageView[6].setImage(images[6]);
        vBox.getChildren().add(buyImageView[6]);
        // set mouse click events
        buyImageView[6].setOnMouseClicked(new ImageViewClick(1, 6,null));
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
            loopManiaWorldController.startTimer();
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
        mBox = new VBox();
        mBox.setStyle("-fx-opacity: 0.9;");
        Scene scene = new Scene(mBox, width, height);
        scene.setFill(null);
        sellStage.initStyle(StageStyle.TRANSPARENT);
        sellStage.setScene(scene);

        // title
        HBox hBox = new HBox();
        hBox.setPrefHeight(100);
        hBox.setAlignment(Pos.CENTER);
        Label title = new Label("STORE-Click to buy / sell");
        title.setFont(new Font(15));
        hBox.getChildren().add(title);
        mBox.getChildren().add(hBox);


        // equipped
        GridPane equippedGridPane = new GridPane();
        equippedGridPane.setAlignment(Pos.CENTER);
        equippedImageView[0] = new ImageView();
        equippedImageView[0].setImage(itemsImages.get(ITEM_TYPE.HELMET_SLOT));
        equippedGridPane.add(equippedImageView[0], 1, 0);

        equippedImageView[1] = new ImageView();
        equippedImageView[1].setImage(itemsImages.get(ITEM_TYPE.SWORD_SLOT));
        equippedGridPane.add(equippedImageView[1], 0, 1);

        equippedImageView[2] = new ImageView();
        equippedImageView[2].setImage(itemsImages.get(ITEM_TYPE.SHIELD_SLOT));
        equippedGridPane.add(equippedImageView[2], 1, 1);

        equippedImageView[3] = new ImageView();
        equippedImageView[3].setImage(itemsImages.get(ITEM_TYPE.ARMOUR_SLOT));
        equippedGridPane.add(equippedImageView[3], 2, 1);
        mBox.getChildren().add(equippedGridPane);
        
        // unequipped
        GridPane unequippedGridPane = new GridPane();
        unequippedGridPane.setAlignment(Pos.CENTER);
        unequippedGridPane.setHgap(3);
        unequippedGridPane.setVgap(3);
        unequippedGridPane.setPadding(new Insets(40));
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                unequippedImageView[i*4+j] = new ImageView();
                unequippedImageView[i*4+j].setImage(itemsImages.get(ITEM_TYPE.EMPTY_SLOT));
                unequippedGridPane.add(unequippedImageView[i*4+j], j, i);
            }
        }
        mBox.getChildren().add(unequippedGridPane);
        
        // set mouse click events
        List<Entity> unequippedInventoryItems = loopManiaWorldController.getLoopManiaWorld().getUnequippedInventoryItems();
        for(int i = 0; i < 4; i++){
            equippedImageView[i].setOnMouseClicked(new ImageViewClick(2, i,unequippedInventoryItems));
        }
        for(int i = 0; i < 16; i++){
            unequippedImageView[i].setOnMouseClicked(new ImageViewClick(3, i,unequippedInventoryItems));
        }

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
            loopManiaWorldController.startTimer();
        });
        mBox.getChildren().add(gridPane);
    }

    /**
     * update items which can be sold
     */
    public void updateItemss(){
        // unequipped
        GridPane unequippedGridPane = new GridPane();
        unequippedGridPane.setAlignment(Pos.CENTER);
        List<Entity> unequippedInventoryItems = loopManiaWorldController.getLoopManiaWorld().getUnequippedInventoryItems();
        for(int i =  0; i < 16; i++){
            if(i < unequippedInventoryItems.size()){
                Entity entity = unequippedInventoryItems.get(i);
                if(entity instanceof Armour){
                    unequippedImageView[i].setImage(itemsImages.get(ITEM_TYPE.ARMOUR));
                }
                else if(entity instanceof Sword){
                    unequippedImageView[i].setImage(itemsImages.get(ITEM_TYPE.SWORD));
                }
                else if(entity instanceof Shield){
                    unequippedImageView[i].setImage(itemsImages.get(ITEM_TYPE.SHIELD));
                }
                else if(entity instanceof Helmet){
                    unequippedImageView[i].setImage(itemsImages.get(ITEM_TYPE.HELMET));
                }
                else if(entity instanceof Staff){
                    unequippedImageView[i].setImage(itemsImages.get(ITEM_TYPE.STAFF));
                }
                else if(entity instanceof Stake){
                    unequippedImageView[i].setImage(itemsImages.get(ITEM_TYPE.STAKE));
                }
                else if(entity instanceof TheOneRing){
                    unequippedImageView[i].setImage(itemsImages.get(ITEM_TYPE.THEONERING));
                }
            }else{
                unequippedImageView[i].setImage(itemsImages.get(ITEM_TYPE.EMPTY_SLOT));
            }
        }
    }
    
    /**
     * show the interface
     */
    public void show(){
        currentStage.show();
        // update items which can be sold
        updateItemss();
    }
    /**
     * close the interface
     */
    public void close(){
        currentStage.close();
        currentStage = buyStage;
    }

    /**
     * eventhandler used to respond to mouse click events
     */
    private  class ImageViewClick implements EventHandler<MouseEvent>{
        private int index = 0;
        private int type = 0;
        private List<Entity> unequippedInventoryItems;
        public ImageViewClick(int type, int index, List<Entity> unequippedInventoryItems){
            this.type = type;
            this.index = index;
            this.unequippedInventoryItems = unequippedInventoryItems;
        }
        @Override
        public void handle(MouseEvent e) {
            if(type == 1){       // buy items
                switch(index){
                    case 0:{     // armour

                        break;
                    }
                    case 1:{    // shield 
                        
                        break;
                    }
                    case 2:{    // helmet
                        
                        break;
                    } 
                    case 3:{    // sword
                        
                        break;
                    }
                    case 4:{    // staff
                        
                        break;
                    }
                    case 5:{    // stake
                        
                        break;
                    }
                    case 6:{    // health potion
                        
                        break;
                    }
                }
            }
            if(type == 2){     // sell equipped items

            }

            if(type == 3){     // sell unequipped items

            }
        }
        
    }
}
