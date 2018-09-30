import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	
	@Test 
	public void testForEmptyTree(){
		LCA treeEmpty = new LCA();
		assertEquals("LCA(Empty)",-1,treeEmpty.findLCA(0, 0));
	}
	

	@Test
	public void testForTreeSize1(){
		LCA treeSize1 = new LCA();
		treeSize1.root = new Node(1);
		assertEquals("LCA(1,0)",-1,treeSize1.findLCA(1, 0));
		
	}
	
	@Test
	public void testForTreeSize9(){
		
	}
	
	@Test
	public void testForTreeSize21(){
		
	}
	
	@Test
	public void testForNonExitingNodes(){
		
	}
	
	@Test
	public void testWhenOneNodeIsAncestorOfOther(){
		
	}
	
	@Test
	public void testForALlSameNode(){
		
	}
}
