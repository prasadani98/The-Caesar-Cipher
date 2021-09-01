object code{
  def main(args : Array[String]) {

    val upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val lowerCase = "abcdefghijklmnopqrstuvwxyz"

    val Encryption = (c: Char, key: Int) =>
      if (c >= 'a' && c <= 'z') lowerCase((lowerCase.indexOf(c) + key) % lowerCase.length)
      else if (c >= 'A' && c <= 'Z') upperCase((upperCase.indexOf(c) + key) % upperCase.length)
      else ' '

    val Decryption = (c: Char, key: Int) =>
      if (c >= 'a' && c <= 'z')
        if(lowerCase.indexOf(c)-key>=0) lowerCase((lowerCase.indexOf(c) - key) % lowerCase.length)
        else lowerCase(lowerCase.length + (lowerCase.indexOf(c) - key) % lowerCase.length)
      else if (c >= 'A' && c <= 'Z')
        if(upperCase.indexOf(c)-key>=0) upperCase((upperCase.indexOf(c) - key) % upperCase.length)
        else upperCase(upperCase.length + (upperCase.indexOf(c) - key) % upperCase.length)
      else ' '

    val cipher = (algo: (Char, Int) => AnyVal, s: String, key: Int) => s.map(x => algo(x, key)).mkString("")

    //val s1 =scala.io.StdIn.readLine()
    //val key =scala.io.StdIn.readInt()
    //val cs =cipher(Encryption, s1, key)
    //println(cs)

    val s = "Hello World"

    val ct =cipher(Encryption, s, 3)
    println(ct)

    val pt = cipher(Decryption,ct, 3)
    println(pt)
  }
}
