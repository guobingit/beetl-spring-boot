package com.gb.demo.Algorithm.Graph;

import java.io.Serializable;

/**
 * �߱�
 */
public class Edge implements Serializable{
	private VertexInterface vertex; // �յ�
	private Double weight; //Ȩֵ
	
	VertexInterface getEndVertex(){
		return this.vertex;
	}
}
