package pl.webapplicationKK.dao;

import java.sql.*;
import java.util.*;
import pl.webapplicationKK.model.Data;
import pl.webapplicationKK.service.DBConnect;

/**
 *
 * @author kasia
 */
public class DataDAO {
    private final DBConnect databaseConnection;
    private final Connection connection;

    public DataDAO() {
        databaseConnection = new DBConnect();
        connection = databaseConnection.getConnectionFromContext();
    }
    
    private static final String SELECT_ALL_USERS = "SELECT id, imie, nazwisko FROM t_uzytkownik ORDER BY id";
    private static final String SELECT_USER_BY_ID = "SELECT id, imie, nazwisko FROM t_uzytkownik WHERE id=?";
    private static final String INSERT_USER = "INSERT INTO t_uzytkownik (id, imie, nazwisko) VALUES ((SELECT COALESCE(MAX(id),0) FROM t_uzytkownik)+1, ?, ?)";
    private static final String UPDATE_USER = "UPDATE t_uzytkownik SET imie=?, nazwisko=? WHERE id=?";
    private static final String DELETE_USER = "DELETE FROM t_uzytkownik WHERE id=?";

    public List<Data> selectAllUsers() {  
        List<Data> list = new ArrayList<>();
        try (Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(SELECT_ALL_USERS);       
            while(rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("imie");
                String lastName = rs.getString("nazwisko");

                list.add(new Data(id, firstName, lastName));
            }      
        } catch (SQLException e) {
              e.printStackTrace();
        }
        return list;
    }
    
    public Data selectUser(int id) {
        Data data = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String firstName = rs.getString("imie");
                String lastName = rs.getString("nazwisko");
                data = new Data(id, firstName, lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    
    public void insertUser(Data data) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_USER)){
            ps.setString(1, data.getFirstName());
            ps.setString(2, data.getLastName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateUser(Data data) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_USER)) {
            ps.setString(1, data.getFirstName());
            ps.setString(2, data.getLastName());
            ps.setInt(3, data.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
              e.printStackTrace();
        }
    }
    
    public void deleteUser(int id) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_USER)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
