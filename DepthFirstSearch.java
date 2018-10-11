import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearch {
	private PuzzleGrid _puzzle;
	Stack<PuzzleNode> remainingChildrens = new Stack<PuzzleNode>();
	HashSet<String> vistedChildrens = new HashSet<String>();
	public PuzzleNode getDefaultRootNode(PuzzleGrid _puzzle){
		PuzzleNode _startNode = new PuzzleNode();
		_startNode.setState(_puzzle.initialProblem);
		_startNode.setTileConfig(); 
		_startNode.setTilePosIndex(0);
		return _startNode;
	}
	public DepthFirstSearch(PuzzleGrid _puzzle) {
		this._puzzle = _puzzle;
	}
	public PuzzleNode deepSearch()
	{
		int _depthPosition = 0;
		while(true)
		{
			remainingChildrens.push(getDefaultRootNode(this._puzzle));
			while (!remainingChildrens.isEmpty())
			{
				PuzzleNode _node = remainingChildrens.pop();
				if(PuzzleGrid.isTargetedState(_node.getState()))
				{
					System.out.println("final solution :");
					System.out.println("========================================");
					return _node;
				}
				vistedChildrens.add(_node.getNextPossibleMoves());
				if(_node.getTilePosIndex() < _depthPosition)
				{
					ArrayList<PuzzleNode> _listNode = _puzzle.retriveTiles(_node);
					for (int i =  _listNode.size()-1; i >=0; i--) {
						PuzzleNode _newNode = _listNode.get(i);
						if(!vistedChildrens.contains(_newNode.getNextPossibleMoves()) && !remainingChildrens.contains(_newNode))
						{
							remainingChildrens.push(_newNode);
						}
					}
				}
			}
			_depthPosition ++;
			remainingChildrens.clear();
			vistedChildrens.clear();
		}
	}
}
