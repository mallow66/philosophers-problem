package philosophersProblem.Monitors;

/**
 * Created by brahim on 6/9/17.
 */
public class Philosopher extends Thread {

    private String name;
    private Fork rightFork;
    private Fork leftFork;

    public Philosopher(String name, Fork rightFork, Fork leftFork){
        this.name = name;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }



    public void think() throws InterruptedException{
        System.out.println("I am "+name +" and i'm thinking ...");
        Thread.sleep(1000);

    }


    public void eat() throws InterruptedException{
        System.out.println("I am "+name+", Waiting for"+rightFork);
       rightFork.take();
       System.out.println("I am "+name+", and just took the "+rightFork);

        System.out.println("I am "+name+", Waiting for"+leftFork);
        leftFork.take();
        System.out.println("I am "+name+", and just took the r"+leftFork);

        System.out.println("Iam "+name+" and I am eating ...!" );
        Thread.sleep(2000);
        System.out.println("Iam "+name+" and I just finished eating ......................!" );

        leftFork.release();
        System.out.println("Iam "+name+" and I just release "+leftFork );

        rightFork.release();
        System.out.println("Iam "+name+" and I just release "+rightFork );

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
