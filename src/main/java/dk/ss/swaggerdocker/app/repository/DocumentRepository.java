package dk.ss.swaggerdocker.app.repository;

import dk.ss.swaggerdocker.app.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByTalentId(Long talentId);
}

