package dadat2;

import java.util.ArrayList;

public abstract class NodePatriciaAbstract implements NodePatriciaInterface {
  ArrayList<EdgePatricia> edges;
  boolean isLeaf;
  
  public boolean isLeaf() {
    return this.isLeaf;
  }
  
  public ArrayList<EdgePatricia> getEdges() {
    return edges;
  }
}
