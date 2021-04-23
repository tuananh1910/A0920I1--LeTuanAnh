package dao.impl;

import exception.PrintSQLException;
import dao.IServiceDao;
import model.Service;
import untils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDaoImpl implements IServiceDao {

    private static final String INSERT_SERVICE_SQL = "Insert into SERVICE(service_name, service_area," +
            " service_cost, service_max_people,rent_type_id,service_type_id,standard_room,description_orther_convenience," +
            "pool_area,number_of_floor) " +
            "values (?, ?, ?, ?,?, ?, ?, ?,?,?)";   //10 value
    private static final String SELECT_SERVICE_BY_ID = "Select * from SERVICE where service_id = ?";
    private static final String SELECT_ALL_SERVICE = "Select * from SERVICE";
    private static final String DELETE_SERVICE_BY_ID = "Delete from SERVICE where service_id = ?";
    private static final String UPDATE_SERVICE = "Update SERVICE set service_name=? , service_area = ?, service_cost = ?, " +
            "service_max_people = ?, rent_type_id = ?, service_type_id = ?,standard_room = ?, description= ?," +
            "pool_area=? ,number_of_floor=? where service_id = ?"; //11 value
    @Override
    public void insertService(Service service) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(INSERT_SERVICE_SQL);

            statement.setString(1,service.getService_name());
            statement.setInt(2,service.getService_area());
            statement.setDouble(3,service.getService_cost());
            statement.setInt(4,service.getService_max_people());
            statement.setInt(5,service.getRent_type_id());
            statement.setInt(6,service.getService_type_id());
            statement.setString(7,service.getStandard_room());
            statement.setString(8,service.getDescription_orther_convenience());
            statement.setDouble(9,service.getPool_area());
            statement.setInt(10,service.getNumber_of_floors());

            System.out.println(statement);
            statement.executeUpdate();
        }catch (SQLException e){
            PrintSQLException.printSQLException(e);
        }finally {
            try{
                if (statement!=null){
                    statement.close();
                }if (connection !=null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public Service getService(int id) {
        Service service = null;
        Connection connection = null;
        PreparedStatement statement=null;
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(SELECT_SERVICE_BY_ID);

            statement.setInt(1,id);
            System.out.println(statement);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int service_id = resultSet.getInt("service_id");
                String service_name = resultSet.getString("service_name");
                int service_area = resultSet.getInt("service_area");
                double service_cost = resultSet.getDouble("service_cost");
                int service_max_people = resultSet.getInt("service_max_people");
                int rent_type_id = resultSet.getInt("rent_type_id");
                int service_type_id = resultSet.getInt("service_type_id");
                String standard_room = resultSet.getString("standard_room");
                String description_orther_convenience = resultSet.getString("description_orther_convenience");
                double pool_area = resultSet.getDouble("pool_area");
                int number_of_floors = resultSet.getInt("number_of_floor");

                service = new Service(service_id,service_name,service_area,service_cost,
                        service_max_people,rent_type_id,service_type_id,standard_room,
                        description_orther_convenience,pool_area,number_of_floors);

            }

        }catch (SQLException e){
            PrintSQLException.printSQLException(e);
        }finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return service;
    }

    @Override
    public List<Service> getAllService() {
        List<Service> serviceList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection= ConnectionDB.getConnection();
            statement = connection.prepareStatement(SELECT_ALL_SERVICE);

            System.out.println(statement);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int service_id = resultSet.getInt("service_id");
                String service_name = resultSet.getString("service_name");
                int service_area = resultSet.getInt("service_area");
                double service_cost = resultSet.getDouble("service_cost");
                int service_max_people = resultSet.getInt("service_max_people");
                int rent_type_id = resultSet.getInt("rent_type_id");
                int service_type_id = resultSet.getInt("service_type_id");
                String standard_room = resultSet.getString("standard_room");
                String description_orther_convenience = resultSet.getString("description_orther_convenience");
                double pool_area = resultSet.getDouble("pool_area");
                int number_of_floors = resultSet.getInt("number_of_floor");

                serviceList.add(new Service(service_id,service_name,service_area,
                        service_cost,service_max_people,rent_type_id,service_type_id,
                        standard_room,description_orther_convenience,pool_area,number_of_floors));
            }
        }catch (SQLException e){
            PrintSQLException.printSQLException(e);
        }finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return serviceList;
    }

    @Override
    public boolean updateService(Service service) {
        return false;
    }

    @Override
    public boolean deleteService(int id) {
        return false;
    }
}
