enum class TreeType {
    FIR, BIRCH, PINE, OAK, MAPLE, WALNUT
}

class Tree(val type: TreeType) {
    override fun toString(): String {
        return type.toString()
    }

    //val animalsOnTree : List<Animal> = forest.animals.filter { animal -> (animal.currentTree == this)}

    fun getAnimalsOnTree(): List<Animal> {
        val animalsOnTree = mutableListOf<Animal>()
        for (animal in forest.animals) {
            if (animal.currentTree == this)
                animalsOnTree.add(animal)
        }
        return animalsOnTree.filter { _ -> true }
    }


    val neighbours: MutableList<Tree> = mutableListOf()

    val Crown = Part()
    val Trunk = Part()
    val Roots = Part()

    companion object {
        fun setAsNeighbours(one: Tree, other: Tree) {
            if (!one.neighbours.contains(other)) {
                one.neighbours.add(other)
                other.neighbours.add(one)
            }
        }
    }

    fun update() {
        Crown.update()
        Trunk.update()
        Roots.update()
    }

    inner class Part {
        var food = World.MAX_TREE_FOOD

        fun update() {
            food = Math.min(food + World.FOOD_REGEN * when(this@Tree.type) {
                TreeType.MAPLE -> 3
                else -> 1
            }, World.MAX_TREE_FOOD)
        }
    }

}
