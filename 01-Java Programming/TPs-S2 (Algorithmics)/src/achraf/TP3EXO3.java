package achraf;

import java.util.Queue;

public class TP3EXO3 {
    public class LinkedList<Type> {
        static class Maillon<Type> {
            public Maillon<Type> suivant;
            public Type valeur;

            public Maillon(Type valeur) {
                this.suivant = null;
                this.valeur = valeur;
            }
        }
        public Maillon<Type> Tete;
        //Tete pointe sur faussetete dont le suivant est le tete

        public Maillon<Type> Queue;

        public LinkedList(Maillon<Type> tete, Maillon<Type> queue) {
            Tete = tete;
            Queue = queue;
        }

        public Boolean estVide(){
            if(this.Tete.suivant==null) return true ;
            return false;
        }

        public void insererTete(Type valeur){
            Maillon<Type> maillon=new Maillon<Type>(valeur);
            if(estVide()){
                this.Tete.suivant=maillon;
                this.Queue.suivant=maillon;
            }
            else{
                maillon.suivant=this.Tete.suivant;
                this.Tete.suivant=maillon;
            }
        }

        public void insererQueue(Type valeur){
            Maillon<Type> maillon=new Maillon<Type>(valeur);
            this.Queue.suivant=maillon;
            this.Queue=maillon;

        }
        public void supprimerTete() {
            if (!estVide()) {
                if (Tete.suivant.suivant != null) {
                    Tete.suivant = Tete.suivant.suivant;
                } else {
                    Tete.suivant = null;
                    Queue = Tete;
                }
            }
        }
        public void supprimerQueue(){
            if (!estVide()){
                if (Tete.suivant.suivant == null) {
                    Tete.suivant = null;
                    Queue=Tete;
                }
                else{
                    Maillon<Type> maillon=Tete.suivant;
                    while(maillon.suivant.suivant!=null){
                        maillon=maillon.suivant;
                    }
                    maillon.suivant=null;
                    Queue=maillon;

                }
            }
        }


    }}



/*public Maillon<Type> Queue;

        public LinkedList() {
            this.Tete=new Maillon(null);
            this.Queue=null;}

        public Boolean estVide(){
            return Tete.suivant==null;
        }
        public void insererTete(Type valeur){
            Maillon<Type> maillon=new Maillon<>(valeur);
            if(this.estVide()){
                this.Tete.suivant=maillon;
                this.Queue=maillon;
            }
            else{
                maillon.suivant=this.Tete.suivant;
                this.Tete.suivant=maillon;
            }
        }
        public void supprimerQueue(){
            if(Queue!=null){
                Maillon maillon= Tete.suivant;
                while(maillon.suivant.suivant!=null){
                    maillon=maillon.suivant;
                }
                maillon.suivant=null;
                Queue=maillon;
            }
        }*/