import java.io.IOException;
import java.util.*;
public class banker
{
    public static void main(String[] args) throws IOException
{
 Scanner scan=new Scanner(System.in);
	int [][]allocated=new int[4][4];
		int [][]need=new int[4][4];
		int [][]total=new int[1][4];
		int [][]ar=new int[1][4];
			int [][]avr1=new int[1][4];
			int [][]avr2=new int[1][4];
	System.out.println("enter elements of allocated");
	for(int i=0;i<4;i++)
		for(int j=0;j<4;j++)
		allocated[i][j]=scan.nextInt();
	System.out.println("enter elements of need");
	for(int i=0;i<4;i++)
		for(int j=0;j<4;j++)
		need[i][j]=scan.nextInt();
	System.out.println("enter elements of total");
	for(int i=0;i<4;i++)
		total[0][i]=scan.nextInt();
	for(int i=0;i<4;i++)
		for(int j=0;j<4;j++)
	ar[0][j]+=allocated[i][j];
		for(int i=0;i<4;i++)
		avr1[0][i]=total[0][i]-ar[0][i];
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
		if(avr1[0][j]<need[i][j])
		{
			for(int k=0;k<4;k++)
				avr2[0][k]=avr1[0][k];
			break;
		}
	else
	avr2[0][j]=avr1[0][j]+allocated[i][j];
	}
	for(int p=0;p<4;p++)
	avr1[0][p]=avr2[0][p];

	}
	for(int p=0;p<4;p++){
if(	avr1[0][p]==total[0][p])
	System.out.println("safe");
else
	System.out.println("not safe");
break;
	}
	
}	
	
	
		
}
