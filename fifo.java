import java.util.*;
class fifo
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter no. of pages");
		int page=scan.nextInt();
		int[] page_frame=new int[page];
		System.out.println("enter page request");
		int request=scan.nextInt();
		int[] page_request=new int[request];
		System.out.println("enter elements of page_request");
		for(int i=0;i<request;i++)
			page_request[i]=scan.nextInt();
		int count=0;
			int j=0;
		for(int i=0;i<request;i++){
			if(j<page){
				for(int a=0;a<page;a++)
					if(page_request[i]==page_frame[a])
						count++;
					if(count==0){
			page_frame[j]=page_request[i];
			System.out.println("-->"+page_frame[j]);
			j++;
					}
					count=0;
			}
		else{
			j=0;
			
			for(int a=0;a<page;a++)
					if(page_request[i]==page_frame[a])
						count++;
					System.out.println("replace-->");
					if(count==0){
			page_frame[j]=page_request[i];
			System.out.println("-->"+page_frame[j]);
			j++;
					}
					count=0;
						
		}
		}
		for(int i=j;i<page;i++)
			System.out.println("-->"+page_frame[i]);
			

	}
}