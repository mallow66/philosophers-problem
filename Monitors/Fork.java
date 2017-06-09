package philosophersProblem.Monitors;

/**
 * Created by brahim on 6/9/17.
 */
public class Fork {

    private String name;
    private boolean taken;

    public Fork(String name){
        this.name = name;
        this.taken= false;
    }



    public synchronized void take(){
        taken = true;
    }

    public synchronized void release(){
        taken = false;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}
