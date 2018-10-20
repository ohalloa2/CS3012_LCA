import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class DAG {
	
	private int V;           // #vertices in diagraph
	private int E;                 // #edges in digraph
	private ArrayList<Integer>[] adj;    // adj[v] is the adjacency list for vertex v
	private int[] indegree;        // indegree[v] is the indegree of vertex v
	private boolean[] marked;		// boolean list which keeps track of visited vertices
	private boolean hasCycle;       //boolean tests if cycle in graph (true) or not(false)
	private boolean stack[];		//boolean list which keeps track of vertices that were visited
	
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
		return hasCycle;
    }
	
	public void findCycle(int v) {
		
	     marked[v] = true;
	        stack[v] = true;

	        for (int w : adj(v)) {
	            if(!marked[w]) {
	                findCycle(w);
	            } else if (stack[w]) {
	                hasCycle = true;
	                return;
	            }
	        }

	        stack[v] = false;		 
	 }
	
	
	public int findLCA(int v, int w)
	{
		findCycle(0);
		if(hasCycle)
		{
			return -1; //Graph not a DAG
		}
		
		if(validateVertex(v)<0||validateVertex(v)<0)
		{
			return -1; //Vertices are not valid
		}
		
		if(E==0)
		{
			return -1;  //Graph is empty (no edges)
		}
		return 0;
	}
	
	
	 public ArrayList<Integer> BFS(int s)
	    {
	        boolean visited[] = new boolean[V];
	 
	        LinkedList<Integer> queue = new LinkedList<Integer>();
	        ArrayList<Integer> order= new ArrayList<Integer>();
	 
	        visited[s]=true;
	        queue.add(s);
	       
	        while (queue.size() != 0)
	        {
	            s = queue.poll();           
	            order.add(s);
	           
	            Iterator<Integer> i = adj[s].listIterator();
	            while (i.hasNext())
	            {
	                int n = i.next();
	                if (!visited[n])
	                {
	                    visited[n] = true;
	                    queue.add(n);
	                }
	            }
	        }
	        return order;
	    }
	 
	 public DAG reverse() 
	 {
	        DAG reversedDAG = new DAG(V);
	        for (int v = 0; v < V; v++) {
	            for (int w : adj(v)) {
	                reversedDAG.addEdge(w, v);
	            }
	        }
	        return reversedDAG;
	    }
	
}

