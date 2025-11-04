package org.carpenoctemcloud.category;

/**
 * An entity describing the useful parts of the category table in the database.
 *
 * @param id   The id of the category.
 * @param name The name describing the category.
 */
public record Category(int id, String name) {
}
