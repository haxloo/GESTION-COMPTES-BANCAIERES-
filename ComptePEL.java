
public class ComptePEL extends Compte {
    private static int pourcentageInterets;

    public ComptePEL() {
        this(null, 0);
    }

    public ComptePEL(Client client, double solde) {
        super(client, solde);
    }

    @Override
    public void depot(double montant) {
        if (montant > 0) {
            super.depot(montant);
            actualiser();
        }

    }

    @Override
    public void actualiser() {
        super.depot(this.getSolde() * ComptePEL.pourcentageInterets);
    }

    public static int getPourcentageInterets() {
        return pourcentageInterets;
    }

    public static void setPourcentageInterets(int pourcentageInterets) {
        ComptePEL.pourcentageInterets = pourcentageInterets;
    }

}
