#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.wso2.carbon.identity.application.authentication.framework.AbstractApplicationAuthenticator;
import org.wso2.carbon.identity.application.authentication.framework.context.AuthenticationContext;
import org.wso2.carbon.identity.application.authentication.framework.exception.AuthenticationFailedException;
import org.wso2.carbon.identity.application.authentication.framework.FederatedApplicationAuthenticator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Authenticator of ${connector_name}.
 */
public class ${connector_name}Authenticator extends AbstractApplicationAuthenticator
        implements FederatedApplicationAuthenticator {

    private static Log log = LogFactory.getLog(${connector_name}Authenticator.class);

    /**
     * This method is used to process the authentication response
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param context AuthenticationContext
     * @throws AuthenticationFailedException
     */
    @Override
    protected void processAuthenticationResponse(HttpServletRequest request , HttpServletResponse response,
                                                AuthenticationContext context)
        throws AuthenticationFailedException {

        // Does the actual authentication

        //TODO: Implement the required logic

    }

    /**
     * This method is used to handle the authentication request
     *
     * @param request HttpServletRequest
     */
    public boolean canHandle(HttpServletRequest request) {

        return true;
    }

    /**
     * This method is to get the correlation ID from the request
     *
     * @param request HttpServletRequest
     */
    public String getContextIdentifier(HttpServletRequest request) {

        return request.getParameter("sessionDataKey");
    }

    /**
     * Get the friendly name of the Authenticator
     */
    public String getFriendlyName() {

        return ${connector_name}AuthenticatorConstants.AUTHENTICATOR_FRIENDLY_NAME;
    }

    /**
     * Get the name of the Authenticator
     */
    public String getName() {

        return ${connector_name}AuthenticatorConstants.AUTHENTICATOR_NAME;
    }
}
