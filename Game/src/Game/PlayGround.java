package Game;




import java.util.Scanner;

import gui.GameGuiPerfect;



public class PlayGround{
	GameGuiPerfect GameGuiPerfect; 
	private player first;
	private player second;
	private boolean gameon;
	private boolean color_flag;
	private boolean gameIsFinish;

	public PlayGround(GameGuiPerfect GameGuiPerfect) {
		this.GameGuiPerfect = GameGuiPerfect;
		first = new player();
		second = new player();
		this.gameIsFinish=false;
	}

	public player getFirst() {
		if (first == null ) {
			return null;
		}
		return this.first;
	}

	public player getSecond() {
		if (second == null ) {
			return null;
		}
		return this.second;
	}

	public boolean getGameOn() {
		return this.gameon;
	}

	public boolean isGameIsFinish() {
		return gameIsFinish;
	}

	public void game_Strat() {
		gameon=true;
		firstplayerpick();
		GameGuiPerfect.paint();
		secondplayerpick();
		GameGuiPerfect.paint();
		playtime();
		checkWhoWin();
		GameGuiPerfect.paint();
	}

	private void playtime() {
		GameGuiPerfect.setFinish_picks(true);
		while (second.getTurn() != 11 && !first.getLost() && !second.getLost() ) {
			firstPlyerTurn();
			GameGuiPerfect.paint();
			first.setTurn(first.getTurn()+1);
			checkStatusFirstPlayer();
			GameGuiPerfect.paint();
			secondPlayerTurn();
			second.setTurn(second.getTurn()+1);
			checkStatusSecondPlayer();
			GameGuiPerfect.paint();
		}

	}

	private void checkWhoWin() {
		this.gameIsFinish=true;
	}

	private void secondplayerpick() {
		second.setPlay_now(true);
		int count =1 , temp =0;
		while (count < 5) {
			if (count != temp) {
				temp = count;
				GameGuiPerfect.paint();
			}
			if ((GameGuiPerfect.x >= 555 && GameGuiPerfect.x <= 575) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800)) {
				if (!second.b.my_Colors.contains(Colors.ORANGE)) {
					second.b.my_Colors.add(Colors.ORANGE);
					count++;
				}
			}
			else if ((GameGuiPerfect.x >= 595 && GameGuiPerfect.x <= 615) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800 )) {
				if (!second.b.my_Colors.contains(Colors.RED)) {
					second.b.my_Colors.add(Colors.RED);
					count++;
				}
			}
			else if((GameGuiPerfect.x >= 635 && GameGuiPerfect.x <= 655) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800 )) {
				if (!second.b.my_Colors.contains(Colors.BLUE)) {
					second.b.my_Colors.add(Colors.BLUE);
					count++;
				}
			}
			else if ((GameGuiPerfect.x >= 675 && GameGuiPerfect.x <= 695) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800 )) {
				if (!second.b.my_Colors.contains(Colors.GREEN)) {
					second.b.my_Colors.add(Colors.GREEN);
					count++;
				}
			}
			else if ((GameGuiPerfect.x >= 715 && GameGuiPerfect.x <= 735) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800 )) {
				if (!second.b.my_Colors.contains(Colors.YELLOW)) {
					second.b.my_Colors.add(Colors.YELLOW);
					count++;
				}
			}
			try {
				time.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		GameGuiPerfect.y=0;
		GameGuiPerfect.x=0;
		second.setPlay_now(false);
	}

	Thread time;
	private void firstplayerpick() {
		first.setPlay_now(true);
		int count =1 , temp =0;
		while (count < 5) {
			if (count != temp) {
				temp = count;
				GameGuiPerfect.paint();
			}
			if ((GameGuiPerfect.x >= 140 && GameGuiPerfect.x <= 160) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800)) {
				if (!first.b.my_Colors.contains(Colors.ORANGE)) {
					first.b.my_Colors.add(Colors.ORANGE);
					count++;
				}
			}
			else if ((GameGuiPerfect.x >= 180 && GameGuiPerfect.x <= 200) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800 )) {
				if (!first.b.my_Colors.contains(Colors.RED)) {
					first.b.my_Colors.add(Colors.RED);
					count++;
				}
			}
			else if((GameGuiPerfect.x >= 220 && GameGuiPerfect.x <= 240) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800 )) {
				if (!first.b.my_Colors.contains(Colors.BLUE)) {
					first.b.my_Colors.add(Colors.BLUE);
					count++;
				}
			}
			else if ((GameGuiPerfect.x >= 260 && GameGuiPerfect.x <= 280) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800 )) {
				if (!first.b.my_Colors.contains(Colors.GREEN)) {
					first.b.my_Colors.add(Colors.GREEN);
					count++;
				}
			}
			else if ((GameGuiPerfect.x >= 300 && GameGuiPerfect.x <= 320) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800 )) {
				System.out.println("Yellow");
				if (!first.b.my_Colors.contains(Colors.YELLOW)) {
					first.b.my_Colors.add(Colors.YELLOW);
					count++;
				}
			}
			try {
				time.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		GameGuiPerfect.y=0;
		GameGuiPerfect.x=0;
		first.setPlay_now(false);
	}

	private void secondPlayerTurn() {
		second.setPlay_now(true);
		int count =1 , temp =0;
		while (count < 5) {
			color_flag=false;
			if (count != temp) {
				temp = count;
				GameGuiPerfect.paint();
			}
			if ((GameGuiPerfect.x >= 555 && GameGuiPerfect.x <= 575) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800)) {
				for (int i = 0; i < 4; i++) {
					if (second.b.chose_board[second.getTurn()][i] == Colors.ORANGE) {
						color_flag=true;
					}
				}
				if(!color_flag) {
					second.b.chose_board[second.getTurn()][count-1]=Colors.ORANGE;
					count++;
					second.setPick_number(second.getPick_number()+1);
				}
			}
			else if ((GameGuiPerfect.x >= 595 && GameGuiPerfect.x <= 615) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800 )) {
				for (int i = 0; i < 4; i++) {
					if (second.b.chose_board[second.getTurn()][i] == Colors.RED) {
						color_flag=true;
					}
				}
				if(!color_flag) {
					second.b.chose_board[second.getTurn()][count-1]=Colors.RED;
					count++;
					second.setPick_number(second.getPick_number()+1);
				}
			}
			else if((GameGuiPerfect.x >= 635 && GameGuiPerfect.x <= 655) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800 )) {
				for (int i = 0; i < 4; i++) {
					if (second.b.chose_board[second.getTurn()][i] == Colors.BLUE) {
						color_flag=true;
					}
				}
				if(!color_flag) {
					second.b.chose_board[second.getTurn()][count-1]=Colors.BLUE;
					count++;
					second.setPick_number(second.getPick_number()+1);
				}
			}
			else if ((GameGuiPerfect.x >= 675 && GameGuiPerfect.x <= 695) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800  )) {
				for (int i = 0; i < 4; i++) {
					if (second.b.chose_board[second.getTurn()][i] == Colors.GREEN) {
						color_flag=true;
					}
				}
				if(!color_flag) {
					second.b.chose_board[second.getTurn()][count-1]=Colors.GREEN;
					count++;
					second.setPick_number(second.getPick_number()+1);
				}
			}
			else if ((GameGuiPerfect.x >= 715 && GameGuiPerfect.x <= 735) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800  )) {
				for (int i = 0; i < 4; i++) {
					if (second.b.chose_board[second.getTurn()][i] == Colors.YELLOW) {
						color_flag=true;
					}
				}
				if(!color_flag) {
					second.b.chose_board[second.getTurn()][count-1]=Colors.YELLOW;
					count++;
					second.setPick_number(second.getPick_number()+1);
				}
			}
			try {
				time.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		GameGuiPerfect.y=0;
		GameGuiPerfect.x=0;	
		second.setPick_number(1);
	}

	private void firstPlyerTurn() {
		first.setPlay_now(true);
		int count =1 , temp =0;
		while (count < 5) {
			color_flag=false;
			if (count != temp) {
				temp = count;
				GameGuiPerfect.paint();
			}
			if ((GameGuiPerfect.x >= 140 && GameGuiPerfect.x <= 160) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800)) {
				for (int i = 0; i < 4; i++) {
					if (first.b.chose_board[first.getTurn()][i] == Colors.ORANGE) {
						color_flag=true;
					}
				}
				if(!color_flag) {
					first.b.chose_board[first.getTurn()][count-1]=Colors.ORANGE;
					count++;
					first.setPick_number(first.getPick_number()+1);
				}
			}
			else if ((GameGuiPerfect.x >= 180 && GameGuiPerfect.x <= 200) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800 )) {
				for (int i = 0; i < 4; i++) {
					if (first.b.chose_board[first.getTurn()][i] == Colors.RED) {
						color_flag=true;
					}
				}
				if(!color_flag) {
					first.b.chose_board[first.getTurn()][count-1]=Colors.RED;
					count++;
					first.setPick_number(first.getPick_number()+1);
				}
			}
			else if((GameGuiPerfect.x >= 220 && GameGuiPerfect.x <= 240) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800 )) {
				for (int i = 0; i < 4; i++) {
					if (first.b.chose_board[first.getTurn()][i] == Colors.BLUE) {
						color_flag=true;
					}
				}
				if(!color_flag) {
					first.b.chose_board[first.getTurn()][count-1]=Colors.BLUE;
					count++;
					first.setPick_number(first.getPick_number()+1);
				}
			}
			else if ((GameGuiPerfect.x >= 260 && GameGuiPerfect.x <= 280) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800 )) {
				for (int i = 0; i < 4; i++) {
					if (first.b.chose_board[first.getTurn()][i] == Colors.GREEN) {
						color_flag=true;
					}
				}
				if(!color_flag) {
					first.b.chose_board[first.getTurn()][count-1]=Colors.GREEN;
					count++;
					first.setPick_number(first.getPick_number()+1);
				}
			}
			else if ((GameGuiPerfect.x >= 300 && GameGuiPerfect.x <= 320) && (GameGuiPerfect.y >=780 && GameGuiPerfect.y <=800 )) {
				for (int i = 0; i < 4; i++) {
					if (first.b.chose_board[first.getTurn()][i] == Colors.YELLOW) {
						color_flag=true;
					}
				}
				if(!color_flag) {
					first.b.chose_board[first.getTurn()][count-1]=Colors.YELLOW;
					count++;
					first.setPick_number(first.getPick_number()+1);
				}
			}
			try {
				time.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		GameGuiPerfect.y=0;
		GameGuiPerfect.x=0;	
		first.setPick_number(1);
	}

	private void checkStatusFirstPlayer() {
		first.setAlmost(0);
		first.setPerfect(0);
		for (int i = 0; i < 4; i++) {
			Colors c_first = first.b.chose_board[first.getTurn()-1][i];
			for (int j = 0; j < 4; j++) {
				Colors c_second = second.b.my_Colors.get(j);
				if (c_first == c_second && i==j ) {
					first.setPerfect(first.getPerfect()+1);
				}
				else if (c_first == c_second && i!=j ) {
					first.setAlmost(first.getAlmost()+1);
				}
			}
		}
		first.b.hit[first.getTurn()-1][0] = first.getPerfect();
		first.b.hit[first.getTurn()-1][1] = first.getAlmost();
		if (first.getPerfect() == 4) {
			first.setLost(true);
		}
		first.setPlay_now(false);
	}

	private void checkStatusSecondPlayer() {
		second.setAlmost(0);
		second.setPerfect(0);
		for (int i = 0; i < 4; i++) {
			Colors c_second = second.b.chose_board[second.getTurn()-1][i];
			for (int j = 0; j < 4; j++) {
				Colors c_first = first.b.my_Colors.get(j);
				if (c_second == c_first && i==j ) {
					second.setPerfect(second.getPerfect()+1);
				}
				else if (c_first == c_second && i!=j ) {
					second.setAlmost(second.getAlmost()+1);
				}
			}
		}
		second.b.hit[second.getTurn()-1][0] = second.getPerfect();
		second.b.hit[second.getTurn()-1][1] = second.getAlmost();
		if (second.getPerfect() == 4) {
			second.setLost(true);
		}
		second.setPlay_now(false);
	}

}
