package ternarySearchTree;

public class NodeTernary {
  char label;
  boolean isVoid;
  boolean isWord;
  NodeTernary[] nodes;
  
  public NodeTernary() {
    this.nodes = new NodeTernary[3]; //0:izq, 1:cen, 2:der
    isVoid = true;
  }
  
  public boolean isVoid() {
    return this.isVoid;
  }
  
  public void setLabel(char param_char) {
    label = param_char;
    isVoid = false;
    //nodes[0] = new NodeTernary();
    //nodes[1] = new NodeTernary();
    //nodes[2] = new NodeTernary();
    for (int i = 0; i < 3; i++) {
      nodes[i] = new NodeTernary();
    }
  }
  
  public void setWord() {
    this.isWord = true;
  }
  
  public boolean isWord() {
    return this.isWord;
  }
  
  public char getLabel() {
    return label;
  }
  
  public NodeTernary getLeftNode() {
    return nodes[0];
  }
  
  public NodeTernary getCenterNode() {
    return nodes[1];
  }
  
  public NodeTernary getRightNode() {
    return nodes[2];
  }
}
