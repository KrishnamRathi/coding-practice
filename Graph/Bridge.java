import java.util.*;
import java.io.*;
 

class Solution{
	static ArrayList<Integer>[] g;
	static int[] vis, low, in;
	static int cnt=0, f=0;
	
	static void dfs(int node, int par) {
		vis[node]=1; 
		low[node]= cnt; 
		in[node]=cnt; 
		cnt++; 
		for(int x: g[node]) {
			if(x==par) continue;
			
			if(vis[x]==1) low[node] = Math.min(low[node], in[x]); // backedge
			else {
				dfs(x, node);
				
				if(low[x]>in[node]) {
					f=1; // edge x - node is a bridge
				}
				low[node] = Math.min(low[node], low[x]);
			}
		}
	}
	
	public static void main(String[] args){
//		Scanner sc=new Scanner(System.in);
		FastReader sc=new FastReader();
		PrintWriter writer=new PrintWriter(System.out);
		int t=1;
		while(t-->0) {
			int n=sc.nextInt(), m=sc.nextInt();
			g=new ArrayList[n+1];
			for(int i=0;i<=n;i++) g[i]=new ArrayList<>();
			vis=new int[n+1]; low=new int[n+1]; in=new int[n+1]; 
			cnt=0; f=0;
			for(int i=0;i<m;i++) {
				int u=sc.nextInt(), v=sc.nextInt();
				g[u].add(v);
				g[v].add(u);
			}
			dfs(1, -1);
			if(f==1) System.out.println('0');
			else {
				
			}
			
		}
		writer.flush();
		writer.close();
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