## Product: Template for WSO2 Identity Server User operation Event listener

STEPS:

 * Navigate to `archetypes/carbon-user-operation-eventListener` and run the following command
         `mvn clean install`

 * Edit and run the following command to create the User operation Event listener
   
   `mvn archetype:generate
         -DarchetypeGroupId=org.wso2.carbon.extension.identity
         -DarchetypeArtifactId=user-operation-eventListner-archetype
         -DarchetypeVersion=5.9.0.x <version of the archetype>
         -DgroupId=<Your group ID>
         -DartifactId=<Your ArtifactId>
         -Dversion=<Your Version> `
         
         eg:
            mvn archetype:generate
              -DarchetypeGroupId=org.wso2.carbon.extension.identity
              -DarchetypeArtifactId=user-operation-eventListner-archetype
              -DarchetypeVersion=5.9.0.1
              -DgroupId=org.sampleID
              -DartifactId=org.sampleID.sampeArtifactId
              -Dversion=1.0.0-SNAPSHOT
       

 * Enter the user operation event listener name after executing steps 1 & 2. This will be append as a prefix to all the classes. 
    `eg:- listener-name : : Sample`

 * Confirm the properties values
     `Y : : Y`
     
 * After making the changes, build your project using `mvn clean install` and 
 put the generated jar into `<is server>/repository/components/dropins`  
