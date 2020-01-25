# All Contributors-Maven

(Unofficial) AllContributors implementation for Maven

[![Build Status](https://ci.codemc.org/buildStatus/icon?job=tr7zw%2Fall-contributors-maven)](https://ci.codemc.org/job/Tr7zw/job/all-contributors-maven/)
[![All Contributors](https://img.shields.io/badge/all_contributors-3-orange.svg?style=flat-square)](#contributors-%e2%9c%a8)

Uses the [.all-contributorsrc](.all-contributorsrc) file to generate the [``Contributors``](#contributors-%e2%9c%a8) block in the [README.md](README.md) during a Maven build/via Maven call.

## Maven

```xml
    <!-- CodeMC -->
    <pluginRepository>
      <id>codemc-repo</id>
      <url>https://repo.codemc.org/repository/maven-public/</url>
      <layout>default</layout>
    </pluginRepository>


    <!-- Run during build -->
      <plugin>
        <groupId>de.tr7zw</groupId>
        <artifactId>allcontributors</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <executions>
          <execution>
            <id>update-contributors</id>
            <goals>
              <goal>update</goal>
            </goals>
          </execution>
        </executions>
      </plugin>

    <!-- Callable via 'mvn allcontributors:update' -->
      <plugin>
        <groupId>de.tr7zw</groupId>
        <artifactId>allcontributors</artifactId>
        <version>0.0.1-SNAPSHOT</version>
      </plugin>

```

## Config

Not all config values the normal CLI Configuration has are supported!

- ✅ ``projectName``
- ✅ ``projectOwner``
- ❌ ``repoType`` (Duplicated by repoHost?)
- ✅ ``repoHost``
- ✅ ``files`` (Can be configured via [Maven property](#maven-properties))
- ✅ ``imageSize``
- ✅ ``commit`` (When the normal ``https://img.shields.io/badge/all_contributors-`` badge part is found, it will be updated. It won't be generated)
- ❌ ``commitConvention`` (?)
- ✅ ``contributorsPerLine``
- ✅ ``badgeTemplate`` (All ``https://img.shields.io/badge/all_contributors-`` badges will be updated. Just modify the ``orange.svg?style=flat-square`` part)
- ❌ ``contributorTemplate`` (TODO?)
- ✅ ``types``
- ✅ ``contributors``
- ✅``contributors.x.login``
- ✅``contributors.x.name``
- ✅``contributors.x.avatar_url``
- ✅``contributors.x.profile``
- ✅``contributors.x.contributions``

### Added Config values

- ✅ ``contributors.x.links`` An optional mapping from ``contributors.x.contributions`` to URLs

## Maven Properties

The default values should be fine for most projects, but can be changed via

````xml
                        <configuration>
                            <readme>CUSTOM_README.md</readme>
                            [...]
                        </configuration>
````

in the ``<execution>`` xml block.

### Default Values

- ``basedir`` = ``${project.basedir}``
- ``readme`` = ``README.md``
- ``srcFile`` = ``.all-contributorsrc``

## Contributors ✨

Thanks goes to these wonderful people ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center"><a href="https://allcontributors.org/"><img src="https://avatars1.githubusercontent.com/u/46410174?s=200&v=4" width="100px;" alt=""/><br /><sub><b>all-contributors</b></sub></a><br /><a href="https://allcontributors.org/docs/en/overview" title="Documentation">📖</a> <a href="https://allcontributors.org/docs/en/cli/overview" title="Ideas, Planning, & Feedback">🤔</a></td>
    <td align="center"><a href="https://github.com/sgdc3"><img src="https://avatars3.githubusercontent.com/u/8779252?s=460&v=4" width="100px;" alt=""/><br /><sub><b>Gabriele C.</b></sub></a><br /><a href="https://codemc.io/" title="Infrastructure (Hosting, Build-Tools, etc)">🚇</a></td>
    <td align="center"><a href="https://github.com/Sprax2013"><img src="https://avatars1.githubusercontent.com/u/7331598?s=460&v=4" width="100px;" alt=""/><br /><sub><b>Sprax2013</b></sub></a><br /><a href="https://github.com/tr7zw/all-contributors-maven/blob/master/.all-contributorsrc" title="Idea for adding custom types with text">🔭 Custom Types</a></td>
  </tr>
</table>
<!-- markdownlint-enable -->
<!-- prettier-ignore-end -->
<!-- ALL-CONTRIBUTORS-LIST:END -->

This project follows the [all-contributors](https://allcontributors.org) specification.
Contributions of any kind are welcome!
