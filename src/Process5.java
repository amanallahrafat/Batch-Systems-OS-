import java.io.IOException;



public class Process5 extends Process{

	
	public Process5(int ID) {
		super(ID);
	}

	@Override
	public void run() {
		//Running state
		this.state = State.RUNNING;
				
		Kernel.println("Please Enter the Lower Bound Number:");
		int lo = Kernel.takeInt();
		
		Kernel.println("Please Enter the Upper Bound Number:");
		int hi = Kernel.takeInt();
		
		String data = "";
		for (int i = lo; i <= hi; i++)
		{
			data += i+"\n";
		}
		String filePath = lo+"-to-"+hi+".txt";
		
		if(Kernel.isFileExists(filePath)) 
		{
			Kernel.println("The Requested File to be Created is Already Exist , to view it try to use process 1 and its Name is "+filePath);
			this.state = State.TERMINATED;
			return;
		}
		try 
		{
			if(!Kernel.createFile(filePath))
			{
				Kernel.println("Cannot create a file with name: "+filePath);
				this.state = State.TERMINATED;
			}
		}
		catch (IOException e) 
		{
			Kernel.println("Cannot create a file with name: "+filePath);
			this.state = State.TERMINATED;
		}
		
		try 
		{
			Kernel.WriteData(filePath, data);
			Kernel.println("The Task is Done and The File With required Data is Created");
			this.state= State.TERMINATED;
		}
		catch (IOException e)
		{
			Kernel.println("Cannot write the count in a new file");
			this.state = State.TERMINATED;
		}
		
	}
}