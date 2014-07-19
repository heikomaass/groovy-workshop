package workshop.model

/**
 * Created by hmaass on 19.07.14.
 */
class Car {
    def position = [0, 0]

    def start() {
        println "start"
    }

    def stop() {
        println "stop"
    }

    def move(Integer x, Integer y) {
        println "move $x $y"
        position[0] += x
        position[1] += y
    }

    def positionAsString() {
        // ------------ START EDITING HERE ----------------------
        "${position[0]},${position[1]}"
        // ------------ STOP EDITING HERE -----------------------
    }
}
