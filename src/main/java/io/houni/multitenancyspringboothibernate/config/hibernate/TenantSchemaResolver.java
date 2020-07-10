package io.houni.multitenancyspringboothibernate.config.hibernate;

import io.houni.multitenancyspringboothibernate.context.TenantContext;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

/**
 * {@link CurrentTenantIdentifierResolver} :
 * It tells hibernate which is the current configured tenant. It uses the previous ThreadLocal variable set by the interceptor.
 *
 * @author Hamza Ouni
 */
public class TenantSchemaResolver  implements CurrentTenantIdentifierResolver {

    private String defaultTenant ="public";

    @Override
    public String resolveCurrentTenantIdentifier() {
        String t =  TenantContext.getCurrentTenant();
        if(t!=null){
            return t;
        } else {
            return defaultTenant;
        }
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
