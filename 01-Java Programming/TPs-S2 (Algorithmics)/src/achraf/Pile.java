package achraf;

public interface Pile<Type> {
    public Boolean estVide();
    public Boolean estPleine();
    public void empiler(Type y) throws ExceptionPilePleine;
    public  Type depiler() throws ExceptionPileVide;

}
