package com.flipkart.resources;

import com.flipkart.dao.SessionDao;

public class SessionAuthentication {
    SessionDao session = new SessionDao();

    public String addValidToken(String userName) throws Exception{
        return session.createSession(userName);
    }

    public boolean isValidToken(String token) throws Exception{
        return session.hasActiveSession(token);
    }

    public boolean removeToken(String token) throws Exception{
        return session.deleteSession(token);
    }
}
