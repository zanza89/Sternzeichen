package and03.kapitel4.sternzeichen

fun sternzeichen(tag: Int, monat: Int): String {
    val sternzeichen = arrayOf<String>("Steinbock", "Wassermann", "Fische", "Widder", "Stier", "Zwilling", "Krebs", "Löwe", "Jungfrau", "Waage", "Skorpion", "Schütze")
    val letzterTag = intArrayOf(20,19,20,20,20,21,22,23,23,23,22,21)
    if (tag > letzterTag[monat-1])
        return sternzeichen[monat%12]
    else
        return sternzeichen[monat-1]
}