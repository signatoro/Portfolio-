package Model;


public class Items
{
    private int itemId;

    private final String itemList[] = {"Stick", "Rusty Dagger", "Cloth Robes", "Health Potion", "Boots", "Wand", "Rusty Sword"};
    
    public Items()
    {
        itemId = 0;
    }
    public String ItemFinder(double UId)
    {
        itemId =(int)(UId * 100);
        int pos = itemId % 10;

        return itemList[pos];
    }
}
