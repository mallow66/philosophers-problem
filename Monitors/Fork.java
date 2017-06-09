package philosophersProblem.Monitors;

/**
 * Created by brahim on 6/9/17.
 */
public class Fork {

    private String name;
    private Boolean taken;

    public Fork(String name){
        this.name = name;
        this.taken= false;

    }



    public   void take() throws InterruptedException {
        while(taken){
           Thread.sleep(2);
        }
        synchronized (taken){taken = true;
        }




    }

    public   void release(){

        synchronized (taken){
            taken  = false;
        }


    }

    public boolean isTaken() {
        return taken;
    }

    @Override
    public String toString(){
        return name;
    }


}
