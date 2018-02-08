package ternarySearchTree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTernaryTree {

  @Test
  void test_insert() {
    NodeTernary head = new NodeTernary();
    InsertTernary insert = new InsertTernary();
    insert.insert(head, "foo", 0);
    SearchTernary search = new SearchTernary();
    assert(search.search(head, "foo", 0));
    assert(!search.search(head, "f", 0));
    assert(!search.search(head, "fo", 0));
  }
}
