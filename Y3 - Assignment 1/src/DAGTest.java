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
				DAG cyclic = new DAG(20);
				cyclic.addEdge(0, 1);
				cyclic.addEdge(1, 2);
				cyclic.addEdge(2, 0);
				cyclic.addEdge(2, 3);
				cyclic.addEdge(3, 4);

				cyclic.findCycle(0);
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
		public void testLCA()
		{
			DAG lca = new DAG(10);
			
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
			assertEquals("", 7, lca.findLCA(8, 7));
			assertEquals("", 6, lca.findLCA(6, 8));
		}
			
		
		@Test
		public void testLCAForNoCommonAncestors(){
			DAG lca2 = new DAG(11);
			lca2.addEdge(0, 1);
			lca2.addEdge(0, 2);
			lca2.addEdge(1, 2);
			lca2.addEdge(2, 3);
			lca2.addEdge(3, 4);
			lca2.addEdge(1, 5);
			lca2.addEdge(3, 5);
			
			//Check it works ok
			assertEquals("", 0, lca2.findLCA(3, 1));
			assertEquals("", 2, lca2.findLCA(3, 2));
			assertEquals("", 3, lca2.findLCA(4, 5));
			
			//Check for no common ancestors
			assertEquals("", -1, lca2.findLCA(7, 3));
		}
		
		@Test
		public void testLCAForSameVertex(){
			DAG lca3 = new DAG(11);
			lca3.addEdge(0, 1);
			lca3.addEdge(0, 2);
			lca3.addEdge(1, 2);
			
			assertEquals("", 2, lca3.findLCA(2, 2));
		}
		
		@Test
		public void testLCAForNonDAG(){
			DAG lca3 = new DAG(11);
			lca3.addEdge(0, 1);
			lca3.addEdge(0, 2);
			lca3.addEdge(2, 3);
			lca3.addEdge(3, 0);
			lca3.addEdge(3, 4);
			
			//Should return -1 if graph is not a DAG
			assertEquals("", -1, lca3.findLCA(2, 3));
			assertEquals("", -1, lca3.findLCA(3, 4));
			assertEquals("", -1, lca3.findLCA(1, 2));
			assertEquals("", -1, lca3.findLCA(0, 3));
			assertEquals("", -1, lca3.findLCA(1, 3));

		}
		
		@Test
		public void testLCAForEmptyDAG(){
			DAG lca4 = new DAG(5);
			assertEquals("", -1, lca4.findLCA(0, 2));
			assertEquals("", -1, lca4.findLCA(0, 0));
			assertEquals("", -1, lca4.findLCA(0, 3));
			
		}
		
		
	

	
	
	
}