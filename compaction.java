import java.io.IOException;
import java.util.*;
public class compaction
{
    public static void main(String[] args) throws IOException
{
 Scanner scan=new Scanner(System.in);
	System.out.println("enter prosses no.");
	int process=scan.nextInt();
		System.out.println("enter process");/////enter   the  memory of process
	int []process_no=new int[process];
	for(int i=0;i<process;i++)
	process_no[i]=scan.nextInt();
System.out.println("enter segment");
	int segment=scan.nextInt();
	int []seg=new int[segment];
	 int []sample=new int[process];
		System.out.println("enter segment elements");
	for(int i=0;i<segment;i++)
	sample[i]=seg[i]=scan.nextInt();
 System.out.println("enter any one--->>");
  System.out.println("1.compaction1 adjecent");
   System.out.println("2.compaction2 from any segment");/////switching of functions
	  int k =scan.nextInt();
        switch (k) {
            case 1: compaction1(seg,process_no,sample,segment,process);
                     break;
		case 2: compaction2(seg,process_no,segment,process);
		        break;
		default : System.out.println("please enter no less than 3");
		}		
}
public static void compaction1(int []seg,int []process_no,int []sample,int segment,int process)//sorry for too much arguments :D
{
		int[] sample2=new int[process];
		int i1=0;
		for (int i=0;i<process;i++)
			for(int j=0;j<segment;j++)
			{
				if(j==segment-1 && seg[j]<process_no[i])
					sample2[i1++]=process_no[i];
				else if(seg[j]>=process_no[i])
				{
					seg[j]=seg[j]-process_no[i];
					System.out.println("memory "+process_no[i]+" will enter and block= "+seg[j]);// print the value of block at this point
					break;
				}
			}
		for (int i=0;i<i1;i++)
		{
			int sum=seg[0];
			int count=0;
			for(int j=0;j<segment;j++)	
			{
				if(seg[j]!=sample[j])
				{	
					sum=seg[j];
					count=j;
				}
				else
					sum+=seg[j];
				if(sum>=sample2[i])
				{
					for(int k=count;k<j;k++)
						seg[k]=0;
					seg[j]=sum-sample2[i];
					System.out.println(" memory "+sample2[i]+" will enter and block= "+seg[j]);// print the value of block at this point
					sample2[i]=0;
					break;
				}
		}
		}
		for(int i=0;i<process;i++)
			if(sample2[i]!=0)
			System.out.println(" memory "+sample2[i]+" will not enter ");
}
public static void compaction2(int []seg,int []process_no,int segment,int process)
{
		int[] sample2=new int[process];
		int i1=0;
		for (int i=0;i<process;i++)
		for(int j=0;j<segment;j++)
			{
				if(j==segment-1 && seg[j]<process_no[i])
					sample2[i1++]=process_no[i];
				else if(seg[j]>=process_no[i])
				{
					seg[j]=seg[j]-process_no[i];
					System.out.println(" memory "+process_no[i]+" will enter and block= "+seg[j]);// print the value of block at this point
					break;
				}
			}
		for (int i=0;i<i1;i++)
		{
			int sum=seg[0];
			int count=0;
			for(int j=0;j<segment;j++)	
			{
				sum+=seg[j];
				if(sum>=sample2[i])
				{
					seg[count]=sum-sample2[i];
					for(int k=count+1;k<=j;k++)
						seg[k]=0;
					System.out.println(" memory "+sample2[i]+" will enter and block= "+seg[j]);// print the value of block at this point
					sample2[i]=0;
					break;
				}
		}
		}
		for(int i=0;i<process;i++)
			if(sample2[i]!=0)
				System.out.println("memory "+sample2[i]+" will not enter ");	
	}
}