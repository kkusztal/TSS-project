package pl.webapplication4KK.service;

import java.util.List;
import pl.webapplication4KK.dao.DataDAO;
import pl.webapplication4KK.model.Data;

/**
 *
 * @author kasia
 */
public class DataService {
    private DataDAO dataDAO;

    public DataService() {
        dataDAO = new DataDAO();
    }
    
    public List<Data> getAllData() {
        return dataDAO.selectAllUsers();
    }
    
    public Data getData(int id) {
        return dataDAO.selectUser(id);
    }
    
    public void addData(Data data) {
        dataDAO.insertUser(data);
    }
    
    public void editData(Data data) {
        dataDAO.updateUser(data);
    }
    
    public void deleteData(int id) {
        dataDAO.deleteUser(id);
    }
}
