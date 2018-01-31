package dadat2;

import java.util.ArrayList;

public class LookupPatricia {
  
  public boolean lookupConcrete(String target, NodePatriciaInterface node, int checked) {
    //Ver si es correcto
    if (checked == target.length() && node.isLeaf()) {
      return true;
    }
    
    ArrayList<EdgePatricia> edges = node.getEdges();
    int edge_num = edges.size();
    
    String remaining_target = target.substring(checked, target.length());
    for (int i = 0; i < edge_num; i++) {
      if (remaining_target.startsWith( edges.get(i).getLabel() )) {
        return lookupConcrete(target, edges.get(i).getKid() , checked + edges.get(i).getLabel().length());
      }
    }
    return false;
  }
  
  public boolean lookup(String target, NodePatriciaAbstract head) {
    if (head.isLeaf()) return false;
    return lookupConcrete(target, head, 0);
  }
}
