package TP2;
import java.lang.Math;
import java.util.Scanner;

public class Sys{
	int n;
	float b[]= new float[19];
	float a[][]=new float [19][19]; 
	
	public  void Remplir(){
		Scanner o2 = new Scanner(System.in);
		System.out.println("\n\n Donner la taille de votre matrice");
		int n = o2.nextInt();
		this.Remplissage(a, b, n);
		System.out.println("\n Le système est: \n");
		this.affSys(a, b , n);
	}
	public void affSys(float [][] a,float [] b ,int n)
	{
		int i,j;
		System.out.println("\n\n");
		for (i=0;i<n;i++){
			System.out.println(" [");
		    for (j=0;j<n;j++){
		    	System.out.println(a[i][j]);
		    }
		System.out.println("] [ "+b[i]+" ]");
		System.out.println("\n");
		}
		}

	public  void Remplissage(float [][] a, float [] b, int n) {
		int i,j;
		Scanner s = new Scanner(System.in);
		System.out.println("\n\n La matrice A: \n\n");
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++){
				a[i][j] = s.nextFloat();
			}
		}
		System.out.println("\n\n La matrice  B \n\n");
		for (i=0; i<n;i++) {
			b[i] = s.nextFloat();
		}
	}
	public void  Commatrice(float [][]a, float [][]c, int i, int j, int n) {
		int l,k;
		/*int i=0;
		int j=0;
		float c[][] = new float[19][19];*/
		for(l=0;l<n;l++) {
			for(k=0;k<n;k++) {
				if ((l<i)&&(k<j)) {
					c[l][k]=a[l][k];
				}
		        if ((l>i)&&(k<j)) {
		        	c[l-1][k]=a[l][k];
		        }
		        if ((l<i)&&(k>j)) {
		        	c[l][k-1]=a[l][k];
		        }
		        if ((l>i)&&(k>j)) {
		        	c[l-1][k-1]=a[l][k];
		        }
			}
		}
		
	}
	public float det(float [][] a, int z ) {
		this.n=z;
		System.out.println(n);
		int k = 2 -1;
		int j;
		float c[][] = new float[19][19];
		float s;
		if(z==0) {
			return 96;
		}
		s=0;
		for(j=0;j<2;j++)
		{
		this.Commatrice(a, c, k, j, n);
		s += Math.pow(-1,k+j)*a[k][j]*this.det(c, k);
		}
		return(s);
		
		
		
	}
	public void Cramer(float [][] a, float [] b, int n ) {
		float deter = det(a, n);
		int i,j,k;
		float A[][] = new float[19][19];
		float x[] =  new float[19];
		if(deter==0) {
			System.out.println("\n Dterminant nul pas de solution \n");
			Scanner pauser = new Scanner (System.in);
		    pauser.nextLine();
		}
		for(j=0;j<n;j++){
			for(k=0;k<n;k++){
				if (k==j){
					for(i=0;i<n;i++) A[i][k]=b[i];
				}	
				else {
					for(i=0;i<n;i++) A[i][k]=a[i][k];
				}
			}
		x[j]=det(A,n)/deter;
		}
		System.out.println("\n-------------- Cramer -------------\n");
		System.out.println("\n * Le determiant du systeme :  \n"+deter);
		System.out.println("\n * La resolution donne :\n\n");
		for (i=0;i<n;i++) {
			System.out.println("X"+(i+1)+"="+ x[i] );
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Sys myObj = new Sys();
		/*----------------------------------------------------------------------------------*/		
        System.out.println("\n *******************************************************\n");
		System.out.println(" *                                                     *\n");
		System.out.println(" *           Resolution de A x = B                     *\n");
		System.out.println(" *                                                     *\n");
		System.out.println("v *******************************************************\n");
		System.out.println(" *                                                     *\n");
		System.out.println(" *   Choix de la methode  :                            *\n");
		System.out.println(" *                                                     *\n");
		System.out.println(" *      A => Cramer                                    *\n");
		System.out.println(" *      B => Inversion                                 *\n");
		System.out.println(" *      C => Gauss                                     *\n");
		System.out.println(" *      D => Gauss pivot partiel                       *\n");
		System.out.println(" *      E => Gauss pivot total                         *\n");
		System.out.println(" *      F => Jordan                                    *\n");
		System.out.println(" *      G => LU Doolittle                              *\n");
		System.out.println(" *      H => LU Crout                                  *\n");
		System.out.println(" *      I => Cholesky                                  *\n");
		System.out.println(" *      J => Jacobie                                   *\n");
		System.out.println(" *      K => Gauss-Seidel                              *\n");
		System.out.println(" *                                                     *\n");
		System.out.println(" *******************************************************\n");
		System.out.println(" *                                                     *\n");
		System.out.println(" *    X => E X I T                                     *\n");
		System.out.println(" *                                                     *\n");
		System.out.println(" *******************************************************\n\n");	
		/*----------------------------------------------------------------------------------*/
		Scanner o = new Scanner(System.in);
		System.out.println("Entrez votre choix");
		String choix = o.nextLine();
		switch (choix){
		case "A":
		    myObj.Remplir();
		    myObj.Cramer(myObj.a, myObj.b, myObj.n);
		    break;
		  case "B":
		    System.out.println("Tuesday");
		    break;
		  case "C":
		    System.out.println("Wednesday");
		    break;
		  case "D":
		    System.out.println("Thursday");
		    break;
		  case "E":
		    System.out.println("Friday");
		    break;
		  case "F":
		    System.out.println("Saturday");
		    break;
		  case "G":
		    System.out.println("Sunday");
		    break;
		  case "H":
			  break;
		  case "I":
			  break;
		  case "J":
			  break;
		  case "K":
			  break;
		  case "X":
			  break;
		  
		  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
}