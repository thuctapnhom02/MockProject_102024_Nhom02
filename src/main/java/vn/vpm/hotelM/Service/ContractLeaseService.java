package vn.vpm.hotelM.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vpm.hotelM.Repository.ContractLeaseRepository;
import vn.vpm.hotelM.domain.ContractLease;

import java.util.List;
import java.util.Optional;

@Service
public class ContractLeaseService {

    @Autowired
    private ContractLeaseRepository contractLeaseRepository;


    // Create
    public ContractLease createContractLease(ContractLease contractLease) {
        return contractLeaseRepository.save(contractLease);
    }

    // Read
    public List<ContractLease> getAllContractLeases() {
        return contractLeaseRepository.findAll();
    }

    public Optional<ContractLease> getContractLeaseById(String id) {
        return contractLeaseRepository.findById(id);
    }

    // Update
    public ContractLease updateContractLease(String id, ContractLease contractLeaseDetails) {
        ContractLease contractLease = contractLeaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ContractLease not found with id: " + id));

        contractLease.setUser(contractLeaseDetails.getUser());
        contractLease.setStaff(contractLeaseDetails.getStaff());
        contractLease.setStatus(contractLeaseDetails.getStatus());
        contractLease.setContactInfo(contractLeaseDetails.getContactInfo());
        contractLease.setRentalFee(contractLeaseDetails.getRentalFee());
        contractLease.setPaymentPeriod(contractLeaseDetails.getPaymentPeriod());
        contractLease.setLeaseStartDate(contractLeaseDetails.getLeaseStartDate());
        contractLease.setLeaseEndDate(contractLeaseDetails.getLeaseEndDate());
        contractLease.setSuppliers(contractLeaseDetails.getSuppliers());
        contractLease.setApartment(contractLeaseDetails.getApartment());

        return contractLeaseRepository.save(contractLease);
    }

    // Delete
    public void deleteContractLease(String id) {
        ContractLease contractLease = contractLeaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ContractLease not found with id: " + id));
        contractLeaseRepository.delete(contractLease);
    }
}
