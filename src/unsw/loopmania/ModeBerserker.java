package unsw.loopmania;

public class ModeBerserker implements ModeReq{ 
    /**
     * set berserker mode 
     */
    @Override
    public Mode setMode(String mode) {
        Mode mode1 = new Mode(mode, false, true, true, true);
        return mode1;

    }
    
}
