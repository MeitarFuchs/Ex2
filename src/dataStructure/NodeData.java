package dataStructure;

import utils.Point3D;

public class NodeData implements node_data {

	private int Key;
	private Point3D Location;
	private double Weight;
	private String Info;
	private int Tag;

	public NodeData() {
		this.Key=0;
		this.Weight=0;
		this.Info="";
		this.Tag=0;
		this.Location=null; 
	}
	public NodeData (int key) {
		this.Key=key; 
	}

	public NodeData(int k , Point3D l , double w , String i , int t) {
		this.Key=k; 
		this.Location=l;
		this.Weight=w;
		this.Info=i;
		this.Tag=t;
	}

	public NodeData(node_data nd) {
		this.Key=nd.getKey(); 
		this.Location=nd.getLocation();
		this.Weight=nd.getWeight();
		this.Info=nd.getInfo();
		this.Tag=nd.getTag();
	}

	@Override
	public int getKey() {

		return this.Key;
	}


	@Override
	public Point3D getLocation() {
		return this.Location;
	}

	@Override
	public void setLocation(Point3D p) {
		this.Location=p;
		DGraph.MC++;
	}

	@Override
	public double getWeight() {
		return this.Weight;
	}

	@Override
	public void setWeight(double w) {
		this.Weight=w;
		DGraph.MC++;

	}

	@Override
	public String getInfo() {
		return this.Info;
	}

	@Override
	public void setInfo(String s) {
		this.Info=s;
		DGraph.MC++;

	}

	@Override
	public int getTag() {
		return this.Tag;
	}

	@Override
	public void setTag(int t) {
		this.Tag=t;
		DGraph.MC++;

	}

}
