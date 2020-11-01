import java.util.*;

class Solution{

	public static void sieveOfEr(int n, int[] a){
		for(int i=2;i<=n;i++){
			for(int j=2;i*j<=n;j++)    ///  O(N(log(log(N)))) -- time complexity
				a[i*j]=0;
		}
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int q=sc.nextInt();
		int[] a=new int[q+1];
		for(int i=0;i<=q;i++) a[i]=1;
		sieveOfEr(q, a);     
		for(int i=1;i<=q;i++){
			String ans = a[i]==1 ? "Prime" : "Not Prime";
			System.out.println("The no. "+i+" is "+ans);
		}


	}
}