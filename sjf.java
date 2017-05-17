import java.io.IOException;
import java.util.*;
public class fcfs
{
    public static void main(String[] args) throws IOException
{
 Scanner scan=new Scanner(System.in);
	int in1 =scan.nextInt();
	int []p=new int[in1];
	int []at=new int[in1];
	int []bf=new int[in1];
	int []wt=new int[in1];
	int []tat=new int[in1];
		for(int i=0;i<in1;i++)
	{
		at[i]=i;
	}
	System.out.println("enter at");
	for(int i=0;i<in1;i++)
	{
		at[i]=scan.nextInt();
	}
	System.out.println("enter bt");
	for(int i=0;i<in1;i++)
	{
		bf[i]=scan.nextInt();
	}
	for(int j=0;j<in1;j++)
		{
			for(int k=0;k<in1-j-1;k++)
			{
				if(at[k]>at[k+1])
				{
					int swap=at[k];
					at[k]=at[k+1];
					at[k+1]=swap;
					 swap=bf[k];
					bf[k]=bf[k+1];
					bf[k+1]=swap;
					 swap=p[k];
					p[k]=p[k+1];
					p[k+1]=swap;
				}
			}
		}
int first=0;
int min=0;
for(int i=0;i<in1;i++)
{
	if(at[i]>first)
	{
		first=at[i];
		wt[i]=0;
		first+=bf[i];
	}
	else
	{
		int j=i;
		while(first>at[j]&&j<in1-1){
			min=bf[j];
		if(bf[j]>bf[j+1])
			min=bf[j+1];
		j++;
		}
		for(int j=0;j<in1;j++)
{
	if(min==bf[j])
		wt[i]=first-at[j];
}
		first+=min;
		//wt[last]
	}
}
	for(int i=0;i<in1;i++)
	{
		tat[i]=wt[i]+bf[i];
	}
for(int j=0;j<in1;j++)
		{
			for(int k=0;k<in1-j-1;k++)
			{
				if(p[k]>p[k+1])
				{
					int swap=at[k];
					at[k]=at[k+1];
					at[k+1]=swap;
					 swap=bf[k];
					bf[k]=bf[k+1];
					bf[k+1]=swap;
					 swap=p[k];
					p[k]=p[k+1];
					p[k+1]=swap;
					 swap=wt[k];
					wt[k]=wt[k+1];
					wt[k+1]=swap;
					 swap=tat[k];
					tat[k]=tat[k+1];
					tat[k+1]=swap;
				}
			}
		}
	System.out.print("wt-->");
	for(int j=0;j<in1;j++)
		System.out.print(" "+wt[j]+" ");
	System.out.print("tat-->");
	for(int j=0;j<in1;j++)
		System.out.print(" "+tat[j]+" ");
	
}
}