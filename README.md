# UserManagementApp

UserManagementApp è un'applicazione Spring Boot per la gestione degli utenti, con supporto per l'autenticazione e autorizzazione basata su JWT. Fornisce API per la registrazione, il login e la protezione delle risorse tramite ruoli utente.

## Requisiti
- Java 11+
- Maven

## Dipendenze
Le principali dipendenze utilizzate in questo progetto includono:
- **Spring Boot**: per creare l'applicazione web e configurare la sicurezza.
- **Spring Security**: per gestire l'autenticazione e autorizzazione.
- **JWT (jjwt)**: per gestire i token JWT.
- **JUnit 5**: per i test unitari.
- **Rest Assured**: per testare le API.

## Esecuzione del Progetto
1. Clona il repository:
   ```bash
   git clone https://github.com/nerlin/UserManagementApp.git

## Naviga nella cartella del progetto:

cd UserManagementApp

## Esegui l'applicazione:

mvn spring-boot:run

## Esecuzione dei Test:

mvn test


## Struttura del Progetto :
AuthController: Gestisce il login e la registrazione degli utenti, integrato con la generazione di token JWT.
UserController: Gestisce le operazioni legate agli utenti (es. recupero profilo, modifica dei dati).
JwtUtil: Classe responsabile della generazione e validazione dei token JWT.
SecurityConfig: Configura Spring Security per proteggere le risorse tramite JWT.