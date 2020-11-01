import java.util.*;
import java.io.*;
 

class Solution{
	static ArrayList<Integer>[] g;
	static int[] vis, in ;
    static ArrayList<Integer> ans;

    static void kanh(int n){
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            if(in[i]==0) q.offer(i);
        }
        while(q.size()!=0){
            int curr = q.poll();
            ans.add(curr);
            for(int x: g[curr]){
                in[x]--;
                if(in[x]==0) q.offer(x);
            }
        }
        for(int y: ans) System.out.print(y+" ");
    }
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt(), m=sc.nextInt();
        g=new ArrayList[n+1];
        vis=new int[n+1]; in=new int[n+1];
        for(int i=0;i<=n;i++) g[i]=new ArrayList<>();
        ans=new ArrayList<>();
        for(int i=0;i<m;i++) {
            int u=sc.nextInt(), v=sc.nextInt();
            g[u].add(v);
            in[v]++;
        }
        kanh(n);
  }
}