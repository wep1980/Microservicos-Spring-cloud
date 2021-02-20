package br.com.waldirdev.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.waldirdev.hrworker.entities.Worker;
import br.com.waldirdev.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class); // Objeto que imprime informações no logger
	
	@Autowired
	private Environment env; // Environment -> Objeto que contem varias informações do contexto da aplicação
	
	
	@Autowired
	private WorkerRepository repository;
	
	
	
	/**
	 * ResponseEntity -> Encapsula uma resposta HTTP
	 */
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		
		// .ok() -> Requisição feita com sucesso, e retorna no corpo a lista
		return ResponseEntity.ok(list);
	}
	
	
	
	/**
	 * value = "/{id}" -> captura o id na requisição
	 * @PathVariable Long id -> captura o id da requisição
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		
		logger.info("PORT = " + env.getProperty("local.server.port")); // Imprime uma menssagem de informação no console da aplicação(logger) a porta que esta sendo usada
		
		// Como o retorno do findById() retorna um optional, para pegar o objeto worker e necessario o get() no final
		Worker obj = repository.findById(id).get();
		
		// .ok() -> Requisição feita com sucesso, e retorna no corpo a lista
		return ResponseEntity.ok(obj);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
