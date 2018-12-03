public class Billeterie {

         private int nombreDeBillet;
         private boolean prevenirResponsable = false;
         private ResponsableBilleterie responsableBilleterie;
         private boolean rechargementEncours =false;


    public Billeterie(int nombreDeBillet) {
        this.nombreDeBillet = nombreDeBillet;
    }

    public synchronized void acheterBillet(int nbrBillet) throws InterruptedException {

        while (nbrBillet > nombreDeBillet){

            System.out.println("Responsable billetterie au secours!");
            prevenirResponsable = true;
            notifyAll();
            wait();
        }

        prevenirResponsable = false;
        System.out.println("Billet Acheté, Client en attente d'impression de billet");
        Thread.sleep(100);

    }

    public synchronized void addBillets(int billetAAjouter){

        rechargementEncours = true;
        nombreDeBillet += billetAAjouter;

        System.out.println("Responsable billetterie a bien rechargé");
        rechargementEncours = false;
        notifyAll();
    }

    public boolean isPrevenirResponsable() {
        return prevenirResponsable;
    }
}
