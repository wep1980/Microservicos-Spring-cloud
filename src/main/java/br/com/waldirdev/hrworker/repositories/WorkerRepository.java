package br.com.waldirdev.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.waldirdev.hrworker.entities.Worker;



public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
