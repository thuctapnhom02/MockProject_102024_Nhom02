package vn.vpm.hotelM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vpm.hotelM.Repository.UtilityContractRepository;
import vn.vpm.hotelM.domain.UtilityContract;

import java.util.List;
import java.util.Optional;

@Service
public class UtilityContractService {

    @Autowired
    private UtilityContractRepository utilityContractRepository;

    public List<UtilityContract> getAllUtilityContracts() {
        return utilityContractRepository.findAll();
    }

    public Optional<UtilityContract> getUtilityContractById(String id) {
        return utilityContractRepository.findById(id);
    }

    public UtilityContract createUtilityContract(UtilityContract utilityContract) {
        return utilityContractRepository.save(utilityContract);
    }

    public UtilityContract updateUtilityContract(String id, UtilityContract utilityContract) {
        utilityContract.setIdContract(id);
        return utilityContractRepository.save(utilityContract);
    }

    public void deleteUtilityContract(String id) {
        utilityContractRepository.deleteById(id);
    }
}
