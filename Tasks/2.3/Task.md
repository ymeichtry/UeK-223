# Projekt-Endpunkt-Definitionen

## Projektbeschreibung

Dieses Projekt ist eine Produktverwaltungsanwendung, die Nutzern die Möglichkeit bietet, sich zu registrieren und anzumelden, Produkte anzuzeigen, zu erstellen, zu aktualisieren und zu löschen, sowie Bestellungen aufzugeben und zu verwalten.

## Hauptfunktionen der Anwendung

1. **Nutzerverwaltung:** Nutzer können sich registrieren und anmelden.
2. **Produktverwaltung:** Produkte können hinzugefügt, angezeigt, bearbeitet und gelöscht werden.
3. **Bestellverwaltung:** Nutzer können Bestellungen aufgeben und den Status einer Bestellung prüfen.

---

## Endpunkt-Definitionen

| Endpunkt-URL         | HTTP-Methode | Beschreibung                               | Benötigte Daten                     |
|----------------------|--------------|--------------------------------------------|-------------------------------------|
| `/register`          | POST         | Registriert einen neuen Nutzer             | E-Mail, Passwort                    |
| `/login`             | POST         | Meldet einen bestehenden Nutzer an         | E-Mail, Passwort                    |
| `/products`          | GET          | Ruft eine Liste aller Produkte ab          | Keine                               |
| `/products`          | POST         | Erstellt ein neues Produkt                 | Produktname, Preis, Beschreibung    |
| `/products/{id}`     | GET          | Ruft Details zu einem bestimmten Produkt ab| Produkt-ID                          |
| `/products/{id}`     | PUT          | Aktualisiert ein Produkt                   | Produkt-ID, Produktname, Preis, Beschreibung |
| `/products/{id}`     | DELETE       | Löscht ein Produkt                         | Produkt-ID                          |
| `/orders`            | POST         | Erstellt eine neue Bestellung              | Produkt-ID, Nutzer-ID               |
| `/orders/{id}`       | GET          | Zeigt Details zu einer bestimmten Bestellung| Bestell-ID                          |
| `/orders/{id}`       | DELETE       | Storniert eine Bestellung                  | Bestell-ID                          |

---

## Beschreibung der wichtigsten Endpunkte

- **POST `/register`:** Dieser Endpunkt registriert einen neuen Nutzer, indem er die E-Mail und das Passwort erhält und speichert.
- **POST `/login`:** Ermöglicht einem Nutzer, sich anzumelden, indem E-Mail und Passwort validiert werden.
- **GET `/products`:** Gibt eine Liste aller verfügbaren Produkte zurück, die der Nutzer anzeigen kann.
- **POST `/products`:** Erlaubt es einem Nutzer, ein neues Produkt hinzuzufügen, indem Produktname, Preis und Beschreibung angegeben werden.
- **PUT `/products/{id}`:** Aktualisiert ein vorhandenes Produkt, das über seine Produkt-ID identifiziert wird, und akzeptiert neue Produktdaten.
- **DELETE `/products/{id}`:** Löscht ein bestimmtes Produkt, identifiziert durch die Produkt-ID.
- **POST `/orders`:** Erstellt eine neue Bestellung, indem der Nutzer ein Produkt auswählt (Produkt-ID) und seine Nutzer-ID angegeben wird.
- **GET `/orders/{id}`:** Zeigt die Details einer spezifischen Bestellung an, die durch die Bestell-ID identifiziert wird.
- **DELETE `/orders/{id}`:** Ermöglicht es einem Nutzer, eine bestehende Bestellung zu stornieren, die über die Bestell-ID identifiziert wird.

---

## Motivation

Die Motivation hinter dieser Produktverwaltungsanwendung besteht darin, eine einfache Möglichkeit für die Verwaltung und Bestellung von Produkten bereitzustellen. Diese Anwendung kann sowohl für den persönlichen als auch für den geschäftlichen Gebrauch nützlich sein.

---

## Technische Anforderungen

Diese Endpunkt-Definitionen stellen sicher, dass alle notwendigen Funktionen abgedeckt sind und die richtigen HTTP-Methoden verwendet werden. Jeder Endpunkt ist auf eine bestimmte Aufgabe ausgerichtet und ermöglicht eine klare und sichere Kommunikation zwischen Frontend und Backend.
