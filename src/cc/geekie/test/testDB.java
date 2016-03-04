package cc.geekie.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cc.geekie.dao.DataContract;
import cc.geekie.dao.DataContract.GpsDB;

public class testDB {
	public static void main(String args[]) {
		Connection con = DataContract.getConnection();

        Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(
				    "insert into " + GpsDB.TABLE_NAME +
				    " values("+ "1" + "," + 
				    		  "2" + "," +
				    		  "3" + "," +
				    		  "'2008-12-26'" + "," +
				    		  "2008-12-26" + ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
}
