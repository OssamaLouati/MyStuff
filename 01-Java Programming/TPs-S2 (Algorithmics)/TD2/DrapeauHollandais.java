package TD2;


public class DrapeauHollandais {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    int t[] = {3,3,3,2,2,1,1,3,3,1};
		    tri2(t);
		    afficherTab(t,0,t.length-1);
	}
		
	static void tri1(int[] t){
		//Bleu 1, Blanc 2, Rouge 3 
		int  n= t.length;
		int i=0;
		int bl=0;
		int rg=(n-1);
		while (i <= rg){
			if(t[i]==3){
				echanger(t,i,rg);
				rg--;
			}
			else{
				if(t[i]==1){
					echanger(t,i,bl);
					bl++; 
				}
				i++;
			}
		}
	}
		
	static void tri2(int[] t){
		//tri par dénombrement : domaine de 3 valeurs
		int  n= t.length;
		int m=3;
		int compt[] = new int[m];
		int i=0;
		for(i=0;i<m;i++){
			compt[i]=0;
		}
		for(i=0;i<n;i++){
			compt[t[i]-1]++;
		}
		i=0;
		for(int v=0;v<m;v++){
			for(int j=0;j<compt[v];j++){
				t[i]=v+1;
				i++;
			}
		}
	}


	static void afficherTab(int t[], int deb, int fin) {
		for(int i=deb;i<=fin;i++) {
			System.out.print(t[i]+"\t");
		}
		System.out.println("\n");
	}

	static void echanger(int t[], int p1, int p2) {
		int temp;
		temp=t[p1];
		t[p1]=t[p2];
		t[p2]=temp;
	}

}
