package TD4;

import java.util.Arrays;

public interface File<Type> {
    void enfiler(File<Type> file, Type x) throws ExceptionFilePleine;

    Type defiler(File<Type> file) throws ExceptionFileVide;

    boolean estVide(File<Type> file);

    boolean estPleine(File<Type> file);
}

class ExceptionFileVide extends Exception {

}

class ExceptionFilePleine extends Exception {

}

class FileTab<Type> implements File<Type> {
    public int capacite;
    public int tete = 0;
    public int queue = -1;
    public int nombreElements = 0;
    Type[] elements;

    public FileTab(int capacite) {
        this.capacite = capacite;
        elements = (Type[]) new Object[capacite];
    }


    @Override
    public void enfiler(File<Type> file, Type x) throws ExceptionFilePleine {
        FileTab<Type> ft = (FileTab<Type>) file;
        if(ft.estPleine(ft)) throw new ExceptionFilePleine();
        ft.elements[(ft.queue==capacite-1)? ft.queue=0: ++ft.queue] = x;
        ft.nombreElements++;
    }

    @Override
    public Type defiler(File<Type> file) throws ExceptionFileVide {
        FileTab<Type> flt = (FileTab<Type>) file;
        if (flt.estVide(flt)) throw new ExceptionFileVide();
        tete =(flt.tete==capacite-1) ? flt.tete=0: flt.tete++;
        Type x = flt.elements[tete]; 
        flt.nombreElements--;
        return x;

    }

    @Override
    public boolean estVide(File<Type> file) {
        FileTab<Type> flt = (FileTab<Type>) file;

        return flt.nombreElements == 0;
    }

    @Override
    public boolean estPleine(File<Type> file) {
        FileTab<Type> flt = (FileTab<Type>) file;

        return flt.nombreElements == flt.capacite;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        for (int i = tete; i < queue ; i++) {
            st.append(elements[i]+" , ");
        }
        return  st.toString();
    }
    public String toString1() {
    	StringBuilder az = new StringBuilder();
    	File<Type> ff = null ;
    	FileTab<Type> f = (FileTab<Type>) ff;
    	while(!ff.estVide(f)) {
    	
    	}
    	
    	return az.toString();
    }




	public static void main(String[] args) {
		FileTab<Integer> flt = new FileTab<>(5);
		try {
			flt.enfiler(flt, 0);
			flt.enfiler(flt, 1);
			flt.enfiler(flt, 2);
			flt.enfiler(flt, 3);
			flt.enfiler(flt, 4);
			flt.defiler(flt);
			flt.defiler(flt);
			flt.defiler(flt);
			flt.defiler(flt);
			flt.defiler(flt);
			flt.enfiler(flt, 5);
			flt.enfiler(flt, 6);
			System.out.println(flt);
			System.out.println(flt.defiler(flt));
			System.out.println(flt);
			
		} catch (ExceptionFilePleine | ExceptionFileVide exceptionFilePleine) {
			exceptionFilePleine.printStackTrace();
		}
	}
}