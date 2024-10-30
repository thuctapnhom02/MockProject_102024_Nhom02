package vn.vpm.hotelM.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vpm.hotelM.Service.ContractLeaseService;
import vn.vpm.hotelM.domain.ContractLease;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContractLeaseController {

    @Autowired
    private ContractLeaseService contractLeaseService;

    // Create
    @PostMapping
    public ResponseEntity<ContractLease> createContractLease(@RequestBody ContractLease contractLease) {
        return ResponseEntity.ok(contractLeaseService.createContractLease(contractLease));
    }

    // Read
    @GetMapping
    public List<ContractLease> getAllContractLeases() {
        return contractLeaseService.getAllContractLeases();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractLease> getContractLeaseById(@PathVariable String id) {
        return ResponseEntity.ok(contractLeaseService.getContractLeaseById(id)
                .orElseThrow(() -> new RuntimeException("ContractLease not found with id: " + id)));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<ContractLease> updateContractLease(@PathVariable String id, @RequestBody ContractLease contractLease) {
        return ResponseEntity.ok(contractLeaseService.updateContractLease(id, contractLease));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContractLease(@PathVariable String id) {
        contractLeaseService.deleteContractLease(id);
        return ResponseEntity.noContent().build();
    }
}
