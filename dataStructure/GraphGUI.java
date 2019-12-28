package dataStructure;

import java.util.Collection;
import java.util.Iterator;

import utils.Point3D;
import utils.StdDraw;

public class GraphGUI {

	static graph myGraph = new DGraph();

	public static void drawGraph (graph g) 
	{
		double minX=0, minY=0,maxX=0,maxY=0;
		Iterator<node_data> it= g.getV().iterator(); 
		while(it.hasNext())
		{
			node_data node = it.next();
			minX=Math.min(minX , node.getLocation().x() );
			maxX=Math.max(maxX,node.getLocation().x());
			maxY=Math.max(maxY,node.getLocation().y());
			minY=Math.min(minY,node.getLocation().y());
		}
		StdDraw.setCanvasSize(1000,1000);
		StdDraw.setXscale(minX-2,maxX+2);
		StdDraw.setYscale(minY-2,maxY+1);
		System.out.println("minX-2"+ minX);
		System.out.println("maxX-2"+ maxX);
		System.out.println("minY-2"+ minY);
		System.out.println("maxY-2"+ maxY);


		Iterator<node_data> nodeIT = g.getV().iterator(); 
		while (nodeIT.hasNext())
		{
			node_data nd = nodeIT.next();
			drawNode(nd);
			Iterator<edge_data> itEdge = g.getE(nd.getKey()).iterator(); 
			while (itEdge.hasNext()) 
			{
				System.out.println("befor");
				edge_data ed = (edge_data) itEdge.next();

				drawEdge(ed.getSrc() ,ed.getDest(), ed.getWeight());
				System.out.println("after");

			}
		}
	}


	public static void drawNode (node_data nd) 
	{
		StdDraw.setPenRadius(0.03);
		int k = nd.getKey();
		System.out.println("1");
		StdDraw.setPenColor(StdDraw.BLUE); 
		StdDraw.filledCircle(nd.getLocation().x(),nd.getLocation().y(),0.03);
		StdDraw.textLeft(nd.getLocation().x()+0.05,nd.getLocation().y()+0.05, Integer.toString(k));

	}

	public static void drawEdge (int src , int dest, double weight) 
	{
		System.out.println("edge");
		node_data source = new NodeData (src);
		node_data destination=new NodeData (dest);
		System.out.println("11");
		Iterator<node_data> nodeIT = myGraph.getV().iterator(); 
		while (nodeIT.hasNext())
		{
			node_data nd = nodeIT.next();
			if(nd.getKey()==src)
			{
				Iterator<edge_data> edgeIT = myGraph.getE(nd.getKey()).iterator(); 
				while (edgeIT.hasNext())
				{
					System.out.println("33");
					edge_data ed = (edge_data) edgeIT.next();
					if (ed.getDest()==dest) 
					{
						StdDraw.setPenRadius(0.05);
						StdDraw.setPenColor(StdDraw.PINK);
						StdDraw.line(source.getLocation().x(),source.getLocation().y(),destination.getLocation().x(),destination.getLocation().y());
						//draw direction and w
						StdDraw.setPenColor(StdDraw.YELLOW);
						double w=weight;
						StdDraw.filledCircle(destination.getLocation().x()+0.05,destination.getLocation().y()+0.05,0.008);
						StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.text(destination.getLocation().x(),destination.getLocation().y(), Double.toString(w));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		graph g = new DGraph();
		Point3D p=new Point3D(1,4,0);
		Point3D p1=new Point3D(2,3,0);
		Point3D p2=new Point3D(3,2,0);
		Point3D p3=new Point3D(4,2,0);		
		node_data ND = new NodeData (1,p,8,"hey",0);
		node_data ND1 = new NodeData (2,p1,5,"hur",0);
		//		node_data ND2 = new NodeData (3,p2,15,"hey",0);
		//		node_data ND3 = new NodeData (4,p3,7,"hur",0);
		//node_data ND2 = new NodeData (3,9);
		((graph) g).addNode(ND);
		( (graph) g).addNode(ND1);
		//		((graph) g).addNode(ND2);
		//		( (graph) g).addNode(ND3);
		g.connect(ND.getKey(),ND1.getKey(),10.0);

		drawGraph((graph) g);
	}
}
