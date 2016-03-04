package cc.geekie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.geekie.dao.GpsDao;
import cc.geekie.domain.GpsInfo;

public class GpsController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("服务器被访问");
		
		String status =request.getParameter("STATUS");
		if ("update".equals(status)) {
			String id = "1";
			String longitude = request.getParameter("longitude");
			String latitude = request.getParameter("latitude");
			String time = request.getParameter("time");
			String startTime = request.getParameter("startTime");

			
			GpsInfo gps = new GpsInfo();
			gps.setId(id);
			gps.setLongitude(longitude);
			gps.setLatitude(latitude);
			gps.setTime(time);
			gps.setStartTime(startTime);
			
			
			GpsDao.createTable();
			GpsDao.insertGps(gps);
			
			
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
