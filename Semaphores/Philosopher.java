package philosophersProblem.Semaphores;

/**
 * Created by brahim on 6/1/17.
 */
public class Philosopher extends Thread{

    private Fork rightFork ;
    private Fork leftFork;
    private String name;

    private long currentTime;




    public Philosopher(){

    }
    public Philosopher(String name, Fork rightFork, Fork leftFork){
        this.rightFork = rightFork;
        this.leftFork = leftFork;
        this.name = name;
    }


    //we gonna suppose that eating will take 2 seconds :

    public void eat() throws InterruptedException {
        think();
        rightFork.take();
        currentTime = System.currentTimeMillis();

        System.out.println("I am  "+ name +", and I just got the "+ rightFork.getName());
        leftFork.take();
        System.out.println("I am  "+ name +", and I just got the "+ leftFork.getName());
        System.out.println(name+" :: Eating ... ");
        Thread.sleep(2000);
        System.out.println("I am"+ name+ " and I just finished eating");
        rightFork.release();
        System.out.println("I am"+ name+ " and I just released"+ rightFork.getName());
        leftFork.release();
        System.out.println("I am"+ name+ " and I just released"+ leftFork.getName());

    }

    private void think() throws InterruptedException {
        System.out.println("I am "+ name +" And Iam thinking");
        //sleeping for an indeterminate time
        Thread.sleep((long)(Math.random()*10000 )% 10000);

    }

    @Override
    public void run() {

            try {
                eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }


}
