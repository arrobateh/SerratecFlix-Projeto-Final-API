package org.serratec.SerratecFlix.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.SerratecFlix.domain.Categoria;
import org.serratec.SerratecFlix.dto.CategoriaDTORequest;
import org.serratec.SerratecFlix.dto.CategoriaDTOResponse;
import org.serratec.SerratecFlix.exception.RecursoNaoEncontradoException;
import org.serratec.SerratecFlix.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	
	public List<CategoriaDTOResponse> findAll() {

	    List<Categoria> categorias = categoriaRepository.findAll();

	    List<CategoriaDTOResponse> categoriaDTO = new ArrayList<>();

	    for (Categoria categoria : categorias) {

	        CategoriaDTOResponse categoriaDTOResponse = new CategoriaDTOResponse();
	        categoriaDTOResponse.setId(categoria.getId());
	        categoriaDTOResponse.setNome(categoria.getNome());
	        categoriaDTOResponse.setDescricao(categoria.getDescricao());

	        categoriaDTO.add(categoriaDTOResponse);
	    }

	    return categoriaDTO;
	}
	
	
	public CategoriaDTOResponse buscar(Long id) {

	    Categoria categoria = categoriaRepository.findById(id)
	    		.orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada com id: " + id));

	    CategoriaDTOResponse  categoriaDTO = new CategoriaDTOResponse();
	    categoriaDTO.setId(categoria.getId());
	    categoriaDTO.setNome(categoria.getNome());
	    categoriaDTO.setDescricao(categoria.getDescricao());

	    return categoriaDTO;
	}
	
	
	
	public CategoriaDTOResponse inserir(CategoriaDTORequest categoriaDTO) {

	    Categoria categoria = new Categoria();
	    categoria.setNome(categoriaDTO.getNome());
	    categoria.setDescricao(categoriaDTO.getDescricao());

	    categoria = categoriaRepository.save(categoria);

	    CategoriaDTOResponse categoriaDTOResponse = new CategoriaDTOResponse();
	    categoriaDTOResponse.setId(categoria.getId());
	    categoriaDTOResponse.setNome(categoria.getNome());
	    categoriaDTOResponse.setDescricao(categoria.getDescricao());

	    return categoriaDTOResponse;
	}
	
	public CategoriaDTOResponse atualizar(Long id, CategoriaDTORequest categoriaDTO) {

	    Categoria categoria = categoriaRepository.findById(id)
	    		.orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada com id: " + id));

	    categoria.setNome(categoriaDTO.getNome());
	    categoria.setDescricao(categoriaDTO.getDescricao());

	    categoria = categoriaRepository.save(categoria);

	    CategoriaDTOResponse categoriaDTOResponse = new CategoriaDTOResponse();
	    categoriaDTOResponse.setId(categoria.getId());
	    categoriaDTOResponse.setNome(categoria.getNome());
	    categoriaDTOResponse.setDescricao(categoria.getDescricao());

	    return categoriaDTOResponse;
	}

	public void deletar(Long id) {

	    Categoria categoria = categoriaRepository.findById(id)
	    		.orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada com id: " + id));

	    categoriaRepository.delete(categoria);
	}
}
