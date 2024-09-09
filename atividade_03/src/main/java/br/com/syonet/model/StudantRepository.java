package br.com.syonet.model;

import java.util.List;

public interface StudantRepository {
  Studant create(Studant studant);
  List<Studant> listAll();
  Studant findById(long id);   
  void update(Studant studant); 
  void delete(long id);        
  List<Studant> findByName(String name); 
}

