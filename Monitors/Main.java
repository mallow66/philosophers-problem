package philosophersProblem.Monitors;

import java.util.Scanner;

/**
 * Created by brahim on 6/20/17.
 */
public class Main {

    public static void main(String [] args){

        //créer un tableau de 5 philosophes
        Philosophe[] philosophes = new Philosophe[5];

        //créer un tableau de 5 fourchettes
        Fourchette[] fourchettes = new Fourchette[5];


        //initialiser les fourchettes
        for(int i= 0; i<5; i++){
            fourchettes[i] = new Fourchette("Fourchette"+(i+1));
        }


        Object lock = new Object();

        System.out.println("Entrer le nombre de fois qu'un philosophe doit manger : ");
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNextInt()){
            System.out.println("Entrer un nombre valide : ");
            scanner = new Scanner(System.in) ;

        }
        int j = scanner.nextInt();

        System.out.println("Entrer la durée en seconds qu'un philosophe prend pour manger: ");
        Scanner scanner2 = new Scanner(System.in);
        while(!scanner2.hasNextInt()){
            System.out.println("Entrer un nombre valide : ");
            scanner2 = new Scanner(System.in) ;

        }
        int s = scanner2.nextInt();

        //Initialiser les philosophes
        philosophes[0] = new Philosophe(s,j,"Philosophe 1", fourchettes[0], fourchettes[1], lock);
        philosophes[1] = new Philosophe(s,j,"Philosophe 2", fourchettes[1], fourchettes[2], lock);
        philosophes[2] = new Philosophe(s,j,"Philosophe 3", fourchettes[2], fourchettes[3], lock);
        philosophes[3] = new Philosophe(s,j,"Philosophe 4", fourchettes[3], fourchettes[4], lock);
        philosophes[4] = new Philosophe(s,j,"Philosophe 5", fourchettes[4], fourchettes[0], lock);

        //Lancer les 5 philosophes :
        for (int i=0; i<5; i++){
            philosophes[i].start();
        }


    }


}
