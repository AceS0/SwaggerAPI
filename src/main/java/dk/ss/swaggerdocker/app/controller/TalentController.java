package dk.ss.swaggerdocker.app.controller;

import dk.ss.swaggerdocker.app.model.Document;
import dk.ss.swaggerdocker.app.model.Talent;
import dk.ss.swaggerdocker.app.service.TalentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/talent")
public class TalentController {

    private final TalentService talentService;

    public TalentController(TalentService talentService){
        this.talentService = talentService;
    }

    @GetMapping
    public ResponseEntity<List<Talent>> findAll(){
        return ResponseEntity.ok(talentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Talent> getTalent(@PathVariable UUID id) {
        return ResponseEntity.ok(talentService.getTalentById(id));
    }

    @GetMapping("/{id}/documents")
    public ResponseEntity<List<Document>> getDocuments(@PathVariable UUID id) {
        return ResponseEntity.ok(talentService.getDocumentsByTalentId(id));
    }

    @GetMapping("/{talentId}/documents/{documentId}")
    public ResponseEntity<Document> getDocument(@PathVariable UUID talentId, @PathVariable UUID documentId) {
        return ResponseEntity.ok(talentService.getDocumentByTalentIdAndDocumentId(talentId, documentId));
    }
}
