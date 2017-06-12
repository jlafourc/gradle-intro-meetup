
## Et mon projet Java ?

---

## Java Plugin

* Identification des sources
* Ajout de tâches diverses
* Gestion des dépendances
* Incremental Compilation
* Compile Avoidance
* Le p'tit frère ```java-library```

---

## SourceSets

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

## Java Plugin Tasks

* ```compileJava``` compilation des sources avec ```javac```
* ```compileTestJava``` compilation des sources des tests
* ```test``` exécution des test avec JUnit (ou autre)
* ```jar``` création du jar avec le résultat de la compilation

---

## Java Plugin Tasks

* Définit un sous-graphe qui se raccroche au lifecycle général
* Toujours possible de s'intercaler à tout moment
* Création dynamiques de tâches lors de l'ajout d'un sourceSet

---

## Gestion des dépendances

* Chaque sourceSet implique la création de ```configurations```
* ```compile, compileOnly, runtime, testCompile, testRuntime ...```

---

## Gestion des dépendances

```groovy
dependencies {
    compile 'com.foo:bar:1.0'
    testCompile group: 'junit', name: 'junit', version: '4.11'
    ///////////
    compile fileTree(dir: 'mes-libs', include: '*.jar')
}
```

---

## Gestion des dépendances

* API de résolution accessible

* Forcer la version d'une dépendance

```groovy
configurations.all {
    resolutionStrategy {
        force 'commons-io:commons-io:1.4'
    }
}
```

---

## Gestion des dépendances

* Exclure un groupe/un artifact globalement

```groovy
configurations {
    runtime.exclude group: "org.slf4j", module: "slf4j-log4j12"
}
```

* Exclure un groupe/un artifact tiré par une dépendance

```groovy
dependencies {
    compile ('org.springframework.data:spring-data-neo4j:4.2.3.RELEASE') {
        exclude group: "org.slf4j", name: "slf4j-log4j12"
    }
}
```

---

## Les repositories

* Gestion des repos Maven et Ivy
* ```mavenCentral(), jcenter(), google()```
* ```mavenLocal()```

```groovy
repositories {
    mavenCentral()
    maven {
        url "http://repo.meetup.io/maven"
    }
}
```

---

## Publier vers un repo Maven

* Séparation nette entre contruction et publication
* Publication de plusieurs artefacts
  * Pas seulement des artifacts annexes
* Plugin ```maven``` ou ```maven-publish```
* Génération et customization du pom

---

## Démo 3
### Création d'une lib avec le plugin java

---

## java-library plugin

* Meilleure gestion de dépendances
* Séparation api et implementation
* Génération du POM plus fine
* Evite les fuites dans le classpath
  * Optimise en plus le build

---

## Démo 4
### Tests d'intégrations dans un projet spring-boot

---

## Les composite builds

* Regrouper des projets séparés
  * Dans un même process de build
* Permet une intégration plus forte
  * Facilte les refactoring
* Goodbye ```mavenLocal()```

---

## Les plugins recommandés

### https://plugins.gradle.org/

* Docker : https://github.com/palantir/gradle-docker
* Node, Grunt, Gulp, Yarn : https://github.com/srs/gradle-node-plugin
* Task tree : https://github.com/dorongold/gradle-task-tree
* Nebula: https://github.com/nebula-plugins
* Si vous avez des BOMs : https://github.com/spring-gradle-plugins/dependency-management-plugin


---

## Ce que nous ne verrons pas

* Les multi-project builds
* La construction de plugins
* L'utilisation du cache
  * Y compris le remote via Http
* Gradle Build Scan
* Et bien d'autre