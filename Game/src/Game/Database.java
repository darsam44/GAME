package Game;

import java.util.ArrayList;
import java.sql.*;




public class Database {

	public static void main(String[] args) throws Exception {
		//		getConnection();
		ArrayList<String> players = new ArrayList<String>();
		players.add("dar");
		players.add("Moti");
		Insert(players , 1);
		//		Insert2();

	}

	public static void Insert2() {
		try {
			int d = 0;
			Connection con = getConnection();
			final String s = "dar";
			String sql = "SELECT * FROM users WHERE user_name = 'dar'";
			//			String sql ="UPDATE users SET win =2 WHERE user_name = 'dar'";
			//			String sql = "DELETE FROM users WHERE user_name = 'n' ";
			//			String sql = "INSERT INTO users (user_name,win,lose,tie) VALUES ('n',0,0,0)";
			PreparedStatement  stm = con.prepareStatement (sql);
			//			stm.executeUpdate(sql);
			ResultSet v = stm.executeQuery();
			if (v.next()) {
				d=v.getInt("win") +1;
				System.out.println("he is " + d);
			}
			else {
				System.out.println("Fail");
			}
			String sql1 ="UPDATE users SET win = 0 WHERE user_name = 'dar'";
			stm.executeUpdate(sql1);

			System.out.println("succssus");
			con.close();	

		} catch (Exception e) {
			e.printStackTrace();
		}



	}

	public static void Insert(ArrayList<String> players , int winner) {
		try {
			Connection con = getConnection();
			Statement stm = con.createStatement();
			String sql ="";
			String sql_player1 = "SELECT * FROM users WHERE user_name = '"+players.get(0)+"'";
			String sql_player2 = "SELECT * FROM users WHERE user_name = '"+players.get(1)+"'";
			//			String sql = "DELETE FROM users WHERE user_name = 'Moti' ";
			//			players.add("Yotam");
			//			String sql2 = "INSERT INTO users (user_name,win,lose,tie) VALUES ('"+players.get(0)+"',0,0,0)";

			ResultSet p1 = stm.executeQuery(sql_player1);
			if (p1.next()) {
				if (winner == 1) {
					int win_p1 = p1.getInt("win") + 1;
					sql =" UPDATE users SET win = '"+win_p1+"'  WHERE user_name = '"+players.get(0)+"'";
				}
				else if (winner == 1) {
					int lose_p1 = p1.getInt("lose") + 1;
					sql =" UPDATE users SET lose = '"+lose_p1+"'  WHERE user_name = '"+players.get(0)+"'";
				}
				else {
					int tie_p1 = p1.getInt("tie") + 1;
					sql =" UPDATE users SET tie = '"+tie_p1+"'  WHERE user_name = '"+players.get(0)+"'";
				}
				stm.executeUpdate(sql);

			}
			else {
				makeNewP1(players.get(0), stm,winner );
			}
			ResultSet p2 = stm.executeQuery(sql_player2);
			if (p2.next()) {
				if (winner == 1) {
					int lose_p2 = p2.getInt("lose") + 1;
					sql =" UPDATE users SET lose = '"+lose_p2+"'  WHERE user_name = '"+players.get(1)+"'";
				}
				else if (winner == 2) {
					int win_p2 = p2.getInt("win") + 1;
					sql =" UPDATE users SET win = '"+win_p2+"'  WHERE user_name = '"+players.get(1)+"'";
				}
				else {
					int tie_p2 = p2.getInt("tie") + 1;
					sql =" UPDATE users SET tie = '"+tie_p2+"'  WHERE user_name = '"+players.get(1)+"'";
				}
				stm.executeUpdate(sql);
			}
			else {
				makeNewP2(players.get(1), stm ,winner );
			}
			System.out.println("succssus");
			con.close();	

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	private static void makeNewP1(String p, Statement stm, int winner) {
		try {
			String sql;
			if (winner ==1 ) {
				sql = "INSERT INTO users (user_name,win,lose,tie) VALUES ('"+p+"',1,0,0)";
			}
			else if ( winner ==2 ) {
				sql = "INSERT INTO users (user_name,win,lose,tie) VALUES ('"+p+"',0,1,0)";
			}
			else {
				sql = "INSERT INTO users (user_name,win,lose,tie) VALUES ('"+p+"',0,0,1)";
			}
			stm.executeUpdate(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void makeNewP2(String p, Statement stm, int winner) {
		try {
			String sql;
			if (winner ==1 ) {
				sql = "INSERT INTO users (user_name,win,lose,tie) VALUES ('"+p+"',0,1,0)";
			}
			else if ( winner ==2 ) {
				sql = "INSERT INTO users (user_name,win,lose,tie) VALUES ('"+p+"',1,0,0)"; 
			}
			else {
				sql = "INSERT INTO users (user_name,win,lose,tie) VALUES ('"+p+"',0,0,1)";
			}
			stm.executeUpdate(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection (){
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/game?useSSL=false";
			String username = "root";
			String pass = "DARdar123";
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, username , pass);
			System.out.println("connction is good");
			return con;

		}
		catch (Exception e) {
			System.out.println("connection is not good");
		}
		return null;
	}
}
