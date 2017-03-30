class Kite(currentTree: Tree) : Predator(currentTree) {
    override fun createChild(): Animal {
        return Kite(currentTree)
    }

    override fun getTreePart(): Tree.Part {
        return currentTree.Crown
    }

    override fun isNutritious(currentTree: Tree): Boolean {
        return true
    }

}