import java.security.SecureRandom

val rnd = SecureRandom()

fun <T> List<T>.randomItem(): T {
    return this[rnd.nextInt(this.size)]
}

enum class Sex {
    FEMALE, // Girls rule
    MALE // Our slaves
}

abstract class Animal(var currentTree: Tree) {

    var hunger: Int = World.MAX_HUNGER
    val sex : Sex

    init {
        if (rnd.nextInt(2) == 0)
            sex = Sex.FEMALE
        else
            sex = Sex.MALE
    }

    abstract fun isNutritious(currentTree: Tree): Boolean

    abstract fun getTreePart() : Tree.Part

    abstract fun createChild() : Animal

    fun isDead() : Boolean = hunger < 0


    abstract fun eat()

    fun update() {

        val possibleTargets = currentTree.neighbours.filter { tree -> isNutritious(tree) }

        if (!possibleTargets.isEmpty())
            currentTree = possibleTargets.randomItem()
        else
            currentTree = currentTree.neighbours.randomItem()

        eat()
    }

    fun isMating(other : Animal) : Boolean {
        if (other.javaClass == this.javaClass && this.hunger > World.MATING_HUNGER && other.hunger > World.MATING_HUNGER) {
            this.hunger -= World.MATING_COST
            other.hunger -= World.MATING_COST
            return true
        }

        return false
    }
}
