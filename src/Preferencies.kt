class World {
    companion object {
        val MAX_HUNGER = 100
        val STARVATION = 5

        val MAX_TREE_FOOD = 50
        val FOOD_REGEN = 3

        val MATING_HUNGER = MAX_HUNGER * 3 / 4
        val MATING_COST = MAX_HUNGER * 1 / 2

        val PREDATOR_MAX_HUNGER = 600
        val PREDATOR_STARVATION = 10

        val PREDATOR_MATING_HUNGER = PREDATOR_MAX_HUNGER * 3 / 4
        val PREDATOR_MATING_COST = PREDATOR_MAX_HUNGER * 1 / 2
    }
}