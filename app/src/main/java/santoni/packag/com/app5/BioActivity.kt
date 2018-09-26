package santoni.packag.com.app5

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bio.*

class BioActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bio)


        // receive data from CelebrityListAdapter ( CLASS ) with same Key NAME
        var receiverData = intent.extras

        //getString(Key)
        var actorName = receiverData.getString(ACTOR_NAME)
        var actorDes = receiverData.getString(ACTOR_DES)
        var actorImage = receiverData.getInt(ACTOR_IMAGE)

        bioActorImage.setImageResource(actorImage)
        lblActorBio.text = "$actorName - $actorDes"

    }

    companion object {
        val ACTOR_NAME = "name"
        val ACTOR_DES = "des"
        val ACTOR_IMAGE = "image"
    }


}