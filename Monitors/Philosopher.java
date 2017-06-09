package philosophersProblem.Monitors;

/**
 * Created by brahim on 6/9/17.
 */
public class Philosopher extends Thread {

    private String name;
    private Fork rightFork;
    private Fork leftFork;



    public void think() throws InterruptedException{
        Thread.sleep(1000);
    }


    public void eat() throws InterruptedException{
        think();
        System.out.println("I am "+name+", Waiting for"+rightFork);
        while(rightFork.isTaken()){

        }
        System.out.println("I am "+name+" just took "+rightFork);
        rightFork.take();
        System.out.println("I am "+name+", Waiting for"+leftFork);
        while(leftFork.isTaken()){
        }
        System.out.println("I am "+name+" just took "+rightFork);
        leftFork.take();

        System.out.println("Iam "+name+" and I am eating ...!" );
        Thread.sleep(2000);
        System.out.println("Iam "+name+" and I just finished eating ...!" );

        System.out.println("Iam "+name+" and I just release "+rightFork );
        rightFork.release();
        System.out.println("Iam "+name+" and I just release "+leftFork );
        leftFork.release();

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
