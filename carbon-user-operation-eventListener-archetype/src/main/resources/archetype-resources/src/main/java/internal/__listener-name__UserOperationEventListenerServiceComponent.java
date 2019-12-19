#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.wso2.carbon.user.core.listener.UserOperationEventListener;
import org.wso2.carbon.user.core.service.RealmService;
import ${groupId}.${listener-name}UserOperationEventListener;

@Component(name = "${package}.${listener-name}UserOperationEventListenerServiceComponent",
        immediate = true)
public class ${listener-name}UserOperationEventListenerServiceComponent {

    private static Log log = LogFactory.getLog(${listener-name}UserOperationEventListenerServiceComponent.class);
    private ServiceRegistration serviceRegistration = null;

    @Activate
    protected void activate(ComponentContext context) {

        //register the custom listener as an OSGI service.
        serviceRegistration = context.getBundleContext().registerService(UserOperationEventListener.class.getName(),
                new ${listener-name}UserOperationEventListener(),null);
        log.info("${listener-name}UserOperationEventListenerServiceComponent bundle activated successfully.");
    }

    protected void deactivate(ComponentContext context) {

        if (log.isDebugEnabled()) {
            log.debug("${listener-name}UserOperationEventListenerServiceComponent is deactivated.");
        }

        // Unregistering the custom listener service.
        if (serviceRegistration != null) {
            serviceRegistration.unregister();
        }
    }

    @Reference(name = "user.realm.service.default",
            service = RealmService.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unsetRealmService")
    protected void setRealmService(RealmService realmService) {

        ${listener-name}UserOperationEventListenerDataHolder.getInstance().setRealmService(realmService);
    }

    protected void unsetRealmService(RealmService realmService) {

        ${listener-name}UserOperationEventListenerDataHolder.getInstance().setRealmService(null);
    }

}
