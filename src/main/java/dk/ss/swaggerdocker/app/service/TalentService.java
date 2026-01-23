package dk.ss.swaggerdocker.app.service;

import dk.ss.swaggerdocker.app.model.Document;
import dk.ss.swaggerdocker.app.model.Talent;
import dk.ss.swaggerdocker.app.repository.DocumentRepository;
import dk.ss.swaggerdocker.app.repository.TalentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentService {

    private final TalentRepository talentRepository;
    private final DocumentRepository documentRepository;

    public TalentService(TalentRepository talentRepository, DocumentRepository documentRepository){
        this.talentRepository = talentRepository;
        this.documentRepository = documentRepository;
    }

    public List<Talent> findAll(){
        return talentRepository.findAll();
    }

    public Talent getTalentById(Long id) {
        return talentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Talent not found with id: " + id));
    }

    public List<Document> getDocumentsByTalentId(Long talentId) {
        return documentRepository.findByTalentId(talentId);
    }

    public Document getDocumentByTalentIdAndDocumentId(Long talentId, Long documentId) {
        Document document = documentRepository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found with id: " + documentId));

        if (!document.getTalent().getId().equals(talentId)) {
            throw new RuntimeException("Document with id " + documentId + " does not belong to talent with id " + talentId);
        }

        return document;
    }
}
