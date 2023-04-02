
import java.time.LocalDate;
import java.util.ArrayList;


public class Client {
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String adresse;
    private ArrayList<Compte> comptes = new ArrayList<Compte>();

    public Client(String nom, String prenom, LocalDate dateDeNaissance, String adresse) {


        this.nom = nom.toUpperCase();
        this.prenom = (Character.toString(prenom.charAt(0))).toUpperCase() + prenom.substring(1, prenom.length() - 1).toLowerCase();
        this.dateDeNaissance = dateDeNaissance;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public ArrayList<Compte> getComptes() {
        return comptes;
    }

    @Override
    public String toString() {
        return this.prenom + " " + this.nom + "(" + this.dateDeNaissance.getDayOfMonth() + " "
                + " " + this.dateDeNaissance.getMonth() + " " + this.dateDeNaissance.getYear() + ")";
    }


}
