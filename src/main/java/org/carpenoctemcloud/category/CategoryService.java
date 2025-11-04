package org.carpenoctemcloud.category;

import java.util.List;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Provides database methods to access the category table of the database.
 */
@Service
public class CategoryService {
    private final NamedParameterJdbcTemplate template;


    /**
     * Creates a new CategoryService with all needed objects.
     *
     * @param template A JdbcTemplate so that the service can make requests to the database.
     */
    public CategoryService(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    /**
     * Retrieves all categories which are available.
     *
     * @return The list of categories in the database.
     */
    public List<Category> getAllCategories() {
        return template.query("select * from category;", new CategoryMapper());
    }
}
