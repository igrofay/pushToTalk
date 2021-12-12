package talk.push.faceter.feature.ui.screen.transmitter.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import talk.push.faceter.R

@Composable
fun TransmitterSettingsScreen(
    connectionWith: String,
    changeConnectionWith: (str: String)-> Unit,
    connectionWho: String,
    changeConnectionWho: (str: String)-> Unit,
    isAdvertising: Boolean,
    changeState : (state :Boolean)-> Unit,
    onClick : ()->Unit
) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = connectionWith,
            onValueChange = changeConnectionWith,
            label = { Text(stringResource(R.string.connection_with))},
            singleLine = true,
            maxLines = 4
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = connectionWho,
            onValueChange = changeConnectionWho,
            label = { Text(stringResource(R.string.connection_who))},
            singleLine = true,
            maxLines = 4
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(!isAdvertising,
                onClick = { changeState(false) })
            Spacer(Modifier.width(8.dp))
            Text(stringResource(R.string.join_room))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(isAdvertising,
                onClick = { changeState(true) })
            Spacer(Modifier.width(8.dp))
            Text(stringResource(R.string.create_room))
        }
    }
    Box(
        Modifier
            .fillMaxWidth()
            .height(300.dp), Alignment.Center){
        Button(onClick = onClick) {
            Text(
                if (isAdvertising) stringResource(R.string.create)
                else stringResource(R.string.join)
            )
        }
    }

}