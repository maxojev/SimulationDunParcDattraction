public class Attraction {


        private int nombreDePlaceDispoNavette;
        private boolean navettePresent;


    public Attraction() {
        this.nombreDePlaceDispoNavette = 5;
        this.navettePresent = false;
    }

    public synchronized void traintementClient() throws InterruptedException {

        while (nombreDePlaceDispoNavette== 0 & navettePresent){

            System.out.println("j'attend la Navette ou il y a plus de place");
            wait();
        }

        notifyAll();
        System.out.println("Client: Je suis dans la Navette");
        nombreDePlaceDispoNavette--;

    }

    public synchronized void GareNavette() throws InterruptedException {

        while (navettePresent){

            System.out.println("Navette2: attente du depart de la navette présente");
            wait();
        }

        System.out.println("Navette présente");

        navettePresent = true;
        nombreDePlaceDispoNavette = 5;
        notifyAll();
    }

    public synchronized void departNavette(){

        System.out.println("Navette à quai parti");
        navettePresent = false;
        notifyAll();
    }

}
