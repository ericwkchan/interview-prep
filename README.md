# interview-prep (Java, Gradle)

Lightweight repo for algorithm/data-structure interview practice.
- Java 21 (or 17) with Gradle
- JUnit 5 + AssertJ for tests
- Spotless (Google Java Format) for auto-format
- JaCoCo for coverage

## Structure
```
src/
  main/java/com/ericchan/interview/...
  test/java/com/ericchan/interview/...
docs/
  cheatsheets/
  problems/
  playbooks/
```

## Common Gradle Tasks
- `./gradlew test` — run tests
- `./gradlew spotlessApply` — auto-format
- `./gradlew jacocoTestReport` — coverage report in `build/reports/jacoco/test/html/index.html`

## First problem
- `TwoSum` under `algo/arrays` with tests.
