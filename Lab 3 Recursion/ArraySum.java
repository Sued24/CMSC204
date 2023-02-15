public class ArraySum {
	
	public int sumOfArray (Integer[] a,int index)
	{
		if (a[0] == null || index < 0)
			return 0;
		else
			return a[index] + sumOfArray(a , index - 1);	
	}
}
