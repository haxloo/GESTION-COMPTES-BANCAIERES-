
public abstract class CompteNonBloque extends Compte {


    public CompteNonBloque() {
        this(null, 0);
    }

    public CompteNonBloque(Client client, double solde) {
        super(client, solde);
    }

    public abstract void retrait(double montant);


    public void virement(Compte distinataire, double montant) {
        // On debite le client qui fait le virement
        // Et on envoi le montant au compte destinataire
        distinataire.depot(montant);
        this.retrait(montant);
        actualiser();
    }
}
