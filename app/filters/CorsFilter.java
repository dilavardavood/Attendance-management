package filters;

import play.filters.cors.CORSFilter;
import play.mvc.EssentialFilter;
import javax.inject.Inject;

public class CorsFilter extends CORSFilter {

    @Inject
    public CorsFilter() {
        super();
    }
}
