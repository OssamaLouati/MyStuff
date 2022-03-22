package achraf;

public class LinkedList<Type> {
	/*class */
	static class Maillon<Type> {
		public Maillon<Type> suivant;
		public Type valeur;

		public Maillon(Type valeur) {
			this.suivant = null;
			this.valeur = valeur;
            }
	}
    /**/    
    public Maillon<Type> tete;
   
    public LinkedList(Maillon<Type> tete){
    	this.tete=tete;       
    }

    public Boolean estVide(){
            if(this==null||this.tete==null) return true;
           return false;
        }
   
    public void insererTete(Type valeur){
	   Maillon<Type> maillon=new Maillon<Type>(valeur);
	   maillon.suivant=this.tete;
	   this.tete=maillon;
   }
    
   public void insererQueue(Type valeur){
	   Maillon<Type> maillon=new Maillon<Type>(valeur);
	   if(estVide()){
		   this.insererTete(valeur);
	   }
	   Maillon<Type> maillon1=this.tete;
	   while(maillon1.suivant!=null){
		   maillon1=maillon1.suivant;
	   }
	   maillon1.suivant=maillon;
   }
   
   public void supprimerTete(){
	   if(!estVide()){
		   this.tete=this.tete.suivant;
        }
   }
   
   public void supprimerQueue(){
	   if(!estVide()){
		   Maillon<Type> maillon1=this.tete;
		   if(maillon1.suivant==null){
			   this.tete=null;
		   }
		   else{
			   while(maillon1.suivant.suivant!=null){
				   maillon1=maillon1.suivant;
			   }
			   maillon1.suivant=null;
		   }
	   }
   }
}












































    /*public LinkedList(Maillon<Type> tete) {
            this.tete = tete;
        }

        public Boolean estVide(){
            if (this.tete==null){
                return true;
            }
            return false;
        }
        public void insererTete(Type valeur){
            Maillon<Type> maillon=new Maillon<>(valeur);
            maillon.suivant=this.tete;
            this.tete=maillon;
        }
        public void insererQueue(Type valeur){
            Maillon<Type> maillon=new Maillon<>(valeur);
            Maillon<Type> maillon1=this.tete;
            if(maillon1!=null){
                while (maillon1.suivant!=null){
                    maillon1.suivant=maillon1.suivant.suivant;
                }}
            maillon1.suivant=maillon;
        }
        public void supprimerTete(){
            if(!this.estVide()){
                Maillon<Type> maillon=this.tete.suivant;
                this.tete=maillon;
            }
        }
        public void supprimerQueue(){
            Maillon<Type> maillon=this.tete;
            if(!this.estVide()){
                while (maillon.suivant!=null&&maillon.suivant.suivant!=null){
                    maillon.suivant=maillon.suivant.suivant;
                }
                maillon.suivant=null;}
        }*/


