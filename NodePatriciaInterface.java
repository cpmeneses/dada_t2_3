package dadat2;

import java.util.ArrayList;

public interface NodePatriciaInterface {
  public boolean isLeaf();
  public ArrayList<EdgePatricia> getEdges();
  public void insertNode(String insertee, int checked);
  public void insertNode(NodePatricia node, String param_label);
}
