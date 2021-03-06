package dao.impl;

import dao.IContractDao;
import exception.PrintSQLException;
import model.Attach_service;
import model.Contract;
import model.Contract_details;
import untils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDaoImpl implements IContractDao {
    private static final String INSERT_CONTRACT_SQL = "Insert into CONTRACT(contract_start_day, contract_end_day," +
            " contract_deposit, contract_total_money,employee_id, customer_id, service_id) " +
            "values (?, ?, ?, ?,?, ?, ?)";   //7 value
    private static final String SELECT_CONTRACT_BY_ID = "Select * from CONTRACT where contract_id = ?";
    private static final String SELECT_ALL_CONTRACT = "Select * from CONTRACT";
    private static final String DELETE_CONTRACT_BY_ID = "Delete from CONTRACT where contract_id = ?";
    private static final String UPDATE_CONTRACT = "Update CONTRACT set contract_start_day=? , contract_end_day = ?, contract_deposit = ?, " +
            "contract_total_money = ?, employee_id = ?, customer_id = ?,service_id = ? where contract_id = ?"; //8 value
    private static final String DELETE_CONTRACT_BY_CUSTOMER_ID ="Delete from CONTRACT where customer_id =?";
    private static final String SELECT_CONTRACT_BY_CUSTOMER_ID = "Select * from CONTRACT where customer_id=?";
    //contract details
    private static final String INSERT_CONTRACT_DETAILS_SQL = "Insert into CONTRACT_DETAILS (contract_id," +
            "attach_service_id, quality) values (?,?,?)";
    private static final String SELECT_CONTRACT_DETAILS_SQL = "Select * from CONTRACT_DETAILS where contract_id=?";
    private static final String DELETE_CONTRACT_DETAILS_BY_CONTRACT_ID_SQL = "Delete from CONTRACT_DETAILS where contract_id=?";
    //attach service
    private static final String SELECT_ATTACH_SERVICE ="Select * from ATTACH_SERVICE where attach_service_id=?";
   private static final String SELECT_ALL_ATTACH_SERVICE = "Select * from ATTACH_SERVICE";
    @Override
    public void insertContract(Contract contract) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(INSERT_CONTRACT_SQL);

            statement.setString(1,contract.getContract_start_date());
            statement.setString(2,contract.getContract_end_date());
            statement.setDouble(3,contract.getContract_deposit());
            statement.setDouble(4,contract.getContract_total_money());
            statement.setInt(5,contract.getEmployee_id());
            statement.setString(6,contract.getCustomer_id());
            statement.setString(7,contract.getService_id());

            System.out.println(statement);
            statement.executeUpdate();
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
    }

    @Override
    public Contract getContract(int id) {
        Contract contract = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(SELECT_CONTRACT_BY_ID);

            statement.setInt(1,id);
            System.out.println(statement);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int contract_id = resultSet.getInt("contract_id");
                String contract_start_date = resultSet.getString("contract_start_date");
                String contract_end_date = resultSet.getString("contract_end_date");
                double contract_deposit = resultSet.getDouble("contract_deposit");
                double contract_total_money = resultSet.getDouble("contract_total_money");
                int employee_id = resultSet.getInt("employee_id");
                String customer_id = resultSet.getString("customer_id");
                String service_id = resultSet.getString("service_id");
                contract = new Contract(contract_id,contract_start_date,contract_end_date,contract_deposit,
                        contract_total_money,employee_id,customer_id,service_id);
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
        return contract;
    }

    @Override
    public List<Contract> getAllContract() {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(SELECT_ALL_CONTRACT);

            System.out.println(statement);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int contract_id = resultSet.getInt("contract_id");
                String contract_start_date = resultSet.getString("contract_start_date");
                String contract_end_date = resultSet.getString("contract_end_date");
                double contract_deposit = resultSet.getDouble("contract_deposit");
                double contract_total_money = resultSet.getDouble("contract_total_money");
                int employee_id = resultSet.getInt("employee_id");
                String customer_id = resultSet.getString("customer_id");
                String service_id = resultSet.getString("service_id");

                contractList.add(new Contract(contract_id,contract_start_date,contract_end_date,
                        contract_deposit,contract_total_money,employee_id,customer_id,service_id));
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
        return contractList;
    }

    @Override
    public boolean updateContract(Contract contract) {
        boolean rowUpdate=false;               //!!!!!!
        Connection connection;
        PreparedStatement statement;

        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(UPDATE_CONTRACT);

            statement.setString(1, contract.getContract_start_date());
            statement.setString(2, contract.getContract_end_date());
            statement.setDouble(3, contract.getContract_deposit());

            statement.setDouble(4, contract.getContract_total_money());


            statement.setInt(5, contract.getEmployee_id());
            statement.setString(6, contract.getCustomer_id());
            statement.setString(7, contract.getService_id());
            statement.setInt(8, contract.getContract_id());

            System.out.println(statement.executeUpdate());
            rowUpdate = statement.executeUpdate()>0;

        } catch (SQLException e) {
            PrintSQLException.printSQLException(e);
        }
        System.out.println(rowUpdate);
        return rowUpdate;

    }

    @Override
    public boolean deleteContract(int id) {
        return false;
    }





    @Override
    public boolean deleteContractByCustomerID(String customer_id) {
        boolean rowDelete= false;
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT_BY_CUSTOMER_ID)){
            preparedStatement.setString(1,customer_id);
            rowDelete = preparedStatement.executeUpdate()>0; // excuteUpdate
        } catch (SQLException e) {
            PrintSQLException.printSQLException(e);
        }
        //System.out.println(rowDelete);
        return rowDelete;

    }

    @Override
    public Contract getContractByCustomerId(String customer_id) {
        Contract contract = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(SELECT_CONTRACT_BY_CUSTOMER_ID);

            statement.setString(1,customer_id);
            System.out.println(statement);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int contract_id = resultSet.getInt("contract_id");
                String contract_start_date = resultSet.getString("contract_start_date");
                String contract_end_date = resultSet.getString("contract_end_date");
                double contract_deposit = resultSet.getDouble("contract_deposit");
                double contract_total_money = resultSet.getDouble("contract_total_money");
                int employee_id = resultSet.getInt("employee_id");

                String service_id = resultSet.getString("service_id");
                contract = new Contract(contract_id,contract_start_date,contract_end_date,contract_deposit,
                        contract_total_money,employee_id,customer_id,service_id);
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
        return contract;
    }

    @Override
    public void insertContractDetails(Contract_details contract_details) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(INSERT_CONTRACT_DETAILS_SQL);

            statement.setInt(1,contract_details.getContrac_id());
            statement.setInt(2,contract_details.getAttach_service_id());
            statement.setInt(3,contract_details.getQuality());

            System.out.println(statement);
            statement.executeUpdate();
        }catch (SQLException e){
            PrintSQLException.printSQLException(e);
        }finally {
            try{
                if (connection!=null){
                    connection.close();
                }if (statement!=null){
                    statement.close();
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Contract_details getContracDetails(int contractID) {
        Contract_details contract_details = null;
        Connection connection = null;
        PreparedStatement statement= null;
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(SELECT_CONTRACT_DETAILS_SQL); //select by contract_id

            statement.setInt(1,contractID);
            System.out.println(statement);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int contract_details_id = resultSet.getInt("contract_details_id");

                int attach_service_id = resultSet.getInt("attach_service_id");
                int quality = resultSet.getInt("quality");

                contract_details = new Contract_details(contract_details_id,contractID,attach_service_id,quality);
            }

        }catch (SQLException e){
            PrintSQLException.printSQLException(e);
        }
        return contract_details;
    }

    @Override
    public boolean deleteContratDetailsByContractID(int contract_id) {
        boolean rowDelete= false;
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT_DETAILS_BY_CONTRACT_ID_SQL)){
            preparedStatement.setInt(1,contract_id);

            System.out.println(preparedStatement);
            rowDelete = preparedStatement.executeUpdate()>0; // excuteUpdate
        } catch (SQLException e) {
            PrintSQLException.printSQLException(e);
        }
        //System.out.println(rowDelete);
        return rowDelete;
    }

    @Override
    public Attach_service getAttachService(int attach_service_id) {
        Attach_service attach_service = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(SELECT_ATTACH_SERVICE);

            statement.setInt(1,attach_service_id);
            System.out.println(statement);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){

                String attach_service_name = resultSet.getString("attach_service_name");
                double attach_service_cost = resultSet.getDouble("attach_service_cost");
                int attach_service_unit = resultSet.getInt("attach_service_unit");
                String attach_service_status = resultSet.getString("attach_service_status");

                attach_service = new Attach_service(attach_service_id,attach_service_name,attach_service_cost,
                        attach_service_unit,attach_service_status);
            }
        }catch (SQLException e){
            PrintSQLException.printSQLException(e);
        }finally {
            try {
                if (connection!=null){
                    connection.close();
                }if (statement!=null){
                    statement.close();
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return attach_service;
    }

    @Override
    public List<Attach_service> getAllAttachService() {
        List<Attach_service> attachServiceList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(SELECT_ALL_ATTACH_SERVICE);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int attach_service_id = resultSet.getInt("attach_service_id");
                String attach_service_name = resultSet.getString("attach_service_name");
                double attach_service_cost = resultSet.getDouble("attach_service_cost");
                int attach_service_unit = resultSet.getInt("attach_service_unit");
                String attach_service_status = resultSet.getString("attach_service_status");

                attachServiceList.add(new Attach_service(attach_service_id,attach_service_name,
                        attach_service_cost,attach_service_unit,attach_service_status));
            }
        }catch (SQLException e){
            PrintSQLException.printSQLException(e);
        }
        return attachServiceList;
    }
}
