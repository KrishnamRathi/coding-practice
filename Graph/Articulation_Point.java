import java.util.*;
import java.io.*;
 

class Solution{
	static ArrayList<Integer>[] g;
	static int[] vis, in ,low;
	static int cnt=0;
	static Set<Integer> hs;
	
	static void dfs(int node, int par) {
		vis[node]=1;
		in[node]=cnt; low[node]=cnt++;
		int par_child=0;
		
		for(int x: g[node]) {
			if(x==par) continue;
			
			if(vis[x]==1) low[node]=Math.min(low[node], in[x]);
			else {
				dfs(x, node);
				if(low[x]>=in[node] && par!=-1) {
					hs.add(node);
				}
				if(par==-1) par_child++;
				low[node]=Math.min(low[node], low[x]);
			}
		}
		if(par_child>1 && par==-1) hs.add(node);
		
	}
	
	public static void main(String[] args){
//		Scanner sc=new Scanner(System.in);
		FastReader sc=new FastReader();
		PrintWriter writer=new PrintWriter(System.out);
		int t=1;
		while(true) {
			int n=sc.nextInt(), m=sc.nextInt();
			if(n==0 && m==0) break;
			g=new ArrayList[n+1];
			hs=new HashSet<>();
			for(int i=0;i<=n;i++) g[i]=new ArrayList<>();
			vis=new int[n+1]; in=new int[n+1]; low=new int[n+1];
			cnt=0;
			for(int i=0;i<m;i++) {
				int u=sc.nextInt(), v=sc.nextInt();
				g[u].add(v);
				g[v].add(u);
			}
			dfs(1, -1);
			System.out.println(hs.size());
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
