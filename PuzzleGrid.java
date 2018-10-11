import java.util.ArrayList;
import java.util.Arrays;
public class PuzzleGrid {
	private static int[] finalSolution;
	public int[] initialProblem;
	public PuzzleGrid(int[] _finalSolution,int[] _initialSolution)
	{
		this.finalSolution = _finalSolution;
		this.initialProblem = _initialSolution;
	}
	
	public ArrayList<PuzzleNode> retriveTiles(PuzzleNode currentState)
	{
		ArrayList<PuzzleNode> _tiles=new ArrayList<PuzzleNode>(); 
		int emptyTileIndex = -1;
		int[] curStat=currentState.getState();
		for(int index=0; index< curStat.length;index++)
		{
			if(curStat[index]==0)
			{
				emptyTileIndex=index;
			}
		}
		if(emptyTileIndex == -1)
		{
			// This should never happen with our current puzzles.
			throw new RuntimeException("Error! No solution found!");
		}
		//UP
		int _deepNodeDeep = currentState.getTilePosIndex();
		if(emptyTileIndex-4>=0)
		{
			_tiles.add(generateNodes((_deepNodeDeep+1), curStat, emptyTileIndex,(emptyTileIndex-4), currentState, 1));
		}
		//UP –RIGHT
		if(emptyTileIndex!=7 && emptyTileIndex!=11 &&  emptyTileIndex-3 >0 )
		{
			_tiles.add(generateNodes((_deepNodeDeep+1), curStat, emptyTileIndex,(emptyTileIndex-3), currentState, 2));
		}
		//RIGHT
		if(emptyTileIndex!=3 && emptyTileIndex!=7 && emptyTileIndex!=11 )
		{
			_tiles.add(generateNodes((_deepNodeDeep+1), curStat, emptyTileIndex,(emptyTileIndex+1), currentState, 3));
		}
		//DOWN- RIGHT
		if(emptyTileIndex!=3 && emptyTileIndex!=7 && emptyTileIndex+5 < curStat.length){
			_tiles.add(generateNodes((_deepNodeDeep+1), curStat, emptyTileIndex,(emptyTileIndex+5), currentState, 4));
		}
		//DOWN
		if(emptyTileIndex+4 < curStat.length)
		{
			_tiles.add(generateNodes((_deepNodeDeep+1), curStat, emptyTileIndex,(emptyTileIndex+4), currentState, 5));
		}
		//DOWN –LEFT
		if(emptyTileIndex!=0 && emptyTileIndex!=4 && emptyTileIndex!=8 && emptyTileIndex+3 < curStat.length)
		{
			_tiles.add(generateNodes((_deepNodeDeep+1), curStat, emptyTileIndex,(emptyTileIndex+3), currentState, 6));
		}
		
		//LEFT
		if(emptyTileIndex!=0 && emptyTileIndex!=4 && emptyTileIndex!=8)
		{
			_tiles.add(generateNodes((_deepNodeDeep+1), curStat, emptyTileIndex,(emptyTileIndex-1), currentState, 7));
		}
		//UP–LEFT
		if(emptyTileIndex!=4 && emptyTileIndex!=8 &&  emptyTileIndex-5 >0 )
		{
			_tiles.add(generateNodes((_deepNodeDeep+1), curStat, emptyTileIndex, (emptyTileIndex-5), currentState, 8));
		}
		return _tiles;
	}
	
	public static PuzzleNode generateNodes(int depthOfNode , int[] curStat , int oldBlankTileIndex, int newBlankTileIndex , PuzzleNode currentState , int directionIndex){
			//String [] preferredMoves = {"UP", "UP–RIGHT", "RIGHT", "DOWN-RIGHT", "DOWN", "DOWN-LEFT", "LEFT", "UP-LEFT"};
			PuzzleNode child=new PuzzleNode(depthOfNode);
			int[] _tmp = new int[curStat.length];
			for(int i=0; i<curStat.length;i++ )
			{
				_tmp[i] = curStat[i];
			}
			int temp = _tmp[oldBlankTileIndex];
			_tmp[oldBlankTileIndex] =_tmp[newBlankTileIndex];
			_tmp[newBlankTileIndex] = temp;
			child.setState(_tmp);
			child.setTileConfig(newBlankTileIndex);
			child.setParent(currentState);
			return child;
	}
	
	public static final boolean isTargetedState(int[] currentState)
	{
		return Arrays.equals(finalSolution, currentState);
	}
}