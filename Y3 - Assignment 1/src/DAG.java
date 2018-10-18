import java.util.ArrayList;


public class DAG {
	
	private int V;           // #vertices in diagraph
	private int E;                 // #edges in digraph
	private ArrayList<Integer>[] adj;    // adj[v] is the adjacency list for vertex v
	private int[] indegree;        // indegree[v] is the indegree of vertex v
	private boolean[] marked;		// boolean list which keeps track of visited vertices
	private boolean hasCycle;       //boolean tests if cycle in graph (true) or not(false)
	
	
	public DAG(int V)
	{
		if (V < 0) throw new IllegalArgumentException("The number of vertices in a digraph must be non-negative");
	    this.V = V;
	    this.E = 0;
	    indegree = new int[V];
	    adj = (ArrayList<Integer>[]) new ArrayList[V];
	    for (int v = 0; v < V; v++) {
	        adj[v] = new ArrayList<Integer>();
	    }
	}
	
	public int V()
	{
		return V ;
	}
	
	public int E()
	{
		return E;
	}
	
	public void addEdge(int v, int w)
	{
		  if((validateVertex(v)>0)&&(validateVertex(w)>0))
		    {
		    	adj[v].add(w);
		    	indegree[w]++;
		    	E++;
		    }
		    else{
		    	System.out.println("Please enter vertices between 0 & n-1");
		    }
	}
	
	private int validateVertex(int v) {
		if (v < 0 || v >= V)
        	return -1;
        else
        	return 1;
    }

	public int indegree(int v) {
		if(validateVertex(v)<0){
			return -1;
		}
		else{
			return indegree[v];
		}

	}

	public int outdegree(int v)
	{
		if(validateVertex(v)<0){
			return -1;
		}
		else{
			return adj[v].size();
		}
    }
	
	public Iterable<Integer> adj(int v)
	{ return adj[v]; }
	
	public boolean hasCycle() {
		return true;
    }
	
	public void findCycle(int v) {
		 
	 }
	
	
	//public ArrayList<Integer>bfs(int s)
	//{
		
	//}
	
}

