import static org.junit.Assert.*;
import org.junit.*;

public class BinNodePublicTest {

	// ========== some trees ==========
	protected static final AbstractBinNode<String> simpleGeneralTree;
	static {
		// __________a___________
		// ______//_____\________
		// _____b=========c______
		// ___//_\_____//_|_\____
		// ___d===e____f==g==h___
		BinNode<String> f = new BinNode<>("f", null, new BinNode<>("g", null, new BinNode<>("h", null, null)));
		BinNode<String> d = new BinNode<>("d", null, new BinNode<>("e", null, null));
		BinNode<String> c = new BinNode<>("c", f, null);
		BinNode<String> b = new BinNode<>("b", d, c);
		simpleGeneralTree = new BinNode<>("a", b, null);
	}

	protected static final AbstractBinNode<String> simpleNonTree;
	static {
		// __________a___________
		// ______//_____\________
		// _____b====\\__\_______
		// ___//_\_____===c______
		// ___d===e==//__________
		BinNode<String> c = new BinNode<>("c", null, null);
		BinNode<String> d = new BinNode<>("d", null, new BinNode<>("e", null, c));
		BinNode<String> b = new BinNode<>("b", d, c);
		simpleNonTree = new BinNode<>("a", b, null);
	}

	protected static final AbstractBinNode<Integer> simpleBinaryTree;
	static {
		// __________1__________
		// ______//_____\_______
		// _____2========3______
		// ___//_\_____//_\_____
		// ___4===5____6===7____
		BinNode<Integer> f = new BinNode<>(6, null, new BinNode<>(7, null, null));
		BinNode<Integer> d = new BinNode<>(4, null, new BinNode<>(5, null, null));
		BinNode<Integer> c = new BinNode<>(3, f, null);
		BinNode<Integer> b = new BinNode<>(2, d, c);
		simpleBinaryTree = new BinNode<>(1, b, null);
	}

	protected static final AbstractBinNode<Alephbeth> simpleBinarySearchTree;
	static {
		// __________d__________
		// ______//_____\_______
		// _____b========w______
		// ___//_\_____//_\_____
		// ___a===g____h===z____
		BinNode<Alephbeth> h = new BinNode<>(Alephbeth.He, null, new BinNode<>(Alephbeth.Zajin, null, null));
		BinNode<Alephbeth> a = new BinNode<>(Alephbeth.Aleph, null, new BinNode<>(Alephbeth.Gimel, null, null));
		BinNode<Alephbeth> w = new BinNode<>(Alephbeth.Waw, h, null);
		BinNode<Alephbeth> b = new BinNode<>(Alephbeth.Beth, a, w);
		simpleBinarySearchTree = new BinNode<>(Alephbeth.Daleth, b, null);
	}

	// ========== BinNode.isTree ==========
	@Test(timeout = 666)
	public void pubTest__oneNode_isTree_gives_true() {
		// ACHTUNG - WARNUNG - VORSICHT - GEFAHR:
		// Java8 hat eine bessere Typinferenz fuer den diamond operator als Java7 (zumindest jdk1.8.0_45 vs. jdk1.7.0_79 von Oracle).
		// => javac von Java8 ist dumm und erkennt den Unterschied zu Java7 auch dann nicht, wenn der "compiler compliance level" auf 7 gesetzt ist!!!11elf
		// Dieser Test soll eine "echt jetzt Java7-kompatible" Implementierung von BinNode erzwingen... ;)
		AbstractBinNode<Alephbeth> rootIsLeafIsRoot = new BinNode<>(null, null, null);
		assertTrue(rootIsLeafIsRoot.isTree());
	}

	// ========== BinNode.isTree ==========
	@Test(timeout = 666)
	public void pubTest__simpleGeneralTree_isTree_gives_true() {
		assertTrue(simpleGeneralTree.isTree());
	}

	@Test(timeout = 666)
	public void pubTest__simpleNonTree_isTree_gives_false() {
		assertFalse(simpleNonTree.isTree());
	}

	// ========== BinNode.getHeight ==========
	@Test(timeout = 666)
	public void pubTest__simpleGeneralTree_getHeight_gives_2() {
		assertEquals(2, simpleGeneralTree.getHeight());
	}

	@Test(timeout = 666)
	public void pubTest__simpleNonTree_getHeight_gives_m1() {
		assertEquals(-1, simpleNonTree.getHeight());
	}

	// ========== BinNode.getBranchingFactor ==========
	@Test(timeout = 666)
	public void pubTest__simpleGeneralTree_getBranchingFactor_gives_3() {
		assertEquals(3, simpleGeneralTree.getBranchingFactor());
	}

	@Test(timeout = 666)
	public void pubTest__simpleNonTree_getBranchingFactor_gives_m1() {
		assertEquals(-1, simpleNonTree.getBranchingFactor());
	}

	// ========== BinNode.isBinaryTree ==========
	@Test(timeout = 666)
	public void pubTest__simpleBinaryTree_isBinaryTree_gives_true() {
		assertTrue(simpleBinaryTree.isBinaryTree());
	}

	@Test(timeout = 666)
	public void pubTest__simpleNonTree_isBinaryTree_gives_false() {
		assertFalse(simpleNonTree.isBinaryTree());
	}

	// ========== BinNode.isBinarySearchTree ==========
	@Test(timeout = 666)
	public void pubTest__simpleBinarySearchTree_isBinarySearchTree_gives_true() {
		assertTrue(simpleBinarySearchTree.isBinarySearchTree());
	}

	@Test(timeout = 666)
	public void pubTest__simpleBinaryTree_isBinarySearchTree_gives_false() {
		assertFalse(simpleBinaryTree.isBinarySearchTree());
	}

	// ========== BinNode.isAVLTree ==========
	@Test(timeout = 666)
	public void pubTest__simpleBinaryTree_isAVLTree_gives_true() {
		assertTrue(simpleBinarySearchTree.isAVLTree());
	}

	@Test(timeout = 666)
	public void pubTest__simpleBinaryTree_isAVLTree_gives_false() {
		assertFalse(simpleBinaryTree.isAVLTree());
	}

	// ========== BinNode.isMinHeap ==========
	@Test(timeout = 666)
	public void pubTest__simpleBinaryTree_isMinHeap_gives_true() {
		assertTrue(simpleBinaryTree.isMinHeap());
	}

	@Test(timeout = 666)
	public void pubTest__simpleGeneralTree_isMinHeap_gives_false() {
		assertFalse(simpleGeneralTree.isMinHeap());
	}

	// ========== BinNode.isMaxHeap ==========
	@Test(timeout = 666)
	public void pubTest__simpleGeneralTree_isMaxHeap_gives_false() {
		assertFalse(simpleGeneralTree.isMaxHeap());
	}
}