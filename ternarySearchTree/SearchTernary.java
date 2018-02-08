package ternarySearchTree;

public class SearchTernary {
  
  public boolean search(NodeTernary head, String target, int checked) {
    
    char char_check = target.charAt(checked);
    if (head.isVoid()) {
      return false;
    } else {
      if (char_check < head.getLabel()) {
        return search(head.getLeftNode(), target, checked);
      }
      if (char_check > head.getLabel()){
        return search(head.getRightNode(), target, checked);
      } else {
        checked++;
        if (checked >= target.length()) {
          return head.isWord();
        }
        return search(head.getCenterNode(), target, checked);
      }
    }
  }
}
