package santoni.packag.com.app5

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.celebrity_row.view.*

class CelebrityListAdapter: BaseAdapter {

    private var celebrityDatabase: CelebrityDatabase? = null

    private var context: Context? = null

    constructor(context: Context){

        celebrityDatabase = CelebrityDatabase()
        this.context = context
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val celebrity: Celebrity = celebrityDatabase?.celebritiesList?.get(position)
                ?: Celebrity("No Actor", "No Des", R.drawable.placeholder, false)

        var celebrityView: View
        var layoutInflator: LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater

        if (celebrity.isAlive == true) {

            celebrityView = layoutInflator.inflate(R.layout.alive_celebrity_row, null)

        } else {

            celebrityView = layoutInflator.inflate(R.layout.celebrity_row, null)
        }


        celebrityView.actorImage.setImageResource(celebrity?.image ?: R.drawable.placeholder)
        celebrityView.lblActorName.setText(celebrity.name)
        celebrityView.lblActorDes.setText(celebrity.des)

        celebrityView.setOnClickListener {

            val actorBioIntent = Intent(context, BioActivity::class.java)
            actorBioIntent.putExtra(BioActivity.ACTOR_NAME, celebrity.name)
            actorBioIntent.putExtra(BioActivity.ACTOR_DES, celebrity.des)
            actorBioIntent.putExtra(BioActivity.ACTOR_IMAGE, celebrity.image)
            startActivity(context!!, actorBioIntent, null)

        }

        celebrityView.setOnLongClickListener {

            showDialog(position)

            return@setOnLongClickListener true
        }



        return celebrityView

    }

    override fun getItem(position: Int): Any {

        return celebrityDatabase?.celebritiesList?.get(position) ?:
        Celebrity("No Actor", "No Des", R.drawable.placeholder, false)

    }

    override fun getItemId(position: Int): Long {

        return position.toLong()

    }

    override fun getCount(): Int {

        return celebrityDatabase?.celebritiesList?.size ?: 0
    }


    private fun showDialog(index: Int) {

        val alertDialog: AlertDialog = AlertDialog.Builder(context).create()
        alertDialog.setTitle("Message")
        alertDialog.setMessage("What would you like to do?")

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Delete") {
            dialog: DialogInterface?, which: Int->

            celebrityDatabase?.celebritiesList?.removeAt(index)

            this@CelebrityListAdapter.notifyDataSetChanged()
        }

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Duplicate") {
            dialog: DialogInterface?, which: Int->

            celebrityDatabase?.celebritiesList?.add(index, celebrityDatabase?.celebritiesList?.get(index)
                    ?: Celebrity("No Actor", "No Des",R.drawable.placeholder, false))

            this.notifyDataSetChanged()
        }

        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancel") {
            dialog: DialogInterface?, which: Int->

            alertDialog.dismiss()

            }

        alertDialog.setCancelable(true)

        alertDialog.show()

    }

}