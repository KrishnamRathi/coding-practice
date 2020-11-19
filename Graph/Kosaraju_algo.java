import java.util.*;
import java.io.*;
 
class Solution{
    static FastReader sc=new FastReader();
    static PrintWriter writer=new PrintWriter(System.out);
    static ArrayList<Integer>[] g, tg;
    static int[] vis, out;
    static int in;
    
    static void dfs(int node) {
    	vis[node]=1;
    	for(int x: g[node]) {
    		if(vis[x]==0) dfs(x);
    	}
    	out[in++]=node;
    }
    
    static void dfstg(int node) {
    	vis[node]=1;
    	
    	for(int x: tg[node]) {
    		if(vis[x]==0) dfstg(x);
    	}
    	System.out.print(node+" ");
    }
    
  
	public static void main(String[] args){
		int tc=sc.nextInt();
		while(tc-->0) {
			int n=sc.nextInt(), m=sc.nextInt();
			g=new ArrayList[n+1]; tg=new ArrayList[n+1];
			in=1;
			vis=new int[n+1]; out=new int[n+1];
			for(int i=0;i<=n;i++) {
				g[i]=new ArrayList<>();
				tg[i]=new ArrayList<>();
			}
			for(int i=0;i<m;i++) {
				int x=sc.nextInt(), y=sc.nextInt();
				g[x].add(y);
				tg[y].add(x);
			}
			dfs(1);
			Arrays.fill(vis, 0);
			for(int i=n;i>0;i--) {
				if(vis[i]==0) {
					System.out.print("SCC:- ");
					dfstg(i);
					System.out.println();
				}
			}
		}
        
        writer.flush();
        writer.close();
	}
	
  static class FastReader { 
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
