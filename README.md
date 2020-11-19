# Archectypes-is

This is to maintain the archetypes related to Identity Server

## Corresponding IS version  and available archetypes
- IS 5.9.0 - [IS 5.9 archetypes](https://github.com/wso2-extensions/archetype-is/tree/is-5.9.0)

 
## How to contribute

1.Run the following command  in the base project to create the basic archetype
```
mvn archetype:create-from-project
```
2.Create the proper file structure in the archetype/src
```
└── src
    └── main
        └── resources
            ├── META-INF
            │   └── maven
            └── archetype-resources
                └── src
                    └── main
                        └── java
                            └── internal
```

3.Please add method comments & have sample codes for the methods.
(**Note**: Check the imports and place the ${package} accordingly )

4.Edit archetype-metadata.xml `in src/main/resources/META-INF/maven`. Only add the relevant directories.
```
<fileSets>
    <fileSet filtered="true" packaged="true" encoding="UTF-8">
        <directory>src/main/java</directory>
        <includes>
            <include>**/*.java</include>
        </includes>
    </fileSet>
</fileSets>
```
5.Define a property in archetype-metadata.xml, So that the component name can be taken as input and appended as a prefix.

```
<requiredProperties>
    <requiredProperty key="authenticator-name">
    </requiredProperty>
</requiredProperties>
```
6.Rename the java file names & rename the component name in the files.
```
File name: 'authenticator.java' --> '__authenticator-name__authenticator.java'
Class name: 'public class Authenticator' --> 'public class ${authenticator-name}Authenticator'
```
(**Note**: Rename all other code references with `${authenticator-name}` & and file change by prefixing `__authenticator-name__`)

7.Edit the archetype/pom.xml
a. Have the versioning like:
```
major -- product release
minor -- addition of a new archetype
patch -- improve
4th digit -- track archetype life
```
Eg:If you have written it for IS 5.10.0 then the version will be like.
               `<version>5.10.0.1-SNAPSHOT</version>`
               
b. Have proper groupID,Name & artifactId
Eg:
    
```
<groupId>org.wso2.carbon.identity.archetype</groupId>
<artifactId>org.wso2.carbon.identity.extension.local-authenticator-archetype</artifactId>
<version>5.9.0.1-SNAPSHOT</version>
<packaging>maven-archetype</packaging>
<name>WSO2 Identity Server - Local Authenticator Archetype</name>
```

8.Build the project in archetype root by command
 ```
 mvn clean install
 ``` 
                   
9.[Test the archetype locally](#testing-the-archetype-locally)

10.[Send the PR](#send-pr-to-wso2)

### Testing the archetype locally

There are two ways to check your local repository.

1.Running the following command
```
mvn archetype:generate -DarchetypeCalalog=local
```

2.Navigate your ~/.m2/repository/ and check the archetype-catalog.xml file. If the new archetype is added it will show the groupId, artifactId, and version of it. Below is an example of a newly added archetype

```
<archetype>
  <groupId>new.archtype.group</groupId>
  <artifactId>new.artifact</artifactId>
  <version>1.0.0</version>
  <description>new.artifact</description>
</archetype>
</archetypes>
```

Now you can provide these details to create a new project like this

```
mvn archetype:generate
  -DarchetypeGroupId=new.archtype.group
  -DarchetypeArtifactId=new.artifact
  -DarchetypeVersion=1.0.0
  -DgroupId=<sampleID>
  -DartifactId=<sampeArtifactId>
  -Dversion=<sampleVersion>
```

### Send PR to wso2
1. Fork repo https://github.com/wso2-extensions/archetype-is/tree/master 
1. Select the branch suitable for the wso2is version
1. Create Readme for your archetype
1. Add component for archetype and point that in the branch readme file.
1. Send the PR.

