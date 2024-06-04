package com.riwi.vacants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.vacants.entities.utils.dto.request.CompanyRequest;
import com.riwi.vacants.entities.utils.dto.response.CompanyResponse;
import com.riwi.vacants.services.interfaces.ICompanyService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/company")
@AllArgsConstructor
public class CompanyController {
  @Autowired
  private final ICompanyService companyService;

  @GetMapping
  public ResponseEntity<Page<CompanyResponse>> getAll(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "3") int size) {
    return ResponseEntity.ok(this.companyService.getAll(page - 1, size));
  }

  @PostMapping
  public ResponseEntity<CompanyResponse> insert(@RequestBody CompanyRequest entity) {
    return ResponseEntity.ok(this.companyService.create(entity));
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<CompanyResponse> update(@RequestBody CompanyRequest entity, @PathVariable String id) {
    return ResponseEntity.ok(this.companyService.update(entity, id));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    this.companyService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<CompanyResponse> getById(@PathVariable String id) {
    return ResponseEntity.ok(this.companyService.getById(id));
  }
}
