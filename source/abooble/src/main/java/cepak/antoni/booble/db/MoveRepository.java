package cepak.antoni.booble.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import cepak.antoni.booble.jrs.model.exp.CGamester;
import cepak.antoni.booble.jrs.model.exp.CServerMessage;

public class MoveRepository {

	private static Connection conn;

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String url = "jdbc:postgresql://stampy.db.elephantsql.com:5432/sxhikdmo";
		// String url = "jdbc:postgresql://<<hostname>>:5432/<<dbname>>";
		String username = "sxhikdmo";
		String password = "5nY8S7wgtPWQ6GBClD31IGNdVH47rKim";
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert(MovePersistant move) throws SQLException {
		Statement statement = conn.createStatement();
		String insertTableSQL = "insert into MOVES (userId, x, y, radius, rankUpdate, gameId) VALUES (" + move.getUserId() + ", " + move.getX() + ", " + move.getY() + ", " + move.getR() + ", " + move.getRankUpdate() + ", " + move.getGameId() + ")";
		statement.executeUpdate(insertTableSQL);
	}

	public static void insert(CServerMessage roundSummary) throws SQLException {
		int i = 0;
		for(CGamester gamester: roundSummary.getRoom().getGamesters()) {
			MovePersistant move = new MovePersistant();
			move.setUserId(i++);
			move.setX(gamester.getMove().getX());
			move.setY(gamester.getMove().getY());
			move.setR(gamester.getMove().getRadius());
			move.setRankUpdate(1);
			move.setGameId(0L);
			
			insert(move);
		}
		
	}
}
