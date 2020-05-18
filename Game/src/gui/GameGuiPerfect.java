package gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Game.Colors;
import Game.Database;
import Game.PlayGround;
import Game.player;

public class GameGuiPerfect {
	public double x;
	public double y;
	public int Winner;
	boolean nameWasPick;
	ArrayList<String> players = new ArrayList<String>();
	PlayGround game;
	Database data;
	player p1,p2;
	private boolean finish_picks;


	public GameGuiPerfect() {
		game = new PlayGround(this);
		data = new Database();
		this.nameWasPick=false;
		initGUI();
	}

	public void startGamePerfect(){
		this.p1 = game.getFirst();
		this.p2 = game.getSecond();
		game.game_Strat();
	}

	public void setFinish_picks(boolean finish) {
		this.finish_picks = finish;
	}

	public void initGUI() {
		StdDrawGame.setCanvasSize(800, 600);
		StdDrawGame.enableDoubleBuffering();
		StdDrawGame.setXscale(0, 800);
		StdDrawGame.setYscale(0, 800);
		StdDrawGame.setGuiGraph(this);
		paint();
	}

	public void paint() {
		StdDrawGame.clear();
		paitboard();
		paintPlaceOfPicks();
		if (game.getGameOn()) {
			if (!nameWasPick) {
				askforname();
			}
			FirstPicks();
			SecondtPicks();
			if (finish_picks) {
				FirtsPlayerTurn();
				SecondPlayerTurn();

			}
			if (game.isGameIsFinish()) {
				paintWhoIsTheWinner();
			}
		}
		StdDrawGame.show();
	}

	private void askforname() {
		JFrame input = new JFrame();
		String s ="";
		s = JOptionPane.showInputDialog(
				null, "Player 1 what yoru username?");
		String s2 ="";
		s2 = JOptionPane.showInputDialog(
				null, "Player 2 what yoru username?");
		this.players.add(s);
		this.players.add(s2);
		this.nameWasPick = true;
	}

	private void paitboard() {
		StdDrawGame.setPenColor(Color.RED);
		StdDrawGame.line(400, 0, 400, 800);
		StdDrawGame.line(0, 0, 0, 800);
		StdDrawGame.line(800, 0, 800, 800);
		StdDrawGame.setPenColor(Color.BLACK);
		StdDrawGame.line(750, 0, 750, 800);
		StdDrawGame.line(350, 0, 350, 800);
		for (int i = 0; i < 800; i+=70) {
			StdDrawGame.line(0, i, 800, i);	
		}
		StdDrawGame.text(60, 790, "First Player");
		StdDrawGame.text(480, 790, "Second Player");
	}

	private void paintPlaceOfPicks() {
		//first Player
		StdDrawGame.setPenColor(Color.RED);
		StdDrawGame.picture(145, 790, "Buttons/Orange.jpg", 25, 25);
		StdDrawGame.picture(185, 790,"Buttons/Red.jpg" , 25, 25);
		StdDrawGame.picture(225, 790, "Buttons/Blue.jpg" , 25, 25);
		StdDrawGame.picture(265, 790, "Buttons/Green.jpg"  , 25, 25);
		StdDrawGame.picture(305, 790, "Buttons/Lime.jpg", 25, 25);

		//second player
		StdDrawGame.setPenColor(Color.RED);
		StdDrawGame.picture(560, 790,"Buttons/Orange.jpg", 25, 25);
		StdDrawGame.picture(600, 790, "Buttons/Red.jpg", 25, 25);
		StdDrawGame.picture(640, 790, "Buttons/Blue.jpg", 25, 25);
		StdDrawGame.picture(680, 790, "Buttons/Green.jpg", 25, 25);
		StdDrawGame.picture(720, 790, "Buttons/Lime.jpg", 25, 25);
	}


	private void FirstPicks() {
		if (p1.isPlay_now()) {
			StdDrawGame.setPenColor(Color.BLACK);
			if (p1.b.my_Colors.size()+1 <=4) {
				String s= "First player this is " + (p1.b.my_Colors.size()+1)+ " choise";
				StdDrawGame.text(400, 845, s );
			}
		}
	}

	private void SecondtPicks() {
		if ( p2.isPlay_now()) {
			StdDrawGame.setPenColor(Color.BLACK);
			if (p2.b.my_Colors.size()+1 <=4) {
				String s= "Second player this is " + (p2.b.my_Colors.size()+1)+ " choise";
				StdDrawGame.text(400, 845, s );
			}
		}
	}

	private void FirtsPlayerTurn() {
		int place=730 , temp=730;
		for (int i = 0, z=60; i < p1.getTurn(); i++ , z=z+70) {
			for (int j = 0, k =0; j < 4; j++ , k+=60) {
				String c = getColor(p1.b.chose_board[i][j]);
				StdDrawGame.picture((60+k), (temp), c, 25, 25);
			}
			paintHitFirts(i , temp);
			temp =place-z;
		}
		if (p1.isPlay_now()) {
			for (int j = 0, k =0; j < 4; j++ , k+=60) {
				String s= "First player this is " + p1.getPick_number()+ " choise";
				StdDrawGame.text(400, 845, s );
				if (p1.b.chose_board[p1.getTurn()][j]!= null) {
					String c = getColor(p1.b.chose_board[p1.getTurn()][j]);
					StdDrawGame.picture((60+k), (temp), c, 25, 25);
				}
			}
		}
	}
	private void paintHitFirts(int i , int place) {
		int perf = p1.b.hit[i][0],  place_perf = place ;
		int almost = p1.b.hit[i][1];
		int how_much = 0;
		for (int j = 0; j < perf; j++) {
			if (how_much == 0 ) {
				StdDrawGame.picture((360), (place_perf), "Buttons/Black.jpg", 15, 15);
				how_much++;
			}
			else if ( how_much == 1) {
				StdDrawGame.picture((380), (place_perf), "Buttons/Black.jpg", 15, 15);
				how_much++;
			}
			else if (how_much == 2) {
				StdDrawGame.picture((360), (place_perf-20), "Buttons/Black.jpg", 15, 15); 
				how_much++;
			}
			else if ( how_much == 3) {
				StdDrawGame.picture((380), (place_perf-20), "Buttons/Black.jpg", 15, 15); 
				how_much++;
			}
		}
		for (int j = 0; j < almost; j++) {
			if (how_much == 0 ) {
				StdDrawGame.picture((360), (place_perf), "Buttons/Brown.jpg", 15, 15);
				how_much++;
			}
			else if ( how_much == 1) {
				StdDrawGame.picture((380), (place_perf), "Buttons/Brown.jpg", 15, 15);
				how_much++;
			}
			else if (how_much == 2) {
				StdDrawGame.picture((360), (place_perf-20), "Buttons/Brown.jpg", 15, 15); 
				how_much++;
			}
			else if ( how_much == 3) {
				StdDrawGame.picture((380), (place_perf-20), "Buttons/Brown.jpg", 15, 15); 
				how_much++;
			}	

		}
	}

	private void SecondPlayerTurn() {
		int place=730, temp=730;
		for (int i = 0, z=60; i < p2.getTurn(); i++ , z=z+70) {
			for (int j = 0, k =0; j < 4; j++ , k+=60) {
				String c = getColor(p2.b.chose_board[i][j]);
				StdDrawGame.picture((460+k), (temp), c, 25, 25);
			}
			paintHitSecond(i , temp);
			temp =place-z;
		}
		if (p2.isPlay_now()) {
			for (int j = 0, k =0; j < 4; j++ , k+=60) {
				String s= "Second player this is " + p2.getPick_number()+ " choise";
				StdDrawGame.text(400, 845, s );
				if (p2.b.chose_board[p2.getTurn()][j]!= null) {
					String c = getColor(p2.b.chose_board[p2.getTurn()][j]);
					StdDrawGame.picture((460+k), (temp), c, 25, 25);
				}
			}
		}
	}

	private void paintHitSecond(int i , int place) {
		int perf = p2.b.hit[i][0],  place_perf = place ;
		int almost = p2.b.hit[i][1];
		int how_much = 0;
		for (int j = 0; j < perf; j++) {
			if (how_much == 0 ) {
				StdDrawGame.picture((760), (place_perf), "Buttons/Black.jpg", 15, 15);
				how_much++;
			}
			else if ( how_much == 1) {
				StdDrawGame.picture((780), (place_perf), "Buttons/Black.jpg", 15, 15);
				how_much++;
			}
			else if (how_much == 2) {
				StdDrawGame.picture((760), (place_perf-20), "Buttons/Black.jpg", 15, 15); 
				how_much++;
			}
			else if ( how_much == 3) {
				StdDrawGame.picture((780), (place_perf-20), "Buttons/Black.jpg", 15, 15); 
				how_much++;
			}
		}
		for (int j = 0; j < almost; j++) {
			if (how_much == 0 ) {
				StdDrawGame.picture((760), (place_perf), "Buttons/Brown.jpg", 15, 15);
				how_much++;
			}
			else if ( how_much == 1) {
				StdDrawGame.picture((780), (place_perf), "Buttons/Brown.jpg", 15, 15);
				how_much++;
			}
			else if (how_much == 2) {
				StdDrawGame.picture((760), (place_perf-20), "Buttons/Brown.jpg", 15, 15); 
				how_much++;
			}
			else if ( how_much == 3) {
				StdDrawGame.picture((780), (place_perf-20), "Buttons/Brown.jpg", 15, 15); 
				how_much++;
			}	
		}
	}

	private void paintWhoIsTheWinner() {
		StdDrawGame.setPenColor(Color.BLUE);
		if ( p1.getLost() && !p2.getLost()) {
			StdDrawGame.text(400, 845, "First player won the game" );
			this.Winner=1;
		}
		else if (!p1.getLost() && p2.getLost() ) {
			StdDrawGame.text(400, 845, "Second player won the game" );
			this.Winner=2;
		}
		else {
			StdDrawGame.text(400, 845, "Its a tie!" );
			this.Winner=0;
		}
		data.Insert(players, Winner);
	}

	private String getColor(Colors c) {
		switch(c) {
		case GREEN: return "Buttons/Green.jpg" ;
		case RED: return "Buttons/Red.jpg";
		case BLUE: return "Buttons/Blue.jpg";
		case ORANGE: return "Buttons/Orange.jpg";
		case YELLOW: return  "Buttons/Lime.jpg";
		default: return null;
		}
	}

	/**
	This function get the point that the user 
	clicked on it the frame from the StdDraw lib that we made (g_StdDraw ).	
	 * @param x
	 * @param y
	 */
	public void setXY(double x , double y) {
		this.x=x;
		this.y=y;
	}


}
