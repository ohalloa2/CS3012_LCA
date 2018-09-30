import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	
	@Test 
	public void testForEmptyTree(){
		LCA treeEmpty = new LCA();
		assertEquals("LCA is empty: ",-1,treeEmpty.findLCA(0, 0));
	}
	

	@Test
	public void testForTreeSize1(){
		LCA treeSize1 = new LCA();
		treeSize1.root = new Node(1);
		assertEquals("LCA of 1 and 0: ",-1,treeSize1.findLCA(1, 0));
		
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
		
		assertEquals("LCA of 1 and 3: ", 1, treeSize9.findLCA(1,3));
		assertEquals("LCA of 4 and 5: ", 2,treeSize9.findLCA(4, 5));
		assertEquals("LCA of 8 and 9: ", 4,treeSize9.findLCA(8, 9));
		assertEquals("LCA of 6 and 9: ", 1, treeSize9.findLCA(6, 9));	
	}
	
	@Test
	public void testForTreeSize13(){
		
		LCA treeSize21 = new LCA();
		treeSize21.root = new Node(1);
		treeSize21.root.left = new Node(2);
		treeSize21.root.right = new Node(3);
		treeSize21.root.left.left = new Node(4);
		treeSize21.root.left.right = new Node(5);
		treeSize21.root.right.left = new Node(6);
		treeSize21.root.right.right = new Node(7);
		treeSize21.root.left.left.left = new Node(8);
		treeSize21.root.left.left.right = new Node(9);
		treeSize21.root.left.right.left = new Node(10);
		treeSize21.root.left.right.right = new Node(11);
		treeSize21.root.right.left.left = new Node(12);
		treeSize21.root.right.left.right = new Node(13);	
	
		assertEquals("LCA of 1 and 12: ", 1, treeSize21.findLCA(1,12));
		assertEquals("LCA of 2 and 3: ", 1, treeSize21.findLCA(2,3));
		assertEquals("LCA of 12 and 13: ", 6, treeSize21.findLCA(12,13));
		assertEquals("LCA of 8 and 9: ", 4, treeSize21.findLCA(8,9));
		assertEquals("LCA of 4 and 13: ", 1, treeSize21.findLCA(4,13));
	}
	
	@Test
	public void testForNonExitingNodes()
	{
		LCA testTree = new LCA();
		testTree.root = new Node(1);
		testTree.root.left = new Node(2);
		testTree.root.right = new Node(3);
		testTree.root.left.left = new Node(4);
		testTree.root.left.right = new Node(5);
		testTree.root.right.left = new Node(6);
		testTree.root.right.right = new Node(7);
		
		//failing
		assertEquals("Find ancestors of non-existent nodes in populated tree: ", null, testTree.findLCA(67, 9));
		assertEquals("Find ancestors of non-existent nodes in populated tree: ", null, testTree.findLCA(12, 19));	
	}
	
	@Test
	public void testWhenOneNodeIsAncestorOfOther(){
		
		
		
	}
	
	@Test
	public void testForALlSameNode(){
		
	}
	
	
	
}
