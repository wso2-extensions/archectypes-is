#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

public class ${connector_name}AuthenticatorConstants {

    public static final String AUTHENTICATOR_NAME = "${connector_name}Authenticator";
    public static final String AUTHENTICATOR_FRIENDLY_NAME = "${connector_name}";
    //${connector_name} authorize endpoint URL
    public static final String ${connector_name}_OAUTH_ENDPOINT = "";
    //${connector_name} token  endpoint URL
    public static final String ${connector_name}_TOKEN_ENDPOINT = "";
    //${connector_name} user info endpoint URL
    public static final String ${connector_name}_USERINFO_ENDPOINT = "";
}
