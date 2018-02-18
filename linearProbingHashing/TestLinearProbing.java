package linearProbingHashing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLinearProbing {

  @Test
  void test() {
    System.out.println(Integer.toString("Testeo".hashCode()));
    System.out.println(Integer.toString("Testeo".hashCode()));
    System.out.println(Integer.toString("a".hashCode()));
    System.out.println(Integer.toString("b".hashCode()));
    String[] arr = new String[1];
    System.out.println(arr[0]);
  }
  
  @Test
  void test_insert() {
    HashTable ht = new HashTable(9999);
    assert(!ht.search("pienso"));
    ht.insert("pienso");
    assert(ht.search("pienso"));
    assert(!ht.search("existo"));
  }
}
