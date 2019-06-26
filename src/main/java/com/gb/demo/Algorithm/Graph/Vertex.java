package com.gb.demo.Algorithm.Graph;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Vertex implements VertexInterface, Serializable {
	
	private String label;//标识标点,可以用不同类型来标识顶点如String,Integer....
	private LinkedList<Edge> edgeList; //到该顶点邻接点的边,实际以java.util.LinkedList存储
	private boolean visited; //标识顶点是否已访问
	private VertexInterface previousVertex; //该顶点的前驱顶点
	private double cost;//顶点的权值,与边的权值要区别开来
	
	public String getLabel() {
		return label;
	}
	
	public Iterator<VertexInterface> getNeighborInterator() {
		return new NeighborIterator();
	}
	
	/**
	 * Task: 遍历该顶点邻接点的迭代器--为 getNeighborInterator()方法 提供迭代器
	 * 由于顶点的邻接点以边的形式存储在java.util.List中,因此借助List的迭代器来实现
	 * 由于顶点的邻接点由Edge类封装起来了--见Edge.java的定义的第一个属性
	 * 因此，首先获得遍历Edge对象的迭代器,再根据获得的Edge对象解析出邻接点对象
	 */
	private class NeighborIterator implements Iterator<VertexInterface> {
		
		Iterator<Edge> edgesIterator;
		
		private NeighborIterator() {
			edgesIterator = edgeList.iterator();//获得遍历edgesList 的迭代器
		}
		
		@Override
		public boolean hasNext() {
			return edgesIterator.hasNext();
		}
		
		@Override
		public VertexInterface next() {
			VertexInterface nextNeighbor = null;
			if (edgesIterator.hasNext()) {
				Edge edgeToNextNeighbor = edgesIterator.next();//LinkedList中存储的是Edge
				nextNeighbor = edgeToNextNeighbor.getEndVertex();//从Edge对象中取出顶点
			} else
				throw new NoSuchElementException();
			return nextNeighbor;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
