public class Navette extends Thread {

    Attraction attraction;

    private int dureeTrajet;

    public Navette(Attraction attraction){
        this.attraction = attraction;
        this.dureeTrajet = 150;
    }

    @Override
    public void run() {

        while (true) {

            attraction.TraitementNavette();

            try {
                System.out.println("je suis en traversé");
                Thread.sleep(dureeTrajet);
                System.out.println("Trajet terminé");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
