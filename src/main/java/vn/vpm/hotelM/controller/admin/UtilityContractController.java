package vn.vpm.hotelM.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vpm.hotelM.domain.UtilityContract;
import vn.vpm.hotelM.service.UtilityContractService;

import java.util.List;

@RestController
@RequestMapping("/api/utility-contracts")
public class UtilityContractController {

    @Autowired
    private UtilityContractService utilityContractService;

    @GetMapping
    public ResponseEntity<List<UtilityContract>> getAllUtilityContracts() {
        List<UtilityContract> contracts = utilityContractService.getAllUtilityContracts();
        return ResponseEntity.ok(contracts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilityContract> getUtilityContractById(@PathVariable String id) {
        return utilityContractService.getUtilityContractById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UtilityContract> createUtilityContract(@RequestBody UtilityContract utilityContract) {
        UtilityContract createdContract = utilityContractService.createUtilityContract(utilityContract);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContract);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilityContract> updateUtilityContract(@PathVariable String id,
                                                                 @RequestBody UtilityContract utilityContract) {
        UtilityContract updatedContract = utilityContractService.updateUtilityContract(id, utilityContract);
        return ResponseEntity.ok(updatedContract);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilityContract(@PathVariable String id) {
        utilityContractService.deleteUtilityContract(id);
        return ResponseEntity.noContent().build();
    }
}
