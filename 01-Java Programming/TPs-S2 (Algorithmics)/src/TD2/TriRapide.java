package TD2;

public class TriRapide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t[]= {11,6,9,13,2,6,7,8};
		afficherTab(t,0,t.length-1);
		//int posPovit=partition(t, 0, t.length-1);
		//afficherTab(t,0,t.length-1);
		//System.out.println(posPovit);
		triRapide(t, 0, t.length-1);
		afficherTab(t,0,t.length-1);
	}
	
	private static int partition(int t[],int deb,int fin)
    {
    //choix pivot
    int randPos = (int)(Math.random() * (fin-deb)) + deb;
    //placer le pivot à la fin du tableau
    echanger(t,randPos,fin);
    int pivot=t[fin];
    //placer les éléments < pivot au début du tableau
    int compt=deb;
    for(int i=deb;i<fin;i++)
        {
        if (t[i]<pivot)
            {
        	echanger(t,i,compt);
        	compt++;
            }
        }
    //placer le pivot après tous les élements inférieurs à lui
    echanger(t,fin,compt);
    return compt;
    }
	
	

	private static void triRapide(int tableau[],int deb,int fin)
    {
    if(deb<fin)
        {
        int positionPivot=partition(tableau,deb,fin);
        triRapide(tableau,deb,positionPivot-1);
        triRapide(tableau,positionPivot+1,fin);
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
