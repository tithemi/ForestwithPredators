abstract class Mammal(currentTree: Tree) : Animal(currentTree) {
    override fun eat() {
        hunger -= World.STARVATION

        if (!isDead() && isNutritious(currentTree)) {
            val foodToTake = Math.min(World.MAX_HUNGER - hunger, getTreePart().food)

            getTreePart().food -= foodToTake
            hunger += foodToTake
        }
    }

}