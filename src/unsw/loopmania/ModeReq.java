package unsw.loopmania;

public class ModeReq {
    public boolean healthPotion;
    public boolean armour;
    public boolean helmets;
    public boolean shields;
    public String mode;
    public ModeReq(String mode){
        this.mode = mode;
        this.healthPotion = false;
        this.armour = false;
        this.helmets = false;
        this.shields = false;
        if (mode.equals("survival")) {
            this.healthPotion = true;
            this.armour = false;
            this.helmets = false;
            this.shields = false;
        } else if (mode.equals("berserker")) {
            this.healthPotion = false;
            this.armour = true;
            this.helmets = true;
            this.shields = true;
        } else if (mode.equals("Standard")) {
            this.healthPotion = false;
            this.armour = false;
            this.helmets = false;
            this.shields = false;
        } 
    }

}