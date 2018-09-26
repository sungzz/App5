package santoni.packag.com.app5

class CelebrityDatabase {

    var celebritiesList: ArrayList<Celebrity>? = null

    constructor() {

        celebritiesList = ArrayList()

        celebritiesList?.add(Celebrity("Angelina Jolie",
                "Andelina Jolie is an American actress",
                R.drawable.angelina_jolie, true))
        celebritiesList?.add(Celebrity("Audrey Hepburn",
                "Audrey Hepburn was a British actress",
                R.drawable.ingrid_bergman, false))
        celebritiesList?.add(Celebrity("Brad Pitt",
                "Brad Pitt is an American actor",
                R.drawable.brad_pitt, true))
        celebritiesList?.add(Celebrity("Elizabeth Taylor",
                "Elizabeth Taylor was a British-American actress",
                R.drawable.elizabeth_taylor, false))
        celebritiesList?.add(Celebrity("James Stewart",
                "James Stewart was an American Actor",
                R.drawable.james_stewart, false))
        celebritiesList?.add(Celebrity("Marilyn Monroe",
                "Marilyn Monroe was an American actress",
                R.drawable.marilyn_monroe, false))

    }

}
//
//celebritiesList?.add(Celebrity("Angelina Jolie",
//"Andelina Jolie is an American actress",
//R.drawable.angelina_jolie, true))
//celebritiesList?.add(Celebrity("Audrey Hepburn",
//"Audrey Hepburn was a British actress",
//R.drawable.ingrid_bergman, false))
//celebritiesList?.add(Celebrity("Brad Pitt",
//"Brad Pitt is an American actor",
//R.drawable.brad_pitt, true))
//celebritiesList?.add(Celebrity("Elizabeth Taylor",
//"Elizabeth Taylor was a British-American actress",
//R.drawable.elizabeth_taylor, false))
//celebritiesList?.add(Celebrity("James Stewart",
//"James Stewart was an American Actor",
//R.drawable.james_stewart, false))
//celebritiesList?.add(Celebrity("Marilyn Monroe",
//"Marilyn Monroe was an American actress",
//R.drawable.marilyn_monroe, false))