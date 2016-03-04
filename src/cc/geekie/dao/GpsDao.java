package cc.geekie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cc.geekie.dao.DataContract.GpsDB;

import cc.geekie.domain.GpsInfo;


public class GpsDao {
	
	public static void createTable() {        
		String createString = 
				"CREATE TABLE IF NOT EXISTS " + GpsDB.TABLE_NAME + " (" +
						GpsDB.COLUMN_NAME_ID + " varchar(32) NOT NULL, " +
						GpsDB.COLUMN_NAME_LONGITUDE + " varchar(32) NOT NULL, " +
						GpsDB.COLUMN_NAME_LATITUDE + " varchar(32) NOT NULL, " +
						GpsDB.COLUMN_NAME_TIME + " DATETIME NOT NULL, " + 
						GpsDB.COLUMN_NAME_START_TIME + " DATETIME NOT NULL " +
						" )"
						;
    	Connection con = DataContract.getConnection();
    	if (con == null) return;
    	
		Statement stmt = null;
	    try {
	        stmt = con.createStatement();
	        stmt.executeUpdate(createString);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (stmt != null) { try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} }
	        try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	}
	
	public static void insertGps(GpsInfo gps) {
		
		Connection con = DataContract.getConnection();
		if (con == null) return;
		Statement stmt = null;
		//gps information
		String id = gps.getId();
		String longitude = gps.getLongitude();
		String latitude = gps.getLatitude();
		String time = gps.getTime();
		String startTime = gps.getStartTime();
		System.out.println(gps.toString());
		
		try {
	        stmt = con.createStatement();
	        stmt.executeUpdate(
	            "insert into " + GpsDB.TABLE_NAME +
	            " values("+ id + "," + 
	            		  longitude + "," +
	            		  latitude + ",'" +
	            		  time + "','" +
	            		  startTime + "')");
	        

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (stmt != null) { try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} }
	        try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }

	}
	
	
	public static List<GpsInfo> searchGpsById(String id) {
		
		List<GpsInfo> gpsList = null;
		
		Connection con = DataContract.getConnection();
		Statement stmt = null;
		String query = 
				"select * from " +
						GpsDB.TABLE_NAME + 
						" where " +
						GpsDB.COLUMN_NAME_ID + 
						" = " + id +
						" order by " + 
						GpsDB.COLUMN_NAME_TIME +
						" asc ";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				if (gpsList == null) gpsList = new ArrayList<GpsInfo>();
				GpsInfo gps = new GpsInfo();
				gps.setId(rs.getString(GpsDB.COLUMN_NAME_ID));
				gps.setLongitude(rs.getString(GpsDB.COLUMN_NAME_LONGITUDE));
				gps.setLatitude(rs.getString(GpsDB.COLUMN_NAME_LATITUDE));
				gps.setTime(rs.getString(GpsDB.COLUMN_NAME_TIME));
				gps.setStartTime(rs.getString(GpsDB.COLUMN_NAME_START_TIME));
				gpsList.add(gps);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return gpsList;
	}
	
	
	
	
	
	
}
