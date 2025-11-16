package org.carpenoctemcloud.account;

/**
 * Entity representing the account table.
 *
 * @param id             The id of the account.
 * @param name           The name of the user.
 * @param email          The email of the user.
 * @param emailConfirmed If the email is confirmed.
 * @param isAdmin        True if the account is an admin, and can log into the admin dashboard.
 * @param password       The hashed password of the account.
 * @param salt           THe salt used to create the password hash.
 */
public record Account(int id, String name, String email, boolean emailConfirmed, boolean isAdmin,
                      String password, String salt) {
}
