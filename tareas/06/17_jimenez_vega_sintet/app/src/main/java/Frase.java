import java.util.ArrayList;

public class Frase {

    private String frase;

    public Frase(String frase) {
        this.frase = frase;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
/*
    private static int lastFraseId = 0;

    public static ArrayList<Frase> createContactsList(int numContacts) {
        ArrayList<Frase> frases = new ArrayList<Frase>();

        for (int i = 1; i <= numContacts; i++) {
            frases.add(new Frase(" " + ++lastFraseId, i <= numContacts / 2));
        }

        return frases;
    }


*/
}

