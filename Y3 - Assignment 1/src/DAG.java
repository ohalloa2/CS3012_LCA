import java.util.ArrayList;


public class DAG {
	
	private int V;           // #vertices in diagraph
	private int E;                 // #edges in digraph
	private ArrayList<Integer>[] adj;    // adj[v] is the adjacency list for vertex v
	private int[] indegree;        // indegree[v] is the indegree of vertex v
	private boolean[] marked;		// boolean list which keeps track of visited vertices

	public int V()
	{
		return 0 ;
	}
	
	public void addEdge(int v, int w)
	{
		validateVertex(v);
	    validateVertex(w);
	    adj[v].add(w);
	    indegree[w]++;
	    E++;
	}
	
	private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

	public int indegree(int v) {
		validateVertex(v);
        return indegree[v];

	}
		
	public Iterable<Integer> adj(int v)
	{ return adj[v]; }
	
	
	public int E()
	{
		return 0;
	}
	
	
	public int LCA(int v, int w)
	{
	return 0;	
	}
	
	public ArrayList<Integer>bfs(int s)
	{
		
	}
	
}

