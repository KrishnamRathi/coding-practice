import java.util.*;
import java.io.*;
 

class Dijsktras {
	
	static ArrayList<Integer>[] g;
	static HashMap<String, Integer> h;
	static PriorityQueue<int[] > pq=new PriorityQueue<>((a1, a2) -> a1[0]-a2[0]);
	static int[] d;
	
	
	public static void main(String[] args){
//		Scanner sc=new Scanner(System.in);
		FastReader sc=new FastReader();
		PrintWriter writer=new PrintWriter(System.out);
		int t=1;
		while(t-->0) {
			int n=sc.nextInt(), m=sc.nextInt();
            g=new ArrayList[n+1]; 
            d=new int[n+1];
			Arrays.fill(d, Integer.MAX_VALUE);
			d[0]=0; d[1]=0;
			for(int i=0;i<=n;i++) {
				g[i]=new ArrayList<>();
			}
			h=new HashMap<>();
			for(int i=0;i<m;i++) {
				int x=sc.nextInt(), y=sc.nextInt(), w=sc.nextInt();
				g[x].add(y);
				g[y].add(x);
				h.put(x+"-"+y, w);
				h.put(y+"-"+x, w);
			}
			pq.offer(new int[] {0, 1});  // distance of node from source node(1) is 0;
			while(pq.size()!=0) {
				int[] node=pq.poll();
				for(int x: g[node[1]]) {
					int dis = node[0]+h.get(x+"-"+node[1]);
					if(d[x]>dis) {
						d[x] = dis;
						pq.offer(new int[] {dis, x});
					}
				}
			}
			for(int i=1;i<=n;i++) System.out.println(i+" "+d[i]);
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