import java.io.IOException;
import java.util.*;
public class compress
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
	 int []sample=new int[memry];
		System.out.println("enter segment elements");
	for(int i=0;i<segment;i++)
	seg[i]=scan.nextInt();
 System.out.println("enter any one--->>");
  System.out.println("1.compress1 adjecent");
   System.out.println("2.compress2 from any segment");
	  int k =scan.nextInt();
        switch (k) {
            case 1: compress1(seg,process,segment,memry);
                     break;
		case 2: compress2(seg,process,segment,memry);
		        break;
		default : System.out.println("please enter no less than 5");
		}		
}
public static void compress1(int []seg,int []process,int []sample,int segment,int memry)
{
			int i1=0;
		int i2=0;
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
			{
				sample[i1]=process[j];
			i1++;
			}
		}
		///////////////////////////////
		for(int j=0;j<memry;j++)
			if(sample[j]==0)
			break;
		else{
	for(int i=0;i<segment-1;i++)
		
		if(sample[j]<=seg[i]+seg[i+1]){
			seg[i]=seg[i]+seg[i+1]-sample[j];
		System.out.println("memory "+sample[j]+" will enter and block="+seg[i]);// print the value of block at this point]
		break;
		}
		else{
			if((i==segment-1)&&(sample[j]>seg[i]))
			{
				sample[i2]=sample[j];
			i2++;
			}
		}
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
public static void compress2(int []seg,int []process,int segment,int memry)
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