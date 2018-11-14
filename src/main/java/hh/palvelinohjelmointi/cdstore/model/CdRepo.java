package hh.palvelinohjelmointi.cdstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CdRepo extends CrudRepository<Cd, Long> {
	List<Cd> findByTitle(String title);
}