package achraf;

public class test {
    public static void main(String[] args) throws ExceptionPilePleine, ExceptionPileVide {
        String a="598+46**7+*";
        TD4.PileTab<Integer> tab=new TD4.PileTab<>(2);
        System.out.println(tab);
        tab.empiler(1);
        tab.empiler(2);
        System.out.println(tab);
        tab.depiler();
        System.out.println(tab);
    }
}
