package philosophersProblem.Monitors;

import java.util.Scanner;

/**
 * Created by brahim on 6/20/17.
 */
public class Main {

    public static void main(String [] args){


        Philosopher[] philosophers = new Philosopher[5];


        Fork[] Forks = new Fork[5];



        for(int i= 0; i<5; i++){
            Forks[i] = new Fork("Fork"+(i+1));
        }


        Object lock = new Object();

        System.out.println("Entrer the number of time a philosopher should eat : ");
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNextInt()){
            System.out.println("Entrer a valid number : ");
            scanner = new Scanner(System.in) ;

        }
        int j = scanner.nextInt();

        System.out.println("Entrer the number of seconds that a philosopher will take to eat :");
        Scanner scanner2 = new Scanner(System.in);
        while(!scanner2.hasNextInt()){
            System.out.println("Enter a valid number : ");
            scanner2 = new Scanner(System.in) ;

        }
        int s = scanner2.nextInt();


        philosophers[0] = new Philosopher(s,j,"Philosophe 1", Forks[0], Forks[1], lock);
        philosophers[1] = new Philosopher(s,j,"Philosophe 2", Forks[1], Forks[2], lock);
        philosophers[2] = new Philosopher(s,j,"Philosophe 3", Forks[2], Forks[3], lock);
        philosophers[3] = new Philosopher(s,j,"Philosophe 4", Forks[3], Forks[4], lock);
        philosophers[4] = new Philosopher(s,j,"Philosophe 5", Forks[4], Forks[0], lock);


        for (int i=0; i<5; i++){
            philosophers[i].start();
        }


    }


}
