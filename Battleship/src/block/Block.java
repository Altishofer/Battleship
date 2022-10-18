package block;

public class Block
{
    private BlockType aBlockType = BlockType.WATER;

    public Enum getBlockType ()
    {
        return aBlockType;
    }

    public void setBlockType(BlockType pBlockType)
    {
        aBlockType = pBlockType;
    }
}
