import java.util.*;
import java.io.*;
 

class LCA {
	
	static ArrayList<Integer>[] g;
	static int[][] LCA;
	static int[] h;
	
	static void dfs(int i, int par, int height){
		LCA[i][0] = par;
		h[i] = height;
		for(int x: g[i]) {
			if(x!=par) dfs(x, i, height+1);
		}
	}
	
	
	public static void main(String[] args){
//		Scanner sc=new Scanner(System.in);
		FastReader sc=new FastReader();
		PrintWriter writer=new PrintWriter(System.out);
		int t=1;
		while(t-->0) {
			int n=sc.nextInt(), m=sc.nextInt();
			int MAX_N=(int)Math.log(n);
			g=new ArrayList[n+1];
			h=new int[n+1];
			LCA=new int[n+1][MAX_N];
			for(int i=0;i<=n;i++) {
				g[i]=new ArrayList<>();
				Arrays.fill(LCA[i], -1);
			}
			for(int i=0;i<m;i++) {
				int x=sc.nextInt(), y=sc.nextInt();
				g[x].add(y);
				g[y].add(x);
			}
			int x=sc.nextInt(), y=sc.nextInt();
			dfs(1, -1, 0); 
			if(h[y]>h[x]) {
				int temp=x;
				x=y;
				y=temp;
			}
			int d=h[x]-h[y];
			for(int i=1;i<MAX_N;i++) {
				for(int j=1;j<n;j++) {
					if(LCA[j][i-1]!=-1) {
						int par = LCA[j][i-1];
						LCA[j][i] = LCA[par][i-1];
					}
				}
			}
			while(d>0) {
				int l=(int)(Math.log(d)/Math.log(2));
				x = LCA[x][l];
				d-=1<<l;
			}
			if(x==y) System.out.println(x);
			else {
				for(int i=MAX_N-1;i>=0;i--) {
					if(LCA[x][i]!=LCA[y][i]) {x=LCA[x][i]; y=LCA[y][i];}
				}
				System.out.println(LCA[x][0]);
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