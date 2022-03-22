package achraf;

import java.lang.constant.Constable;
import java.util.Arrays;

public class TD4 {
    public static void main(String[] args) throws ExceptionPileVide, ExceptionPilePleine, ExceptionNotationPolonaise {
        String a=" 5 9 8 + 4 6 * * 7 + * ";
        System.out.println(NaotationPolonaise(a));

    }
    public static class PileTab<Type> implements Pile<Type> {
        int capacite;
        Type[] elements;
        int sommet;

        public PileTab(int capacite) {
            this.capacite = capacite;
            this.sommet = -1;
            this.elements = (Type[]) new Object[capacite];
        }


        @Override
        public Boolean estVide() {
            return (sommet == -1);
        }

        @Override
        public Boolean estPleine() {
            return (sommet==capacite-1);
        }

        @Override
        public void empiler(Type y) throws ExceptionPilePleine {


            if (estPleine()) throw new ExceptionPilePleine("Pile pleine");

            sommet++;
            elements[sommet] = y;

        }

        @Override
        public Type depiler() throws ExceptionPileVide {
            if (estVide()) throw new ExceptionPileVide("Pile is empty");
            Type z = elements[sommet];
            elements[sommet] = null;
            sommet--;
            return z;
        }

        @Override
        public String toString() {
            if (!estVide()) {
                String r = "{" + elements[0];
                int i = 1;

                while (i <= sommet) {
                    r += "," + elements[i];
                    i++;
                }
                r += "}";
                return r;
            }
            return null;
        }

    }
    public static int NaotationPolonaise(String a) throws ExceptionPilePleine, ExceptionNotationPolonaise, ExceptionPileVide {
        PileTab<Object> tab=new PileTab<>(a.length());
        for(int i=0;i<a.length();i++) {
            char s = a.charAt(i);
            if (Character.isDigit(s)) {
                tab.empiler((int)s);
            }
            else if(s == ' ') continue;
            else {
                //if (s == ' ') break;
                //if (tab.sommet < 1) throw new ExceptionNotationPolonaise();
                int e=(int)tab.depiler();
                int r=(int)tab.depiler();
                tab.empiler(calculer(s,r,e));
            }
        }
        return (int)tab.depiler();
    }
    public static int calculer(char s, int r,int e){
        if (s == '*') return  r * e;

        if (s == '+') return r + e;

        if (s == '-') return r - e;

        if (s == '/')  return r / e;

        return 0;
    }

    class FileTab<Type> implements File<Type>{
        int capacite;
        Type[] elements;
        int tete;
        int queue;
        int nombreElements;

        public FileTab(int capacite) {
            this.capacite = capacite;
            this.elements=(Type[])new Object[capacite];
            this.tete=0;
            this.queue=-1;
        }
    }
}


