#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.framework.ServiceRegistration;
import org.wso2.carbon.identity.application.authentication.framework.ApplicationAuthenticator;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import ${package}.${connector_name}Authenticator;

import java.util.Hashtable;

@Component(name = "${package}.${connector_name}AuthenticatorServiceComponent", immediate = true)

public class ${connector_name}AuthenticatorServiceComponent{

private static Log log=LogFactory.getLog(${connector_name}AuthenticatorServiceComponent.class);
private ServiceRegistration serviceRegistration = null;


@Activate
protected void activate(ComponentContext context){

    //register the custom local authenticator as an OSGI service.
    serviceRegistration=context.getBundleContext().registerService(ApplicationAuthenticator.class.getName(),
    new ${connector_name}Authenticator(),null);
    log.info("${connector_name}AuthenticatorServiceComponent bundle activated successfully.");
}

protected void deactivate(ComponentContext context){

    if(log.isDebugEnabled()){
        log.debug("${connector_name}AuthenticatorServiceComponent is deactivated.");
    }

// Unregistering the custom local authenticator service.
    if(serviceRegistration!=null){
        serviceRegistration.unregister();
    }
    }
}
