package pl.webapplication3KK.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author kasia
 */
public class DataService {
    List<Data> list = new ArrayList<Data>() {
        {
            add(new Data(100, "Kowalski", "Jan", "Katowice"));
            add(new Data(101, "Nowak", "Piotr", "Bielsko-Biała"));
            add(new Data(102, "Górska", "Anna", "Sosnowiec"));
        }
    };
    
    public List<Data> getData() {
        return list;
    }
    
    public void addData(String firstName, String lastName, String city) {
        int id = 1;
        if(list.size() != 0) {
            id = list.get(list.size()-1).getId();
            id++;
        }
        list.add(new Data(id, lastName, firstName, city));
    }
    
    public void updateData(int id, String firstName, String lastName, String city) {
        for(Data user : list) {
            if(user.getId() == id) {
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setCity(city);
            }
        }
    }

    public void deleteData(int id) {
        Iterator<Data> iterator = list.iterator();
        while(iterator.hasNext()) {
            Data user = iterator.next();
            if(user.getId() == id)
                iterator.remove();
        }
    }
}
