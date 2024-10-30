package vn.vpm.hotelM.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vpm.hotelM.Repository.ContractServiceRepository;
import vn.vpm.hotelM.domain.ContractService;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceService {

    @Autowired
    private ContractServiceRepository contractServiceRepository;

    public ContractService createContractService(ContractService contractService) {
        return contractServiceRepository.save(contractService);
    }

    public List<ContractService> getAllContractServices() {
        return contractServiceRepository.findAll();
    }

    public Optional<ContractService> getContractServiceById(String id) {
        return contractServiceRepository.findById(id);
    }

    public ContractService updateContractService(String id, ContractService updatedContractService) {
        updatedContractService.setIdContract(id);
        return contractServiceRepository.save(updatedContractService);
    }

    public void deleteContractService(String id) {
        contractServiceRepository.deleteById(id);
    }
}
