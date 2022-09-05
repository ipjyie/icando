package controller;

import java.util.ArrayList;

import model.player;
import model.playerDTO;

public interface GameInterface {
	
	
	public abstract void printMenu();
	
	public abstract void Cplayer();
	
	public abstract void Cselect();
	
	public abstract void Ccheck();
	
	public abstract void CopP();
	
	public abstract void Catt();
	
	public abstract void Cdef();
	
	public abstract void Crank();
}

//다 void로 만들어버리는게 안 좋은 습관인지