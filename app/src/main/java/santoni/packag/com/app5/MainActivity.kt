package santoni.packag.com.app5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var celebrityAdapter: CelebrityListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        celebrityAdapter = CelebrityListAdapter(this@MainActivity)

        celebrityListView.adapter = celebrityAdapter
    }
}
