
public class CompteCourant extends CompteNonBloque {
    private static int pourcentageAgios;
    private double seuilDecouvert;

    public CompteCourant() {
        this(null, 0, 0);
    }

    public CompteCourant(double seuilDecouvert) {
        this(null, seuilDecouvert, 0);
    }

    public CompteCourant(Client client, double seuilDecouvert, double solde) {
        super(client, solde);
        this.seuilDecouvert = seuilDecouvert;
    }


    // Elle permet de debiter un compte
    @Override
    public void retrait(double montant) {
        if (montant > 0 && this.getSolde() - montant > this.seuilDecouvert) {
            if (this.getSolde() - montant < 0)
                actualiser();
            this.setSolde(this.getSolde() - montant);
            // si le compte a debiter ne detient pas la somme requise on interdit
            // de depasser le seuil de decouvert
        } else if (this.getSolde() - montant < 0)
            System.out.println("Impossible de depasser le seuil de decouvert.\n");
    }

    @Override
    public void virement(Compte distinataire, double montant) {
        if (this.getSolde() - montant >= this.seuilDecouvert) {
            if (this.getSolde() - montant < 0)
                actualiser();
            super.virement(distinataire, montant);
        }
        // else throw exception
    }

    @Override
    public void actualiser() {
        this.setSolde(this.getSolde() - this.getSolde() * CompteCourant.pourcentageAgios);
    }

    public static int getPourcentageAgios() {
        return pourcentageAgios;
    }

    public static void setPourcentageAgios(int pourcentageAgios) {
        CompteCourant.pourcentageAgios = pourcentageAgios;
    }

    public double getSeuilDecouvert() {
        return seuilDecouvert;
    }

    public void setSeuilDecouvert(double seuilDecouvert) {
        this.seuilDecouvert = seuilDecouvert;
    }


}
