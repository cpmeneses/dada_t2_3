package dadat2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestsPatricia {

  //@Test
  //void test() {
    //fail("Not yet implemented");
  //}

  @Test
  void test_startsWith() {
    assert("casa".startsWith(""));
  }
  
  @Test
  void test_edgesArray_searchIndexByLetter() {
    EdgesArray edges = new EdgesArray();
    edges.insertByName("foo");
    int index = edges.searchIndexByLetter("f");
    assert(index == 0);
    index = edges.searchIndexByLetter("o");
    assert(index == -1);
  }

  @Test
  void test_insertAndLookupRoot() {
    NodePatriciaRoot root_node = new NodePatriciaRoot();
    assert(root_node.isLeaf());
    assertEquals(root_node.getEdges().size(), 0);
    
    root_node.insertNode("a", 0);
    assert(!root_node.isLeaf());
    assertEquals(root_node.getEdges().size(), 1);
    assertEquals(root_node.getEdges().get(0).label, "a");
    
    LookupPatricia lookup = new LookupPatricia();
    assert(lookup.lookup("a", root_node));
    assert(!lookup.lookup("o", root_node));
    
    root_node.insertNode("s", 0);
    assertEquals(root_node.getEdges().size(), 2);
    assert(lookup.lookup("a", root_node));
    assert(lookup.lookup("s", root_node));
    assert(!lookup.lookup("as", root_node));
    assert(!lookup.lookup("o", root_node));
    
    root_node.insertNode("as", 0);
    assertEquals(root_node.getEdges().size(), 2);
    assert(lookup.lookup("a", root_node));
    assert(lookup.lookup("as", root_node));
    assert(lookup.lookup("s", root_node));
    assert(!lookup.lookup("o", root_node));
    //assert("casa".startsWith(""));
    
    root_node.insertNode("beso", 0);
    assertEquals(root_node.getEdges().size(), 3);
    assert(lookup.lookup("beso", root_node));
    assert(lookup.lookup("a", root_node));
    assert(lookup.lookup("as", root_node));
    assert(lookup.lookup("s", root_node));
    assert(!lookup.lookup("o", root_node));
    
    root_node.insertNode("be", 0);
    assertEquals(root_node.getEdges().size(), 3);
    assert(lookup.lookup("beso", root_node));
    assert(lookup.lookup("be", root_node));
    assert(lookup.lookup("a", root_node));
    assert(lookup.lookup("as", root_node));
    assert(lookup.lookup("s", root_node));
    assert(!lookup.lookup("o", root_node));
  }
  
  @Test
  void test_insertCaso2() {
    NodePatriciaRoot root_node = new NodePatriciaRoot();
    root_node.insertNode("beso", 0);
    root_node.insertNode("be", 0);
    
    ArrayList<EdgePatricia> edges1 = root_node.getEdges();
    assertEquals(edges1.size(), 1);
    EdgePatricia edge1 = edges1.get(0);
    assertEquals(edge1.getLabel(), "be");
    
    LookupPatricia lookup = new LookupPatricia();
    assert(lookup.lookup("beso", root_node));
    assert(lookup.lookup("be", root_node));
  }
  
  @Test
  void test_insert3() {
    NodePatriciaRoot root_node = new NodePatriciaRoot();
    root_node.insertNode("romane", 0);
    root_node.showDebug();
    System.out.println("INSERT romanus");//DEBUG
    root_node.insertNode("romanus", 0);
    root_node.showDebug();
    assertEquals(root_node.getEdges().get(0).getKid().getEdges().size(), 2);//DEBUG?
    root_node.insertNode("romulus", 0);
    root_node.insertNode("rubens", 0);
    root_node.insertNode("ruber", 0);
    root_node.insertNode("rubicon", 0);
    root_node.insertNode("rubicundus", 0);
    
    //root_node.showDebug();
    
    LookupPatricia lookup = new LookupPatricia();
    assert(lookup.lookup("romane", root_node));
    assert(lookup.lookup("romanus", root_node));
    assert(lookup.lookup("romulus", root_node));
    assert(lookup.lookup("rubens", root_node));
    assert(lookup.lookup("ruber", root_node));
    assert(lookup.lookup("rubicon", root_node));
    assert(lookup.lookup("rubicundus", root_node));
    assert(!lookup.lookup("r", root_node));
    assert(!lookup.lookup("rom", root_node));
    assert(!lookup.lookup("rub", root_node));
    assert(!lookup.lookup("rubic", root_node));
    assert(!lookup.lookup("rube", root_node));
    assert(!lookup.lookup("rom", root_node));
    assert(!lookup.lookup("roman", root_node));
  }
}
