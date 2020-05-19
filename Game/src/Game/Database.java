package Game;

import java.util.ArrayList;
import java.sql.*;




public class Database {

	public Database() {}
	
	public static void Insert(ArrayList<String> players , int winner) {
		try {
			Connection con = getConnection();
			Statement stm = con.createStatement();
			String sql ="";
			String sql_player1 = "SELECT * FROM users WHERE user_name = '"+players.get(0)+"'";
			String sql_player2 = "SELECT * FROM users WHERE user_name = '"+players.get(1)+"'";
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
			return con;

		}
		catch (Exception e) {
		}
		return null;
	}
}
