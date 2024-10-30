package vn.vpm.hotelM.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vpm.hotelM.Service.ContractServiceService;
import vn.vpm.hotelM.domain.ContractService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contract-service")
public class ContractServiceController {

    @Autowired
    private ContractServiceService contractServiceService;

    @PostMapping
    public ResponseEntity<ContractService> createContractService(@RequestBody ContractService contractService) {
        ContractService createdContractService = contractServiceService.createContractService(contractService);
        return new ResponseEntity<>(createdContractService, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContractService>> getAllContractServices() {
        List<ContractService> contractServices = contractServiceService.getAllContractServices();
        return new ResponseEntity<>(contractServices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractService> getContractServiceById(@PathVariable String id) {
        Optional<ContractService> contractService = contractServiceService.getContractServiceById(id);
        return contractService.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContractService> updateContractService(@PathVariable String id, @RequestBody ContractService contractService) {
        ContractService updatedContractService = contractServiceService.updateContractService(id, contractService);
        return new ResponseEntity<>(updatedContractService, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContractService(@PathVariable String id) {
        contractServiceService.deleteContractService(id);
        return ResponseEntity.noContent().build();
    }
}
