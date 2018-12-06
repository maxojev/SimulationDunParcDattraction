public class Navette extends Thread {

    Attraction attraction;

    private int dureeTrajet;
    private int dureeAttenteQuai;


    public Navette(Attraction attraction){
        this.attraction = attraction;
        this.dureeTrajet = 200;
        this.dureeAttenteQuai = 200;
    }

    @Override
    public void run() {

        while (true) {

            try {
                attraction.GareNavette();

                Thread.sleep(dureeAttenteQuai);

                System.out.println("methode2");

                attraction.departNavette();

                Thread.sleep(dureeTrajet);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
