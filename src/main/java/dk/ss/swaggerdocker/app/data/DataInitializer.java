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
                "https://www.linkedin.com/in/abdulcelilsekerci",
                "https://projekter.tech/"
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
                Projekter: https://projekter.tech/

                UDDANNELSE
                Datamatiker - Københavns Erhvervsakademi (KEA)
                2024 August - 2027 Januar (forventet)
                Fokusområder: Backend udvikling, Cloud Computing, DevOps, Systemintegration

                TEKNISKE KOMPETENCER
                Backend: Java, Spring Boot, Python, Go, REST API, JPA/Hibernate
                Frontend: JavaScript, Next.js, React (grundlæggende)
                Database: PostgreSQL, MySQL, H2
                Cloud & DevOps: Azure, DigitalOcean, AWS, Docker, DevOps Kursus, CI/CD pipelines
                Tools: Git, Maven, IntelliJ IDEA, VS Code
                API: OpenAPI/Swagger, RESTful design
                Architecture: Microservices, Layered Architecture, Design Patterns

                PROJEKTER
                Talent API (Dette projekt)
                - REST API med Java 21 og Spring Boot 4.0.1
                - JPA entities med OneToMany/ManyToOne relations (Talent ↔ Document)
                - H2 in-memory database med auto-initialisering og H2 Console
                - Layered architecture (Controller → Service → Repository → Model)
                - Lombok til boilerplate reduktion
                - Docker multi-stage build (eclipse-temurin:21-jre-alpine)

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
                """.stripIndent()
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
                """.stripIndent()
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
                Projektside: https://projekter.tech/

                PROJEKTER

                1. projekter.tech - Live Projekt Portfolio
                Tech Stack: Next.js, React, JavaScript, Cloud Hosting
                URL: https://projekter.tech/
                Beskrivelse: Personlig projektside der viser en samling af mine udviklede og hostede projekter/systemer. Siden er live og tilgængelig online og fungerer som en showcase for mine kompetencer inden for deployment og hosting.
                Features:
                - Showcase af live hostede projekter og systemer
                - Demonstration af deployment og hosting kompetencer
                - Overblik over teknologier og løsninger jeg har bygget
                - Live og tilgængelig online

                2. WhoKnows Migration Project - SyntaxDevopsSquad
                Tech Stack: Go 1.25.0, SQLite, Gorilla Sessions, Docker, Terraform, GitHub Actions, Azure
                Repository: https://github.com/SyntaxDevopsSquad-SDS/devops-syntaxsquad
                Beskrivelse: DevOps modul projekt (KEA 2026) - Migration af legacy Python Flask applikation til Go med fokus på DevOps praksis, CI/CD og Infrastructure as Code. Projektet er udført som en del af DevOps-modulet på KEA af et hold på 4 udviklere, ingen med forudgående Go erfaring.
                Stack: Go backend, SQLite database, Gorilla Sessions til session management, Docker til containerisering, Terraform til IaC på Azure, GitHub Actions til CI/CD
                Features:
                - Migration fra Python/Flask til Go backend
                - User authentication: Registration, login og session management
                - Wiki-style page management med søgefunktionalitet
                - SQLite database med users og pages tabeller
                - Terraform Infrastructure as Code på Azure (Azure for Students)
                - Docker containerisering og CI/CD pipelines med GitHub Actions
                - Conventional Commits og Git workflows
                - Teamsamarbejde i hold af 4 udviklere
                Team: CodeByNajib, AceS0, MarcusLieberH, Daniel23894

                3. Talent API (Dette projekt)
                Tech Stack: Java 21, Spring Boot 4.0.1, Spring Data JPA, H2, Lombok, Docker
                Repository: https://github.com/AceS0/SwaggerAPI
                Beskrivelse: REST API udviklet som del af Tech Chapter praktikopgave - en fuld portfolio API med talent- og dokumenthåndtering
                Features:
                - RESTful API design følgende OpenAPI 3.0 specifikation
                - JPA entities med OneToMany/ManyToOne relations (Talent ↔ Document)
                - Layered architecture (Controller → Service → Repository → Model)
                - Spring Data JPA repositories
                - H2 in-memory database med auto-initialisering og H2 Console
                - Lombok til reduktion af boilerplate kode
                - Docker multi-stage build (Maven build + eclipse-temurin:21-jre-alpine)
                - Endpoints: GET /talent, GET /talent/{id}, GET /talent/{id}/documents, GET /talent/{id}/documents/{documentId}

                4. BilligTshirt Webshop
                Tech Stack: Java, Spring Boot, Vanilla JavaScript, MySQL
                URL: https://billigtshirt.projekter.tech/
                Repository: https://github.com/AceS0/billigtshirt-webshop (Private)
                Beskrivelse: Eksamenprojekt udviklet af Syntax Squad for virksomheden Preface - live og hostet på billigtshirt.projekter.tech
                Features:
                - Webshop til BilligTshirt.dk med fuld e-commerce funktionalitet
                - Gavelogik for ordrer over 499 DKK
                - Database design og implementering med MySQL
                - Teamwork og agile udviklingspraksis


                5. KinoXP
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

                6. AlphaSolutions AE Project
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

                7. Project-AI
                Tech Stack: Java, Spring Boot, JavaScript, API - AI/ML relateret
                URL: https://ai.projekter.tech/
                Repository: https://github.com/AceS0/Project-AI
                Beskrivelse: Eksperimentelt AI projekt - live og hostet på ai.projekter.tech
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
                """.stripIndent()
        );
        portfolio.setTalent(talent);
        talent.getDocuments().add(portfolio);

    }

    private void createSkillsDocument(Talent talent) {
        Document skills = new Document(
                "Kompetencer & Værktøjer",
                """
                KOMPETENCER
                Teknologier og metoder jeg arbejder med til daglig.

                PROGRAMMERINGSSPROG
                - Java (Primær) - Spring Boot, Spring Data JPA, Jakarta EE
                - Python - FastAPI, Flask, scripting og automation
                - Go - Backend udvikling (WhoKnows Migration Project)
                - JavaScript / TypeScript - Frontend og Node.js
                - SQL - PostgreSQL, MySQL, H2, SQLite
                - Bash / Shell scripting
                - HTML / CSS
                - YAML - Docker Compose, GitHub Actions workflows
                - Markdown - Dokumentation

                FRAMEWORKS & BACKEND
                - Spring Boot (Web, Data JPA, Security basics)
                - JPA / Hibernate
                - FastAPI (Python)
                - Node.js
                - Next.js
                - Gorilla Sessions (Go)
                - Lombok
                - JUnit 5 & Mockito
                - SpringDoc OpenAPI
                - Jackson (JSON processing)

                DATABASER
                - MySQL
                - PostgreSQL
                - H2 (in-memory)
                - SQLite
                - ORM: JPA/Hibernate
                - Database design og normalisering
                - SQL queries og joins

                DEVOPS & INFRASTRUKTUR
                - Git & GitHub (Actions, branching strategies, Conventional Commits)
                - Linux / CLI
                - Bash Scripts
                - Docker (containerisering, multi-stage builds)
                - Docker Compose
                - CI/CD Pipelines (GitHub Actions)
                - Cloud Hosting (Azure, DigitalOcean, AWS)
                - Terraform (Infrastructure as Code)
                - Kubernetes (teoretisk + lokal eksperimentering)
                - Maven (dependency management & build)
                - Postman (API testing)
                - YAML (workflows & config)

                METODER & KONCEPTER
                - OOP (Object Oriented Programming)
                - Design Patterns (Repository, DTO, Service Layer, SOLID)
                - REST APIs & OpenAPI/Swagger specifikation
                - Agile / Scrum / XP
                - Layered Architecture
                - Microservices Architecture
                - Clean Code & Unit Testing
                - AI & Chatbot-integration

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
                """.stripIndent()
        );
        skills.setTalent(talent);
        talent.getDocuments().add(skills);
    }

}
