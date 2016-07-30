package assignment19;

/**
 * A Queue class implemented with a circular array
 * 
 * @author William McDaniel Albritton
 */
public class ArrayQueue<T> implements QueueInterface<T> {
	// data fields
	// Index of element at front of the queue
	protected int frontIndex = 0;
	// Index of element at end of the queue
	// Value is -1, because we have not added any elements yet.
	protected int endIndex = -1;
	// Current number of elements in queue
	protected int currentSize = 0;
	// Maximum number of elements in queue (set by constructor)
	protected int maxSize;
	// Array to store elements of T type
	protected T array[ ];

	/**
	 * Constructor
	 * 
	 * @param max
	 *            is the maximum number of elements in the queue
	 */
	public ArrayQueue(int max) {
		maxSize = max;
		// Have to do casting, because we cannot instantiate
		// an array unless we know its type.
		// Casting is putting a class name in parenthesis,
		// which tells the compiler that a variable
		// is of a specific type.
		// protected T array[] = new T[arraySize]; //wrong syntax
		/*
		 * May create following error message, but can't be avoided with arrays.
		 * Note: ArrayQueue.java uses unchecked or unsafe operations. Note:
		 * Recompile with -XlInteger:unchecked for details.
		 */
		array = (T[ ]) new Object[maxSize];
	}

	/**
	 * Tests if the Queue is empty
	 * 
	 * @return true/false if empty/not empty
	 */
	public boolean empty() {
		// see if size of array is 0
		boolean emptyArray = (currentSize == 0);
		return emptyArray;
	}

	/**
	 * Tests if the Queue is full
	 * 
	 * @return true/false if full/not full
	 */
	private boolean full() {
		// See if size of array is at maximum
		boolean fullArray = (currentSize == maxSize);
		return fullArray;
	}

	/**
	 * Adds an element to the end of the Queue
	 * 
	 * @param element
	 *            is added to the end of the Queue
	 * @return true if it was possible to add the element to Queue, else false
	 */
	public boolean offer(T element) {
		// check to see if full
		if (!this.full()) {
			// increment the endIndex
			// use modulus to "wrap around" the array
			endIndex = (endIndex + 1) % maxSize;
			// assign element to array
			array[endIndex] = element;
			// increment current size of queue
			currentSize++;
			// successfully added to array
			return true;
		}
		// if full, cannot add to array
		return false;
	}

	/**
	 * Retrieves and removes the from the front of Queue, or null if Queue
	 * is empty
	 * 
	 * @return the front of Queue, or null if Queue is empty
	 */
	public T poll() {
		// create a variable of class T
		T element = null;
		// if array is not empty, then get element from front of queue
		if (!this.empty()) {
			// get the front element's address
			element = array[frontIndex];
			// increment frontIndex
			// take the modulus to wrap around the array
			frontIndex = (frontIndex + 1) % maxSize;
			// decrement current size of queue
			currentSize--;
		}
		// return either null or the element
		return element;
	}

	/**
	 * Retrieves, but does not remove, from the frontIndex of Queue, or null if
	 * Queue is empty
	 * 
	 * @return the frontIndex of Queue, or null if Queue is empty
	 */
	public T peek() {
		// create a variable
		T element = null;
		// check to see if not empty
		if (!this.empty()) {
			// get the address of front element
			element = array[frontIndex];
		}
		// return either null or element
		return element;
	}

	/**
	 * Driver code to test class
	 * 
	 * @param arguments
	 *            Commandline arguments not used
	 */
	public static void main(String[] arguments) {
		// make Queue of Integers
		// use Interface in declaration (left of equals)
		// use class to instantiate object (right of equals)
		// syntax: Interface variable = new Class();
		QueueInterface<Integer> queue 
		= new ArrayQueue<Integer>(5);
		//boolean isFull = queue.full();
		// test empty
		System.out.println("Is queue empty? " + queue.empty());
		// test poll from an empty queue
		System.out.println("queue.poll() = " + queue.poll());
		// test peek from an empty queue
		System.out.println("queue.peek() = " + queue.peek());
		System.out.println();

		// test offer
		Integer number = new Integer(10);
		for (int i = 0; i < 5; i++) {
			System.out.println("queue.offer(" + number + ") = "
					+ queue.offer(number));
			System.out.println("Is queue empty? " + queue.empty());
			number = number + 10;
		}
		System.out.println();

		// test offer to full queue
		System.out.println("test offer to full queue");
		number = number + 10;
		System.out.println("queue.offer(" + number + ") = "
				+ queue.offer(number));
		number = number + 10;
		System.out.println("queue.offer(" + number + ") = "
				+ queue.offer(number));
		System.out.println();

		// test wrapping around circular array
		System.out.println("test wrapping around circular array");
		System.out.println("queue.poll() = " + queue.poll());
		for (int i = 0; i < 20; i++) {
			System.out.println("queue.poll() = " + queue.poll());
			System.out.println("queue.poll() = " + queue.poll());
			System.out.println("queue.poll() = " + queue.poll());
			System.out.println("queue.poll() = " + queue.poll());
			System.out.println("queue.poll() = " + queue.poll());
			System.out.println("queue.poll() = " + queue.poll());
			number = number + 10;
			System.out.println("queue.offer(" + number + ") = "
					+ queue.offer(number));
			number = number + 10;
			System.out.println("queue.offer(" + number + ") = "
					+ queue.offer(number));
			number = number + 10;
			System.out.println("queue.offer(" + number + ") = "
					+ queue.offer(number));
			number = number + 10;
			System.out.println("queue.offer(" + number + ") = "
					+ queue.offer(number));
			number = number + 10;
			System.out.println("queue.offer(" + number + ") = "
					+ queue.offer(number));
			number = number + 10;
			System.out.println("queue.offer(" + number + ") = "
					+ queue.offer(number));
		}

	}// end of main()

}// end of class

/*PROGRAM OUTPUT:
Is queue empty? true
queue.poll() = null
queue.peek() = null

queue.offer(10) = true
Is queue empty? false
queue.offer(20) = true
Is queue empty? false
queue.offer(30) = true
Is queue empty? false
queue.offer(40) = true
Is queue empty? false
queue.offer(50) = true
Is queue empty? false

test offer to full queue
queue.offer(70) = false
queue.offer(80) = false

test wrapping around circular array
queue.poll() = 10
queue.poll() = 20
queue.poll() = 30
queue.poll() = 40
queue.poll() = 50
queue.poll() = null
queue.poll() = null
queue.offer(90) = true
queue.offer(100) = true
queue.offer(110) = true
queue.offer(120) = true
queue.offer(130) = true
queue.offer(140) = false
queue.poll() = 90
queue.poll() = 100
queue.poll() = 110
queue.poll() = 120
queue.poll() = 130
queue.poll() = null
queue.offer(150) = true
queue.offer(160) = true
queue.offer(170) = true
queue.offer(180) = true
queue.offer(190) = true
queue.offer(200) = false
queue.poll() = 150
queue.poll() = 160
queue.poll() = 170
queue.poll() = 180
queue.poll() = 190
queue.poll() = null
queue.offer(210) = true
queue.offer(220) = true
queue.offer(230) = true
queue.offer(240) = true
queue.offer(250) = true
queue.offer(260) = false
queue.poll() = 210
queue.poll() = 220
queue.poll() = 230
queue.poll() = 240
queue.poll() = 250
queue.poll() = null
queue.offer(270) = true
queue.offer(280) = true
queue.offer(290) = true
queue.offer(300) = true
queue.offer(310) = true
queue.offer(320) = false
queue.poll() = 270
queue.poll() = 280
queue.poll() = 290
queue.poll() = 300
queue.poll() = 310
queue.poll() = null
queue.offer(330) = true
queue.offer(340) = true
queue.offer(350) = true
queue.offer(360) = true
queue.offer(370) = true
queue.offer(380) = false
queue.poll() = 330
queue.poll() = 340
queue.poll() = 350
queue.poll() = 360
queue.poll() = 370
queue.poll() = null
queue.offer(390) = true
queue.offer(400) = true
queue.offer(410) = true
queue.offer(420) = true
queue.offer(430) = true
queue.offer(440) = false
queue.poll() = 390
queue.poll() = 400
queue.poll() = 410
queue.poll() = 420
queue.poll() = 430
queue.poll() = null
queue.offer(450) = true
queue.offer(460) = true
queue.offer(470) = true
queue.offer(480) = true
queue.offer(490) = true
queue.offer(500) = false
queue.poll() = 450
queue.poll() = 460
queue.poll() = 470
queue.poll() = 480
queue.poll() = 490
queue.poll() = null
queue.offer(510) = true
queue.offer(520) = true
queue.offer(530) = true
queue.offer(540) = true
queue.offer(550) = true
queue.offer(560) = false
queue.poll() = 510
queue.poll() = 520
queue.poll() = 530
queue.poll() = 540
queue.poll() = 550
queue.poll() = null
queue.offer(570) = true
queue.offer(580) = true
queue.offer(590) = true
queue.offer(600) = true
queue.offer(610) = true
queue.offer(620) = false
queue.poll() = 570
queue.poll() = 580
queue.poll() = 590
queue.poll() = 600
queue.poll() = 610
queue.poll() = null
queue.offer(630) = true
queue.offer(640) = true
queue.offer(650) = true
queue.offer(660) = true
queue.offer(670) = true
queue.offer(680) = false
queue.poll() = 630
queue.poll() = 640
queue.poll() = 650
queue.poll() = 660
queue.poll() = 670
queue.poll() = null
queue.offer(690) = true
queue.offer(700) = true
queue.offer(710) = true
queue.offer(720) = true
queue.offer(730) = true
queue.offer(740) = false
queue.poll() = 690
queue.poll() = 700
queue.poll() = 710
queue.poll() = 720
queue.poll() = 730
queue.poll() = null
queue.offer(750) = true
queue.offer(760) = true
queue.offer(770) = true
queue.offer(780) = true
queue.offer(790) = true
queue.offer(800) = false
queue.poll() = 750
queue.poll() = 760
queue.poll() = 770
queue.poll() = 780
queue.poll() = 790
queue.poll() = null
queue.offer(810) = true
queue.offer(820) = true
queue.offer(830) = true
queue.offer(840) = true
queue.offer(850) = true
queue.offer(860) = false
queue.poll() = 810
queue.poll() = 820
queue.poll() = 830
queue.poll() = 840
queue.poll() = 850
queue.poll() = null
queue.offer(870) = true
queue.offer(880) = true
queue.offer(890) = true
queue.offer(900) = true
queue.offer(910) = true
queue.offer(920) = false
queue.poll() = 870
queue.poll() = 880
queue.poll() = 890
queue.poll() = 900
queue.poll() = 910
queue.poll() = null
queue.offer(930) = true
queue.offer(940) = true
queue.offer(950) = true
queue.offer(960) = true
queue.offer(970) = true
queue.offer(980) = false
queue.poll() = 930
queue.poll() = 940
queue.poll() = 950
queue.poll() = 960
queue.poll() = 970
queue.poll() = null
queue.offer(990) = true
queue.offer(1000) = true
queue.offer(1010) = true
queue.offer(1020) = true
queue.offer(1030) = true
queue.offer(1040) = false
queue.poll() = 990
queue.poll() = 1000
queue.poll() = 1010
queue.poll() = 1020
queue.poll() = 1030
queue.poll() = null
queue.offer(1050) = true
queue.offer(1060) = true
queue.offer(1070) = true
queue.offer(1080) = true
queue.offer(1090) = true
queue.offer(1100) = false
queue.poll() = 1050
queue.poll() = 1060
queue.poll() = 1070
queue.poll() = 1080
queue.poll() = 1090
queue.poll() = null
queue.offer(1110) = true
queue.offer(1120) = true
queue.offer(1130) = true
queue.offer(1140) = true
queue.offer(1150) = true
queue.offer(1160) = false
queue.poll() = 1110
queue.poll() = 1120
queue.poll() = 1130
queue.poll() = 1140
queue.poll() = 1150
queue.poll() = null
queue.offer(1170) = true
queue.offer(1180) = true
queue.offer(1190) = true
queue.offer(1200) = true
queue.offer(1210) = true
queue.offer(1220) = false
queue.poll() = 1170
queue.poll() = 1180
queue.poll() = 1190
queue.poll() = 1200
queue.poll() = 1210
queue.poll() = null
queue.offer(1230) = true
queue.offer(1240) = true
queue.offer(1250) = true
queue.offer(1260) = true
queue.offer(1270) = true
queue.offer(1280) = false
 */