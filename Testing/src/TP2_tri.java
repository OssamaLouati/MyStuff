
public class TP2_tri {
	public static void afficher(int[] tab) {
		for (int i : tab) {
			System.out.print(i+" " );
		}
		System.out.println(" ");
		
	}
	
	public static void tri(int[] t) {
		int r = 0; 
		int n = t.length;
		int  i =0;
		int a = n-1;
		while( i< a) {
			if(t[i] ==3) {
				int temp = 0;
				temp = t[i];
				t[i] = t[a];
				t[a] = temp;
				a--;
			}
			else {
				if(t[i] ==1) {
					int tem = 0;
					tem = t[i];
					t[i] = t[r];
					t[r] = tem;
					r++;
				}
				i++;
			}
		}
	}
	public void tri_den(int[] tab) {
		
		
	}
	public static int[] fusion(int[] t1, int[] t2) {
		int[] t3 = new int [t1.length+t2.length];
		int i=0;
		int j=0;
		int k =0;
		
		while(i < t1.length && j <t2.length) {
			if(t1[i] < t2[j]) {
				t3[k]=t1[i];
				i++;
				k++;
			}
			else {
				t3[k] = t2[j];
				j++;
				k++;
			}
		}
		while(i <t1.length) {
			t3[k] = t1[i];
			i++;
			k++;
		}
		while(j<t2.length) {
			t3[k] = t2[j];
			j++;
			k++;
			}		
		return t3;
		
	}
	public static void fusion2(int[] t, int x) {
		
	}
	
	
	public static void main(String[] atgs) {
		int[] t1= {1,3,7,10,12};
		int[] t2= {2,4,5,8};
		afficher(t2);
		afficher(t1);
		int[] ta = fusion(t1,t2);
		afficher(ta);
		
		
	}

}
