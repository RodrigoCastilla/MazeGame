package Model;

public class TimeKeeper
{
                                               //Método que inicializa y almacena los datos del tiempo. Acepta dos entreros (uno para minutos y otro para segundos).
    public void setTimeKeeper(int min, int sec)//a class to keep track of the total seconds and minuntes the player has used to get to a level
	{ 
	   if(sec + seconds <=60)
	    {
	        minutes+=min;
	        seconds=sec+seconds;
    	}
	   else
	   {
	       minutes+=min;
	       minutes+=1*((sec+seconds)/60);
	       seconds=(sec+seconds)%60;
	   }
	}//end TimeKeeper
	
	public int getMinutes()
	{
	    return minutes;
	}
	
	public int getSeconds()
	{
	    return seconds;
	}
	
int minutes=0; 
int seconds=0;
}//end class
