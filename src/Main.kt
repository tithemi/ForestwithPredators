import java.security.SecureRandom

fun main(args: Array<String>) {

    val TREES_COUNT = 1000
    val INITIAL_MAMMALS = 500
    val INITIAL_PREDATORS = 100

    for (i in 1..TREES_COUNT)
        forest.newTree()

    val rnd = SecureRandom()

    for (i in 0 until TREES_COUNT)
        for (j in 1..2)
            Tree.setAsNeighbours(forest.trees[i], forest.trees[rnd.nextInt(TREES_COUNT)])

    for (i in 1..INITIAL_MAMMALS)
        forest.newMammal()
    for (i in 1..INITIAL_PREDATORS)
        forest.newPredator()

    print(forest)

    while (!forest.animals.isEmpty()) {
        forest.update()

        for ((key, value) in forest.animals.groupBy { animal->animal.javaClass })
            println("$key: ${value.size}")
        println("Total: ${forest.animals.size}")
    }
}