package ma.ac.usmba.springApp.dao;


import ma.ac.usmba.springApp.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<ClientEntity, Integer> {
    ClientEntity findByNome(String nome);
}
