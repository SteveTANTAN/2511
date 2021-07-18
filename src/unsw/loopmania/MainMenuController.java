package unsw.loopmania;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * controller for the main menu.
 * TODO = you could extend this, for example with a settings menu, or a menu to load particular maps.
 */
public class MainMenuController {
    /**
     * facilitates switching to main game
     */
    private MenuSwitcher gameSwitcher;
    public ModeReq mode_req;

    public void setGameSwitcher(MenuSwitcher gameSwitcher){
        this.gameSwitcher = gameSwitcher;
    }
    public ModeReq getMode_req() {
        return mode_req;
    }

    /**
     * facilitates switching to main game upon button click
     * @throws IOException
     */
    @FXML
    private void switchsurvival() throws IOException {
        mode_req = new ModeReq("survival");
        gameSwitcher.switchMenu();
    }

    /**
     * facilitates switching to main game upon button click
     * @throws IOException
     */
    @FXML
    private void switchBerserker() throws IOException {
        mode_req = new ModeReq("berserker");
        
        gameSwitcher.switchMenu();
    }

    /**
     * facilitates switching to main game upon button click
     * @throws IOException
     */
    @FXML
    private void switchStandard() throws IOException {
        mode_req = new ModeReq("Standard");
        
        gameSwitcher.switchMenu();
    }
}
