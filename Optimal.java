import java.util.*;
class optimal
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter no. of pages");
		int page=scan.nextInt();
		int[] page_frame=new int[page];
		int[] sample=new int[page];
		System.out.println("enter page request");
		int request=scan.nextInt();
		int[] page_request=new int[request];
		System.out.println("enter elements of page_request");
		for(int i=0;i<request;i++)
			page_request[i]=scan.nextInt();
		int min=sample[0];
		int index=0;
		int count =0;
			int j=0;
		for(int i=0;i<request;i++){
			if(j<page){
				for(int a=0;a<page;a++)
				if(page_request[i]==page_frame[a]){
				sample[a]=i+1;
					count++;
				}				
				if(count==0){
if(sample[0]==0)		
{
	page_frame[j]=page_request[i];
			System.out.println("-->"+page_frame[j]);
			j++;
}	
else{
	
					////////////////////////// index update of sample
					for(int k=0;k<page;k++)
					for(int c=request-1;c>0;c--)
						if(page_request[c]==page_frame[k]){
							sample[k]=c+1;
							break;
						}
					//////////////////////////
					for(int b=0;b<page;b++)
					{
						if(min>sample[b]){
					min=sample[b];
				index=b;
						}
					}
				page_frame[index]=page_request[i];
				sample[index]=i+1;
				System.out.println("-->"+page_frame[j]);
				j++;
				}
				}
				count=0;
				}
		else{
			j=0;
		System.out.println("replace-->");
		for(int a=0;a<page;a++)
				if(page_request[i]==page_frame[a]){
				sample[a]=i+1;
					count++;
				}				
				if(count==0){
if(sample[0]==0)		
{
	page_frame[j]=page_request[i];
			System.out.println("-->"+page_frame[j]);
			j++;
}	
else{
	////////////////////////// index update of sample
					for(int k=0;k<page;k++)
					for(int c=request-1;c>0;c--)
						if(page_request[c]==page_frame[k]){
							sample[k]=c+1;
							break;
						}
					//////////////////////////
					for(int b=0;b<page;b++)
					{
						if(min>sample[b]){
					min=sample[b];
				index=b;
						}
					}
				page_frame[index]=page_request[i];
				sample[index]=i+1;
				System.out.println("-->"+page_frame[j]);
				j++;
				}
				}
				count=0;
			
		}
		}
	for(int i=j;i<page;i++)
			System.out.println("-->"+page_frame[i]);
	}
}