

package philosophersProblem.Semaphores;

/**
 * Created by brahim on 6/20/17.
 */
public class Philosophe extends Thread{

    private Fork rightFork ;
    private Fork leftFork;
    
    private int nbreMange;


    private String nom;
    //LEFT_HANDED ou RIGHT_HANDED
    private Type Type;
    int s, j;

    public enum Type{ RIGHT_HANDED, LEFT_HANDED};




    public Philosophe(){

    }
    public Philosophe(int s, int j, String nom, Fork rightFork, Fork leftFork, Type Type){
        this.rightFork = rightFork;
        this.leftFork = leftFork;
        this.nom = nom;
        this.Type = Type;
        this.nbreMange = 0;

        //those two variables are used for the execution of the program at the Main class
        this.s = s;
        this.j = j;
    }

   

    public int getNbreMange() {
        return nbreMange;
    }



    public synchronized void eat() throws InterruptedException {


        if(this.isRightHanded()){

            rightFork.take(this);
            System.out.println(nom+" : I took  "+rightFork);



            leftFork.take(this);
            System.out.println(nom+" : I took  "+leftFork);

           
            System.out.println(nom+" :: I eat  ....");
            Thread.sleep(s*1000);

           
            nbreMange++;


            System.out.println(nom+" I just finished eating : --> Eaten    : "+nbreMange);


            rightFork.release();
            System.out.println(nom+" I release "+rightFork);

            leftFork.release();
            System.out.println(nom+" I release "+leftFork);




        }

        //si le philosophe est LEFT_HANDED
        else{



            leftFork.take(this);
            System.out.println(nom+" : I took  "+leftFork);

            rightFork.take(this);
            System.out.println(nom+" : I took  "+rightFork);


            System.out.println(nom+" :: I eat  ...");
            Thread.sleep(s*1000);


            nbreMange++;


            System.out.println(nom+" I just finished eating : --> Eaten    : "+nbreMange);


            leftFork.release();
            System.out.println(nom+" I release "+leftFork);

            rightFork.release();
            System.out.println(nom+" I release "+rightFork);




        }

    }

    private void think() throws InterruptedException {
        //think for an inderterminist amount of time
        long t = (long)(Math.random()*10000 )% 10000;
        System.out.println(nom+" : I think for about  "+(int)t/1000+"sec");
        Thread.sleep(t);


    }

    private boolean isRightHanded(){
        if(Type == Type.RIGHT_HANDED)
            return true;
        return false;
    }

    @Override
    public String toString(){
        return nom;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Philosophe that = (Philosophe) o;

        return nom.equals(that.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
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
