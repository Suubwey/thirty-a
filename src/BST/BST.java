package BST;

public class BST {
    public BST(int i)
    {
        rootNode = new BstNode(i);
    }

    public void addNode(int i)
    {
        BstNode currentNode = rootNode;
        boolean finished = false;
        do
        {
            BstNode curLeftNode = currentNode.leftNode;
            BstNode curRightNode = currentNode.rightNode;
            int curIntData = currentNode.intData;

            if(i > curIntData)
            {
                if(curRightNode == null)
                {
                    currentNode.rightNode = new BstNode(i);
                }
                else
                {
                    currentNode = currentNode.rightNode;
                }
            }
            else
            {
                if(curLeftNode == null)
                {
                    currentNode.leftNode = new BstNode(i);
                    finished = true;
                }
                else
                {
                    currentNode = currentNode.leftNode;
                }
            }
        } while(!finished);
    }

    public boolean find(int i) {

    }

    BstNode rootNode;
}
