package philosophersProblem.Monitors;

/**
 * Created by brahim on 6/9/17.
 */
public class Main {


    public static void main(String[] args) {


        Philosopher[] philosophers = new Philosopher[5];
        //creating an array of 5 forks :
        Fork[] forks = new Fork[5];

        //creating the forks objects :


        //creating the objects of the philosophers :

        philosophers[0] = new Philosopher("Philosopher 1");
        philosophers[1] = new Philosopher("Philosopher 2");
        philosophers[2] = new Philosopher("Philosopher 3");
        philosophers[3] = new Philosopher("Philosopher 4");
        philosophers[4] = new Philosopher("Philosopher 5");


        philosophers[0].setNeighbors(philosophers[4], philosophers[1]);
        philosophers[1].setNeighbors(philosophers[0], philosophers[2]);
        philosophers[2].setNeighbors(philosophers[1], philosophers[3]);
        philosophers[3].setNeighbors(philosophers[2], philosophers[4]);
        philosophers[4].setNeighbors(philosophers[3], philosophers[0]);

            for (int i = 0; i < 5; i++) {
                philosophers[i].start();
            }
        }
    }

