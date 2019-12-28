package utils;

	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Menu;
	import java.awt.MenuBar;
	import java.awt.MenuItem;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

	import javax.swing.JFrame;

import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;

	public class GUI_JFRAME extends JFrame implements ActionListener, MouseListener
	{
		 graph myGraph = new DGraph();
		
		public GUI_JFRAME()
		{
			initGUI();
		}
		
		private void initGUI() 
		{
			this.setSize(500, 500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			MenuBar menuBar = new MenuBar();
			Menu file = new Menu("file");
			menuBar.add(file);
			this.setMenuBar(menuBar);
			//MenuBar menuBar1 = new MenuBar();
			Menu graph_algo = new Menu("graph algo");
			menuBar.add(graph_algo);
			//this.setMenuBar(menuBar);
			
			MenuItem item1 = new MenuItem("save");
			item1.addActionListener(this);
			MenuItem item2 = new MenuItem("load");
			item2.addActionListener(this);
			MenuItem item3 = new MenuItem("shortpath");
			item3.addActionListener(this);
			MenuItem item4 = new MenuItem("tsp");
			item4.addActionListener(this);
		
			
			
			file.add(item1);
			file.add(item2);
			graph_algo.add(item3);
			graph_algo.add(item4);
			this.addMouseListener(this);
		}

		public void paint(graph g)
		{

			Iterator<node_data> nodeIT = g.getV().iterator(); 
			while (nodeIT.hasNext())
			{
				node_data nd = nodeIT.next();
				((Graphics) g).fillOval((int)nd.getLocation().x(), (int)nd.getLocation().y(), 10, 10);
				Iterator<edge_data> itEdge = g.getE(nd.getKey()).iterator(); 
				while (itEdge.hasNext()) 
				{
					System.out.println("befor");
					edge_data ed = (edge_data) itEdge.next();
					((Graphics) g).drawLine((int)nd.getLocation().x(), (int)nd.getLocation().y(), 
							HashMapNode.get(ed.getDest()).get, (int)prev.y());

					drawEdge(ed.getSrc() ,ed.getDest(), ed.getWeight());
					System.out.println("after");

				}
			}
			super.paint(g);
			
			Point3D prev = null;
			
			for (Point3D p : points) 
			{
				g.setColor(Color.BLUE);


				
				if(prev != null)
				{
					g.setColor(Color.RED);
					g.drawLine((int)p.x(), (int)p.y(), 
							(int)prev.x(), (int)prev.y());
					
					g.drawString("5", (int)((p.x()+prev.x())/2),(int)((p.y()+prev.y())/2));
				}
				
				prev = p;
			}
		}
		
		

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String str = e.getActionCommand();
			
			if(str.equals("Item 1"))
			{
				Point3D p1 = new Point3D(100,100);
				Point3D p2 = new Point3D(50,300);
				Point3D p3 = new Point3D(400,150);
				
				points.add(p1);
				points.add(p2);
				points.add(p3);
				
				repaint();
			}
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("mouseClicked");
			
		}

		//@Override
//		public void mousePressed(MouseEvent e) {
//			int x = e.getX();
//			int y = e.getY();
//			Point3D p = new Point3D(x,y);
//			points.add(p);
//			repaint();
//			System.out.println("mousePressed");
//			
//		}

		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("mouseReleased");
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			System.out.println("mouseEntered");
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			System.out.println("mouseExited");
		}
		

		public static void main(String[] args) 
		{
			GUI_JFRAME window = new GUI_JFRAME();
			window.setVisible(true);
			
//			graph g = new DGraph();
//			Point3D p=new Point3D(1,4,0);
//			Point3D p1=new Point3D(2,3,0);
//			Point3D p2=new Point3D(3,2,0);
//			Point3D p3=new Point3D(4,2,0);		
//			node_data ND = new NodeData (1,p,8,"hey",0);
//			node_data ND1 = new NodeData (2,p1,5,"hur",0);
//			//		node_data ND2 = new NodeData (3,p2,15,"hey",0);
//			//		node_data ND3 = new NodeData (4,p3,7,"hur",0);
//			//node_data ND2 = new NodeData (3,9);
//			((graph) g).addNode(ND);
//			( (graph) g).addNode(ND1);
//			//		((graph) g).addNode(ND2);
//			//		( (graph) g).addNode(ND3);
//			g.connect(ND.getKey(),ND1.getKey(),10.0);

			//drawGraph((graph) g);
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	}



