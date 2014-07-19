package workshop.model

/**
 * User: hmaass
 * Date: 17.07.14
 * Time: 17:44
 */
class Customer {
    Integer uid
    String email
    String name
    Cart cart

    // returns `true` when the cart was created today.
    def createdCartToday() {
        // Reuse the `sameDay` method.
        // ------------ START EDITING HERE ----------------------
        Date now = new Date()

        if (this.cart?.created_at) {
            return sameDay(now, this.cart.created_at)
        }
        // ------------ STOP EDITING HERE -----------------------
        false

    }

    def sameDay(Date date1, Date date2) {
        (date1..date2).size() == 1
    }
}
