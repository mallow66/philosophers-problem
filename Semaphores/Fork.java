package philosophersProblem.Semaphores;

/**
 * Created by brahim on 6/1/17.
 */
public class Fork {

    private String name;
    private int value;



    public Fork(String name){
        //Only one philosopher can eat with the fork at the same time ::
        value = 1;
        this.name = name;
    }


    //the philospher who gonna take the fork must wait until value > 0
    public  synchronized void  take() throws InterruptedException {
        while(value<=0){
            wait();
        }
        value --;
    }

    public synchronized void release(){
        value ++;
        if(value>0) notifyAll();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
