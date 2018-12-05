public class Billeterie {

         private int nombreDeBillet;
         private boolean prevenirResponsable;



    public Billeterie(int nombreDeBillet) {
        this.nombreDeBillet = nombreDeBillet;
        prevenirResponsable = false;
    }

    public synchronized void acheterBillet(int nbrBillet) throws InterruptedException {

        while (nbrBillet > nombreDeBillet){

            System.out.println("Responsable billetterie au secours!" + " " + nombreDeBillet);
            prevenirResponsable = true;

            Thread.sleep(50);

            notifyAll();
            wait();
        }

        nombreDeBillet -= nbrBillet;
        System.out.println("Billet Acheté, Client en attente d'impression de billet");

        Thread.sleep(50);
        System.out.println("J'ai mon billet");

    }

    public synchronized void traintementResponsableBillet(int billetAAjouter) throws InterruptedException
    {
        System.out.println("respo present");

        while (!prevenirResponsable){

            System.out.println("wait Respo");
            wait();
        }

        nombreDeBillet += billetAAjouter;

        System.out.println("Responsable billetterie a bien rechargé");

        prevenirResponsable = false;
        notifyAll();
    }


}
