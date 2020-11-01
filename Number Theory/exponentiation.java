import java.util.*;

class Solution{

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(), p=sc.nextInt(), base, ans=1;
		base=n;
		while(p>0){      /// O(logN) -- Time Complexity  
			if(p%2==0) {
				base*=base;
				p/=2;
			}else {
				ans*=base;
				p--;
			}
		}
		System.out.println(ans);
	}
}