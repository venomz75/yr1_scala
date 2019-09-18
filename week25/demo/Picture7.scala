package demo

object Picture7 {
  
  import gfx.Layer
  import gfx.Image
  import gfx.Compass._
  
  def main(args: Array[String]): Unit = {
    val layers = (0 to 9) map (i => new Layer(50, 30,'*', '-', N, true))
    var x = 25
    var y = 15
    layers(0).setXY(x,y)
    layers(0).setNib('#')
    layers(0).star(2)
    
    layers(1).setXY(x-2,y)
    layers(1).setNib('*')
    layers(1).star(3)
    layers(1).setXY(x+2,y)
    layers(1).setNib('*')
    layers(1).star(3)
    layers(1).setXY(x,y-2)
    layers(1).setNib('*')
    layers(1).star(3)
    layers(1).setXY(x,y+2)
    layers(1).setNib('*')
    layers(1).star(3)
    
    layers(2).setXY(x-5,y)
    layers(2).setNib(''')
    layers(2).star(4)
    layers(2).setXY(x+5,y)
    layers(2).setNib(''')
    layers(2).star(4)
    layers(2).setXY(x,y-5)
    layers(2).setNib(''')
    layers(2).star(4)
    layers(2).setXY(x,y+5)
    layers(2).setNib(''')
    layers(2).star(4)
    
    layers(3).setXY(x,y)
    layers(3).setNib('/')
    layers(3).setDirection(NE)
    layers(3).move(10)
    layers(3).turn(right, 4)
    layers(3).move(20)
    
    layers(4).setXY(x,y)
    layers(4).setNib('\\')
    layers(4).setDirection(NW)
    layers(4).move(10)
    layers(4).turn(right, 4)
    layers(4).move(20)
    
    layers(5).setXY(x,y)
    layers(5).setNib('|')
    layers(5).setDirection(N)
    layers(5).move(10)
    layers(5).turn(right, 4)
    layers(5).move(20)
    
    layers(6).setXY(x,y)
    layers(6).setNib('=')
    layers(6).setDirection(E)
    layers(6).move(10)
    layers(6).turn(right, 4)
    layers(6).move(20)
    val image = new Image(layers(9))

    for (i <- 9 to 0 by -1)
    image.push(layers(i)) 
    image.paint()
    
//    layers map (_.flipAboutHorizontal())
//    image.paint()
//   
    image.reverseLayers()
    image.paint()
//    
//    image.moveLayerToTop(5)
//    image.paint()
    
  }
}