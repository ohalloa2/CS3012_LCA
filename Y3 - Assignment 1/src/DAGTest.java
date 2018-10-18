import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DAGTest {
	
	//Following tests check Directed Graph class works correctly
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
		
		
	@Test 
	public void testE()
	{
		
	}
	
	@Test
	public void testV()
	{
		
	}
	
	@Test 
	public void testLCA ()
	{
		
	}
	
	
	
}