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
  
  @Test
  void test_insert_2() {
	NodeTernary head = new NodeTernary();
    InsertTernary insert = new InsertTernary();
    SearchTernary search = new SearchTernary();
    insert.insert(head, "is", 0);
    insert.insert(head, "be", 0);
    insert.insert(head, "on", 0);
    insert.insert(head, "as", 0);
    insert.insert(head, "he", 0);
    insert.insert(head, "in", 0);
    insert.insert(head, "it", 0);
    insert.insert(head, "at", 0);
    insert.insert(head, "by", 0);
    insert.insert(head, "of", 0);
    insert.insert(head, "or", 0);
    insert.insert(head, "to", 0);
    assert(search.search(head, "is", 0));
    assert(search.search(head, "be", 0));
    assert(search.search(head, "on", 0));
    assert(search.search(head, "as", 0));
    assert(search.search(head, "he", 0));
    assert(search.search(head, "in", 0));
    assert(search.search(head, "it", 0));
    assert(search.search(head, "at", 0));
    assert(search.search(head, "by", 0));
    assert(search.search(head, "of", 0));
    assert(search.search(head, "or", 0));
    assert(search.search(head, "to", 0));
    assert(!search.search(head, "i", 0));
    assert(!search.search(head, "o", 0));
    assert(!search.search(head, "s", 0));
    assert(!search.search(head, "b", 0));
    assert(!search.search(head, "n", 0));
    assert(!search.search(head, "t", 0));
    assert(!search.search(head, "h", 0));
    assert(!search.search(head, "e", 0));
    assert(!search.search(head, "a", 0));
    assert(!search.search(head, "y", 0));
    assert(!search.search(head, "io", 0));
    assert(!search.search(head, "ib", 0));
    assert(!search.search(head, "ibast", 0));
    assert(!search.search(head, "ba", 0));
  }
}
