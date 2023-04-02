
public class CompteLDD extends CompteNonBloque{
       private static int pourcentageInteres;
	   private static double seuil;
	   
	   private final double POURCENTAGEINTERES = (double)CompteLDD.pourcentageInteres/100;
	   
	   public CompteLDD(){
		   
	   }
	   public CompteLDD(Client client,double solde) {
		      super(client,solde);
	   }
	 
	   @Override
	   public void retrait(double montant) {
		
		   if(montant >= 0 && montant <= CompteLDD.seuil && this.getSolde() >= montant ) {
			  this.setSolde(this.getSolde() - montant);
			  System.out.println("RETRAIT EFFUCTUÉ");
		     }
		   else if (montant < 0) System.out.println("ERREUR : Le montant que vous essayez de  retirer est négatif (OPÉRATION NON EFFUCTUÉ)");
		   else if (montant > seuil) System.out.println("ERREUR : vous essayez de dépasser le seuil (OPÉRATION NON EFFUCTUÉ)");
		   else if(this.getSolde() < montant) System.out.println("ERREUR : le découvert est interdit sur ce compte (OPÉRATION NON EFFUCTUÉ)");
	   }
	   @Override
	   public void virement(Compte distinataire,double montant) {
		      if(montant > 0 && montant <= CompteLDD.seuil && this.getSolde() >= montant) {
		    	  super.virement(distinataire, montant);
		    	  System.out.println("VIREMENT EFFUCTUÉ");
		      }
		      else if(this.getSolde()  < montant)
	    	      System.out.println("ERREUR: le découvert est interdit sur ce compte (OPÉRATION NON EFFUCTUÉ)");
	          else if (montant < 0)
	    	   System.out.println("ERREUR: vous essayez de virer un montant négatif (OPÉRATION NON EFFUCTUÉ)");
	   }

	   @Override
	   public void actualiser() {
		       this.setSolde( this.getSolde() + this.getSolde() *  POURCENTAGEINTERES);
		}
	   @Override
	   public void depot(double montant) {
		      if(montant > 0 && montant <= CompteLDD.seuil) {
		    	  super.depot(montant);
		    	  actualiser();
		      }
		      else if (montant < 0) System.out.println("ERREUR : Le montant que vous essayez de  deposer est négatif (OPÉRATION NON EFFUCTUÉ)");
			  else if (montant > seuil) System.out.println("ERREUR : vous essayez de dépasser le seuil (OPÉRATION NON EFFUCTUÉ)");
		
	   }
	  
	   
	   //gettres and setters
	   public static int getPourcentageInteres() {
		   return pourcentageInteres;
	   }
	   public static void setPourcentageInteres(int pourcentageInteres) {
		   CompteLDD.pourcentageInteres = pourcentageInteres;
	   }
	   public static double getSeuil() {
		   return seuil;
	   }
	   public static void setSeuil(double seuil) {
		   CompteLDD.seuil = seuil;
	   }
	   

}
