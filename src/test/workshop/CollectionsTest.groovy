package test.workshop

/**
 * Created by hmaass on 29.06.14.
 */
class CollectionsTest extends GroovyTestCase {

    void test_01_sumUpWithEach() {

        def steps = [2023, 12922, 3135, 7415, 8544]
        def stepsSum = 0

        // Use the `each` function to sum up the steps
        // ------------ START EDITING HERE ----------------------
        steps.each { stepsSum += it }
        // ------------ STOP EDITING HERE  ----------------------
        assert stepsSum == 34039
    }

    void test_02_sumUpWithSum() {
        def steps = [2023, 12922, 3135, 7415, 8544]

        def stepsSum
        // Now use `sum` function to sum up the steps
        // ------------ START EDITING HERE ----------------------
        stepsSum = steps.sum()
        // ------------ STOP EDITING HERE  ----------------------

        assert stepsSum == 34039
    }

    void test_03_findStepsAboveGoal() {
        def steps = [2023, 12922, 3135, 17416, 8544]
        def goal = 10000

        def stepsAboveGoal

        // Now use `findAll` function to create a list of steps which
        // are above the goal of 10000

        // ------------ START EDITING HERE ----------------------
        stepsAboveGoal = steps.findAll {
            it > goal
        }
        // ------------ STOP EDITING HERE  ----------------------
        assert stepsAboveGoal.size() == 2
    }

    void test_04_calculateBurnedCaloriesUsingCollect() {
        def steps = [2023, 12922, 3135, 17416, 8544]
        def burnedCalories = 0
        def caloriesPerStep = 0.05

        // Use the `collect` method to transform the steps into calories
        // ------------ START EDITING HERE ----------------------
        burnedCalories = steps.collect { it * caloriesPerStep }.sum()
        // ------------ STOP EDITING HERE  ----------------------

        assert burnedCalories == 2202
    }
    
    void test_05_accessingMaps() {
        def map = [ 
            cast: [
                [ name: 'Fred Flintstone', voice_actor: 'Alan Reed' ],
                [ name: 'Barney Rubble', voice_actor: 'Mel Blanc' ]
            ]
        ]
        def first_actor = ''
        def second_actor = ''
        
        // ------------ START EDITING HERE ----------------------
        first_actor = map.cast[0].voice_actor
        second_actor = map.cast[1].voice_actor
        // ------------ STOP EDITING HERE  ----------------------
        
        assert first_actor == 'Alan Reed'
        assert second_actor == 'Mel Blanc'
    }
    
}
