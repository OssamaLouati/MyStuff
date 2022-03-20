package TD4;

public class TestMain {
    public static void main(String[] args) {
        testPile();
    }

    public static void testFile() {
        FileLinkedList<Integer> file = new FileLinkedList<>();
        file.enfiler(0);
        file.enfiler(1);
        file.enfiler(2);
        file.enfiler(3);
        file.enfiler(4);
        System.out.println(file);
        file.defiler();
        System.out.println(file);
    }

    public static void testPile() {
        Pile_from_File<Integer> pile = new Pile_from_File<>();
        pile.empiler(0);
        pile.empiler(1);
        pile.empiler(2);
        pile.empiler(3);
        pile.empiler(4);
        System.out.println(pile);
        pile.depiler();
        System.out.println(pile);
    }

}
