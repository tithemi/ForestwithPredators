
class Badger(currentTree: Tree) : Mammal(currentTree) {

    val habitat = listOf(TreeType.MAPLE, TreeType.OAK, TreeType.BIRCH)

    override fun createChild() : Animal {
        return Badger(currentTree)
    }

    override fun getTreePart(): Tree.Part {
        return currentTree.Roots
    }

    override fun isNutritious(currentTree: Tree): Boolean {
        return currentTree.type in habitat
    }
}