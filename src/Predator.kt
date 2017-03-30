abstract class Predator(currentTree: Tree) : Animal(currentTree) {
    override fun eat() {
        hunger -= World.STARVATION

        if (!isDead()) {
            val animalsToEat = currentTree.getAnimalsOnTree()
            if (!animalsToEat.isEmpty()) {
                val animalToEat : Animal = animalsToEat.randomItem()
                animalToEat.hunger = -1
                hunger += World.ANIMAL_NUTRITIONAL
            }
        }
    }
}