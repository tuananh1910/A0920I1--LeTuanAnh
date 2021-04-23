package dao.impl;

import exception.PrintSQLException;
import dao.IContractDao;
import model.Contract;

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
            statement.setInt(6,contract.getCustomer_id());
            statement.setInt(7,contract.getService_id());

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
                int customer_id = resultSet.getInt("customer_id");
                int service_id = resultSet.getInt("service_id");
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
                int customer_id = resultSet.getInt("customer_id");
                int service_id = resultSet.getInt("service_id");

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
        return false;
    }

    @Override
    public boolean deleteContract(int id) {
        return false;
    }
}
