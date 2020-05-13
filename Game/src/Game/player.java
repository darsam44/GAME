package Game;

public class player {
	public board b;
	private boolean play_now;
	private int turn;
	private boolean lost;
	private int perfect;
	private int almost;
	private int pick_number;
	
	public player() {
		this.turn=0;
		b = new board();
		this.lost=false;
		this.pick_number=1;
		this.perfect=0;
		this.almost=0;
	}
	
	public boolean isPlay_now() {
		return play_now;
	}

	public void setPlay_now(boolean play_now) {
		this.play_now = play_now;
	}

	public int getTurn(){
		return this.turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	public boolean getLost() {
		return this.lost;
	}

	public void setLost(boolean lost) {
		this.lost = lost;
	}
	
	public int getPerfect(){
		return this.perfect;
	}
	
	public void setPerfect(int perfect) {
		this.perfect= perfect;
	}
	
	public int getAlmost(){
		return this.almost;
	}
	
	public void setAlmost(int almost) {
		this.almost = almost;
	}
	
	public int getPick_number(){
		return this.pick_number;
	}

	public void setPick_number(int pick) {
		this.pick_number = pick;
	}
}
