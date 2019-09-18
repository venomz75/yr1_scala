

object SimpleStrings {
  def main(args: Array[String]): Unit = {
     var s1: String = "Dealing with strings"
     var s2: String = "Playing"
     var s3: String = s2 + s1.substring(7)
     println(s3)
     println(s3.toUpperCase)
     println(s3.substring(0, 7))
     println(s3.startsWith(s2))
     println(s3.endsWith(s1))
     println(s3.substring(0,13) + s3.substring(13,14).toUpperCase + s3.substring(14))
  }
}