package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import constant.DBConstant;

@Component
public class DbAssistant {

	private Connection connection;
	private String URL;
	private String USER;
	private String PSW;

	public DbAssistant() {
		try {
			Class.forName(DBConstant.DB_DRIVER);
			System.out.println("erro:can not load the db driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.connection = DriverManager.getConnection(DBConstant.URL,
					DBConstant.USER, DBConstant.PSW);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro:can not link to the db");
		}
	}

	public DbAssistant(String db, String url, String user, String psw) {
		try {
			Class.forName(db);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("erro:can not load the db driver");
		}
		try {
			this.connection = DriverManager.getConnection(url, user, psw);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro:can not link to the db");
		}
	}

	public static String buildValue(List<String> valueList) {
		String valueStr = "";
		for (int i = 0; i < valueList.size(); i++) {
			valueStr += "\"" + valueList.get(i) + "\"";
			if (i < valueList.size() - 1) {
				valueStr += ",";
			}
		}
		return valueStr;
	}

	public static String buildColumn(List<String> columnList) {
		String columnStr = "";
		for (int i = 0; i < columnList.size(); i++) {
			columnStr += "\"" + columnList.get(i) + "\"";
			if (i < columnList.size() - 1) {
				columnStr += ",";
			}
		}
		return columnStr;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public void setUSER(String uSER) {
		USER = uSER;
	}

	public void setPSW(String pSW) {
		PSW = pSW;
	}
}
