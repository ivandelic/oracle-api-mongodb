package com.ivandelic.micro.csas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping(path = "/branches", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BranchController {

    @Autowired
    BranchRepository branchRepository;

    @GetMapping("")
    @ResponseBody ResponseEntity<Iterable<Branch>> list() {
        Iterable<Branch> branches = branchRepository.findAll();
        return new ResponseEntity<>(branches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Branch> getById(@PathVariable Integer id) {
        Optional<Branch> branch = branchRepository.findById(id);
        if (branch.isPresent()) {
            return new ResponseEntity<>(branch.get(), HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("Not Found");
        }
    }

    @PutMapping("/")
    public @ResponseBody ResponseEntity<Branch> insert(@RequestBody Branch input) {
        Branch branch = branchRepository.save(input);
        return new ResponseEntity<>(branch, HttpStatus.CREATED);
    }

    @PostMapping("/")
    public @ResponseBody ResponseEntity<Branch> save(@RequestBody Branch input) {
        Branch branch = branchRepository.save(input);
        return new ResponseEntity<>(branch, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity delete(@PathVariable Integer id) {
        branchRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
