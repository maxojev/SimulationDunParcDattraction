public class ResponsableBilleterie extends Thread{

   private int nombreBilletAmettre;
   private Billeterie billeterie;


    public ResponsableBilleterie(int nombreBilletAmettre, Billeterie billeterie){
        this.nombreBilletAmettre = nombreBilletAmettre;
        this.billeterie = billeterie;
    }

    public void run(){
        while (!billeterie.isPrevenirResponsable()){
            try {
                billeterie.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        billeterie.addBillets(nombreBilletAmettre);
    }


}
