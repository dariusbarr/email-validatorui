package csci3130.email_validatorUI;

public class Email {
	String email;
	
	public Email(String email)
	{
		this.email=email;
	}
	
	public boolean atSign()
	{
		boolean result=false;
		for(int i=0;i<email.length();i++)
		{
			if(email.charAt(i)=='@')
			{
				result=true;
				
				break;
			}
			
		}
		
		if(result==false)
		System.out.println("@ sign not found");
		
		else System.out.println("@ sign found");
		return result;
	}
	
	public boolean lengthCheck()
	{
	
	if(email.length()<320)
	{
		System.out.println("Appropriate Length");
		return true;
	}
	
	else 
		{
			System.out.println("Too Long");
			return false; 
		}
		}


public boolean spaceCheck()
{
	boolean result=false;
	for (int i=0;i<email.length();i++)
	{
		if(email.charAt(i)==' ')
		{
			System.out.println("has a space");
			result= true;
		}
	}
	if(result==false)
	System.out.println("does not have a space");
	return result;
}
	
	public boolean period()
	{
		boolean result=false;
		for(int i=0;i<email.length();i++)
		{
			if(email.charAt(i)=='.')
			{
				result=true;
				
				break;
			}
			
		}
		
		if(result==false)
		System.out.println("'.' sign not found");
		
		else System.out.println("'.' sign found");
		return result;
	}
	
	

	}
