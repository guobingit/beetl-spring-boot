package com.gb.demo.Algorithm.Graph;

import java.io.Serializable;

/**
 * 边表
 */
public class Edge implements Serializable{
	private VertexInterface vertex; // 终点
	private Double weight; //权值
	
	VertexInterface getEndVertex(){
		return this.vertex;
	}
}
