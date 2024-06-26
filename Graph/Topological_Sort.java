import java.util.*;
import java.io.*;
 

class Solution{
    static FastReader sc=new FastReader();
    static PrintWriter writer=new PrintWriter(System.out);
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
    }
	
	public static void main(String[] args){
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
        if(ans.size()!=n) System.out.println("Sandro fails.");
        else for(int x: ans) System.out.print(x+" ");
  }
  static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
}