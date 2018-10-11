import java.util.ArrayList;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) throws Exception {
		int[] goalState = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0};
		int[] initialState = {1, 2, 3, 4, 5, 6, 7, 8, 0, 9, 10, 11};
		PuzzleGrid _puzzle = new PuzzleGrid(goalState, initialState);
		DepthFirstSearch _dfs = new DepthFirstSearch(_puzzle);
        printFinalSolution(_dfs.deepSearch());
	}
	public static final void printFinalSolution(PuzzleNode resultTile)
	{
		if(resultTile != null){
			ArrayList<String> _finalResultState = new ArrayList<String>();
			while(resultTile != null)
			{
				_finalResultState.add(resultTile.getPuzzleInformation());
				resultTile = resultTile.getParent();
			}	
			for(int i = _finalResultState.size()-1; i>= 0;i--)
			{
				System.out.println(_finalResultState.get(i));
			}
			System.out.println("");
			System.out.println("Traverse cost count "+ _finalResultState.size());
		}	
	}

}