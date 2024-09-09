package br.com.syonet.service;

import java.util.List;

import br.com.syonet.model.Studant;
import br.com.syonet.model.StudantRepository;

public class StudantService {
  private StudantRepository repository;

  public StudantService(StudantRepository repository) {
      this.repository = repository;
  }

  public long save(Studant studant) {
      if (studant.getId() == 0) {
          Studant newStudant = this.repository.create(studant);
          return newStudant.getId();
      }
      throw new IllegalArgumentException("Id não pode ser atribuido");
  }

  public List<Studant> listAll() {
      return this.repository.listAll();
  }

  public Studant findById(long id) {
      return this.repository.findById(id);
  }

  public void update(Studant studant) {
      this.repository.update(studant);
  }

  public void delete(long id) {
      this.repository.delete(id);
  }

  public List<Studant> findByName(String name) {
      return this.repository.findByName(name);
  }
}

