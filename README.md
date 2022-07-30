# Lojinha Web Automação
Este é um repositório que contém a automação de alguns testes web de um software denominado Lojinha. Os subtópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologias Utilizadas

- Java JDK
  https://download.oracle.com/java/18/latest/jdk-18_windows-x64_bin.msi
- Maven
  https://maven.apache.org/
- JUnit Maven
  https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.9.0-M1
- Selenium Java Maven
  https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
- Chrome Driver
- https://chromedriver.chromium.org/downloads
- IntelliJ IDEA
  https://www.jetbrains.com/pt-br/idea/download/

## Testes Automatizados
Testes para validar as partições de equivalência relacionadas ao valor do  produto na Lojinha Web que estão diretamente vinculados a Regra de Negócio do software.
*RN1*:  O valor do produto deve estar entre R$0,01 e R$7.000,00.