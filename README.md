# RPN


En notation Polonaise inversée (Reverse Polish Notation) les opérateurs (`+`, `-`, `*`, ...)
suivent les opérandes. Par exemple pour ajouter 3 et 4, au lieu d'écrire `3 + 4`, on écrira
`3 4 +`.

S'il y a plusieurs opérateurs, les opérateurs sont écrits immédiatement après le second opérande.
L'expression `3 - 4 + 5` (qui pourrait s'écrire `(3 - 4) + 5`, s'écrira:
`3 4 - 5 +`
La première expression sera évaluée `3 4 -` en `-1`, on peut alors imaginer que l'expression initiale
devienne alors `-1 5 +` évaluée en `4`

```
20 5 /          —>       (20/5) = 4
5 2 3 + -       ->      5-(2+3) = 0
4 2 + 3 -       —>      (4+2)-3 = 3
3 5 8 * 7 + *   —>  3*((5*8)+7) = 141
7 2 - 3 4       —>  5 3 4
```
# Projet


Objectifs:

1. Le code doit compiler
2. Les tests doivent passer
3. Les tests devraient être enrichis
4. Supporter les opérateurs suivants:
    * `+`
    * `-`
    * `*`
    * `/` (optionnel)
5. Supporter les nombres négatifs
6. Supporter les nombres à virgules flottantes (optionnel)

## Lancer les tests:

```
$ mvn clean test
```

## Executer le programme (via maven)

```
$ mvn compile exec:java -Dexec.mainClass="rpn.CLI" -Dexec.args="4 3 +"
```

## Executer avec le jar

Générer le jar

```
$ mvn clean package
```

Si les tests ne passent pas :tear:

```
$ mvn clean package -DskipTests
```

Lancer le programme directement (une fois le jar générer):

```
$ java -cp target/esgi-rpn-1.0-SNAPSHOT.jar rpn.CLI "4 3 +"
```