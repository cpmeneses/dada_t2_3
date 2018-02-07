package dadat2;

import java.util.ArrayList;

public class NodePatriciaRoot extends NodePatriciaAbstract {
  
  EdgesArray edges;
  boolean isLeaf;
  
  public NodePatriciaRoot() {
    this.isLeaf = true;
    this.edges = new EdgesArray();
  }
	
  public boolean isLeaf() {
    return this.isLeaf;
  }
  
  public ArrayList<EdgePatricia> getEdges() {
	    return edges.getEdges();
	  }
  
  @Override
  public void insertNode(String insertee, int checked) {    
    String remain_label = insertee.substring(checked, insertee.length());
    if (this.isLeaf()) { //Es una hoja
      if (remain_label.length() == 0) { //Intentando insertar un string de largo 0
        System.out.println("En root esto es un error");
        return;
      } else { //Insertar el resto.
        System.out.println("Insertar directamente");//DEBUG
        this.edges.insertByName(remain_label);
        this.isLeaf = false;
      }
    } else { //Es un nodo
      if (remain_label.length() == 0) { //Este es el nodo de lo que queremos insertar.
        System.out.println("Nodo de lo que queremos insertar");//DEBUG
        this.edges.insertByName("");
        return;
      } else { //Largo > 0. Buscamos una arista que empiece con la misma letra.
        int edge_index = edges.searchIndexByLetter(remain_label.substring(0,1));
        //si el label de la arista es igual o prefijo de remain_label, se sigue bajando.
        //si remain_label es prefijo del label de la arista, la arista se parte en dos
        if (edge_index == -1) { //Caso 4: Si no hay, insertmos lo que queda.
          this.edges.insertByName(remain_label);
          
        } else { //Hay una arista con por lo menos una letra en comun.
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
          
          if (common_prefix_length == down_label.length()) { //Caso 1: Lo que baja esta incluido en la arista por incluir. Se baja y continua ahi.
            
            edges.getNode(edge_index).insertNode(insertee, checked + common_prefix_length);
            return;
          } else { //Caso 2? Hay que partir por la mitad.
            System.out.println(Integer.toString(edges.getEdges().size()));
            System.out.println("Caso partir por la mitad");//DEBUG
            NodePatricia old_kid = edges.getNode(edge_index);
            
            NodePatricia new_kid = new NodePatricia();
            System.out.println(remain_label.substring(0, common_prefix_length));//DEBUG
            EdgePatricia new_kid_edge = new EdgePatricia(remain_label.substring(0, common_prefix_length));
            new_kid_edge.setKid(new_kid);
            System.out.println(down_label.substring(common_prefix_length, down_label.length()));//DEBUG
            System.out.println(Integer.toString(new_kid.getEdges().size()));//DEBUG
            new_kid.insertNode(old_kid, down_label.substring(common_prefix_length, down_label.length()));
            System.out.println(Integer.toString(new_kid.getEdges().size()));//DEBUG
            System.out.println(remain_label.substring(common_prefix_length, remain_label.length()));//DEBUG
            new_kid.insertNode(remain_label.substring(common_prefix_length, remain_label.length()), 0);
            System.out.println(Integer.toString(new_kid.getEdges().size()));//DEBUG
            
            edges.setEdge(new_kid_edge, edge_index);
            return;
          }
        }
      }
    }
  }

  @Override
  public void insertNode(NodePatricia node, String param_label) {
    edges.insertNode(node, param_label);
    return;
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
