package model;

import java.util.Random;

public class playerDTO {
	
	Random rd= new Random();
	private String name;
	private int ab;
	public int score=0;
	
	public playerDTO(String name) {
		this.name = name;
		this.ab = rd.nextInt(101);	
	}

	public String getName() {
		return name;
	}


	public int getAb() {
		return ab;
	}

	
	
	

}
