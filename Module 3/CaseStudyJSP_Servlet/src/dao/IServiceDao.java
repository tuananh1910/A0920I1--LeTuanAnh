package dao;


import model.Service;

import java.util.List;

public interface IServiceDao {
    void insertService(Service service);
    Service getService(int id);
    List<Service> getAllService();
    boolean updateService(Service service);
    boolean deleteService(int id);

}
