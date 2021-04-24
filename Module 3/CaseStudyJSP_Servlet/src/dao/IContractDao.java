package dao;

import model.Attach_service;
import model.Contract;
import model.Contract_details;

import java.util.List;

public interface IContractDao {
    void insertContract(Contract contract);
    Contract getContract(int id);
    List<Contract> getAllContract();
    boolean updateContract(Contract contract);
    boolean deleteContract(int id);
    boolean deleteContractByCustomerID(int customer_id);

    //contract details
    void insertContractDetails(Contract_details contract_details);
    Contract_details getContracDetails(int contractID);
    boolean deleteContratDetailsByContractID(int contract_id);

    //attach_service
    Attach_service getAttachService(int attach_service_id);
}
