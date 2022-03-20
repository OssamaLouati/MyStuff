package TD2;


public class TriFusion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int t1[]= {1,6,9,13};
		int t2[]= {2,6,7,8};
		int t3[]=fusion(t1,t2);
		afficherTab(t3,0,t3.length-1);
		
		/*
		int t[]= {1,6,9,13,2,6,7,8};
		          1,2,6,9,13,6,7,8
		{1,2,6,9,13,6,7,8}
		//fusionEnPlace(t,0,3,7);
		mergeSort(t, 0, t.length-1);
		afficherTab(t,0,t.length-1);
		*/
		
	}
	
	 private static int[] fusion(int t1[],int t2[])
     {
     int n = t1.length;
     int m = t2.length;
     int tab[]= new int[m+n];
     int i=0,j=0,x=0;
     while(i<n && j<m){
    	 if(t1[i]<t2[j]) {
    		 tab[x]=t1[i];
    		 i++;
    		 x++;
    	 }
    	 else {
    		 tab[x]=t2[j];
    		 j++;
    		 x++;
    	 }
     }
     //placer les éléments restants de t1
     while(i<n){
    	 tab[x]=t1[i];
    	 x++;
    	 i++;
     }
     //placer les éléments restants de t2
     while(j<m){
    	 tab[x]=t2[j];
    	 x++;
    	 j++;
     }
     return tab;
    }
	 
	static void fusionEnPlace(int t[], int deb, int milieu, int fin)
	 {
	     int deb2 = milieu + 1;
	     // si le tableau est déjà trié
	     if (t[milieu] <= t[deb2]) {
	         return;
	     }
	     // Maintenir les pointeurs deb 1 et deb2 dans les rangs possibles
	     while (deb <= milieu && deb2 <= fin) {
	         // l'élément du premier tableau est dans la bonne place
	         if (t[deb] <= t[deb2]) {
	        	 deb++;
	         }
	         else {
	             int val = t[deb2];
	             int i = deb2;
	             // décalage des éléments à droite entre deb2 et deb1 --> insertion de t[deb2]
	             while (i != deb) {
	                 t[i] = t[i - 1];
	                 i--;
	             }
	             t[deb] = val;
	             deb++;
	             milieu++;
	             deb2++;
	         }
	     }
	 }
	
	static void mergeSort(int arr[], int l, int r)
	{
	    if (l < r) {
	        int m = (l+r)/2;
	        // trier les deux sous-tableaux
	        mergeSort(arr, l, m);
	        mergeSort(arr, m + 1, r);
	        //fusion
	        fusionEnPlace(arr, l, m, r);
	    }
	}
	static void echanger(int t[], int p1, int p2) {
		int temp;
		temp=t[p1];
		t[p1]=t[p2];
		t[p2]=temp;
	}
	
	static void afficherTab(int t[], int deb, int fin) {
		for(int i=deb;i<=fin;i++) {
			System.out.print(t[i]+"\t");
		}
		System.out.println("\n");
	}

}
