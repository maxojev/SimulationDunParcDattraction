public class Attraction {

        private int dureeAttenteQuai;
        private int nombreDePlaceDispoNavette;
        private boolean parti;

    public Attraction() {
        this.dureeAttenteQuai = 200;
        this.nombreDePlaceDispoNavette = 5;
        this.parti = false;
    }

    public synchronized void traintementClient() throws InterruptedException {

        while (nombreDePlaceDispoNavette== 0 & parti){

            System.out.println("j'attend la Navette ou il y a plus de place");
            wait();
        }

        System.out.println("je suis dans la Navette");
        nombreDePlaceDispoNavette--;
        System.out.println("test"+ nombreDePlaceDispoNavette);

    }

    public synchronized void TraitementNavette(){

        nombreDePlaceDispoNavette = 5;
        parti = false;
        notifyAll();

        System.out.println("Navette sur le quai avec un nombre de places limité");

        try {
            Thread.sleep(dureeAttenteQuai);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parti = true;

        System.out.println("Navette partie");
    }
}
