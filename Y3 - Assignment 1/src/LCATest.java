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
		
		LCA treeSize9 = new LCA();
		treeSize9.root = new Node(1);
		treeSize9.root.left = new Node(2);
		treeSize9.root.right = new Node(3);
		treeSize9.root.left.left = new Node(4);
		treeSize9.root.left.right = new Node(5);
		treeSize9.root.right.left = new Node(6);
		treeSize9.root.right.right = new Node(7);
		treeSize9.root.left.left.left = new Node(8);
		treeSize9.root.left.left.right = new Node(9);
		
		assertEquals("LCA(1,3", 1, treeSize9.findLCA(1,3));
		assertEquals("LCA(4,5)", 2,treeSize9.findLCA(4, 5));
		assertEquals("LCA(8,9)", 4,treeSize9.findLCA(8, 9));
		assertEquals("LCA(6,9)", 3, treeSize9.findLCA(6, 9));	
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
