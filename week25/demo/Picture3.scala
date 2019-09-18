package demo

object Picture3 {
  
  import gfx.Layer
  import gfx.Image
  
  def main(args: Array[String]): Unit = {
    val zero: Layer = new Layer(40,20,'0')
    val one: Layer = new Layer(50,15,'1')
    
    zero.setXY(20,5)
    zero.startWriting()
    zero.square(7)
    one.setXY(23,8)
    one.startWriting()
    one.square(7)

    zero.paint()
    one.paint()
  }
}