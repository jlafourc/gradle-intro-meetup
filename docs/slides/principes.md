## Démo

---

## Un moteur de build
* Exécution sur la plateforme Java
* Description des builds en Groovy
* Extensible
* Rapide
* API entièrement accessible

---

## Gradle s'adapte à mon projet
#### (Et pas l'inverse !)
* Convention over configuration
* Faire évoluer les conventions
* Idéal pour des projets legacy
* On ne décrit pas son build, on le construit

---

## Pour builder quoi ?

* Du Java (built-in)
  * Mais aussi Groovy et Scala
* C, C++ ... (built-in)
* Python
* Node (npm, yarn ...), JS, Bower
* Docker

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

* Identification des sources
* Ajout de tâches diverses
* Gestion des dépendances
* Incremental Compilation
* Compile Avoidance
* Le p'tit frère ```java-library```

---

## ```SourceSets```

* Conventions par défaut
```
# src/main/java
# src/main/resources
# src/test/java
```
* Customizer les ```sourceSets``` existants
* Ajouter de nouveaux ```sourceSets```
  * pour les tests d'intégration par exemple ?

---

## ```Java Plugin Tasks (1)```

* ```compileJava``` compilation des sources avec ```javac```
* ```compileTestJava``` compilation des sources des tests
* ```test``` exécution des test avec JUnit (ou autre)
* ```jar``` création du jar avec le résultat de la compilation

---

## ```Java Plugin Tasks (2)```

* Définit un sous-graphe qui se raccroche au lifecycle général
* Toujours possible de s'intercaler à tout moment
* Création dynamiques de tâches lors de l'ajout d'un sourceSet

---

## Gestion des dépendances (1)


* Chaque sourceSet implique la création de ```configurations```
* ```compile, compileOnly, runtime, testCompile, testRuntime ...```

----
```CONFIGURATION = DEPENDANCES + ARTIFACTS```

----

---

## Gestion des dépendances (2)

```groovy
dependencies {
    compile 'com.foo:bar:1.0'
    testCompile 'org.junit:junit:4.11'
    ///////////
    compile fileTree(dir: 'mes-libs', include: '*.jar')
}
```





---

## Gestion des dépendances (2)