package ternarySearchTree;

public class InsertTernary {
  public void insert(NodeTernary head, String insertee, int checked) {

    char char_check = insertee.charAt(checked);
    if (head.isVoid()) {
      head.setLabel(char_check);
      checked++;
      if (checked >= insertee.length()) {
        head.setWord();
        return;
      }
      insert(head.getCenterNode(), insertee, checked);
      return;
    } else {
      if (char_check < head.getLabel()) {
        insert(head.getLeftNode(), insertee, checked);
        return;
      }
      
      if (char_check > head.getLabel()) {
        insert(head.getRightNode(), insertee, checked);
        return;
      } else {
        checked++;
        if (checked >= insertee.length()) {
          head.setWord();
          return;
        }
        insert(head.getCenterNode(), insertee, checked);
        return;
      }
    }
  }
}
