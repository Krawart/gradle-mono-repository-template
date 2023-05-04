# Base multi-module template project

This is a multi-module project template fo r Java 17 projects.

## Conventions

Conventions are used to configure the project. The following conventions are used:

* **com.krawart.base-conventions** - Base conventions for all projects
    * Common repositories
* **com.krawart.java-common-conventions** - Conventions for Java projects
    * **JaCoCo** - Code coverage configuration
    * **Checkstyle** - Code style configuration
    * **JUnit** 5 - Test configuration
* **com.krawart.java-formatter** - Formatter configuration for Java projects
    * **Spotless** using Prettier plugin

## IntelliJ IDEA

### Importing project

Find `build.gradle.kts` file in root of project and click `Open as Project`

### Formatter configuration

To use Prettier formatter in IntelliJ IDEA

> __INFO__: Point 2-4 are optional. Gradle spotless apply pulls prettier by himself so after first spotlessApply run,
> you can locate prettier, inside build folder of particular module using spotless

1. Install node.js and npm [link](https://nodejs.org/en/download/ "Node.js download page")
2. Install prettier plugin for IntelliJ IDEA
3. Run `bootstrap.sh` script in root of project
4. Go to `Settings -> Languages & Frameworks -> Prettier` and configure:
   ![prettier-configuration.png](docs%2FIntelliJ_IDEA%2Fprettier-configuration.png)
5. If rules prettier will not be picked up by IntelliJ, go to `./config/spotless/.prettierrc.yml`, right click on it and
   select `Apply Prettier Code Style Rules`

This way you can use Prettier formatter in IntelliJ IDEA also for java files.

> __NOTE__: You can perform gradle task `spotlesApply` to apply Prettier formatter to all files in project.
