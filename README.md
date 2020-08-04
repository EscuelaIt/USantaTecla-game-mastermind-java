<h1 align="center">Welcome to Master Mind. Solución 4.2. ** dv.+doubleDispathing **
 👋</h1>
<p>
  <a href="/docs" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
  <a href="#" target="_blank">
    <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" />
  </a>
</p>

> Master Mind. Solución dv.withdoubleDispathing

## Install

```sh
mvn install
```

## Usage

For Console edition:

Edit pom.xml line 42 for this:

```sh
<mainClass>usantatecla.mastermind.ConsoleMastermind</mainClass>
```
And then:

```sh
mvn clean
mvn package
java -jar target/mastermind-1.0-SNAPSHOT.jar
```

For Graphics edition:

Edit pom.xml line 42 for this:

```sh
<mainClass>usantatecla.mastermind.GraphicsMastermind</mainClass>
```
And then:

```sh
mvn clean
mvn package
java -jar target/mastermind-1.0-SNAPSHOT.jar
```

## Run tests

```sh
mvn test
```

## Author

👤 **USantaTecla**

* Github: [@USantaTecla](https://github.com/USantaTecla)


Note that you should have to [install JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [Maven](https://maven.apache.org/install.html) as prerequisite.