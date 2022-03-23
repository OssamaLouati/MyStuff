package TD4;

import TD3.LinkedList;
import TD4.RevisionFile.File;
import TD4.RevisionFile.FileTab;

public class LinkedListFile<Type> implements File<Type>{
	
	LinkedList<Type> linkedlist;
	@Override
	public boolean estVide(FileTab<Type> file) {
		
		return linkedlist.estVide();
	}

	@Override
	public boolean estPleine(FileTab<Type> file) {
		return !linkedlist.estVide();
	}
	public Type defiler() {
		return (Type) linkedlist.tete;
		linkedlist.supprimerTete();
		return null;
		
	}
	
	
	
	
	@Override
	public void enfiler(File<Type> file, Type x) throws ExceptionFilePleine {
		
	}

	@Override
	public Type defiler(File<Type> file) throws ExceptionfileVide {
		return null;
	}
	

}
