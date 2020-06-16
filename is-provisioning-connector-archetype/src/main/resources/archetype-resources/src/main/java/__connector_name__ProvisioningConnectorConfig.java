#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.provisioning.IdentityProvisioningException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Outbound Provisioning Connector Config for ${connector_name}.
 */
public class ${connector_name}ProvisioningConnectorConfig {

    private static final Log log = LogFactory.getLog(${connector_name}ProvisioningConnectorConfig.class);
    private Properties configs;

    /**
     * Return provisioning connector config properties
     * @param configs
     */
    public ${connector_name}ProvisioningConnectorConfig(Properties configs) {

        this.configs = configs;
    }

    /**
     * Return lis of required attributes names
     */
    public List<String> getRequiredAttributeNames() {

        List<String> requiredAttributeList = new ArrayList<String>();
        //Add your code to get the required attributes names
        return requiredAttributeList;
    }

    /**
     * Return userID claim
     */
    public String getUserIdClaim() throws IdentityProvisioningException {

        //Add the your code to get the userID claim
        return null;
    }
    /**
     * Return value for config property key
     */
    public String getValue(String key) {

        return this.configs.getProperty(key);
    }
}
