package workshop.model

/**
 * Created by hmaass on 19.07.14.
 */
class Spice {
    def scoville = 0

    // Add a `plus` implementation which sums up the scoville values
    // ------------ START EDITING HERE ----------------------
    def plus(Spice s1) {
        new Spice(scoville: s1.scoville + this.scoville)
    }
    // ------------ STOP EDITING HERE -----------------------
}
