package philosophersProblem.Monitors;

/**
 * Created by brahim on 6/20/17.
 */
public class Philosophe extends Thread{

    private String name;
    private Fork leftFork;
    private Fork rightFork ;
    private int nbreDeFoisMange;
    //a shared object with the philosophers between them to communicate
    private Object lock;
    int j;
    int s;



    public Philosophe(int s, int j, String name, Fork leftFork, Fork rightFork, Object lock){
        this.name = name;
        this.leftFork  = leftFork;
        this.rightFork = rightFork;
        this.lock = lock;
        nbreDeFoisMange = 0;
        this.j = j;
        this.s = s;
    }


    private void think() throws InterruptedException {
        
        long t = (long)(Math.random()*10000 )% 10000;
        System.out.println(name+" : I think for about "+(int)t/1000+"sec");
        Thread.sleep(100);


    }

    private  void  eat() throws InterruptedException{


        while(rightFork.isBusy() || leftFork.isBusy()
                || rightFork.lastUsedBy(this)
                || leftFork.lastUsedBy(this)){
            System.out.println(name+" It's not my turn to eat   :'( ");
            synchronized (lock){
                lock.wait();
            }

        }
        synchronized (this){
            leftFork.take();
            System.out.println(name+ ": I took "+leftFork);


            rightFork.release(this);
            System.out.println(name+ ": I took "+rightFork);
        }



        System.out.println(name+" :: I eat ....");
        Thread.sleep(s*1000);
        System.out.println(name+" ::: I just finished eating,  ->("+(++nbreDeFoisMange)+" times)");

        synchronized (this){
            rightFork.release(this);
            System.out.println(name+ ": I release "+rightFork);


            leftFork.release(this);
            System.out.println(name+ ": I release "+leftFork);


        }

        synchronized (lock){
            lock.notifyAll();
        }



    }


    @Override
    public void run() {

        try {
          
            for(int i=0; i<j; i++) {
                think();
                eat();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
