class Wolf(currentTree: Tree) : Predator(currentTree) {
    override fun createChild(): Animal {
        return Wolf(currentTree)
    }

    override fun getTreePart(): Tree.Part {
        return currentTree.Roots
    }

    override fun isNutritious(currentTree: Tree): Boolean {
        return true
    }
}