package gfx

class Image(initLayer: Layer) {
  
  /**
   * An image must have at least one layer. This is the top of the stack and
   * is initialised to the initial layer provided upon creation of the image
   */
  private var layers: List[Layer] = List(initLayer)  // Layer zero is the top of the stack
  private var background: Char = initLayer.getBackground
  
  /**
   * Set new background character
   */
  def setBackground(bg: Char) {
    background = bg
  }
  
  /**
   * Return the largest x-dimension/y-dimension from all of the stacked layers
   */
  def maxX: Int = layers.map(_.getXmax).max
  def maxY: Int = layers.map(_.getYmax).max
  
  def getNumberOfLayers: Int = layers.length
  
  /**
   * Return the layer number (index) of the first non-None pixel at given co-ordinate
   */
  def getActiveLayer(i: Int, j: Int): Int =
    layers.takeWhile(_.getPixelAt(i,j).isEmpty).length
  
  /**
   * Return the top-most active pixel at given co-ordinate
   */
  def getActivePixel(i: Int, j: Int): Option[Char] = {
    val idx = getActiveLayer(i,j)
    if (idx == layers.length) // then there is no active pixel (all are None at (i,j))
      None
    else
      layers(idx).getPixelAt(i, j)
  }
  
  /**
   * Move given layer to top
   */
  def moveLayerToTop(idx: Int) {
    if (idx >= 0 && idx < layers.length)
      layers = layers(idx) :: (layers.take(idx) ++ layers.drop(idx+1)) 
  }
  
  /**
   * Move active layer to top
   */
  def moveActiveLayerToTop(i: Int, j: Int) {
    val idx = getActiveLayer(i,j)
    moveLayerToTop(idx)
  }
  
  /**
   * Push a new layer onto the top of the current picture
   */
  def push(layer: Layer) {
    layers = layer :: layers
  }
 
  /**
   * Insert a layer into the current picture
   */
  def insertLayer(i: Int, layer: Layer) {
    layers = layers.take(i) ++ (layer :: layers.drop(i))
  }
 
  /**
   * Removes a specified layer from the image
   */
  def removeLayer(i: Int) {
    layers = layers.take(i) ++ layers.drop(i+1)
  }
  
  /**
   * Reverse the order of the layers
   */
  def reverseLayers() {
    layers = layers.reverse
  }
  
  /**
   * Paint the image on the terminal (console). It is as if the bottom-most layers
   * are painted first, and then each subsequent layer is overlayed on top of the
   * previous ones as the picture is built up.  The top-most layer (0) is the last
   * one to be painted. Of course, this description only describes the finished
   * result. It is actually printed more directly, using the method getActivePixel
   * to get the pixel which is "top-most" for the given co-ordinates.
   */
  def paint() {
    for (j <- maxY to 0 by -1) {
      for (i <- 0 to maxX)
        getActivePixel(i,j) match {
                     case None => print(background)
                     case Some(c) => print(c)
                   }
      println
    }
  }
  
}