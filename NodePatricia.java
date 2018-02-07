package dadat2;

import java.util.ArrayList;

public class NodePatricia extends NodePatriciaAbstract {
  EdgesArray edges;
  boolean isLeaf;

  public NodePatricia() {
    this.edges = new EdgesArray();
    this.isLeaf = true;
  }
  
  public boolean isLeaf() {
    return this.isLeaf;
  }
  
  public ArrayList<EdgePatricia> getEdges() {
    return edges.getEdges();
  }
  
  public void insertNode(String insertee, int checked) {
    
    String remain_label = insertee.substring(checked, insertee.length());
    
    if (this.isLeaf()) {
      if (remain_label.length() == 0) {
        System.out.println(insertee + "Insertando algo que ya esta.");
        return;
      } else {
        //insertar dos nodos hojas nuevos. Uno con edge de string vacio y uno con lo que falta chequear
        this.edges.insertByName(remain_label);
        this.edges.insertByName("");
        this.isLeaf = false;
      }
    } else {
      //estamos en un nodo
      if (remain_label.length() == 0) {
    	//si es vacio, insertamos un nodo vacio
        //tal vez deberiamos revisar si ya esta? (busquemos antes de insertar pls)
        this.edges.insertByName("");
      } else {
        //buscamos una arista que empiece con la misma letra
        
        int edge_index = edges.searchIndexByLetter(remain_label.substring(0,1));
        //si el label de la arista es igual o prefijo de remain_label, se sigue bajando.
        //si remain_label es prefijo del label de la arista, la arista se parte en dos
        if (edge_index == -1) {
          //Caso 4: Si falla, insertmos lo que queda
          this.edges.insertByName(remain_label);
        } else {
          //hay una arista con algo en comun
          String down_label = this.edges.getEdgeLabel(edge_index);
          
          //ver cuanto es comun
          int common_prefix_length = 0;
          for (int i = 0; i < remain_label.length(); i++) {
            if (i < down_label.length()) {
              if (remain_label.charAt(i) == down_label.charAt(i)) {
                common_prefix_length++;
                continue;
              }
            }
            break;
          }
          
          if (common_prefix_length == down_label.length()) {
            //Caso 1: Lo que baja esta incluido en la arista por incluir. Se baja y continua ahi.
            edges.getNode(edge_index).insertNode(remain_label, common_prefix_length); 
            return;
          } else { //Caso 2? Hay que partir por la mitad.
            System.out.println("Partir por la mitad");//DEBUG
            NodePatricia old_kid = edges.getNode(edge_index);
              
            NodePatricia new_kid = new NodePatricia();
            EdgePatricia new_kid_edge = new EdgePatricia(remain_label.substring(0, common_prefix_length));
            new_kid_edge.setKid(new_kid);
            new_kid.insertNode(old_kid, down_label.substring(common_prefix_length));
            new_kid.insertNode(remain_label.substring(common_prefix_length), 0);
            
            edges.setEdge(new_kid_edge, edge_index);
            return;
          }
        }
      }
    }
  }

  @Override
  public void insertNode(NodePatricia node, String param_label) {
    // TODO Auto-generated method stub
    edges.insertNode(node, param_label);
    this.isLeaf = false;
  }
  
  public void showDebug() {
    System.out.println("Nodo");
    if (!this.isLeaf()) {
      ArrayList<EdgePatricia> edges_array = edges.getEdges();
      for (int i = 0; i < edges_array.size(); i++) {
        System.out.println("Label:" + edges_array.get(i).getLabel());
        edges_array.get(i).getKid().showDebug();
      }
    }
    System.out.println("Fin Nodo");
  }
}
