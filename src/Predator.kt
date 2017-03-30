abstract class Predator(currentTree: Tree) : Animal(currentTree) {
    override fun getMatingHunger(): Int {
        return World.PREDATOR_MATING_HUNGER
    }

    override fun getMatingCost(): Int {
        return World.PREDATOR_MATING_COST
    }

    init {
        hunger = World.PREDATOR_MAX_HUNGER
    }

    override fun eat() {
        hunger -= World.PREDATOR_STARVATION

        if (!isDead() && hunger < World.PREDATOR_MAX_HUNGER) {
            val animalsToEat = currentTree.getAnimalsOnTree()
                    .filter { animal -> animal is Mammal  && animal.getTreePart() == this.getTreePart()}
            if (!animalsToEat.isEmpty()) {
                val animalToEat : Animal = animalsToEat.randomItem()
                hunger += animalToEat.hunger
                animalToEat.hunger = -1
            }
        }
    }
}