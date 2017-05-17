import java.io.IOException;
import java.util.*;
public class memory
{
    public static void main(String[] seggs) throws IOException
{
 Scanner scan=new Scanner(System.in);
	System.out.println("enter prosses");
	int memry=scan.nextInt();
		System.out.println("enter memory");
	int []process=new int[memry];
	for(int i=0;i<memry;i++)
	process[i]=scan.nextInt();
System.out.println("enter segment");
	int segment=scan.nextInt();
	int []seg=new int[segment];
		System.out.println("enter segment elements");
	for(int i=0;i<segment;i++)
	seg[i]=scan.nextInt();
 System.out.println("enter any one--->>");
  System.out.println("1.firstfit");
   System.out.println("2.bestfit");
    System.out.println("3.worstfit");
	 System.out.println("4.nextfit");
	  int k =scan.nextInt();
        switch (k) {
            case 1: System.out.println("firstfit--->>");
		firstfit(seg,process,segment,memry);
                     break;
		case 2: bestfit(seg,process,segment,memry);
		        break;
		case 3: 
		worstfit(seg,process,segment,memry);
		break;
		case 4:
		nextfit(seg,process,segment,memry);
	break;
	default : System.out.println("please enter no less than 5");
		}		
}
public static void bestfit(int []seg,int []process,int segment,int memry)
{
	System.out.println("bestfit--->>");
	Arrays.sort(seg);
	firstfit(seg,process,segment,memry);
}
public static void worstfit(int []seg,int []process,int segment,int memry)
{
	System.out.println("worstfit--->>");
	Arrays.sort(seg);
	for(int i=0;i<segment/2;i++)
				{
					int temp =seg[i];
					seg[i]=seg[segment-1-i];
					seg[segment-1-i]=temp;
				}
	firstfit(seg,process,segment,memry);
}
public static void nextfit(int []seg,int []process,int segment,int memry)
{
	System.out.println("nextfit--->>");
	{
		int i=0;
		int j=0;
		while(i<memry)
		{
			int k;
			if(j==0)
				 k=segment-1;
			else
				 k=j-1;
			while(j<segment)
			{
				if(j==k && seg[j]<process[i])
				{
					System.out.println("memory "+process[i]+" will not enter");
					break;
				}
				else if(seg[j]>=process[i])
				{
					seg[j]=seg[j]-process[i];
					System.out.println("memory "+process[i]+" will enter and block="+seg[j]);// print the value of block at this point
					break;
				}
				if(j==segment-1)
					j=0;
				else
					j++;	
			}
			i++;
		}
	}
}
public static void firstfit(int []seg,int []process,int segment,int memry)
{
	
	if(memry>segment)
	{
		for(int j=0;j<memry;j++)
	for(int i=0;i<segment;i++)
		if(process[j]<=seg[i]){
			seg[i]=seg[i]-process[j];
		System.out.println("memory "+process[j]+" will enter and block="+seg[i]);// print the value of block at this point]
		break;
		}
		else{
			if((i==segment-1)&&(process[j]>seg[i]))
				System.out.println("memory "+process[j]+" will not enter");
		}
	}
		else
		{
			for(int i=0;i<memry;i++)
				for(int j=0;j<segment;j++)
		if(process[i]<=seg[j]){
			seg[j]=seg[j]-process[i];
		System.out.println("memory "+process[i]+" will enter and block="+seg[j]);// print the value of block at this point]
		break;
		}
		else
			if((j==segment-1)&&(process[i]>seg[j]))
				System.out.println("memory "+process[i]+" will not enter ");
		}
}
}