package philosophersProblem.Semaphores;

/**
 * Created by brahim on 6/1/17.
 */
public class Main {

    public static void main(String[] args){

        Philosopher[] philosophers = new Philosopher[5];
        Fork[] forks = new Fork[5];

        for(int i= 0; i<5; i++){
            forks[i] = new Fork("Fork"+(i+1));
        }

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
