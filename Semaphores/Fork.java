package philosophersProblem.Semaphores;

/**
 * Created by brahim on 6/20/17.
 */
public class Fork {

    // the name of the fork
    private String name;

    //the valueof the semaphore
    private int value;

    //the last philosopher who used the fork (useful for eliminating philosopher starvation)
    private Philosophe philosopher;





    public Fork(String name){

       //initiated to 1 because only one philospher can use the fork at the same time
        value = 1;
        this.name = name;
    }



    public  synchronized void  take(Philosophe newPhilosopher) throws InterruptedException {

        while(value<=0 ||newPhilosopher.equals(this.philosopher)){
            System.out.println(newPhilosopher + ":it is not my turn to eat    :'(   ");
            wait();
        }
        this.philosopher = newPhilosopher;
        value --;
    }

    public synchronized void release(){
        value ++;
        if(value>0) notifyAll();
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
