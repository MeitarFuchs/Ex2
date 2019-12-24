package utils;

import java.util.Collection;
import java.util.Iterator;

import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;

public class GraphGUI {

	graph myGraph = new DGraph();

	public void drawGraph (graph g) {
		Iterator<node_data> nodeIT = (node_data) (g.iterator()); 
		while (nodeIT.hasNext()) {
		
		}
	}
	
	
	public void drawNode (node_data nd) 
	{
		StdDraw.setPenRadius(0.005);
		int k = nd.getKey();
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.point(nd.getLocation().x(),nd.getLocation().y());
		StdDraw.textLeft(nd.getLocation().x(),nd.getLocation().y(), Integer.toString(k));
    
	}

	public void drawEdge (node_data src , node_data dest, int weight) {
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.line(src.getLocation().x(),src.getLocation().y(),dest.getLocation().x(),dest.getLocation().y());
		StdDraw.setPenRadius(0.002);
		StdDraw.setPenColor(StdDraw.YELLOW);
		int w=weight;
		StdDraw.point(dest.getLocation().x()+0.05,dest.getLocation().y()+0.05);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(dest.getLocation().x(),dest.getLocation().y(), Integer.toString(w));
	}

}
