package philosophersProblem.Semaphores;

/**
 * Created by brahim on 6/1/17.
 */
public class Fork {

    private String name;
    private int value;
    private long currentTime;





    public Fork(String name){
        //Only one philosopher can eat with the fork at the same time ::
        value = 1;
        this.name = name;
    }


    //the philospher who gonna take the fork must wait until value > 0
    public  synchronized void  take() throws InterruptedException {
        currentTime = System.currentTimeMillis();
        while(value<=0){
            wait();
            if(System.currentTimeMillis() - currentTime > 10000){
                notifyAll();
                System.out.println("just released the fork beceause of the starvation");
                //wait 1s to retake the fork
                Thread.sleep(1000);
                take();
                System.out.println("Just retaked the fork !");
                return;
            }

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
