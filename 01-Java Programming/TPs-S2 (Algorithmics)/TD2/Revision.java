package TD2;

public class Revision {
	public void permute(int[] t , int pr,int pmin) {
		int temp;
		temp = t[pr];
		t[pr] = t[pmin];
		t[pmin] = temp;
		
	}
	public void triParselection(int[] tab) {
		int n = tab.length;
		for (int i =1; i<n;i++) {
			int min = i;
			for(int  j =i+1; j<=n;j++) {
				if(tab[i] < tab[min]) {
					min = j;
				}
			permute(tab, i, min);
			}
		}
	}
	public void triBulles(int[] tab) {
		int taille=tab.length;
		for (int i =0 ;i<taille;i++) {
			for(int j=1;j<taille-i;j++) {
				if(tab[j-1]>tab[j]) {
					permute(tab,j-1,j);
				}
			}
		}
	}
	public void afficher(int[] tab) {
		for (int i=0; i<tab.length;i++) {
			System.out.println(tab[i]+" ");
		}
	}
	public void triParinsertion(int[] tab) {
		int taille = tab.length;
		for (int i =0; i<taille; i++) {
			int index = tab[i];
			int j = i-1;
			while(j>0 && tab[j] >index) {
				tab[j+1] = tab[j];
				j--;
			}
			tab[j+1] = index;
		}
	}
	public void trihollandais(int[] t){
		//Bleu 1, Blanc 2, Rouge 3 
		int  n= t.length;
		int i=0;
		int bl=0;
		int rg=(n-1);
		while (i <= rg){
			if(t[i]==3){
				permute(t,i,rg);
				rg--;
			}
			else{
				if(t[i]==1){
					permute(t,i,bl);
					bl++; 
				}
				i++;
			}
		}
	}
	public void triFusion2tab(int[] tab1, int[] tab2) {
		int n = tab1.length;
		int m = tab2.length;
		int[] tab3 = new int[n+m];
		int i = 0,j=0;
		int x = 0;
		while( i<n && j<m) {
			if(tab1[i] <tab2[j]) {
				tab3[x] = tab1[j];
				x++;
				i++;
			}else {
				tab3[x]=tab2[j];
				x++;
				j++;
			}
		}
		while(i<n) {
			tab3[x]=tab1[i];
			x++;
			i++;
		}
		while(j<m) {
			tab3[x]= tab2[j];
			x++;
			j++;
		}
		
	}
	public void fusion(int[] tab, int x) {
		int n = tab.length;
		int[] tab1 = new int[x];
		int[] tab2 = new int[n-x];
		for(int i =0; i<=x;i++) {
			tab1[i]=tab[i];
		}
		for(int j= 0; j<(n-x);j++) {
			tab2[j]=tab[j+1+x];
		}
		triParinsertion(tab1);
		triParinsertion(tab2);
		afficher(tab1);
		afficher(tab2);
	}
	public int partition(int[] tab1, int deb, int fin) {
		int posRd = (int) (Math.random()*(deb-fin) + deb);
		permute(tab1, fin, posRd);
		int pivot = tab1[fin];
		int compt = deb;
		for (int i = deb; i<fin; i++) {
			if(tab1[i]<pivot) {
				permute(tab1, i, compt );
				compt++;
			}
		}
		permute(tab1, fin, compt);
		return compt;
	}
	public void triRapide(int[] tab, int deb, int fin) {
		if(deb<fin) {
			int positionPivot = partition(tab, deb, fin);
			triRapide(tab, deb, positionPivot-1);
			triRapide(tab, positionPivot+1, fin);			
			}
	}
}
