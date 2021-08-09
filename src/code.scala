object code{
  def main(args : Array[String]) {

    val upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val lowerCase = "abcdefghijklmnopqrstuvwxyz"

    val Encryption = (c: Char, key: Int) => if (c >= 'a' && c <= 'z') lowerCase((lowerCase.indexOf(c) + key) % 26)
    else if (c >= 'A' && c <= 'Z') upperCase((upperCase.indexOf(c) + key) % 26)
    else ' '

    val Decryption = (c: Char, key: Int) => if (c >= 'a' && c <= 'z') lowerCase((lowerCase.indexOf(c) - key) % 26)
    else if (c >= 'A' && c <= 'Z') upperCase((upperCase.indexOf(c) - key) % 26)
    else ' '

    val cipher = (algo: (Char, Int) => AnyVal, s: String, key: Int) => s.map(x => algo(x, key)).mkString("")

    val s = "Hello World"

    val ct =cipher(Encryption, s, 3)
    println(ct)

    val pt = cipher(Decryption,ct, 3)
    println(pt)
  }
}
