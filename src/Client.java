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

            System.out.println("je vais sur le quai1");
            attraction.traintementClient();

            System.out.println("je suis à la première attraction1");
            Thread.sleep(100);

            System.out.println("je vais sur le quai2");
            attraction.traintementClient();

            System.out.println("je suis à la première attraction2");
            Thread.sleep(100);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
