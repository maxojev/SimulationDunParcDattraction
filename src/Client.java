public class Client extends Thread{

    private int nbreDeBilletAAcheter;
    private Billeterie billeterie;
    private Attraction attraction;

    public Client(int nbreDeBilletAAcheter, Billeterie billeterie, Attraction attraction) {
        this.nbreDeBilletAAcheter = nbreDeBilletAAcheter;
        this.billeterie = billeterie;
        this.attraction = attraction;
    }

    public void run(){

        try {
            billeterie.acheterBillet(nbreDeBilletAAcheter);

            System.out.println("je vais sur le quai");

            attraction.traintementClient();

            Thread.sleep(200);

            attraction.traintementClient();

            Thread.sleep(200);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
