import java.util.ArrayList;
import java.util.Scanner;

public class Banque {
    private ArrayList<Compte> comptes;
    private ArrayList<Client> clients;

    public Banque(ArrayList<Compte> comptes, ArrayList<Client> clients) {
        this.comptes = comptes;
        this.clients = clients;
    }

    public void ajouterClient(Client client) {
        this.clients.add(client);
        for (Compte tmp : client.getComptes()) {
            this.ajouterLesComptesDesClients(tmp);
        }
    }

    public void nouveauCompte() {
        Compte compte;
        // Affichage du menu
        System.out.println("Tapez le type de compte que vous voulez ouvrir : \n[1] Compte courant\n[2] Compte LDD\n[3] Compte PEL");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choix = scanner.nextInt();
            if (choix == 1) {
                compte = new CompteCourant();
                break;
            } else if (choix == 2) {
                compte = new CompteLDD();
                break;
            } else if (choix == 3) {
                compte = new ComptePEL();
            }

        }
        scanner.close();
        this.comptes.add(compte);

    }

    public void crediter(double montant, int numeroDeCompte) {
        for (Compte tmp : comptes) {
            if (tmp.getNumero() == numeroDeCompte) {
                tmp.depot(montant);
            }

        }
    }

    public void debiter(double montant, int numeroDeCompte) {
        for (Compte tmp : comptes) {
            if (tmp.getNumero() == numeroDeCompte) {
                if (tmp instanceof CompteNonBloque) {
                    CompteNonBloque tmp2 = (CompteNonBloque) tmp;
                    tmp2.retrait(montant);
                }
                //else throw exception
            }
        }
    }

    public void afficherSoldeNom(int numeroDeCompte) {
        for (Compte tmp : comptes) {
            if (tmp.getNumero() == numeroDeCompte) {
                System.out.println(tmp.toString());
            }
        }

    }

    public Compte rechercher(int numeroDeCompte) {
        for (Compte tmp : comptes) {
            if (tmp.getNumero() == numeroDeCompte)
                return tmp;
        }
        return null;
    }

    public void afficherCompteDecouvert() {
        boolean existeCompteDecouvert = false;
        for (Compte tmp : comptes) {
            if (tmp.getSolde() < 0) {
                System.out.println(tmp.getNumero());
                existeCompteDecouvert = true;
            }
        }
        if (!existeCompteDecouvert)
            System.out.println("Il y a pas des comptes decouverts.\n");
    }

    public void ajouterLesComptesDesClients(Compte compte) {
        this.comptes.add(compte);
    }

    @Override
    public String toString() {
        String info = "les clients:";
        info = info + "\n";
        for (Client tmp : clients) {
            info = info + tmp.toString() + "\n";
        }
        info = info + "les comptes: ";
        info = info + "\n";
        for (Compte tmp : comptes) {
            info = info + tmp.toString() + "\n";
        }
        return info;
    }

}
