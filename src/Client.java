public class Client extends Thread{

    private int nbreDeBilletAAcheter;
    private Billeterie billeterie;

    public Client(int nbreDeBilletAAcheter, Billeterie billeterie) {
        this.nbreDeBilletAAcheter = nbreDeBilletAAcheter;
        this.billeterie = billeterie;
    }

    public void run(){

        try {
            billeterie.acheterBillet(nbreDeBilletAAcheter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
