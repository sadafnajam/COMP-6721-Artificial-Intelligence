
public class PuzzleNode {
	private String _tilesConfig;
	private char[] config={'a','b','c','d','e','f','g','h','i','j','k','l'};
	private PuzzleNode parentNode;
	private int[] _pos;
	private String printableCode=null;
	private int _tilePosIndex; 
	private boolean cached=false;
    private String series=null;
	
	public PuzzleNode()
	{
		
	}
	
	public PuzzleNode(int _tilePosIndex)
	{
		this._tilePosIndex=_tilePosIndex;
	}
	
	public void setTilePosIndex(int _tilePosIndex)
	{
		this._tilePosIndex = _tilePosIndex;
	}
	
	public int getTilePosIndex()
	{
		return _tilePosIndex;
	}
	
	public void setState(int[] _pos)
	{
		this._pos=_pos;
		getNextPossibleMoves();
	}
	public int[] getState()
	{
		return _pos;
	}
	
	public void setParent(PuzzleNode parent)
	{
		this.parentNode=parent;
	}
	
	public PuzzleNode getParent()
	{
		return parentNode;
	}
	
	public String getTileConfig()
	{
		return _tilesConfig;
	}
	
	public void setTileConfig(int index)
	{
		_tilesConfig=config[index]+" ";
	}
	
	public void setTileConfig()
	{
		_tilesConfig="0 ";
		
	}
	
	public String getNextPossibleMoves(){
		if(series == null)
		{
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<_pos.length;i++)
			{
				sb.append(_pos[i]+" ");
			}
			series=sb.toString();
			return series;
		}
		return series;
	}
	
	public String getPuzzleInformation()
	{
		if(printableCode!=null)
		{
			return printableCode;
		}
		StringBuilder sb=new StringBuilder();
		sb.append(_tilesConfig + "[");
		for(int i=0;i<_pos.length;i++)
		{
			if(i+1 == _pos.length){
				sb.append(_pos[i]);
			}else{
				sb.append(_pos[i]+", ");
			}
		}
		String result=sb.toString();
		result+="]";
		printableCode=result;
		return result;
	}
}

