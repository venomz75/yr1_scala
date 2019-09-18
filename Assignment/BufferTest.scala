package sed2

import org.junit.Test
import junit.framework.TestCase
import org.junit.Assert._
import sed2.Buffer

class BufferTest {
  
  val zeroString: String = ""                                                         // has no chars
  val unitString: String = "u"                                                        // has one char
  val message: String = "Functional programming is a great way to write code"         // has 51 chars including spaces
  val party: String = "Now Is The Time For All Good Men To Come To The Aid Of Parity" // has 61 chars including spaces 
  val word: String = "aardvark"                                                       // has eight chars
  
  var cursorBefore = 0
  var markerBefore = 0
  var stringBefore = ""
  var pasteBefore = ""
  var buf: Buffer = _

  def initialiseTest(str: String) {
    buf = new Buffer(str)
    cursorBefore = buf.getCursor;
    markerBefore = buf.getMarker;
    stringBefore = buf.getString;
    pasteBefore  = buf.getPaste;
  }
  
  // AL and AR
  
  @Test def test_00_ar {
    initialiseTest(zeroString)
    buf.ar()
    assertEquals(0, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_01_ar {
    initialiseTest(unitString)
    buf.ar()
    assertEquals(1, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_02_ar {
    initialiseTest(message)
    buf.ar()
    assertEquals(1, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_03_al {
    initialiseTest(zeroString)
    buf.al()
    assertEquals(0, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_04_al {
    initialiseTest(unitString)
    buf.al()
    assertEquals(1, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_05_al {
    initialiseTest(message)
    buf.al()
    assertEquals(message.length, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
    
  // GO
  
  @Test def test_06_go {
    initialiseTest(zeroString)
    buf.go(0)
    assertEquals(0, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_07_go {
    initialiseTest(zeroString)
    buf.go(1)
    assertEquals(cursorBefore, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_08_go {
    initialiseTest(unitString)
    buf.go(1)
    assertEquals(1, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_09_go {
    initialiseTest(unitString)
    buf.go(2)
    assertEquals(cursorBefore, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
 }
  @Test def test_10_go {
    initialiseTest(unitString)
    buf.go(-1)
    assertEquals(cursorBefore, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_11_go {
    initialiseTest(message)
    buf.go(message.length)
    assertEquals(message.length, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
}
  @Test def test_12_go {
    initialiseTest(message)
    buf.go(message.length)
    buf.al
    assertEquals(message.length-1, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
 }
  @Test def test_13_go {
    initialiseTest(unitString)
    buf.go(1)
    buf.ar
    assertEquals(0, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_14_go {
    initialiseTest(message)
    buf.go(message.length)
    buf.ar
    assertEquals(0, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_15_go {
    initialiseTest(message)
    buf.go(message.length/2)
    assertEquals(message.length/2, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_16_go {
    initialiseTest(message)
    buf.go(message.length+1)
    buf.go(message.length/2)
    assertEquals(message.length/2, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  
    // TL and TR

  @Test def test_17_tr {
    initialiseTest(zeroString)
    buf.tr()
    assertEquals(0, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_18_tr {
    initialiseTest(unitString)
    buf.tr()
    assertEquals(1, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_19_tr {
    initialiseTest(message)
    buf.tr()
    assertEquals(message.length, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_20_tl {
    initialiseTest(zeroString)
    buf.tl()
    assertEquals(0, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_21_tl {
    initialiseTest(unitString)
    buf.tl()
    assertEquals(0, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_22_tl {
    initialiseTest(message)
    buf.tl()
    assertEquals(0, buf.getCursor)
    assertEquals(markerBefore, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
 
    // DR

  @Test def test_23_dr {
    initialiseTest(message)
    val buf = this.buf; import buf._ ; go(message.length/2); dr
    assertEquals(message.length/2, getMarker)
    assertEquals(message.length/2, buf.getCursor)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
}
  @Test def test_24_dr {
    initialiseTest(message)
    val buf = this.buf; import buf._ ; go(message.length/2); dr ; ar
    assertEquals(message.length/2, getMarker)
    assertEquals(message.length/2+1, buf.getCursor)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  
  // DA
  
  @Test def test_25_da {
    initialiseTest(zeroString)
    buf.da()
    assertEquals(0, buf.getCursor)
    assertEquals(0, buf.getMarker)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_26_da {
    initialiseTest(unitString)
    buf.da()
    assertEquals(0, buf.getMarker)
    assertEquals(1, buf.getCursor)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_27_da {
    initialiseTest(message)
    buf.da()
    assertEquals(0, buf.getMarker)
    assertEquals(message.length, buf.getCursor)
    assertEquals(stringBefore, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  
  // ES
  
  @Test def test_28_es {
    initialiseTest(zeroString)
    buf.es("")
    assertEquals(0, buf.getCursor)
    assertEquals(0, buf.getMarker)
    assertEquals(zeroString, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_29_es {
    initialiseTest(zeroString)
    buf.es("z")
    assertEquals(1, buf.getCursor)
    assertEquals(0, buf.getMarker)
    assertEquals("z", buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_30_es {
    initialiseTest(unitString)
    buf.es("")
    assertEquals(0, buf.getCursor)
    assertEquals(0, buf.getMarker)
    assertEquals(unitString, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_31_es {
    initialiseTest(unitString)
    buf.es("z")
    assertEquals(1, buf.getCursor)
    assertEquals(0, buf.getMarker)
    assertEquals("zu", buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_32_es {
    initialiseTest(unitString)
    buf.ar();
    buf.es("")
    assertEquals(1, buf.getCursor)
    assertEquals(0, buf.getMarker)
    assertEquals(unitString, buf.getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_33_es {
    initialiseTest(message)
    val buf = this.buf; import buf._ 
    go(message.length/2); es("")
    assertEquals(message.length/2, getCursor)
    assertEquals(0, getMarker)
    assertEquals(message, getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_34_es {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    go(4); es("XX")
    assertEquals(6, buf.getCursor)
    assertEquals(0, buf.getMarker)
    assertEquals("aardXXvark", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_35_es {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    tr; es("XX")
    assertEquals(word.length+2, getCursor)
    assertEquals(0, getMarker)
    assertEquals("aardvarkXX", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  
  // XC
  
  @Test def test_36_xc {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    go(2); dr; xc
    assertEquals(2, getCursor)
    assertEquals(2, getMarker)
    assertEquals(word, getString)
    assertEquals("", getPaste)
  }
  @Test def test_37_xc {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    go(4); dr; ar; ar; ar; xc
    assertEquals(7, getCursor)
    assertEquals(4, getMarker)
    assertEquals(word, getString)
    assertEquals("var", getPaste)
  }
  @Test def test_38_xc {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    dr; rpt(4)(ar); xc
    assertEquals(4, getCursor)
    assertEquals(0, getMarker)
    assertEquals(word, getString)
    assertEquals("aard", getPaste)
  }
  @Test def test_39_xc {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    da; xc
    assertEquals(word.length, getCursor)
    assertEquals(0, getMarker)
    assertEquals(word, getString)
    assertEquals(word, getPaste)
  }
  @Test def test_40_xc {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    tr; dr; al; al; xc
    assertEquals(word.length-2, getCursor)
    assertEquals(word.length, getMarker)
    assertEquals(word, getString)
    assertEquals("rk", getPaste)
  }
  
  // XD
  
  @Test def test_41_xd {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    go(2); dr; xd
    assertEquals(2, getCursor)
    assertEquals(2, getMarker)
    assertEquals("aardvark", getString)
    assertEquals("", getPaste)
  }
  @Test def test_42_xd {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    go(4); dr; ar; ar; ar; xd
    assertEquals(4, getCursor)
    assertEquals(4, getMarker)
    assertEquals("aardk", getString)
    assertEquals("var", getPaste)
  }
  @Test def test_43_xd {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    dr; rpt(4)(ar); xd
    assertEquals(0, getCursor)
    assertEquals(0, getMarker)
    assertEquals("vark", getString)
    assertEquals("aard", getPaste)
  }
  @Test def test_44_xd {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    da; xd
    assertEquals(0, getCursor)
    assertEquals(0, getMarker)
    assertEquals("", getString)
    assertEquals("aardvark", getPaste)
  }
  @Test def test_45_xd {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    tr; dr; al; al; xd
    assertEquals(word.length-2, getCursor)
    assertEquals(word.length-2, getMarker)
    assertEquals("aardva", getString)
    assertEquals("rk", getPaste)
  }
  
  // XP
  
  @Test def test_46_xp {
    initialiseTest(zeroString)
    val buf = this.buf; import buf._ 
    xp()
    assertEquals(0, getCursor)
    assertEquals(0, getMarker)
    assertEquals("", getString)
    assertEquals("", getPaste)
  }
  @Test def test_47_xp {
    initialiseTest(unitString)
    val buf = this.buf; import buf._ 
    da ; xd ; xp
    assertEquals(1, getCursor)
    assertEquals(0, getMarker)
    assertEquals(unitString, getString)
    assertEquals(unitString, getPaste)
  }
  @Test def test_48_xp {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    da ; xd ; xp
    assertEquals(word.length, getCursor)
    assertEquals(0, getMarker)
    assertEquals(word, getString)
    assertEquals(word, getPaste)
  }
  @Test def test_49_xp {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    da ; xd ; xp ; xp
    assertEquals(word.length*2, getCursor)
    assertEquals(0, getMarker)
    assertEquals(word+word, getString)
    assertEquals(word, getPaste)
  }
  
  // EE and ED
  
  @Test def test_50_ee {
    initialiseTest(zeroString)
    val buf = this.buf; import buf._ 
    ee
    assertEquals(0, getCursor)
    assertEquals(0, getMarker)
    assertEquals(stringBefore, getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_51_ee {
    initialiseTest(unitString)
    val buf = this.buf; import buf._ 
    ee
    assertEquals(0, getCursor)
    assertEquals(0, getMarker)
    assertEquals("", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_52_ee {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    ee
    assertEquals(0, getCursor)
    assertEquals(0, getMarker)
    assertEquals(word.tail, getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_53_ee {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    rpt(20)(ee)
    assertEquals(0, getCursor)
    assertEquals(0, getMarker)
    assertEquals("", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_54_ee {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    tr; dr; al ; al ; ee
    assertEquals(word.length-2, getCursor)
    assertEquals(word.length-1, getMarker)
    assertEquals("aardvak", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_55_ed {
    initialiseTest(zeroString)
    val buf = this.buf; import buf._ 
    ed
    assertEquals(0, getCursor)
    assertEquals(0, getMarker)
    assertEquals("", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_56_ed {
    initialiseTest(unitString)
    val buf = this.buf; import buf._ 
    ar; ed
    assertEquals(0, getCursor)
    assertEquals(0, getMarker)
    assertEquals("", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_57_ed {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    tr; ed
    assertEquals(word.length-1, getCursor)
    assertEquals(0, getMarker)
    assertEquals(word.init, getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_58_ed {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    tr; rpt(20)(ed)
    assertEquals(0, getCursor)
    assertEquals(0, getMarker)
    assertEquals("", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_59_ed {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    tr; dr; al ; al ; ed
    assertEquals(word.length-3, getCursor)
    assertEquals(word.length-1, getMarker)
    assertEquals("aardvrk", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  
  // CC
  
  @Test def test_60_cc {
    initialiseTest(zeroString)
    val buf = this.buf; import buf._ 
    da; cc
    assertEquals(cursorBefore, getCursor)
    assertEquals(markerBefore, getMarker)
    assertEquals("", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_61_cc {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    da; cc
    assertEquals(word.length, getCursor)
    assertEquals(markerBefore, getMarker)
    assertEquals("AARDVARK", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_62_cc {
    initialiseTest(party)
    val buf = this.buf; import buf._ 
    go(15); dr; tr; xd; da; cc
    assertEquals("nOW iS tHE tIME", getString)
    assertEquals(" For All Good Men To Come To The Aid Of Parity", getPaste)
  }
  @Test def test_63_cc {
    initialiseTest(party)
    val buf = this.buf; import buf._ 
    go(15); dr; tr; xd; dr; go(7); ee; ee; ee; ee; tl; cc
    assertEquals(0, getCursor)
    assertEquals(11, getMarker)
    assertEquals("nOW iS tIME", getString)
    assertEquals(" For All Good Men To Come To The Aid Of Parity", getPaste)
  }
  @Test def test_64_cc {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    ar; ar; xd; dr; tr; cc; xp
    assertEquals(8, getCursor)
    assertEquals(0, getMarker)
    assertEquals("RDVARKaa", getString)
    assertEquals("aa", getPaste)
  }
  
  // SC
  
  @Test def test_65_sc {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    tr; dr; tl; sc('a','X')
    assertEquals(0, getCursor)
    assertEquals(8, getMarker)
    assertEquals("XXrdvXrk", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_66_sc {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    dr; tr; xc; sc('a','X')
    assertEquals(8, getCursor)
    assertEquals(0, getMarker)
    assertEquals("XXrdvXrk", getString)
    assertEquals("aardvark", getPaste)
  }
  @Test def test_67_sc {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    da; xc; sc('a','X'); sc('r','Y')
    assertEquals(8, getCursor)
    assertEquals(0, getMarker)
    assertEquals("XXYdvXYk", getString)
    assertEquals("aardvark", getPaste)
  }
  @Test def test_68_sc {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    ar; ar; dr; ar; ar; ar; xd; da; sc('r','Z'); sc('d','D')
    assertEquals(5, getCursor)
    assertEquals(0, getMarker)
    assertEquals("aaaZk", getString)
    assertEquals("rdv", getPaste)
  }
  @Test def test_69_sc {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    ar; dr; ar; sc('a','X'); sc('X','Y')
    assertEquals(2, getCursor)
    assertEquals(1, getMarker)
    assertEquals("aYrdvark", getString)
    assertEquals("", getPaste)
  }
  @Test def test_70_sc {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    dr; ar; ar; ar; xd; da; sc('a','X'); xp
    assertEquals(8, getCursor)
    assertEquals(0, getMarker)
    assertEquals("dvXrkaar", getString)
    assertEquals("aar", getPaste)
  }
  
  // DD
  
  @Test def test_71_dd {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    dd
    assertEquals(0, getCursor)
    assertEquals(0, getMarker)
    assertEquals("aardvark", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_72_dd {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    da; dd
    assertEquals(5, getCursor)
    assertEquals(0, getMarker)
    assertEquals("ardvk", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_73_dd {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    ar; dr; tr; dd
    assertEquals(6, getCursor)
    assertEquals(1, getMarker)
    assertEquals("aardvk", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_74_dd {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    da; xc; dd; tr; es(" = "); xp
    assertEquals(16, getCursor)
    assertEquals(0, getMarker)
    assertEquals("ardvk = aardvark", getString)
    assertEquals("aardvark", getPaste)
  }
  @Test def test_75_dd {
    initialiseTest(party)
    val buf = this.buf; import buf._ 
    da; dd
    assertEquals(26, getCursor)
    assertEquals(0, getMarker)
    assertEquals("Now IsTheimFrAlGdMnCOfPaty", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_76_dd {
    initialiseTest("..........")
    val buf = this.buf; import buf._ 
    da; dd
    assertEquals(1, getCursor)
    assertEquals(0, getMarker)
    assertEquals(".", getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
 
  // FF
  
  @Test def test_77_ff {
    initialiseTest(message)
    val buf = this.buf; import buf._ 
    assertTrue(ff('F'))
    assertEquals(0, getCursor)
    assertEquals(markerBefore, getMarker)
    assertEquals(stringBefore, getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_78_ff {
    initialiseTest(message)
    val buf = this.buf; import buf._ 
    assertFalse(ff('Z'))
    assertEquals(0, getCursor)
    assertEquals(markerBefore, getMarker)
    assertEquals(stringBefore, getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_79_ff {
    initialiseTest(message)
    val buf = this.buf; import buf._
    ar
    assertFalse(ff('F'))
    assertEquals(1, getCursor)
    assertEquals(markerBefore, getMarker)
    assertEquals(stringBefore, getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_80_ff {
    initialiseTest(message)
    val buf = this.buf; import buf._
    ar
    assertTrue(ff('n'))
    assertEquals(2, getCursor)
    assertEquals(markerBefore, getMarker)
    assertEquals(stringBefore, getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_81_ff {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    ff('a'); ff('a')
    assertEquals(0, getCursor)
    assertEquals(markerBefore, getMarker)
    assertEquals(stringBefore, getString)
    assertEquals(pasteBefore, buf.getPaste)  }
  
  // SF
  
  @Test def test_82_sf {
    initialiseTest(party)
    val buf = this.buf; import buf._ 
    assertTrue(sf(_ == ' '))
    assertEquals(3, getCursor)
    assertEquals(markerBefore, getMarker)
    assertEquals(stringBefore, getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_83_sf {
    initialiseTest(party)
    val buf = this.buf; import buf._ 
    assertFalse(sf(_ == '$'))
    assertEquals(0, getCursor)
    assertEquals(markerBefore, getMarker)
    assertEquals(stringBefore, getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_84_sf {
    initialiseTest(party)
    val buf = this.buf; import buf._ 
    assertTrue(sf(_ => true))
    assertEquals(0, getCursor)
    assertEquals(markerBefore, getMarker)
    assertEquals(stringBefore, getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_85_sf {
    initialiseTest(party)
    val buf = this.buf; import buf._ 
    assertTrue(sf(c => (c.isSpaceChar || c.isLower)))
    assertEquals(1, getCursor)   
    assertEquals(markerBefore, getMarker)  
    assertEquals(stringBefore, getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_86_sf {
    initialiseTest(zeroString)
    val buf = this.buf; import buf._ 
    assertFalse(sf(_ => true))
    assertEquals("", getString)
    assertEquals(0, getCursor)   
    assertEquals(markerBefore, getMarker)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_87_sf {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    assertTrue(ff('r')); dr; assertTrue(ff('r'))
    assertEquals(2, getCursor)   
    assertEquals(2, getMarker)
    assertEquals(stringBefore, getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_88_sf {
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    assertTrue(ff('r')); dr; ar; assertTrue(ff('r'))
    assertEquals(6, getCursor)   
    assertEquals(2, getMarker)
    assertEquals(stringBefore, getString)
    assertEquals(pasteBefore, buf.getPaste)
  }
  @Test def test_89_sf {
    initialiseTest(message)
    val buf = this.buf; import buf._ 
    dr; tr; es("."); tl; ff('.'); xd
    assertEquals(".", getString)
    assertEquals(message, getPaste)
    assertEquals(0, getMarker)
    assertEquals(0, getCursor)
  }
  
  // Final ten
  
  @Test def test_90___ {//extreme cut/paste on empty string
    initialiseTest(zeroString)
    val buf = this.buf; import buf._ 
    xd;ar;xp
    assertEquals(cursorBefore, getCursor)   
    assertEquals(markerBefore, getMarker)
    assertEquals(stringBefore, getString)
    assertEquals(pasteBefore,  getPaste)
  }
  @Test def test_91___ {//copy/paste at boundaries
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    al;xc;dr;ar;xp
    assertEquals(word.length, getCursor)   
    assertEquals(word.length, getMarker)
    assertEquals(word+word ,  getString)
    assertEquals(word,         getPaste)
  }
  @Test def test_92___ {//extreme cut/paste with unit string
    initialiseTest(unitString)
    val buf = this.buf; import buf._ 
    al;xd;al;xp
    assertEquals(1, getCursor)   
    assertEquals(markerBefore, getMarker)
    assertEquals(unitString, getString)
    assertEquals(unitString, getPaste)
  }
  @Test def test_93___ {//extreme cut 'across' wrap boundary
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    dr;al;al;xd
    assertEquals(0, getCursor)   
    assertEquals(0, getMarker)
    assertEquals(""+word.last, getString)
    assertEquals(word.init, getPaste)
  }
  @Test def test_94___ {//word split/swap
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    val wl2 = word.length/2
    go(wl2);xd;tr;xp
    assertEquals(word.length, getCursor)   
    assertEquals(0, getMarker)
    assertEquals(word.drop(wl2)+word.take(wl2) , getString)
    assertEquals(word.take(wl2), getPaste)
  }
  @Test def test_95___ {//word split/swap with change case
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    val wl2 = word.length/2
    go(wl2);xd;tr;cc;xp
    assertEquals(word.length, getCursor)   
    assertEquals(0, getMarker)
    assertEquals(word.drop(wl2).toUpperCase()+word.take(wl2) , getString)
    assertEquals(word.take(wl2), getPaste)
  }
  @Test def test_96___ {//word split/swap with substitute char
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    val wl2 = word.length/2
    go(wl2);xd;tr;sc('a','A');xp
    assertEquals(word.length, getCursor)   
    assertEquals(0, getMarker)
    assertEquals("vArkaard" , getString)
    assertEquals(word.take(wl2), getPaste)
  }
  @Test def test_97___ {//cut - paste twice - once with change case
    initialiseTest(word)
    val buf = this.buf; import buf._ 
    da;xd;xp;cc;tr;xp
    assertEquals(word.length*2, getCursor)   
    assertEquals(0, getMarker)
    assertEquals(word.toUpperCase()+word, getString)
    assertEquals(word,  getPaste)
  }
  @Test def test_98___ {//detailed editing
    initialiseTest(message)
    val buf = this.buf; import buf._ 
    rpt(3){ff(' ');ar};dr;ff('g');xd;ff(' ');dr;tr;xd
    assertEquals(31, getCursor)   
    assertEquals(31, getMarker)
    assertEquals("Functional programming is great", getString)
    assertEquals(" way to write code",  getPaste)
  }
  
  @Test def test_99___ {//contains a loop so if search does not terminate then this may not also
    initialiseTest(party)
    val buf = this.buf; import buf._ 
    while(sf(c => c.isSpaceChar || c.isLower)) ee
    assertEquals("NITTFAGMTCTTAOP", getString)
    assertEquals(15, getCursor)   
    assertEquals(markerBefore, getMarker)
    assertEquals(pasteBefore,  getPaste)
  }
}
