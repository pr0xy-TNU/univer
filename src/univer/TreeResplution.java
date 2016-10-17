package univer;

import com.javarush.test.level15.lesson12.home03.Tree;

/**
 * Created by Yarik on 11.10.2016.
 */
class TreeResolution {
    public static int treeeStage = 0;

    static class Tree {
        public Tree leftBranch;
        public Tree rightBranch;
        int IGain = 0;
        int stage = 0;
        String nodeName;

        public Tree() {
            this.stage = treeeStage++;
            this.nodeName += stage;
        }

        public void addLeftBranch(Tree branch) {
            this.leftBranch = branch;
        }

        public void addRightBranch(Tree branch) {
            this.leftBranch = branch;
        }

        public boolean isLeftEmpty() {
            if (this.leftBranch == null)
                return true;
            else
                return false;
        }

        public boolean isRightBranchEmpty() {
            if (this.rightBranch == null)
                return true;
            else
                return false;
        }

        public void info() {

        }
    }

    public static void main(String[] args) {
        Tree newTree = new Tree();


    }
}
