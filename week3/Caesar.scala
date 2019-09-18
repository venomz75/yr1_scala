object Caesar {
	def main(args: Array[String]): Unit = {
			var original: Char = readChar();
    	var encrypted = (original + 4);
    	if (encrypted > 122) {
    	  encrypted = encrypted - 26
    	}
    	var newchar: Char = encrypted.toChar	
    	println(newchar)
	}
}