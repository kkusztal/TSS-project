package pl.webapplication4KK.service;

import java.sql.Connection;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author kasia
 */
public final class DBConnect {
    private Connection connection;
    
    public DBConnect() {
        getConnectionFromContext();
    }
    
    public Connection getConnectionFromContext() {
        try {
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource ds_mssql = (DataSource)envContext.lookup("jdbc/bazaTestowaMSSQL");
            
            connection = ds_mssql.getConnection();        
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
