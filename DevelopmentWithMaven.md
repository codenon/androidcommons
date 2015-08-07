# Preface #

First of all, you should to use [Maven Android Plugin](http://code.google.com/p/maven-android-plugin/).

# Use Maven repository #

Android Commons has two Maven repositories:
  * **Releases repository** http://androidcommons.googlecode.com/svn/maven-repository/
  * **Snapshots repository** http://androidcommons.googlecode.com/svn/maven-snapshot-repository/

To use Android Commons Maven repository just add it to the repositories section of your POM:
```
<project xmlns="http://maven.apache.org/POM/4.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                      http://maven.apache.org/xsd/maven-4.0.0.xsd">
  ...
  <repositories>
    ...
    <repository>
      <id>androidcommons</id>
      <name>Android Commons Repository</name>
      <url>http://androidcommons.googlecode.com/svn/maven-repository/</url>
      <releases>
        <enabled>true</enabled>
        <updatePolicy>never</updatePolicy>
      </releases>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
    </repository>
    ...
  </repositories>
  ...
</project>
```