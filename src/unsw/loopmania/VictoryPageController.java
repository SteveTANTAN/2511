package unsw.loopmania;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class VictoryPageController {
    
    @FXML
    private HBox exitGame;

    @FXML
    private Label infoLabel;

    private MenuSwitcher mainMenuSwitcher;    

    public void init(){
        exitGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                // exit game
                mainMenuSwitcher.switchMenu();
            }
		});
        infoLabel.setWrapText(true);
    }
    public void update(LoopManiaWorld world){
        infoLabel.setText(String.format("You have defeated %d slugs,%d zombies and %d vampires in %d rounds.", world.getSlugsNum(),
            world.getZombiesNum(),world.getVampiresNum(),world.getRoundsNum()));
    }
    public void setMainMenuSwitcher(MenuSwitcher mainMenuSwitcher){
        this.mainMenuSwitcher = mainMenuSwitcher;
    }
}
