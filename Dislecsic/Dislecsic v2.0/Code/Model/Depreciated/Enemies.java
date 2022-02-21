package Model.Depreciated;

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
        int pos;
        if (UId == .51) {
            pos = 1;
        }
        else if (UId == .52) {
            pos = 2;
        }
        else if (UId == .53) {
            pos = 3;
        }
        else if (UId == .54) {
            pos = 4;
        }
        else if (UId == .56) {
            pos = 6;
        }
        else if (UId == .57) {
            pos =7;
        }
        else {
            pos = 0;
        }

        return enemyIdList[pos];
    }

    public double EnemyMultiplierFinder(double UId)
    {
        enemyId = (int) (UId * 100);
        int multiplier = enemyId % 10;

        return multiplier;

    }
}