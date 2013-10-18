/*
 * Judge.java
 *
 * Version:
 *          $Id$
 *
 * Revisions:
 *          $Log$
 *
 */

/*
*@Problem       : To perform matrix multiplication using threads
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author        : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.1
*@LastModified  : 10/28/2012 7.30 PM
*
*
/*
How does your algorithm work ?
	1. Create N Kids and a Judge.
	2. Call start() on all kids and a Judge Thread.
	3. Judge waits to start music until all kids are waiting on a same synchronized object so that the chance
	of getting picked by the schedular is the same for all threads despite different priority for a fair game play.
	4. Judge (after all kids are in wait) sets the music.
	5. All Threads go in a loop of running (that is what happens in musical chairs)
	6. Music stops and every kid competes to acquire a permit from Semaphore(Considered as a chair)
	7. The last kid that is left, his playing variable is set to false so goes out of the loop since there are
	n players and n-1 chairs.
	8. Step 3 to 7 continues until one kid is left who is declared winner and his playing status is also set to false so that the program ends.

Why is your algorithm fair ?
	Because every kid goes to wait first before the music starts and then the judge starts music and notify's all
	so that every kid has the equal chance of being picked by the schedular to run.
*/


import java.util.*;
import java.util.concurrent.Semaphore;
//class Kid that specifies name and playing status of the kid.
class Kid extends Thread {
	//Name of the Kid
	private int name;
	//True if kid is playing false otherwise
	private boolean playing = true;
	//Construtor that creates a kid thread.
	public Kid(int name) {
		this.name = name;
	}
	/*
	 * startRunning		Think as kids start running around chairs.
     */
    public void startRunning() {
		// If music is on
		while(Judge.music) {
			//Go to the next chair
		}
		if(Judge.chairs.tryAcquire()) {
			//Chair Taken
			if(Judge.players <= 2) {
				this.playing = false;
				System.out.println("===== "+this.name+" is the winner with priority "+this.getPriority());
				Judge.players--;
			}
		} else {
			//So that the current thread runds out of while loop.
			this.playing = false;
			System.out.println("     "+this.name+" is out with priority "+this.getPriority());
			//Now number of players will decrease by 1 since 1 player lost.
			Judge.players--;
			//Also number of chairs will be decreased by 1 as per rules.
			Judge.updateChairs();
		}
	}
	/*
	 * run		Run function of the kid thread.
    */
	public void run() {
		while(this.playing) {
			//All kids wait first so that when music starts everyone gets a fair chance.
				synchronized(Judge.waitObj) {
					Judge.playersWaiting++;
					try {
						Judge.waitObj.wait();
					} catch(InterruptedException e) {
						System.out.println(e);
					}
				}
				startRunning();
		}
	}
}
//Judge class that control music to control the game.
class Judge {
	public static volatile boolean music = false;
	public static Semaphore chairs;
	public static volatile int players = 0;
	public static volatile int playersWaiting = 0;
	public static Object waitObj = new Object();
	/*
     * createNPlayers  Create the required kid threads to play.
     * @param   n      represents the kid threads to be created.
     */
    public void createNPlayers(int n) {
		//If there are more than one threads.
		if(n != 1) {
			players = n;
			chairs = new Semaphore(n-1);
			for(int i=1;i<=n;i++) {
				Kid k = new Kid(i);
				int random = (int)(Math.random()*10);
				if(random == 0) {
					k.setPriority(10);
				} else {
					k.setPriority(random);
				}
				k.start();
			}
		} else {
			System.out.println("1 is Winner");
		}
	}
	/*
     * updateChairs  Updates Semaphore chairs after every music on/off iteration.
     */
    public static void updateChairs() {
		chairs = new Semaphore(players-1);
	}
	/*
     * startGame  Judge Object starts the game.
     */
	public void startGame() {
		while(players > 0) {
			//All players should wait for game to start fairly
			if(playersWaiting == players) {
				//Judge syncs to notify all.
				synchronized(waitObj) {
					//Start music
					music = true;
					playersWaiting = 0;
					System.out.println(players+" are playing");
					waitObj.notifyAll();
				}
			} else {
				if(!music) {
					//Sleep till game can start fairly
					try {
						// Judge is taking a nap
						Thread.sleep(70);
					} catch (Exception e) {
					}
				} else {
					//music is on. so randomly sleep for some time and then turn the music off
					try {
						Thread.sleep((int)(Math.random()*100));
					} catch(Exception e) {
					}
					music = false;
				}
			}
		}
	}
	//Invoking main function
	public static void main(String args[]) {
		Judge m = new Judge();
		//Create the specified number of threads to start playing.
		m.createNPlayers(Integer.parseInt(args[0]));
		m.startGame();
	}
}
