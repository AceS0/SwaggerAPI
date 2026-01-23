package dk.ss.swaggerdocker.app.repository;

import dk.ss.swaggerdocker.app.model.Talent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalentRepository extends JpaRepository<Talent, Long> {
}
