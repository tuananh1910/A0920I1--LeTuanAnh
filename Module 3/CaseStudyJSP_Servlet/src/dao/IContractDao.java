package dao;

import model.Contract;
import model.Contract_details;
import model.Service;

import java.util.List;

public interface IContractDao {
    void insertContract(Contract contract);
    Contract getContract(int id);
    List<Contract> getAllContract();
    boolean updateContract(Contract contract);
    boolean deleteContract(int id);

    //contract details
    void insertContractDetails(Contract_details contract_details);

    //attach_service
//    String getAttachServiceName (int attach_service_id);
}
