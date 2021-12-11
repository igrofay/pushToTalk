package talk.push.faceter.feature.ui.screen.dialogconmod

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import talk.push.faceter.R
import talk.push.faceter.data.type.ConnectionMode

@Composable
fun DialogConnectionMode(
    visible: Boolean,
    onDismiss : ()-> Unit,
    onClick: (type: String)->Unit
) {
    if(visible)
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Card(
            Modifier
                .fillMaxWidth()
                .height(250.dp),
            RoundedCornerShape(10),
        ) {
            Column(
                Modifier
                    .padding(24.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(stringResource(R.string.select_connection_method), Modifier.fillMaxWidth(), textAlign = TextAlign.Center,
                fontSize = 22.sp , fontWeight = FontWeight.W500)
                Item(R.drawable.ic_local_connection, R.string.local ) {
                    onClick(ConnectionMode.Local.name)
                    onDismiss()
                }
                Item(R.drawable.ic_global_connection, R.string.global) {
                    onClick(ConnectionMode.Global.name)
                    onDismiss()
                }
            }
        }
    }
}

@Composable
private fun Item(
    @DrawableRes icon: Int,
    @StringRes label : Int,
    onClick: () -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable(onClick = onClick)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,

    ){
        Icon(painterResource(icon), contentDescription = null , Modifier.size(50.dp))

        Text(stringResource(label), Modifier.fillMaxWidth(),fontSize = 24.sp , textAlign = TextAlign.Center)
    }
}