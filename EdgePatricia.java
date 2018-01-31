package dadat2;

public class EdgePatricia implements EdgePatriciaInterface {
  NodePatricia kidNode;
  String label;
  
  public EdgePatricia(String label_param) {
    this.label = label_param;
    this.kidNode = new NodePatricia();
  }
  
  public boolean isVoid() {
    return false;
  }
  
  public String getLabel() {
    return this.label;
  }
  
  public NodePatricia getKid() {
    return this.kidNode;
  }
}
