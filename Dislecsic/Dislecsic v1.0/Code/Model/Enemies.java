package Model;

public class Enemies
{
    private int enemyId;

    private final String enemyIdList[] = {"Error", "Summer Reeding Bouk", "Speling Test", "Skelital Inglish Teycher", "Cobold", "Error", "Troll", "Spealling Bea Banner"};

    public Enemies()
    {
        enemyId = 0; 
    }

    public String EnemyFinder(double UId)
    {
        enemyId = (int) (UId * 100);
        int pos = enemyId % 10;

        return enemyIdList[pos];
    }

    public double EnemyMultiplierFinder(double UId)
    {
        enemyId = (int) (UId * 100);
        int multiplier = enemyId % 10;

        return multiplier;

    }
}