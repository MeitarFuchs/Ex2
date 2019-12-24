package dataStructure;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collection;

public class DGraph implements graph{
	private HashMap  <Integer, node_data> HashMapNode  = new HashMap<Integer, node_data>();
	private HashMap  <Integer, HashMap<Integer, edge_data>> HashMapEdge  = new HashMap<Integer, HashMap<Integer, edge_data>>();
	public static int MC=0;
	
	@Override
	public node_data getNode(int key) {
		return HashMapNode.get(key);
	}



	@Override
	public edge_data getEdge(int src, int dest) {
		return (HashMapEdge.get(src)).get(dest);
		
	}

	@Override
	public void addNode(node_data n) {
		HashMapNode.put(n.getKey(), n);
		HashMapEdge.put(n.getKey(),new HashMap<Integer, edge_data>());
	}

	
	
	@Override
	public void connect(int src, int dest, double w) {
		if (HashMapNode.get(src)!= null) {

			if (( HashMapEdge.get(src))!= null) {
				if(( HashMapEdge.get(src)).get(dest).getWeight()!=-1) {// what to do if we have weight
					  ((EdgeData) HashMapEdge.get(src).get(dest)).setWeight(w);
				}
			}
		}
		else {
			node_data nd = new NodeData(src);
			addNode(nd);
			((EdgeData) HashMapEdge.get(src).get(dest)).setWeight(w);
		}	
	}

	



	@Override
	public Collection<node_data> getV() {
		return HashMapNode.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		return HashMapEdge.get(node_id).values();
	}

	@Override
	public node_data removeNode(int key) {
		if (HashMapEdge.get(key)!=null) {
			HashMapEdge.remove(key);
			Collection<node_data> listV=getV();
			Iterator<node_data> it = listV.iterator(); 
			while (it.hasNext()) 
			{
				HashMapEdge.get(it.next().getKey()).remove(key);
			}
		}
		node_data tempND = new NodeData (HashMapNode.get(key));
		if (HashMapNode.get(key)!=null) {
			HashMapNode.remove(key);
		}
		return tempND;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		edge_data ed=new EdgeData();
		if (HashMapEdge.get(src)!=null) {
			ed=HashMapEdge.get(src).get(dest);
			HashMapEdge.get(src).remove(dest);
		}
		else {
			System.out.println("the src doesnt exsit");
		}
		return ed;
	}

	@Override
	public int nodeSize() {
		int Size = HashMapNode.size(); 
		return Size;
	}

	@Override
	public int edgeSize() {
		int Size = HashMapEdge.size(); 
		return Size;
	}

	
	@Override
	public int getMC() {	
		return MC;
	}

	public Iterator<node_data> iterator() 
	{
		return ((Collection<node_data>) HashMapNode).iterator();
	}

}
