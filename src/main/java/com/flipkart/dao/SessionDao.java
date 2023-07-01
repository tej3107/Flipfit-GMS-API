package com.flipkart.dao;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


public class SessionDao {

    private static final int TOKEN_LENGTH = 20;

    public static String generateToken() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid.substring(0, Math.min(uuid.length(), TOKEN_LENGTH));
    }

    public static String generateCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    public String createSession(String userName) throws Exception{
        String token = generateToken();
        String time = generateCurrentDateTime();

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBUtils.getConnection();

            stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_SESSION_QUERY);
            stmt.setString(1, token);
            stmt.setString(2, userName);
            stmt.setString(3, time);
//
            stmt.executeUpdate();
          return token;

        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
            throw sqlExcep;
        } catch(Exception excep) {
            excep.printStackTrace();
            throw excep;
        }

    }

    public boolean deleteSession(String token) throws Exception{

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBUtils.getConnection();

            stmt = conn.prepareStatement(SQLConstants.SQL_DELETE_QUERY_FOR_SESSION);
            stmt.setString(1, token);
            stmt.execute();
            return true;

        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
            throw sqlExcep;
        } catch(Exception excep) {
            excep.printStackTrace();
            throw excep;
        }

    }

    public boolean hasActiveSession(String token) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBUtils.getConnection();

            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_SESSION_QUERY);
            stmt.setString(1, token);

            ResultSet output = stmt.executeQuery();
            if(output.next()){
                return true;
            }
            else return false;

        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
            throw sqlExcep;
        } catch(Exception excep) {
            excep.printStackTrace();
            throw excep;
        }


    }
}
