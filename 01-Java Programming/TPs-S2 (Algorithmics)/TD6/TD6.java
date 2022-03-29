package TD6;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TD6 {
	/*
    public static class Arbre<Type>{
        public Noeud racine;
        public static class Noeud<Type> {
            public Type valeur;
            public Noeud Pere;
            public Noeud filsgauche;
            public Noeud filsdroite;

            public Noeud(Type valeur, Noeud pere, Noeud filsgauche, Noeud filsdroite) {
                this.valeur = valeur;
                this.Pere = pere;
                this.filsgauche = filsgauche;
                this.filsdroite = filsdroite;
            }

            public Type getValeur() {
                return valeur;
            }

            public void setValeur(Type valeur) {
                this.valeur = valeur;
            }

            public Noeud getPere() {
                return Pere;
            }

            public void setPere(Noeud pere) {
                Pere = pere;
            }

            public Noeud getFilsgauche() {
                return filsgauche;
            }

            public void setFilsgauche(Noeud filsgauche) {
                this.filsgauche = filsgauche;
            }

            public Noeud getFilsdroite() {
                return filsdroite;
            }

            public void setFilsdroite(Noeud filsdroite) {
                this.filsdroite = filsdroite;
            }
        }

        public Arbre(Noeud racine) {
            this.racine = racine;
        }
    }
	*/
    public static class ABR<Type>{
    	
        public Noeud racine;
        
        public static class Noeud<Type>   {
            public  int clé;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Noeud<?> noeud = (Noeud<?>) o;
                return clé == noeud.clé && Objects.equals(valeur, noeud.valeur);
            }

            @Override
            public int hashCode() {
                return Objects.hash(clé, valeur);
            }

            public Type valeur;
            public Noeud Pere;
            public Noeud filsgauche;
            public Noeud filsdroite;

            public Noeud(int clé, Type valeur, Noeud pere, Noeud filsgauche, Noeud filsdroite) {
                this.clé = clé;
                this.valeur = valeur;
                this.Pere = pere;
                this.filsgauche = filsgauche;
                this.filsdroite = filsdroite;
            }

            public int getClé() {
                return clé;
            }

            public void setClé(int clé) {
                this.clé = clé;
            }

            public Type getValeur() {
                return valeur;
            }

            public void setValeur(Type valeur) {
                this.valeur = valeur;
            }

            public Noeud getPere() {
                return Pere;
            }

            public void setPere(Noeud pere) {
                Pere = pere;
            }

            public Noeud getFilsgauche() {
                return filsgauche;
            }

            public void setFilsgauche(Noeud filsgauche) {
                this.filsgauche = filsgauche;
            }

            public Noeud getFilsdroite() {
                return filsdroite;
            }

            public void setFilsdroite(Noeud filsdroite) {
                this.filsdroite = filsdroite;
            }
        }
        public ABR(Noeud racine) {
            this.racine = racine;
        }

    }

    public static boolean recherer(ABR abr, ABR.Noeud n){
    	
        
    	ABR.Noeud a= abr.racine;
        
    	while(a!=null){
            if(a.equals(n)){
                return true;
            }
            else if(a.clé>n.clé){
                a=  a.filsgauche;
            }
            else{
                a=a.filsdroite;
            }
        }
            return false;
    }
    
    public static boolean rechercher0(ABR a, ABR.Noeud n) {
    	ABR.Noeud z = a.racine;
    	if(a!=null) {
    		if(z.equals(n)) {
    			return true;
    		}
    		else if(z.clé>n.clé) {
    			z = z.filsgauche;
    		}
    		else {
    			z =z.filsdroite;
    		}
    	}
		return false;
    }
    

    public static void inserer(ABR abr, ABR.Noeud noeud){
        ABR.Noeud y=null;
        ABR.Noeud x= abr.racine;
        while(x!=null){
            y=x;
            if(x.clé> noeud.clé) {
            	x=x.filsgauche;
            }else {
            	x=x.filsdroite;
            }
        }
        if(y==null){
            abr.racine=noeud;
        }
        else{
            noeud.Pere=y;
            if(y.clé> noeud.clé) {
            	y.filsgauche=noeud;
            }
            else {
            	y.filsdroite=noeud;
            }

        }
    }
    
    public static List<Integer> TriArboressant(int[] tab){
        ABR<Integer> abr=new ABR<>(null);
        for(int i=0;i<tab.length;i++) {
        	inserer(abr,new ABR.Noeud(tab[i],0,null,null,null));
        }
        List<ABR.Noeud> list=new ArrayList<>();
        list=ParcoursInfixeABR(abr,list);
        List<Integer> list1=new ArrayList<>();
        for(int j=0;j<list.size();j++){
            list1.add(list.get(j).clé);
        }
        return list1;
    }

    public static <Type> List<ABR.Noeud> ParcoursInfixeABR(ABR<Type> A,List<ABR.Noeud> list){

        if(A.racine!=null){
            ParcoursInfixeABR(new ABR<Type>(A.racine.filsgauche),list);
            list.add(A.racine);
            ParcoursInfixeABR(new ABR<Type>(A.racine.filsdroite),list);
        }
        return list;
    }




    public static <Type> int hauteur( Arbre<Type> A){
        Arbre.Noeud d = A.racine;
        if(d==null) return 0;
            return 1+Math.max(hauteur(new Arbre<Type>(A.racine.filsgauche)),hauteur(new Arbre<Type>(A.racine.filsdroite)));
    }
    
    
    public static <Type> boolean recherche(Arbre<Type> A,Type value){
        if(A.racine==null) return false;
        if(A.racine.valeur.equals(value)) return true;
        return (recherche(new Arbre<Type>(A.racine.filsgauche),value)||recherche(new Arbre<Type>(A.racine.filsdroite),value));
    }

    
    public static <Type> List<Arbre.Noeud> ParcoursInfixe(Arbre<Type> A,List<Arbre.Noeud> list){

        if(A.racine!=null){
            ParcoursInfixe(new Arbre<Type>(A.racine.filsgauche),list);
            list.add(A.racine);
            ParcoursInfixe(new Arbre<Type>(A.racine.filsdroite),list);
        }
        return list;
    }

    
    public static void main(String[] args){
        /*Arbre.Noeud<Integer> a0=new Arbre.Noeud<>(0,null,null,null);
        Arbre.Noeud<Integer> a1=new Arbre.Noeud<>(1,a0,null,null);
        Arbre.Noeud<Integer> a2=new Arbre.Noeud<>(2,a0,null,null);
        Arbre.Noeud<Integer> a3=new Arbre.Noeud<>(3,a1,null,null);
        Arbre.Noeud<Integer> a4=new Arbre.Noeud<>(4,a1,null,null);
        Arbre.Noeud<Integer> a5=new Arbre.Noeud<>(5,a2,null,null);
        Arbre.Noeud<Integer> a6=new Arbre.Noeud<>(6,a2,null,null);
        a0.setFilsdroite(a2);
        a0.setFilsgauche(a1);
        a1.setFilsdroite(a4);
        a1.setFilsgauche(a3);
        a2.setFilsdroite(a6);
        a2.setFilsgauche(a5);
        Arbre<Integer> arbre=new Arbre<>(a0);
        List<Arbre.Noeud> list=new ArrayList<>();
        ParcoursInfixe(arbre,list);
        for(int i=0;i< list.size();i++){
            System.out.println(list.get(i).valeur);
        }
        System.out.println(hauteur(arbre));
        System.out.println(recherche(arbre,5));
        System.out.println(recherche(arbre,7));*/
        ABR<Integer> abr=new ABR<>(null);
        inserer(abr,new ABR.Noeud(5,0,null,null,null));
        inserer(abr,new ABR.Noeud(2,0,null,null,null));
        inserer(abr,new ABR.Noeud(7,0,null,null,null));
        inserer(abr,new ABR.Noeud(8,0,null,null,null));
        inserer(abr,new ABR.Noeud(1,0,null,null,null));
        inserer(abr,new ABR.Noeud(3,0,null,null,null));
        ABR.Noeud<Integer> a0=new ABR.Noeud(1,0,null,null,null);
        ABR.Noeud<Integer> a1=new ABR.Noeud(9,0,null,null,null);
        //System.out.println(recherer(abr,a0));
        //System.out.println(recherer(abr,a1));
        int[] tab={5,2,1,7,3,4,8,2};
        System.out.println(TriArboressant(tab));




    }













    /*public element<Type> racine;
        public class element<Type>{
            private Type value;
            private element<Type> pere;
            private element<Type> filsdroite;
            private element<Type> filsgauche;

            public element<Type> getFilsdroite() {
                return filsdroite;
            }

            public void setFilsdroite(element<Type> filsdroite) {
                this.filsdroite = filsdroite;
            }

            public element<Type> getFilsgauche() {
                return filsgauche;
            }

            public void setFilsgauche(element<Type> filsgauche) {
                this.filsgauche = filsgauche;
            }

            public element(Type value, element<Type> pere, element<Type> filsdroite, element<Type> filsgauche) {
                this.value = value;
                this.pere = pere;
                this.filsdroite = filsdroite;
                this.filsgauche = filsgauche;
            }

            public Type getValue() {
                return value;
            }

            public void setValue(Type value) {
                this.value = value;
            }

            public element<Type> getPere() {
                return pere;
            }

            public void setPere(element<Type> pere) {
                this.pere = pere;
            }


        }

        public Exo1(element<Type> racine) {
            this.racine = racine;
        }

        public element<Type> getRacine() {
            return racine;
        }

        public void setRacine(element<Type> racine) {
            this.racine = racine;
        }

        public <Type> int hauteurArbreBinaire(element<Type> racine){
            if(racine==null) return 0;

            return  1+Math.max(hauteurArbreBinaire(racine.filsdroite),hauteurArbreBinaire(racine.filsgauche));
        }
        public int hauteur(){
            return hauteurArbreBinaire(this.racine);
        }

        public Boolean rechercher(element<Type> value){
            return rechercheeltArbreBinaire(this.racine,value);
        }

        public <Type> Boolean rechercheeltArbreBinaire(element<Type> racine,element<Type> value){
            if(racine!=null) {
                if (racine.equals(value)) return true;
                return (rechercheeltArbreBinaire(racine.filsdroite, value) || rechercheeltArbreBinaire(racine.filsgauche, value));
            }
            return false;
        }





*/



}
