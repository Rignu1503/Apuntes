package com.riwi.vacants.services;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.entities.Vacant;
import com.riwi.vacants.entities.utils.dto.request.CompanyRequest;
import com.riwi.vacants.entities.utils.dto.response.CompanyResponse;
import com.riwi.vacants.entities.utils.dto.response.VacantToCompanyResponse;
import com.riwi.vacants.repositories.CompanyRepository;
import com.riwi.vacants.services.interfaces.ICompanyService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {
  @Autowired
  private final CompanyRepository objCompanyRepository;

  @Override
  public Page<CompanyResponse> getAll(int page, int size) {
    page = (page < 0) ? 0 : page;
    // if (page < 0) lo anterior es igual a esto
    // page = 0;
    PageRequest pagination = PageRequest.of(page, size);
    // dentro del map lo que esta es igual a: company ->
    // this.entityToResponse(company)
    return this.objCompanyRepository.findAll(pagination).map(this::entityToResponse);
  }

  @Override
  public CompanyResponse create(CompanyRequest request) {
    Company entity = this.objCompanyRepository.save(this.requestToEntity(request, new Company()));
    return this.entityToResponse(entity);
  }

  @Override
  public CompanyResponse update(CompanyRequest request, String id) {
    this.find(id);
    Company entity = this.requestToEntity(request, new Company());
    entity.setId(id);
    this.objCompanyRepository.save(entity);
    return this.entityToResponse(entity);

  }

  @Override
  public void delete(String id) {
    //Buscamos la compañia a la que le corresponde el ID
    Company company = this.find(id);
    this.objCompanyRepository.delete(company);
  }

  @Override
  public CompanyResponse getById(String id) {
    Company company = this.find(id);
    return this.entityToResponse(company);
  }

  // este metodo se encargara en convertir una entidad en el dto de respuesta de
  // la entidad
  private CompanyResponse entityToResponse(Company entity) {
    CompanyResponse response = new CompanyResponse();
    // todo lo que esta en entity los va a colocar en response(espacios disponibles)
    BeanUtils.copyProperties(entity, response);
    // stream -> convierte la lista en coleccion para pader iterarse
    // map -> Itera toda la lista y retorna cambios
    // Collect -> crea de nuevo toda la lista que se habia transformado en
    // collection
    response.setVacant(entity.getVacant().stream().map(this::vacantToREsponse).collect(Collectors.toList()));
    return response;
  }
  

  private Company requestToEntity(CompanyRequest request, Company objCompany) {
    BeanUtils.copyProperties(request, objCompany);
    objCompany.setVacant(new ArrayList<>());
    return objCompany;
  }

  private VacantToCompanyResponse vacantToREsponse(Vacant entity) {
    VacantToCompanyResponse response = new VacantToCompanyResponse();
    BeanUtils.copyProperties(entity, response);
    return response;
  }

  private Company find(String id) {
    return this.objCompanyRepository.findById(id).orElseThrow();
  }
}