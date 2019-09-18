package demo

object Picture5 {
  
  import gfx.Layer
  import gfx.Image
  import gfx.Compass._
  
  def main(args: Array[String]): Unit = {
    val layers = (0 to 9) map (i => new Layer(40, 15, (i+48).toChar, ' ', N, true))
    
    for (i <- 0 to 9) {
      layers(i).setXY(i*3, i)
      layers(i).filledSquare(5)
    }
    
    val image = new Image(layers(9))

    for (i <- 8 to 0 by -1)
      if (i % 2 == 0) {
        layers(i).flipAboutHorizontal
        image.push(layers(i))
      }
      else {
        image.push(layers(i))
      }  

    image.paint()
    
//    layers map (_.flipAboutHorizontal())
//    image.paint()
//   
//    image.reverseLayers()
//    image.paint()
//    
//    image.moveLayerToTop(5)
//    image.paint()
    
  }
}