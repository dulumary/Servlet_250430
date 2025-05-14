package com.marondal.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MysqlService {
	
	private Connection connection;
	
	// 클래스를 설계한 입장에서
	// 해당 클래스의 객체가 두개이상 만들어지지 않도록
	// 하나의 객체를 공유해서 사용하게 한다.
	// Singleton pattern
	// static 변수 : 객체 생성 없이 사용할 수 있는 멤버변수 
	private static MysqlService mysqlService = null;
	
	// 해당 클래스의 객체를 return 하는 메소드
	// static 메소드 : 객체 생성없이 사용할 수 있는 메소드
	// 객체 생성없이 수행되는 기능이기 때문에 객체 생성을 통해서 만들어지는 멤버변수는 사용 불가능
	public static MysqlService getInstance() {
		
		if(mysqlService == null) {
			mysqlService = new MysqlService();
		}
		
		return mysqlService;
	}
	
	// 데이터베이스 접속 기능
	public boolean connect() {
		
		// database 접속
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			// 접속에 필요한 정보 
			// 접속 주소, 포트, 사용할 데이터베이스, 사용자이름, 비밀번호
			String url = "jdbc:mysql://localhost:3306/dulumary_250414";
			String username = "root";
			String password = "root";
			
			connection = DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			// 접속 실패 
			return false;
		}
		
		return true;
		
	}
	
	// 조회 쿼리 수행기능
	public List<Map<String, Object>> select(String query) {
		
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			// 조회 결과의 컬럼 목록
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			// 컬럼 이름 리스트
			List<String> columnList = new ArrayList<>();
			for(int i = 1; i <= columnCount; i++) {
				columnList.add(rsmd.getColumnName(i));
			}
			
			List<Map<String, Object>> resultList = new ArrayList<>();
			while(resultSet.next()) {
				
				Map<String, Object> row = new HashMap<>();
				// 하나의 행에서 컬럼 이름으로 모든 값 얻어 오기 
				for(String column:columnList) {
					Object value = resultSet.getObject(column);
					
					row.put(column, value);
				}				
				resultList.add(row);
			}
			statement.close();
			return resultList;
		} catch (SQLException e) {

			e.printStackTrace();
			
			return null;
		}
	}
	
	// INSERT, UPDATE, DELETE 
	public int update(String query) {
		
		Statement statement;
		try {
			statement = connection.createStatement();
			int count = statement.executeUpdate(query);
			statement.close();
			return count;

		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return -1;
		}
	
	
	}
	// 데이터베이스 접속 끊기 
	public boolean disconnect() {
		
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return false;
		}
		
		return true;
		
	}
	

}
