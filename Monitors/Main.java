package philosophersProblem.Monitors;

/**
 * Created by brahim on 6/9/17.
 */
public class Main {


    public static void main(String[] args){


        Philosopher[] philosophers = new Philosopher[5];
        //creating an array of 5 forks :
        Fork[] forks = new Fork[5];

        //creating the forks objects :
        for(int i= 0; i<5; i++){
            forks[i] = new Fork("Fork"+(i+1));
        }

        //creating the objects of the philosophers :

        philosophers[0] = new Philosopher("Philosopher 1", forks[0], forks[1]);
        philosophers[1] = new Philosopher("Philosopher 2", forks[1], forks[2]);
        philosophers[2] = new Philosopher("Philosopher 3", forks[2], forks[3]);
        philosophers[3] = new Philosopher("Philosopher 4", forks[3], forks[4]);
        philosophers[4] = new Philosopher("Philosopher 5", forks[4], forks[0]);

        for (int i=0; i<5; i++){
            philosophers[i].start();
        }
    }
}
