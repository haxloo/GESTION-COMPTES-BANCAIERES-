
public abstract class Compte {

    private double solde;
    private Client titulaire;
    private int numero;
    // On initialise le premier numero de compte a un et on l'incremente apres chaque creation de compte
    private static int numeroCompte = 1;

    // Initialisation du compte
    public Compte() {
        this(null, 0);
    }

    public Compte(Client titulaire, double solde) {
        this.solde = solde;
        this.titulaire = titulaire;
        this.numero = numeroCompte;
        if (this instanceof CompteCourant) {
            // Si le compte n'existe pas on procede a la creation du compte
            if (!verifier(titulaire))
                titulaire.getComptes().add(this);
                // Dans le cas contraire on affiche un message indiquant que le compte est existant
            else System.out.println("Il existe deja un compte courant.");
        } else titulaire.getComptes().add(this);
        // On incremente le numero de compte apres chaque creation
        numeroCompte++;
    }


    public double getSolde() {
        return solde;
    }


    protected void setSolde(double solde) {
        this.solde = solde;
    }

    public int getNumero() {
        return numero;
    }

    public void depot(double montant) {
        this.setSolde(this.getSolde() + montant);
    }

    public abstract void actualiser();

    // On redefinie la methode toString
    @Override
    public String toString() {
        return "Le numero de compte : " + numero + "\nLe titulaire: " + this.titulaire.toString() + "\nLe solde: " + this.solde;
    }

    // La methode verifier permet de savoir si le client detient deja un compte
    // elle retourne oui le cas echeant et faux dans le cas contraire
    private boolean verifier(Client titulaire) {
        if (titulaire.getComptes() == null)
            return false;
        for (Compte tmp : titulaire.getComptes()) {
            if (tmp instanceof CompteCourant)
                return true;
        }
        return false;
    }
}
