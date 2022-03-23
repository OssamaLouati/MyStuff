package TD4;

import java.util.Arrays;

public class RevisionFile {
	public interface File<Type>{
		public boolean estVide(FileTab<Type> file);
		public boolean estPleine(FileTab<Type> file);
		public void enfiler(File<Type> file, Type x) throws ExceptionFilePleine;
		public  Type defiler(File<Type> file) throws ExceptionfileVide;
		public class ExceptionfileVide extends Exception {};
		public class ExceptionFilePleine extends Exception {};
	}
	public class FileTab<Type> implements File<Type>{
		int capacite;
		Type[] elements;
		int tete;
		int queue;
		
		public FileTab(int capacite) {
			super();
			this.capacite = capacite;
			elements = (Type[]) new Object[capacite];
		}

		int nombreElements;
		
		public boolean estVide(FileTab<Type> file) {
			return file.nombreElements ==0;
		}
		@Override
		public boolean estPleine(FileTab<Type> file) {
			return file.capacite == file.nombreElements;
		}
		@Override
		public void enfiler(File<Type> file, Type x) throws ExceptionFilePleine {
			FileTab<Type> fi = (FileTab<Type>) file;
			if(estPleine(fi)) throw new ExceptionFilePleine();
			fi.elements[(fi.queue==fi.capacite-1)? fi.queue=0: fi.queue] = x;
			fi.nombreElements++;
		}
		
		@Override
		public Type defiler(File<Type> file) throws ExceptionfileVide {
			FileTab<Type> fi = (FileTab<Type>) file;
			if(estPleine(fi)) throw new ExceptionfileVide();
			tete = (this.tete==capacite-1)? fi.tete=0 : fi.tete++;
			Type x = this.elements[tete];
			this.nombreElements--;
			return x;
		}
		@Override
		public String toString() {
			return "FileTab [capacite=" + capacite + ", elements=" + Arrays.toString(elements) + ", tete=" + tete
					+ ", queue=" + queue + ", nombreElements=" + nombreElements + "]";
		}
		 public void afficher(FileTab<Type> tab) {
			 FileTab<Type> ta = (FileTab<Type>) tab;
			 for(int i=0; i<ta.nombreElements;i++) {
				 System.out.println(this.elements[i].toString());
			 }
		 }
		
		
	}
	

}
