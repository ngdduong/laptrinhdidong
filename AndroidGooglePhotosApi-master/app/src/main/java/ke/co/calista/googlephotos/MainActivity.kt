package ke.co.calista.googlephotos

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.Scope
import com.google.android.gms.tasks.Task
import com.kogicodes.sokoni.models.custom.Status
import ke.co.calista.googlephotos.ui.main.MainFragment
import ke.co.calista.googlephotos.ui.main.MainViewModel
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener {
    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

      var serverCode : String=""
     var token: String? = null
    private val RC_GET_AUTH_CODE = 9003

    private lateinit var viewModel: MainViewModel
    private  var RC_SIGN_IN: Int=100
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mGoogleApiClient: GoogleApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()

                .requestServerAuthCode("your oauth web id",false)
                .requestScopes(Scope("https://www.googleapis.com/auth/photoslibrary.readonly"))
                .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)


        mGoogleApiClient = GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)

                .build()

        viewModel.observeAccount().observe(this, Observer(function = {
            run {


                when {
                    it != null -> when {
                        it.status == Status.SUCCESS -> {
                            sign_in_button.visibility = GONE
                            viewPhotos.visibility= VISIBLE
                            name.text=(it.data as GoogleSignInAccount).displayName
                            Log.d("sdfsd",serverCode)

                            Glide.with(this).load(it.data.photoUrl.toString()).into(image)
                            supportFragmentManager?.beginTransaction()?.replace(R.id.container, MainFragment.newInstance(serverCode))?.commit()

                        }
                        else -> {
                            sign_in_button.visibility = VISIBLE
                            viewPhotos.visibility= GONE

                        }
                    }
                    else -> {

                    }
                }

            }
        }))

        sign_in_button.setOnClickListener { signIn() }
        signout.setOnClickListener { signOut() }

        for (i in 0 until signout.getChildCount()) {
            val v = signout.getChildAt(i)

            if (v is TextView) {
                val tv = v as TextView
                tv.textSize = 14f
                tv.setTypeface(null, Typeface.NORMAL)
                tv.text = "Log Out"
                tv.setTextColor(Color.parseColor("#212121"))

                tv.setSingleLine(true)

                return
            }
        }

    }



     fun setMainFragment(){
         supportFragmentManager?.beginTransaction()?.replace(R.id.container, MainFragment.newInstance(serverCode))?.commit()

     }


    private fun signIn() {

        val signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
        startActivityForResult(signInIntent, RC_GET_AUTH_CODE)
    }

    private fun signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this) {
                    updateUI(GoogleSignIn.getLastSignedInAccount(this))
                    token=null
                }
    }

    override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if(account!=null){
            signOut()
        }else{
            updateUI(null)
        }
    }

    private fun updateUI(account: GoogleSignInAccount?) {

        if(account!=null){
            viewModel.setIsSignedIn(account)
        }
        else{
            viewModel.setIsNotSignedIn()
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }

        if (requestCode == RC_GET_AUTH_CODE) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)

        }


    }

    private fun handleSignInResult(task: Task<GoogleSignInAccount>?) {
        try {
            val account = task?.getResult(ApiException::class.java)
            serverCode= account?.serverAuthCode.toString()

            updateUI(account)

        } catch (e: ApiException) {
            updateUI(null)
            // Log.d("sfs",e.toString())
        }

    }


}
