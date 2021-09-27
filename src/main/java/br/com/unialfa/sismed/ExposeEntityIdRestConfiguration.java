package br.com.unialfa.sismed;

import br.com.unialfa.sismed.convenio.domain.Convenio;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * Solução para o retornar o id da entidade pelo JSON.
 */
@Component
public class ExposeEntityIdRestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Convenio.class);
    }
}
