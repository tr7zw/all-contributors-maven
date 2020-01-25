# all-contributors-maven
(Unofficial) AllContributors implementation for Maven

[![Build Status](https://ci.codemc.org/buildStatus/icon?job=tr7zw%2Fall-contributors-maven)](https://ci.codemc.org/job/Tr7zw/job/all-contributors-maven/)
[![All Contributors](https://img.shields.io/badge/all_contributors-2-orange.svg?style=flat-square)](#contributors-%e2%9c%a8)

Uses the [.all-contributorsrc](.all-contributorsrc) file to generate the [``Contributors``](#contributors-%e2%9c%a8) block in the [README.md](README.md) during a Maven build/via Maven call.


# Maven

```
    <!-- CodeMC -->
    <repository>
      <id>codemc-repo</id>
      <url>https://repo.codemc.org/repository/maven-public/</url>
      <layout>default</layout>
    </repository>


    <!-- Run during build -->
      <plugin>
        <groupId>de.tr7zw</groupId>
        <artifactId>allcontributors</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <executions>
          <execution>
            <id>update-contributors</id>
            <goals>
              <goal>allcontributors</goal>
            </goals>
          </execution>
        </executions>
      </plugin>

    <!-- Callable via 'mvn allcontributors:allcontributors' -->
      <plugin>
        <groupId>de.tr7zw</groupId>
        <artifactId>allcontributors</artifactId>
        <version>0.0.1-SNAPSHOT</version>
      </plugin>

```

# Contributors ✨

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center"><a href="https://allcontributors.org/"><img src="https://avatars1.githubusercontent.com/u/46410174?s=200&v=4" width="100px;" alt=""/><br /><sub><b>all-contributors</b></sub></a><br /><a href="https://github.com/tr7zw/all-contributors-maven/commits?author=all-contributors" title="Documentation">📖</a> <a href="#ideas-all-contributors" title="Ideas, Planning, & Feedback">🤔</a></td>
    <td align="center"><a href="https://github.com/sgdc3"><img src="https://avatars3.githubusercontent.com/u/8779252?s=460&v=4" width="100px;" alt=""/><br /><sub><b>Gabriele C.</b></sub></a><br /><a href="#infra-sgdc3" title="Infrastructure (Hosting, Build-Tools, etc)">🚇</a></td>
  </tr>
</table>
<!-- markdownlint-enable -->
<!-- prettier-ignore-end -->
<!-- ALL-CONTRIBUTORS-LIST:END -->


