package philosophersProblem.Monitors;

/**
 * Created by brahim on 6/9/17.
 */
public class Philosopher extends Thread {

    public enum State{THINK, EAT }

    private String name;
    private Fork rightFork;
    private Fork leftFork;
    private State state;


    private Philosopher rightPhilosopher, leftPhilosopher;

    public Philosopher(String name){
        this.name = name;
    }

    public Philosopher(String name,Philosopher rightPhilosopher, Philosopher leftPhilosopher){
        this.name = name;
        this.rightPhilosopher = rightPhilosopher;
        this.leftPhilosopher = leftPhilosopher;
        this.state = State.THINK;

    }



    public void think() throws InterruptedException{
        System.out.println("I am "+name +" and i'm thinking ...");
        Thread.sleep(1000);

    }

    private synchronized void takeForks() throws InterruptedException{
        while(rightPhilosopher.isEating() || leftPhilosopher.isEating()){
            this.wait();
        }

        state = State.EAT;

    }

    private synchronized  void releaseForks(){
        state = State.THINK;
        if(!rightPhilosopher.isEating() || !leftPhilosopher.isEating())
            notifyAll();


    }


    public  void eat() throws InterruptedException{
           takeForks();

            System.out.println("Iam "+name+" and I am eating ...!" );
            Thread.sleep(2000);
            System.out.println("Iam "+name+" and I just finished eating ......................!" );

            releaseForks();


    }



    public boolean isEating(){
        if(state == State.EAT)
            return true;
        return false;
    }

    public void setNeighbors(Philosopher rightPhilosopher, Philosopher leftPhilosopher){
        this.rightPhilosopher = rightPhilosopher;
        this.leftPhilosopher = leftPhilosopher;
    }



    @Override
    public void run(){
        try {
            eat();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
