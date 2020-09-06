package com.orgin.sales.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
public class DatabaseSequence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2008239480645755683L;

	@Id
	private String id;

	private long seq;

	public DatabaseSequence() {
		// TODO Auto-generated constructor stub
	}

	public DatabaseSequence(String id, long seq) {
		super();
		this.id = id;
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

}