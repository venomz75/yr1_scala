import scala.io.StdIn.readInt

object TwoDimensionalDisplay {
  def main(args: Array[String]): Unit = {
    var height, width = 10
    
    //print("Height? ")
    //height = readInt(); 
    //height += 2
    //print("\nWidth? ")
    //width = readInt(); 
    //width += 2
    
    var table = Array.ofDim[Char](height,width)
       
    var o, a = 0  
    var p = table.length - 1
    var q = table(0).length -1
    
    while (o < table.length) {
      while (a < table(o).length) {
        table(o)(a) = '.'
        a += 1
      }
      o += 1
      a = 0
    }
    
    o = 0; a = 0
    while (o < table(0).length) {//horizontal walls
      table(0)(o) = '#'
      table(p)(o) = '#'
      o += 1
    }
    
    o = 0
    while (o < table.length) {//vertical walls
      table(o)(0) = '#'
      table(o)(q) = '#'
      o += 1
    }
    
    o = 0
    var random = scala.util.Random
    var rC = 1 + random.nextInt(( 9 - 1) + 1)
    var rX = 1 + random.nextInt(( 9 - 1) + 1)
    var rY = 1 + random.nextInt(( 9 - 1) + 1)
    while (o < rC) {//obstacles

      table(rY)(rX) = '#'
      o += 1
      if (rY < 10){
        rY += 1
      }
    }
    
    var x = width / 2
    var y = height / 2
    table(y)(x) = '@'
    var input = ' '
    print("\n" * 20)
    do {     
      var i = 0
      while (i < table.length) {
        var j = 0
        while (j < table(i).length) {
          print(table(i)(j))
          j += 1
        }
        print("\n")
        i += 1
      }
      
      var input = readChar()
      if (input == 'w' && (table(y-1)(x) != '#')) {
        print("\n" * 20)
        table(y-1)(x) = table(y)(x)
        table(y)(x) = '.'
        y -= 1
      } else if (input == 'd' && (table(y)(x+1) != '#')) {
        print("\n" * 20)
        table(y)(x+1) = table(y)(x)
        table(y)(x) = '.'
        x += 1
      } else if (input == 's' && (table(y+1)(x) != '#')) {
        print("\n" * 20)
        table(y+1)(x) = table(y)(x)
        table(y)(x) = '.'
        y += 1
      }
       else if (input == 'a' && (table(y)(x-1) != '#')) {
        print("\n" * 20)
        table(y)(x-1) = table(y)(x)
        table(y)(x) = '.'
        x -= 1
       } else {
         print("\n" * 20)
       }
    } while (input != 'x')
      println("Exiting...")
  }
}