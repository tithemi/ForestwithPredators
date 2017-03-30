object forest {
    val trees: MutableList<Tree>
    val animals: MutableList<Animal> = mutableListOf()

    init {
        trees = mutableListOf()
    }

    override fun toString(): String {
        return trees.toString()
    }

    fun newTree() {
        val key = rnd.nextInt(6)
        trees.add(Tree(
                when (key) {
                    0 -> TreeType.FIR
                    1 -> TreeType.BIRCH
                    2 -> TreeType.MAPLE
                    3 -> TreeType.OAK
                    4 -> TreeType.PINE
                    else -> TreeType.WALNUT
                })
        )

    }

    fun newMammal() {
        val tree = trees.randomItem()

        animals.add(when (rnd.nextInt(5)){
            0 -> Badger(tree)
            1 -> Chipmunk(tree)
            2 -> FlyingSqurrel(tree)
            3 -> Squirrel(tree)
            else -> Woodpecker(tree)
        })
    }

    fun newPredator() {
        val tree = trees.randomItem()

        animals.add(when (rnd.nextInt(2)){
            0 -> Wolf(tree)
            else -> Kite(tree)
        })
    }

    fun update() {
        for (tree in trees)
            tree.update()

        var toDelete = mutableListOf<Animal>()
        for (animal in animals)
            animal.update()

        animals.filterTo(toDelete) { it.isDead() }
        animals.removeAll(toDelete)

        for ((_, value) in animals.groupBy(Animal::currentTree)) {
            for (i in 0 until value.size)
                if (value[i].sex == Sex.FEMALE)
                    for (j in i + 1 until value.size)
                        if (value[j].sex == Sex.MALE && value[i].isMating(value[j]))
                            animals.add(value[i].createChild())
        }
    }


}
