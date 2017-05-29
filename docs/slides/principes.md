## Démo

---

## Un moteur de build
* Exécution sur la plateforme Java
* Description des builds en Groovy
* Extensible
* Rapide

---

## Gradle s'adapte à mon projet
#### (Et pas l'inverse !)
* Convention over configuration
* Faire évoluer les conventions
* Idéal pour des projets legacy
* On ne décrit pas son build, on le construit

---

##  Des tâches, des tâches
#### Et encore des tâches
* Élément de base
* Graphe orienté acyclique
* Maîtrise complète de l'ordonnancement
* Phase de configuration avant éxécution

---

## Démo

---

## Et mon projet Java ?

---

## ```Java Plugin```
* Conventions par défaut
```
# src/main/java
# src/main/resources
# src/test/java
```
* Customization des ```sourceSets``` existants
* Ajout de nouveaux sourceSets ```sourceSets```
  * pour les tests d'intégration par exemple ?

---

## ```Java Plugin Tasks```
* Le plugin rajoute diverses tâches
  * ```compileJava``` compilation des sources avec ```javac```
  * ```compileTestJava``` compilation des sources des tests
  * ```test``` exécution des test avec JUnit (ou autre)
  * ```jar``` création du jar avec le résultat de la compilation

* Définit un sous-graphe qui se raccroche au lifecycle général
* Toujours possible de s'intercaler à tout moment
* Création dynamiques de tâches lors de l'ajout d'un sourceSet

---

## Gestion des dépendances

