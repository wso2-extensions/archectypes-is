#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.framework.ServiceRegistration;
import org.wso2.carbon.identity.provisioning.AbstractProvisioningConnectorFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import ${package}.${connector_name}ProvisioningConnectorFactory;

import java.util.Hashtable;

@Component(name = "${package}.${connector_name}ConnectorServiceComponent", immediate = true)

public class ${connector_name}ConnectorServiceComponent {

    private static Log log = LogFactory.getLog(${connector_name}ConnectorServiceComponent.class);
    private ServiceRegistration serviceRegistration = null;

    @Activate
    protected void activate(ComponentContext context) {

        if (log.isDebugEnabled()) {
            log.debug("Activating ${connector_name}ConnectorServiceComponent");
        }
        //register the custom provisioning connector as an OSGI service.
        serviceRegistration = context.getBundleContext().registerService(
                AbstractProvisioningConnectorFactory.class.getName(),new ${connector_name}ProvisioningConnectorFactory(),
        null);
        log.info("${connector_name} Identity Provisioning Connector bundle is activated.");
    }

    protected void deactivate(ComponentContext context) {

        if(log.isDebugEnabled()) {
            log.debug("${connector_name} Identity Provisioning Connector bundle is deactivated.");
        }

        // Unregistering the custom provisioning connector service.
        if(serviceRegistration != null) {
            serviceRegistration.unregister();
        }
    }
}
