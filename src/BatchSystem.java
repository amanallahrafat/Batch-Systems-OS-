import java.util.LinkedList;
import java.util.Queue;

public class BatchSystem {

	private static Queue<Process> Ready = new LinkedList<>() ;

	public static void main(String[] args) throws InterruptedException {
		/**
		 * Process1 -> read data from a file
		 * Process2 -> write data in a file
		 * Process3 -> count from 0 to 300
		 * Process4 -> count from 500 to 1000
		 * Process5 -> get a lower bound and upper bound as input and count from the lower to the upper
		 * 
		 */
		Process2 p21 = new Process2(); 
		Process3 p31 = new Process3();
		Process5 p51 = new Process5();
		Process1 p11 = new Process1();
		Process3 p32 = new Process3();
		Process4 p41 = new Process4();
		Process5 p52 = new Process5();
		Process4 p42 = new Process4();
		
		simulate();
	}
	
	public static void simulate(){
		if(Ready.isEmpty())
			return ;
		
		Process p = Ready.poll();
		p.start();
		
		boolean next = false ;
		
		while(!Ready.isEmpty() || !Kernel.NoBlockedProcesses())
		{
			if(p.getCurrentState() == ProcessState.TERMINATED || p.getCurrentState() == ProcessState.BLOCKED)
				next = true ;
			
			if(next && !Ready.isEmpty())
			{
				p = Ready.poll();
				if (p.getCurrentState() == ProcessState.READY)
					p.start();
				else
					p.setState(ProcessState.RUNNING);
				next = false ;
			}
		}
	}

	public static Queue<Process> getReady() {
		return Ready;
	}

}
