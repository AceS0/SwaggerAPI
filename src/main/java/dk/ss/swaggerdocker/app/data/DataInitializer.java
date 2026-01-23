package dk.ss.swaggerdocker.app.data;

import dk.ss.swaggerdocker.app.model.Document;
import dk.ss.swaggerdocker.app.model.Talent;
import dk.ss.swaggerdocker.app.repository.TalentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final TalentRepository talentRepository;

    public DataInitializer(TalentRepository talentRepository) {
        this.talentRepository = talentRepository;
    }

    @Override
    public void run(String... args) {
        if (talentRepository.count() > 0) {
            return;
        }

        initializeTalentData();


    }

    private void initializeTalentData() {

        Talent talent = new Talent(
                "Abdulcelil Sekerci",
                "Datamatiker Studerende - Cloud Entusiast",
                "Passioneret datamatiker studerende med stærk interesse for Cloud Native udvikling, " +
                        "DevOps og moderne software arkitektur. Jeg søger en praktikplads hvor jeg kan anvende " +
                        "og udvide mine færdigheder inden for Kubernetes, CI/CD, containerisering og skalerbare " +
                        "cloud-løsninger. Jeg er motiveret, lærevillig og trives med at arbejde i teams hvor " +
                        "vidensdeling og kontinuerlig forbedring er i fokus.",
                "abdulcelilsekerci@gmail.com",
                "+4550380510",
                "København",
                "Danmark",
                "https://github.com/AceS0",
                "https://www.linkedin.com/in/abdulcelilsekerci"
        );

        createCVDocument(talent);
        createMotivationLetter(talent);
        createPortfolio(talent);
        createSkillsDocument(talent);

        talentRepository.save(talent);
    }

    private void createCVDocument(Talent talent) {
        Document cv = new Document(
                "CV - Abdulcelil Sekerci",
                """
                PERSONLIGE OPLYSNINGER
                Navn: Abdulcelil Sekerci
                Email: abdulcelilsekerci@gmail.com
                Telefon: +45 50 38 05 10
                Lokation: København, Danmark
                GitHub: https://github.com/AceS0
                LinkedIn: https://linkedin.com/in/abdulcelilsekerci
                
                UDDANNELSE
                Datamatiker - Københavns Erhvervsakademi (KEA)
                2024 August - 2027 Januar (forventet)
                Fokusområder: Backend udvikling, Cloud Computing, DevOps, Systemintegration
                
                TEKNISKE KOMPETENCER
                Backend: Java, Spring Boot, REST API, JPA/Hibernate
                Frontend: JavaScript, React (grundlæggende)
                Database: PostgreSQL, MySQL, H2
                Cloud & DevOps: Azure, DigitalOcean, AWS, Docker, DevOps Kursus, CI/CD pipelines
                Tools: Git, Maven, IntelliJ IDEA, VS Code
                API: OpenAPI/Swagger, RESTful design
                Architecture: Microservices, Layered Architecture, Design Patterns
                
                PROJEKTER
                Talent API (Dette projekt)
                - REST API med Spring Boot og JPA
                - H2 database med entity relations
                - Swagger/OpenAPI dokumentation
                - Docker containerisering med multi-stage build
                - Layered architecture pattern
                
                SPROGKUNDSKABER
                Dansk: Modersmål
                Engelsk: Flydende
                Tyrkisk: Flydende
                
                PERSONLIGE EGENSKABER
                - Lærevillig og nysgerrig
                - Problemløser med analytisk tilgang
                - God til samarbejde og vidensdeling
                - Struktureret og ansvarsbevidst
                - Interesseret i best practices og kodekvalitet
                """
        );
        cv.setTalent(talent);
        talent.getDocuments().add(cv);

    }

    private void createMotivationLetter(Talent talent) {
        Document motivation = new Document(
                "Motivationsbrev - Tech Chapter Praktik",
                """
                Kære Tech Chapter,
                
                Jeg søger praktikplads hos Tech Chapter, fordi I repræsenterer præcis det miljø, jeg drømmer om at udvikle mig i. Jeres fokus på Cloud Native udvikling, DevOps og Site Reliability Engineering matcher perfekt mine ambitioner og interesser.
                
                HVORFOR TECH CHAPTER?
                Jeg er fascineret af jeres tilgang til at kombinere høj faglighed med stærkt socialt fælleskab og vidensdeling. At arbejde med cutting-edge teknologier som Kubernetes, Container Orkestrering og Infrastructure-as-Code, mens man samtidig er del af et ungt, vidensdelende team, er præcis det udviklingsmiljø jeg søger.
                
                Det imponerer mig, at I arbejder med kunder som LEGO, Novo Nordisk og Danmarks Nationalbank - det viser både jeres ekspertise og trustworthiness i branchen.
                
                HVAD KAN JEG BIDRAGE MED?
                - Stærkt grundlag i backend udvikling med Java og Spring Boot
                - Praktisk erfaring med Docker og containerisering
                - Forståelse for RESTful API design og best practices
                - Passion for at lære nye teknologier (især Kubernetes og cloud platforms)
                - Mindset omkring kodekvalitet, testing og dokumentation
                - Positiv attitude og vilje til at tage ansvar for mine opgaver
                
                HVAD VIL JEG LÆRE?
                Jeg ønsker at dykke dybere ned i:
                - Kubernetes og container orkestrering i praksis
                - CI/CD pipelines og automatisering
                - Infrastructure-as-Code med værktøjer som Terraform
                - Observability og monitoring i cloud miljøer
                - Best practices inden for sikkerhed og skalerbarhed
                - At arbejde i et professionelt DevOps miljø
                
                Jeg er klar til at tage praktikopholdet seriøst, lave godt arbejde og lære massivt i processen. Jeg ved at det kræver en indsats at blive god til noget, og jeg er mere end klar til at investere den tid og energi.
                
                Jeres motto om at "gøre sig umage" resonerer stærkt med mig - det er præcis den attitude jeg har til min uddannelse og fremtidige karriere.
                
                SAMARBEJDE OG NETVÆRK
                Jeg har en god ven, Enes Filikci, som jeg har haft glæden af at arbejde sammen med på flere projekter under vores uddannelse. Vi har talt om muligheden for praktik hos Tech Chapter, og jeg ved at han også kommer til at søge. Vi deler den samme passion for Cloud Native teknologier og DevOps, og jeg tror at vores fælles erfaring med samarbejde og vidensdeling kunne være en styrke. Uanset om vi begge får muligheden for praktik hos jer eller ej, ved jeg at vi begge vil give vores bedste og bidrage positivt til teamet.
                
                Jeg glæder mig til potentielt at blive en del af Tech Chapter familien!
                
                Med venlig hilsen,
                Abdulcelil Sekerci
                """
        );
        motivation.setTalent(talent);
        talent.getDocuments().add(motivation);

    }

    private void createPortfolio(Talent talent) {
        Document portfolio = new Document(
                "Portfolio & Projekter",
                """
                PORTFOLIO
                
                GitHub: https://github.com/AceS0
                
                PROJEKTER
                
                1. Talent API (Dette projekt)
                Tech Stack: Java 21, Spring Boot 4.0.1, JPA, H2, Docker
                Repository: https://github.com/AceS0/SwaggerAPI
                Beskrivelse: REST API udviklet som del af Tech Chapter praktikopgave
                Features:
                - RESTful API design følgende OpenAPI 3.0 specifikation
                - JPA entities med OneToMany/ManyToOne relations
                - Layered architecture (Controller → Service → Repository → Model)
                - Spring Data JPA repositories med custom queries
                - H2 in-memory database med auto-initialisering
                - Swagger/OpenAPI dokumentation med SpringDoc
                - Docker multi-stage build for optimal image størrelse
                - Docker Compose setup
                
                2. BilligTshirt Webshop
                Tech Stack: Java, Spring Boot, Vanilla JavaScript, MySQL
                Repository: https://github.com/AceS0/billigtshirt-webshop (Private)
                Beskrivelse: Eksamenprojekt udviklet af Syntax Squad for faget Preface
                Features:
                - Webshop til BilligTshirt.dk med fuld e-commerce funktionalitet
                - Gavelogik for ordrer over 499 DKK
                - Database design og implementering med MySQL
                - Teamwork og agile udviklingspraksis
                
                
                3. KinoXP
                Tech Stack: Java, Spring Boot, JavaScript
                Repository: https://github.com/2AE-DK/KinoXP
                Beskrivelse: Kino booking system projekt
                Features:
                - Biografbooking funktionalitet
                - Backend udvikling med Spring Boot
                - Database håndtering
                - Dynamisk Frontend via SPA
                - CI/CD pipelines med Github Actions
                - Docker multi-stage build for optimal image størrelse
                - Docker Compose setup
                
                4. AlphaSolutions AE Project
                Tech Stack: Java, Spring Boot, Thymeleaf, JDBC, H2, MySQL
                Repository: https://github.com/AceS0/AlphaSolutions-AE-Project
                Beskrivelse: Projekt for AlphaSolutions
                Features:
                - Java backend implementering
                - Projektledelse og systemdesign
                - Database integration med MySQL og H2
                - Thymeleaf templating
                - Team samarbejde
                - Agile udviklingsmetoder
                - Deployment via Azure App Service
                - CI/CD pipelines med GitHub Actions
                
                5. Project-AI
                Tech Stack: Java, Spring Boot, JavaScript, API - AI/ML relateret
                Repository: https://github.com/AceS0/Project-AI
                Beskrivelse: Eksperimentelt AI projekt
                Features:
                - AI/Machine Learning eksperimentering
                - Læring af nye teknologier
                
                ANDRE KOMPETENCER
                - Git version control og branching strategies
                - Maven dependency management
                - IntelliJ IDEA advanced features
                - API testing med Postman
                - Database design og normalisering
                - Agile metodikker (Scrum basics)
                - Teamwork og projektsamarbejde
                
                LÆRINGSFOKUS
                - Docker container orchestration
                - CI/CD med GitHub Actions
                - Microservices arkitektur patterns
                - Cloud platforms (AWS, Azure, GCP)
                - Infrastructure as Code
                
                Jeg er altid åben for feedback og læring. Mit mål er at blive en dygtig backend developer med stærke DevOps skills, der kan bidrage til robuste, skalerbare cloud-native løsninger.
                """
        );
        portfolio.setTalent(talent);
        talent.getDocuments().add(portfolio);

    }

    private void createSkillsDocument(Talent talent) {
        Document skills = new Document(
                "Kompetencer & Værktøjer",
                """
                TEKNISK VÆRKTØJSKASSE
                
                PROGRAMMING LANGUAGES
                Java (Primær) - Spring Boot, Spring Data JPA, Jakarta EE
                SQL - PostgreSQL, MySQL, H2
                TypeScript/JavaScript - Grundlæggende (React)
                Bash/Shell scripting - Grundlæggende
                
                FRAMEWORKS & LIBRARIES
                - Spring Boot (Web, Data JPA, Security basics)
                - Hibernate/JPA
                - Lombok
                - JUnit 5 & Mockito
                - SpringDoc OpenAPI
                - Jackson (JSON processing)
                
                DATABASES
                - Relational: PostgreSQL, MySQL, H2
                - ORM: JPA/Hibernate
                - Database design og normalisering
                - SQL queries og joins
                
                DEVOPS & TOOLS
                - Docker (containerization)
                - Docker Compose
                - Git & GitHub (Actions)
                - Maven (dependency management & build)
                - IntelliJ IDEA
                - Postman (API testing)
                
                CLOUD & INFRASTRUCTURE (Læring)
                - Kubernetes (teoretisk + lokal eksperimentering)
                - CI/CD concepts
                - Infrastructure as Code (interesse)
                - Cloud platforms (grundlæggende forståelse)
                
                API & INTEGRATION
                - RESTful API design
                - OpenAPI/Swagger specifikation
                - HTTP protocols
                - JSON/XML
                
                SOFTWARE PRACTICES
                - Layered Architecture
                - Design Patterns (Repository, DTO, Service Layer)
                - SOLID principles
                - Clean Code
                - Version Control (Git workflows)
                - Unit Testing
                - API Documentation
                
                SOFT SKILLS
                - Problemløsning og debugging
                - Selvstændig læring
                - Teamwork og kommunikation
                - Struktureret arbejdsmetode
                - Åbenhed overfor feedback
                - Proaktiv attitude
                
                CURRENT FOCUS AREAS
                - Kubernetes og container orchestration
                - Microservices architecture
                - CI/CD pipelines
                - Cloud-native patterns
                - Observability & monitoring
                - Security best practices
                """
        );
        skills.setTalent(talent);
        talent.getDocuments().add(skills);
    }

}
