package TD4;

public class FileLinkedList<Type> implements File<Type> {
    linkedList<Type> linkedList;

    public FileLinkedList() {
        this.linkedList = new linkedList<>();
    }

    @Override
    public void enfiler(Type x) {
        linkedList.insererQueue(x);
    }

    @Override
    public Type defiler(){

        return linkedList.supprimerTete();
    }

    @Override
    public boolean estVide() {
        return linkedList.estVide();
    }

    @Override
    public boolean estPleine() {
        return !linkedList.estVide();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }

	@Override
	public void enfiler(File<Type> file, Type x) throws ExceptionFilePleine {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Type defiler(File<Type> file) throws ExceptionFileVide {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean estVide(File<Type> file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estPleine(File<Type> file) {
		// TODO Auto-generated method stub
		return false;
	}
}
