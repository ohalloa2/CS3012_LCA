import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DAGTest {
	
	//Check Directed Graph class works correctly
		@Test
		public void testForDirectedGraph(){
			DAG test = new DAG(10);
			test.addEdge(1, 2);
			test.addEdge(1, 3);
			test.addEdge(3, 4);
			test.addEdge(4, 5);
			test.addEdge(4, 6);
			
			assertEquals("", 1, test.indegree(4));
			assertEquals("", 2, test.outdegree(4));
			assertEquals("", 5, test.E());
			assertEquals("", 10, test.V());
			String ans = "[2, 3]";
			assertEquals("",ans, test.adj(1).toString());
		}
		
		@Test
		public void testAddEdge(){
			DAG test1 = new DAG(5);
			test1.addEdge(3, 9);
			test1.addEdge(-2, -5);	
		}
		
		@Test
		public void testinDegree(){
			DAG test2 = new DAG(5);
			assertEquals("", -1, test2.indegree(-3));
		}
		
		@Test
		public void testOutDegree(){
			DAG test3 = new DAG(5);
			assertEquals("", -1, test3.outdegree(8));	
		}
		
		
		@Test(expected=Exception.class)
		public void exceptionTest(){
			//Can't make a directed graph with less than 0 vertices
			DAG test4 = new DAG(-5);
		}
		
		//Check Directed Acyclic Graph class works correctly
		@Test
		public void testsForCycle(){
				DAG cyclic = new DAG(5);
				cyclic.addEdge(0, 1);
				cyclic.addEdge(1, 2);
				cyclic.addEdge(2, 0);
				assertTrue(cyclic.hasCycle());
		}
		
		@Test
		public void testForAcyclicGraph(){
				DAG acyclic = new DAG(5);
				acyclic.addEdge(0, 1);
				acyclic.addEdge(1, 2);
				acyclic.addEdge(2, 3);
				assertFalse(acyclic.hasCycle());
		}
		
		@Test
		public void testLCA(){
			DAG lca = new DAG(8);
			
			//--------2---5----7--
			//---0--1-------6----8
			//--------3---4-------
			lca.addEdge(0, 1);
			lca.addEdge(1, 2);
			lca.addEdge(1, 3);
			lca.addEdge(2, 5);
			lca.addEdge(3, 4);
			lca.addEdge(4, 6);
			lca.addEdge(5, 6);
			lca.addEdge(6, 8);
			lca.addEdge(5, 7);
			lca.addEdge(7, 8);
			
			assertEquals("", 1, lca.findLCA(5, 4));
			assertEquals("", 5, lca.findLCA(7, 8));
			assertEquals("", 4, lca.findLCA(6, 4));
		}
		
		
		
	@Test 
	public void testE()
	{
		
	}
	
	@Test
	public void testV()
	{
		
	}

	
	
	
}