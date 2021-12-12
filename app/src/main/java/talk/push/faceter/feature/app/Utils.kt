package talk.push.faceter.feature.app


import android.widget.Toast
import androidx.annotation.StringRes

fun toast(@StringRes strRes: Int){
    Toast.makeText(App.appContext, strRes, Toast.LENGTH_SHORT).show()
}

fun toast(str: String){
    Toast.makeText(App.appContext, str, Toast.LENGTH_SHORT).show()
}