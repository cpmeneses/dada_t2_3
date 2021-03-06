package dadat2;

import java.util.ArrayList;

public class EdgesArray {
  ArrayList<EdgePatricia> edges;
  
  public EdgesArray() {
    this.edges = new ArrayList<EdgePatricia>();
  }
  
  public int searchIndexByLetter(String l) {
    String iter_str;
    for (int i = 0; i < edges.size(); i++) {
      iter_str = edges.get(i).getLabel();
      if (iter_str.startsWith(l) && iter_str.length() > 0) {
        return i;
      }
    }
    return -1;
  }
  
  public ArrayList<EdgePatricia> getEdges() {
    return this.edges;
  }

  public void insertByName(String edge_name) {
    EdgePatricia edge = new EdgePatricia(edge_name);
    this.edges.add(edge);
  }
  
  public NodePatricia getNode(int index){
    return edges.get(index).getKid();
  }

  public String getEdgeLabel(int edge_index) {
    return edges.get(edge_index).getLabel();
  }

  public void insertNode(NodePatricia node, String edge_name) {
    EdgePatricia edge = new EdgePatricia(edge_name);
    edge.setKid(node);
    edges.add(edge);
  }

  public void setEdge(EdgePatricia new_kid_edge, int edge_index) {
    edges.set(edge_index, new_kid_edge);
  }
}
