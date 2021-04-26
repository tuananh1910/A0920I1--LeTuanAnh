package dao;


import model.Rent_type;
import model.Service;
import model.Service_type;

import java.util.List;

public interface IServiceDao {
    void insertService(Service service);
    Service getService(String id);
    List<Service> getAllService();
    boolean updateService(Service service);
    boolean deleteService(int id);

    Service_type getServiceType(int service_type_id);
    Rent_type getRentType(int rent_type_id);

}
