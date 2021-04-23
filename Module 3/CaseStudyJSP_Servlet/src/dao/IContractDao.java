package dao;

import model.Contract;
import model.Service;

import java.util.List;

public interface IContractDao {
    void insertContract(Contract contract);
    Contract getContract(int id);
    List<Contract> getAllContract();
    boolean updateContract(Contract contract);
    boolean deleteContract(int id);
}
