package philosophersProblem.Semaphores;

/**
 * Created by brahim on 6/1/17.
 */
public class Philosopher extends Thread{

    private Fork rightFork ;
    private Fork leftFork;
    private String name;



    public Philosopher(){

    }
    public Philosopher(String name, Fork rightFork, Fork leftFork){
        this.rightFork = rightFork;
        this.leftFork = leftFork;
        this.name = name;
    }


    //we gonna suppose that eating will take 2 seconds :

    public void eat() throws InterruptedException {
        rightFork.take();
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
        think();
    }

    private void think() throws InterruptedException {
        System.out.println("I am "+ name +" And Iam thinking");
        Thread.sleep(1000);

    }

    @Override
    public void run() {
            for (int i=0; i<10; i++)
            try {
                eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }


}
