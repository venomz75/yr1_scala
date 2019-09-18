package gfx

object Canvas {
  import Array._
  import Compass._
  
  private val DEFAULT_DIRECTION: Direction = N
  private val DEFAULT_BACKGROUND: Char     = '.'
  private val DEFAULT_NIB: Char            = '*' 
  private val DEFAULT_WIDTH                = 60
  private val DEFAULT_HEIGHT               = 15
  private val Xmax: Int                    = DEFAULT_WIDTH - 1
  private val Ymax: Int                    = DEFAULT_HEIGHT - 1

  private var x: Int = 0
  private var y: Int = 0
  private var direction: Direction = DEFAULT_DIRECTION
  private var background: Char     = DEFAULT_BACKGROUND
  private var nib: Char            = DEFAULT_NIB
  private var writing: Boolean     = false
  private var grid: Array[Array[Option[Char]]]
                                   = ofDim[Option[Char]](DEFAULT_WIDTH, DEFAULT_HEIGHT)
  
  /**
   * Accessor methods - public functions to return current state values
   */
  def getX: Int = x
  def getY: Int = y
  def getXY: (Int,Int) = (x, y)
  def getDirection: Direction = direction
  def getBackground: Char = background
  def getNib: Char = nib
  def isWriting: Boolean = writing

  /**
   * Mutator methods to set the x,y coordinates.  The use of max and min
   * ensure that the pen is not placed outside the border of the canvas
   */
  def setX(newX: Int)             { x = Math.min(Math.max(0, newX), Xmax) }
  def setY(newY: Int)             { y = Math.min(Math.max(0, newY), Ymax) }
  def setXY(newX: Int, newY: Int) { setX(newX) ; setY( newY ) }

  /**
   * Mutator methods to set the drawing attributes
   */
  def setDirection(d: Direction) { direction = d }
  def setBackground(bg: Char)    { background = bg }
  def setNib(n: Char)            { nib = n }

  /**
   * Mutator methods to switch on/off the pen's writing action
   */
  def startWriting(): Unit = { writing = true }
  def stopWriting(): Unit  = { writing = false }
  
  /**
   * Reset the canvas to an initial state. All the cells are set to blank. A blank
   * cell is represented by the value None - an Option value that contains nothing.
   */
  def reset() {
    x          = 0
    y          = 0
    direction  = DEFAULT_DIRECTION
    background = DEFAULT_BACKGROUND
    nib        = DEFAULT_NIB
    writing    = false
    for (i <- 0 to Xmax; j <- 0 to Ymax)
      grid(i)(j) = None
  }
  
   /**
   * Paint the canvas on the screen (console). Do this by traversing each row and
   * within each row printing each cell in the grid. If the cell is empty (None) then
   * print the background character; otherwise print the character that was written
   * into that cell (i.e. whatever was the nib of the pen at the time). 
   */
  def paint() {
    for (j <- Ymax to 0 by -1) {
      for (i <- 0 to Xmax)
        grid(i)(j) match {
                     case None => print(background)
                     case Some(c) => print(c)
                   }
      println
    }
  }
  
 /**
   * Move the cursor one place in the current direction of travel. If the writing nib
   * is down then leave a mark.  Then adjust the (x, y) coordinates to reflect the new
   * position without moving off the canvas.
   */
  def move() {
    if (isWriting)   // if pen is down then mark the canvas
      grid(x)(y) = Some(nib)
      
    direction match { // Adjust (x, y) without moving off the canvas
      case N  => if (y<Ymax)             y = y + 1
      case NE => if (y<Ymax && x<Xmax) { y = y + 1; x = x + 1 }
      case E  => if (x<Xmax)                        x = x + 1
      case SE => if (y>0    && x<Xmax) { y = y - 1; x = x + 1 }
      case S  => if (y>0)                y = y - 1
      case SW => if (y>0    && x>0)    { y = y - 1; x = x - 1 }
      case W  => if (x>0)                           x = x - 1
      case NW => if (y<Ymax && x>0)    { y = y + 1; x = x - 1 }
    } 
  }
  
  /**
   * Turn the pen direction either left or right by 45 degrees
   */
  def turn(leftOrRight: Direction => Direction) {
    direction = leftOrRight(direction)
  }
  
  /**
   * Repeat an action n times (n). This is just a shorthand for writing
   * for(i <- 1 to n).  This works because in Scala for is a curried function
   * whose second argument is a block of code.  In Scala this can be written
   * in braces { ... } so the result looks like a conventional control structure.
   * Thus we could write   repeat(3){ move() ; turn(right) }
   */
  def repeat(n: Int)(a: =>Unit) = for (i <- 1 to n){a}

  /**
   * Move n times. This makes use of the repeat function.
   */
  def move(n: Int) {
    repeat(n) {
      move()
    }
  }
  
  /**
   * Turn (left or right) n times. This makes use of the repeat function.
   */
  def turn(leftOrRight: Direction => Direction, n: Int) {
    repeat(n) {
      turn(leftOrRight)
    }
  }
  
  /**
   * A quick way to draw a square of side n: draw a line of side n and then turn 90
   * degrees, four times.
   */
  def square(n: Int) {
    repeat(4) {
      move(n)
      turn(right,2)
    }
  }
  
  /**
   * A quick way to draw an isosceles triangle with base of length b. Only looks
   * good if the base is an even length.
   */
  def tri(b: Int) {
    move(b)
    turn(right, 3)
    move(b/2)
    turn(right, 2)
    move(b/2)
    turn(right, 3)
  }
  
  def rect(x: Int, y:Int) {
    repeat(2) {
      move(x)
      turn(right,2)
      move(y)
      turn(right,2)
    }
  }
  
  def fillsquare(x: Int) {
    var y = x
      repeat(4) {
        move(x)
        turn(right,2)
      }
      repeat(x) {
        repeat(4) {
          move(y)
          turn(right,2)   
        }
      y -= 1
      }   
  }
  
  def star(x: Int) {
    repeat(8) {
      move(x)
      turn(right,4)
      move(x)
      turn(left,3)
    }    
  }
  
  def spiral(x: Int,y: Int) {
    var z = x
    repeat(y) {
      move(z)
      turn(right,2)
      move(z)
      turn(right,2)
      z += 2
    } 
  }
  
  def checkerboard(m: Int, n: Int) {
    var x = getX
    var y = getY
    var nib = getNib
    var background = getBackground
    var ink = true
    repeat (m) {
      repeat(m) {
        if (ink == true) setNib(nib) else setNib(background)
        setDirection(N)
        startWriting()
        fillsquare(n-1)
        stopWriting()
        turn(right,2)
        move(n)
        if (ink == true) ink = false else if (ink == false) ink = true
      }
      setXY(x,y)
      setDirection(N)
      move(n)
      x = getX
      y = getY
      if (m % 2 == 0) {if (ink == true) ink = false else if (ink == false) ink = true}     
    }
  }
  
  def zero() {
    setDirection(N)
    setNib('#')
    stopWriting()
    move(1)
    startWriting()
    move(2)
    stopWriting()
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(right,2)
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(right,2)
    move(1)
    startWriting()
    move(2)
    stopWriting()
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(right,2)
    move(1)
    startWriting()
    move(2)
  }
  
  def one() {
    setDirection(N)
    setNib('#')
    stopWriting()
    turn(right,2)
    move(3)
    turn(left,2)
    move(1)
    startWriting()
    move(2)
    stopWriting()
    move(1)
    startWriting()
    move(2)
  }
  
  def two() {
    setDirection(N)
    setNib('#')
    stopWriting()
    turn(right,2)
    move(2)
    turn(right,4)
    startWriting()
    move(2)
    stopWriting()
    move(1)
    turn(right,2)
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(right,2)
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(left,2)
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(left,2)
    move(1)
    startWriting()
    move(2)
  }
  
  def three() {
    setDirection(N)
    setNib('#')
    turn(right,2)
    stopWriting()
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(left,2)
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(left,2)
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(left,4)
    move(3)
    stopWriting()
    turn(left,2)
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(left,2)
    move(1)
    startWriting()
    move(2)
  }
  
  def four() {
    setDirection(N)
    setNib('#')
    stopWriting()
    move(5)
    turn(right,4)
    startWriting()
    move(2)
    stopWriting()
    turn(left,2)
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(left,2)
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(right,4)
    move(4)
    startWriting()
    move(2)
  }
  
  def five() {
    setDirection(N)
    setNib('#')
    stopWriting()
    turn(right,2)    
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(left,2)    
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(left,2)
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(right,2)    
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(right,2)    
    move(1)
    startWriting()
    move(2) 
  }
  
  def six() {
    setDirection(N)
    setNib('#')
    stopWriting()
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(right,4)
    move(3)
    turn(left,2)    
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(left,2)    
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(left,2)
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(right,2)    
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(right,2)    
    move(1)
    startWriting()
    move(2) 
  }
  
  def seven() {
    setDirection(N)
    setNib('#')
    stopWriting()
    turn(right,2)
    move(3)
    turn(left,2)
    move(1)
    startWriting()
    move(2)
    stopWriting()
    move(1)
    startWriting()
    move(2)
    stopWriting()
    turn(left,2)
    move(1)
    startWriting()
    move(2)
  }
  
  def eight() {
    setDirection(N)
    setNib('#')
    stopWriting()
    move(1)
    startWriting()
    move(2)//
    stopWriting()
    turn(right,2)
    move(1)
    startWriting()
    move(2)
    turn(right,4)
    stopWriting()
    move(3)
    turn(right,2)
    move(1)  
    startWriting()
    move(2)//
    stopWriting()
    turn(right,2)
    move(1)
    startWriting()
    move(2)//
    stopWriting()
    turn(right,2)
    move(1)
    startWriting()
    move(2)//
    stopWriting()
    move(1)
    startWriting()
    move(2)//
    stopWriting()
    turn(right,2)
    move(1)
    startWriting()
    move(2)//
  }
  
  def nine() {
    setDirection(N)
    setNib('#')
    stopWriting()
    move(3)
    turn(right,2)
    move(1)
    startWriting()
    move(2)
    turn(right,4)
    stopWriting()
    move(3)
    turn(right,2)
    move(1)  
    startWriting()
    move(2)//
    stopWriting()
    turn(right,2)
    move(1)
    startWriting()
    move(2)//
    stopWriting()
    turn(right,2)
    move(1)
    startWriting()
    move(2)//
    stopWriting()
    move(1)
    startWriting()
    move(2)//
    stopWriting()
    turn(right,2)
    move(1)
    startWriting()
    move(2)//
  }
  
  def number(n:Long) {
    var number = n.toString
    var x = getX
    var y = getY
    for (i <- 0 to number.length-1) {
        number.charAt(i) match {
          case '0' => zero()
          case '1' => one()
          case '2' => two()
          case '3' => three()
          case '4' => four()
          case '5' => five()
          case '6' => six()
          case '7' => seven()
          case '8' => eight()
          case '9' => nine()
        }
        setXY(x+6,y)
    }
  }
  /* Before anything else, this happens... */  
  reset()

}