package dao.impl;

import dao.IManager_productDao;
import model.Manager_prodcut;
import untils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Manager_ProductDaoImpl implements IManager_productDao {
    private static final String GET_ALL_MANAGER_PRODUCT_SQL = "Select * from manage_product";

    @Override
    public void insertProduct(Manager_prodcut manager_prodcut) {

    }

    @Override
    public IManager_productDao getProduct(int id) {
        return null;
    }

    @Override
    public List<Manager_prodcut> getAllProduct() {
        List<Manager_prodcut> managerProdcutList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(GET_ALL_MANAGER_PRODUCT_SQL);

            System.out.println(statement);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int manager_product_id = resultSet.getInt("manager_product_id");
                String product_name = resultSet.getString("product_name");
                double product_price = resultSet.getDouble("product_price");
                int product_discount = resultSet.getInt("product_discount");

                managerProdcutList.add(new Manager_prodcut(manager_product_id,product_name,product_price,product_discount));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return managerProdcutList;
    }

    @Override
    public boolean updateProduct(IManager_productDao IManager_productDao) {
        return false;
    }

    @Override
    public boolean deleteProdcut(int id) {
        return false;
    }
}
