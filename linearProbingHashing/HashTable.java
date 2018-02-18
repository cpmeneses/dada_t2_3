package linearProbingHashing;

public class HashTable {
  int size;
  String[] table;
  
  HashTable(int size_param) {
    size = size_param;
    table = new String[size_param];
  }
  
  private int hash(String key) {
    return (key.hashCode() & 0x7fffffff) % this.size;
  }
  
  public void insert(String insertee) {
    int hash_value = hash(insertee);
    String extracted;
    for (int i = 0; i < size; i++) {
      extracted = table[(hash_value + i) % this.size];
      if (extracted == null) {
        table[(hash_value + i) % this.size] = insertee;
        return;
      }
    }
    //tabla llena.
  }
  
  public boolean search(String target) {
    int hash_value = hash(target);
    String extracted;
    for (int i = 0; i < size; i++) {
      extracted = table[(hash_value + i) % this.size];
      if (extracted == target) {
        return true;
      }
      if (extracted == null) {
        return false;
      }
    }
    return false; //tabla llena y no esta.
  }
  
  
}
