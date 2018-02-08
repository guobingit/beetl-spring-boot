package com.gb.demo.Algorithm.Graph;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Vertex implements VertexInterface, Serializable {
	
	private String label;//��ʶ���,�����ò�ͬ��������ʶ������String,Integer....
	private LinkedList<Edge> edgeList; //���ö����ڽӵ�ı�,ʵ����java.util.LinkedList�洢
	private boolean visited; //��ʶ�����Ƿ��ѷ���
	private VertexInterface previousVertex; //�ö����ǰ������
	private double cost;//�����Ȩֵ,��ߵ�ȨֵҪ������
	
	public String getLabel() {
		return label;
	}
	
	public Iterator<VertexInterface> getNeighborInterator() {
		return new NeighborIterator();
	}
	
	/**
	 * Task: �����ö����ڽӵ�ĵ�����--Ϊ getNeighborInterator()���� �ṩ������
	 * ���ڶ�����ڽӵ��Աߵ���ʽ�洢��java.util.List��,��˽���List�ĵ�������ʵ��
	 * ���ڶ�����ڽӵ���Edge���װ������--��Edge.java�Ķ���ĵ�һ������
	 * ��ˣ����Ȼ�ñ���Edge����ĵ�����,�ٸ��ݻ�õ�Edge����������ڽӵ����
	 */
	private class NeighborIterator implements Iterator<VertexInterface> {
		
		Iterator<Edge> edgesIterator;
		
		private NeighborIterator() {
			edgesIterator = edgeList.iterator();//��ñ���edgesList �ĵ�����
		}
		
		@Override
		public boolean hasNext() {
			return edgesIterator.hasNext();
		}
		
		@Override
		public VertexInterface next() {
			VertexInterface nextNeighbor = null;
			if (edgesIterator.hasNext()) {
				Edge edgeToNextNeighbor = edgesIterator.next();//LinkedList�д洢����Edge
				nextNeighbor = edgeToNextNeighbor.getEndVertex();//��Edge������ȡ������
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
