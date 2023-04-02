
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
			  System.out.println("RETRAIT EFFUCTU�");
		     }
		   else if (montant < 0) System.out.println("ERREUR : Le montant que vous essayez de  retirer est n�gatif (OP�RATION NON EFFUCTU�)");
		   else if (montant > seuil) System.out.println("ERREUR : vous essayez de d�passer le seuil (OP�RATION NON EFFUCTU�)");
		   else if(this.getSolde() < montant) System.out.println("ERREUR : le d�couvert est interdit sur ce compte (OP�RATION NON EFFUCTU�)");
	   }
	   @Override
	   public void virement(Compte distinataire,double montant) {
		      if(montant > 0 && montant <= CompteLDD.seuil && this.getSolde() >= montant) {
		    	  super.virement(distinataire, montant);
		    	  System.out.println("VIREMENT EFFUCTU�");
		      }
		      else if(this.getSolde()  < montant)
	    	      System.out.println("ERREUR: le d�couvert est interdit sur ce compte (OP�RATION NON EFFUCTU�)");
	          else if (montant < 0)
	    	   System.out.println("ERREUR: vous essayez de virer un montant n�gatif (OP�RATION NON EFFUCTU�)");
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
		      else if (montant < 0) System.out.println("ERREUR : Le montant que vous essayez de  deposer est n�gatif (OP�RATION NON EFFUCTU�)");
			  else if (montant > seuil) System.out.println("ERREUR : vous essayez de d�passer le seuil (OP�RATION NON EFFUCTU�)");
		
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
