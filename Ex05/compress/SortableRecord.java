
public class SortableRecord extends Record implements Comparable<SortableRecord>
{
    public SortableRecord(String id, int m, int j, int e)
    {
        super(id, m, j, e);
    }

    @Override
    public int compareTo(SortableRecord o)
    {
        int result;
        result = o.score_total - score_total;
        if(result == 0) {
            result = o.score_math - score_math;
        }
        if(result == 0) {
            result = o.score_Japanese - score_Japanese;
        }
        if(result == 0) {
            result = o.score_English - score_English;
        }
        return result;
    }

}
