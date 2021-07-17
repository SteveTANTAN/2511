package unsw.loopmania;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CardDescription {
    private Stage stage;
    private Label nameLabel;
    private Label descriptionLabel;
    /**
     * constructor
     * @param x x of position
     * @param y y of position
     */
    public CardDescription(int x, int y){
        stage = new Stage();
        stage.setX(x);
        stage.setY(y);
        int width =  350;
        int height = 300;
        VBox vBox = new VBox();
        nameLabel = new Label();
        descriptionLabel = new Label();
        vBox.getChildren().addAll(nameLabel, descriptionLabel);
        Scene scene = new Scene(vBox, width, height);
        scene.setFill(null);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
    }
    
    /**
     * show the stage
     * @param description description of the card
     */
    public void show(String name, String description){
        nameLabel.setText(name);
        descriptionLabel.setText(description);
        stage.show();
    }

    /**
     * close the stage
     */
    public void close(){
        stage.close();
    }
}
