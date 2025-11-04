package org.carpenoctemcloud.category;

import java.util.List;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    final NamedParameterJdbcTemplate template;

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
