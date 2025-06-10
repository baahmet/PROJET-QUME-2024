# 📦 Projet QUME 2024 — Distributeur Automatique de Boissons

> Projet réalisé dans le cadre de l’unité d’enseignement :  
> **Mesure de Qualité et Performance Logicielle (QUME)**  
> Niveau : Licence 3 Informatique — Semestre 6  
>  
> 📅 **Date de rendu :** 04/06/2025

---

## 👥 Membres du groupe

- 🔸 **Ba Mohamet Lamine** 
- 🔸 **Ba Mouhamadou Al Bachir** 

---

## 🎯 Objectif du projet

Ce projet a pour objectif de modéliser et développer une application Java simulant un **distributeur automatique de boissons**, permettant :

- D'afficher la liste des boissons disponibles
- D'effectuer des achats en insérant un montant
- De recharger les stocks par le personnel
- De gérer un portefeuille utilisateur
- De journaliser toutes les transactions

Il met l'accent sur la qualité du code, la modularité, les tests unitaires et d’acceptance, ainsi que la rigueur dans l’approche orientée objet.

---

## 🧱 Technologies utilisées

- 🔹 **Java 17**
- 🔹 **Maven** (build & gestion des dépendances)
- 🔹 **JUnit 5** (tests unitaires)
- 🔹 **Cucumber 7.14.0** (tests d’acceptance)
- 🔹 **draw.io (diagramme de classes)
- 🔹 **IntelliJ IDEA**

---

## 📘 Fonctionnalités clés

- Affichage de toutes les boissons disponibles avec leur stock et prix
- Achat d’une boisson avec validation du montant
- Gestion du portefeuille (insertion, remise à zéro)
- Recharge du stock d'une boisson par le personnel
- Journalisation des ventes
- Gestion des erreurs (boisson introuvable, montant insuffisant, stock épuisé…)

---

## 📂 Structure du projet

```
Projet_QUME_L3/
├── src/
   └── main/
       └──java/
            ├──org.example/
                ├──models/ contient les fichier.java des classes.
                          ├──Boisson
                          ├──Distributeur
		                      ├──JournalVente
		                      ├──Portefeuille
                          ├──Transaction
                          ├──Utilisateur
       └── resources/ 
            └── features/          ← Contient les fichiers .feature avec les scénarios en langage     Gherkin
└── test/
         ├──java  
     	   ├──runner/               ←Contient la classe qui lance les tests d’acception
   	   ├──steps/                 ← Contient les StepDefinitions (logique des scénarios)
               ├──Juste en bas se trouve tous les fichiers des tests unitaires

```

---

## 🧪 Tests réalisés

### ✔️ 35 tests unitaires (JUnit 5)

Les classes suivantes ont été testées :

- `BoissonTest`
- `DistributeurTest`
- `PortefeuilleTest`
- `TransactionTest`
- `JournalVenteTest`
- `UtilisateurTest`

**Exemples de tests :**
- Création et affichage des boissons
- Vérification de la disponibilité et réduction de stock
- Achat avec montant exact ou insuffisant
- Recharge de stock
- Enregistrement des transactions
- Gestion du portefeuille utilisateur

---

### ✔️ 15 scénarios de tests d’acceptance (Cucumber)

> Exemple de scénario :
```gherkin
Scenario: Achat réussi d'une boisson
  Given le distributeur contient une boisson "Fanta" à 400 FCFA avec 5 en stock
  When l'utilisateur insère 500 FCFA et achète "Fanta"
  Then l'achat est réussi et le stock diminue de 1
```

Les tests couvrent tous les cas d’usage métiers :
- Affichage
- Achat
- Erreurs (stock vide, boisson inexistante, etc.)
- Recharge

---

## ▶️ Exécution des tests

Lancer tous les tests depuis un terminal :
```bash
mvn clean test
```
---

## 📘 Rapport PDF

Le fichier Projet_QUME_2024.pdf contient :

- ✅ Le diagramme de classes UML
- ✅ La description des classes
- ✅ La liste des tests unitaires (35)
- ✅ La liste des scénarios Gherkin (15)
- ✅ Les noms des étudiants
- ✅ Une conclusion sur le projet

---

## ✅ Statut du projet

| Éléments attendus         | État   |
|---------------------------|--------|
| Diagramme de classes UML  | ✅ Fait
| Code Java complet         | ✅ Fait
| Tests unitaires (35)      | ✅ Fait
| Scénarios Gherkin (15)    | ✅ Fait
| Rapport PDF               | ✅ Fait
| README GitHub             | ✅ Fait

---



## 🏁 Fin

Projet complet, testé, et prêt à être livré ✅
