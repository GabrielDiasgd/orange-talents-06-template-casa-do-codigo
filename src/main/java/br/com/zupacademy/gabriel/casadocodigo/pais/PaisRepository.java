package br.com.zupacademy.gabriel.casadocodigo.pais;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.gabriel.casadocodigo.estado.Estado;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

	Optional<Estado> findByEstados(Estado estado);

	Optional<Estado> findByEstadosId(Long idEstado);

}
