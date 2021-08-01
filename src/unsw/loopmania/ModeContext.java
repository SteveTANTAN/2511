package unsw.loopmania;
public class ModeContext {
    private ModeReq ModeReq;
    /**
     * constructor
     * @param ModeReq
     */
    public ModeContext(ModeReq ModeReq){
        this.ModeReq = ModeReq;
    }
    /**
     * set mode 
     * @param mode
     * @return
     */
    public Mode executeMode (String mode) {
        return ModeReq.setMode(mode);
    }
}