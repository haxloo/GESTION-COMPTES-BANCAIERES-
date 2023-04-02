import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stubC
        Banque banque = new Banque(new ArrayList<Compte>(), new ArrayList<Client>());
        Client cl1 = new Client("baziz", "ahmed", LocalDate.parse("1999-10-09"), "Alger");
        Client cl2 = new Client("behloul", "mohamed", LocalDate.parse("2001-11-30"), "Alger");
        CompteCourant ahmedCompte = new CompteCourant(cl1, -500, 0);
        ahmedCompte.depot(1000);
        ahmedCompte.retrait(100);
        ahmedCompte.retrait(2000);
        ComptePEL ahmedComptePEL = new ComptePEL(cl1, 0);
        ComptePEL.setPourcentageInterets(3 / 100);
        ahmedComptePEL.depot(200);
        CompteCourant compte = new CompteCourant(cl1, 0, 200);
        banque.ajouterClient(cl1);
        banque.ajouterClient(cl2);
        System.out.println(banque.toString());
    }
}
