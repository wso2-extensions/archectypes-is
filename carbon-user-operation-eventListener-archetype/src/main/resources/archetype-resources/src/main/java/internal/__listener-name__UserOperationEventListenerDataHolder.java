#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.internal;

import org.wso2.carbon.user.core.service.RealmService;

public class ${listener-name}UserOperationEventListenerDataHolder {

    private static ${listener-name}UserOperationEventListenerDataHolder instance =
            new ${listener-name}UserOperationEventListenerDataHolder();

    private RealmService realmService;

    public static ${listener-name}UserOperationEventListenerDataHolder getInstance() {

        return instance;
    }

    public RealmService getRealmService() {

        return realmService;
    }

    public void setRealmService(RealmService realmService) {

        this.realmService = realmService;
    }

}
