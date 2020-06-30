#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.common.model.Property;
import org.wso2.carbon.identity.provisioning.AbstractOutboundProvisioningConnector;
import org.wso2.carbon.identity.provisioning.AbstractProvisioningConnectorFactory;
import org.wso2.carbon.identity.provisioning.IdentityProvisioningException;

import java.util.ArrayList;
import java.util.List;

/**
 * Outbound Provisioning Connector Config Factory for ${connector_name}.
 */
public class ${connector_name}ProvisioningConnectorFactory extends AbstractProvisioningConnectorFactory {

    private static final Log log = LogFactory.getLog(${connector_name}ProvisioningConnectorFactory.class);

    /**
     * @param provisioningProperties
     * @throws IdentityProvisioningException
     */
    @Override
    protected AbstractOutboundProvisioningConnector buildConnector(
            Property[] provisioningProperties) throws IdentityProvisioningException {

        ${connector_name}ProvisioningConnector connector = new ${connector_name}ProvisioningConnector();
        connector.init(provisioningProperties);
        if (log.isDebugEnabled()) {
            log.debug("${connector_name} provisioning connector created successfully.");
        }
        return connector;
    }

    /**
     * Return the connector type
     */
    @Override
    public String getConnectorType() {

        return ${connector_name}ConnectorConstants.CONNECTOR_TYPE;
    }

    /**
     * Populate the provisioning properties in the UI
     */
    @Override
    public List<Property> getConfigurationProperties() {

        List<Property> configProperties = new ArrayList<Property>();
        // Add your code for the UI
        return configProperties;
    }
}
