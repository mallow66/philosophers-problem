package philosophersProblem.Semaphores;

import philosophersProblem.Semaphores.Fork;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by brahim on 6/20/17.
 */
public class Main {

    public static void main(String[] args){



        Philosophe[] philosophes = new Philosophe[5];


        Fork[] Forks = new Fork[5];



        //initialiser les Forks
        for(int i= 0; i<5; i++){
            Forks[i] = new Fork("Fork "+(i+1));
        }


        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer the number of time a philosopher should eat");
        while(!scanner.hasNextInt()){
            System.out.print("Entrer a valid number");
            scanner = new Scanner(System.in);
        }
        int j = scanner.nextInt();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Entrer the number of seconds that a philosopher will take to eat :");
        while(!scanner2.hasNextInt()){
            System.out.println("Entrer a valid number");
            scanner2 = new Scanner(System.in);
        }
        int s = scanner2.nextInt();







        philosophes[0] = new Philosophe(s, j,"Philosopher 1", Forks[4], Forks[0], Philosophe.Type.LEFT_HANDED);
        philosophes[1] = new Philosophe(s, j,"Philosopher 2", Forks[0], Forks[1], Philosophe.Type.RIGHT_HANDED);
        philosophes[2] = new Philosophe(s, j,"Philosopher 3", Forks[1], Forks[2], Philosophe.Type.RIGHT_HANDED);
        philosophes[3] = new Philosophe(s, j,"Philosopher 4", Forks[2], Forks[3], Philosophe.Type.RIGHT_HANDED);
        philosophes[4] = new Philosophe(s, j,"Philosopher 5", Forks[3], Forks[4], Philosophe.Type.RIGHT_HANDED);


        




        for (int i=0; i<5; i++){
            philosophes[i].start();
        }






    }
}
