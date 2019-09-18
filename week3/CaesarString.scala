

object CaesarString {
  def main(args: Array[String]): Unit = {
      var oriString: String = "";
      oriString = readLine();
      var i: Int = oriString.length;
      var j: Int = 0;
      while (i > j) {
        var oriChar: Char = oriString(j);
      	var encChar = (oriChar+ 4);
      	if (encChar > 122) {
      	  encChar = encChar - 26
      	}
      	var newchar: Char = encChar.toChar	
      	print(newchar)
      	j = j + 1;
      }   	
  }
}