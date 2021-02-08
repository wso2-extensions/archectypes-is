# Template for WSO2 Identity Server Provisioning Authenticator

## STEPS

1.Navigate to "archetypes/is-provisioning-connector-archetype" and run the following command
```       
mvn clean install
```

2.Edit and run the following command to create the IS Provisioning Connector inside a directory.
```
mvn archetype:generate
    -DarchetypeGroupId=org.wso2.carbon.identity.archetype
    -DarchetypeArtifactId=org.wso2.carbon.identity.extension.is-provisioning-connector-archetype
    -DarchetypeVersion=5.9.0.x <version of the archetype>
    -DgroupId=<Your group ID>
    -DartifactId=<Your ArtifactId>
    -Dversion=<Your Version>
```

Eg:
```
mvn archetype:generate -DarchetypeGroupId=org.wso2.carbon.identity.archetype -DarchetypeArtifactId=org.wso2.carbon.identity.extension.is-provisioning-connector-archetype -DarchetypeVersion=5.9.0.1-SNAPSHOT -DgroupId=org.carbon.provisioning -DartifactId=org.carbon.provisioning.authenticator -Dversion=1.0.0
```
3.Enter the authenticator name after executing steps 1 & 2. This will be append as a prefix to all the classes.
     eg:- connector_name : : duo

4.Confirm the connector name
     Y : : Y

5.After making the changes, build your project using `mvn clean install` and
 put the generated jar into `<is server>/repository/components/dropins`