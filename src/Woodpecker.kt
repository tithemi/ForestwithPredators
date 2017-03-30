class Woodpecker(currentTree: Tree) : Mammal(currentTree) {

    override fun createChild() : Animal {
        return Badger(currentTree)
    }

    override fun getTreePart(): Tree.Part {
        return currentTree.Trunk
    }

    override fun isNutritious(currentTree: Tree): Boolean {
        return true
    }
}