import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateExceptionTest {

	private int year;
	private int month;
	private int day;

	private int expectedYear;
	private int expectedMont;
	private int expectedDay;

	public DateExceptionTest(int y,int m,int d, int ey,int em,int ed){

		year = y;
		month = m;
		day = d;
		expectedYear=ey;
		expectedMont=em;
		expectedDay=ed;
	}

	@Parameters
	public static List<Integer[]> data(){
		List<Integer[]> params = new LinkedList<Integer[]>();
		params.add(new Integer[] {1500,	02,	31,	0,0,0});
		params.add(new Integer[] {1500,	02,	29,	0,0,0});
		params.add(new Integer[] {-1,	10,	20,	0,0,0});
		params.add(new Integer[] {1458,	15,	12,	0,0,0});
		params.add(new Integer[] {1975, 6,-50,0,0,0});
		return params;
	}

	@Test(expected=IllegalArgumentException.class)
	public void tests(){
    		Date  date = new Date(year,month,day);
		Date next = date.nextDate();
		Assert.assertEquals(expectedYear, next.getYear());
		Assert.assertEquals(expectedMont, next.getMonth());
		Assert.assertEquals(expectedDay, next.getDay());
	}
}