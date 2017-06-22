package philosophersProblem.Monitors;

/**
 * Created by brahim on 6/20/17.
 */
public class Fork {

    private String name;
    //si la Fork est occupé ou non
    private boolean busy;
    //refer to the last philosopher who used the fork
    private Philosopher lastUse;


    public Fork(String name){
        this.name = name;
        busy = false;
        lastUse = null;
    }





    public synchronized boolean isBusy(){
        return busy;
    }

    public synchronized boolean lastUsedBy(Philosopher philosopher){
        if(lastUse == null)
            return false;
        return this.lastUse.equals(philosopher);
    }

    public synchronized void take(){
        busy = true;
    }

    public  synchronized void release(Philosopher philosophe){
        busy = false;
        this.lastUse = philosophe;
    }

    @Override
    public String toString(){
        return name;
    }

}
