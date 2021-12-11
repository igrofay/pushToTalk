package talk.push.faceter.feature.ui.screen.functional

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import talk.push.faceter.R
import talk.push.faceter.data.type.RelationshipMode
import talk.push.faceter.feature.ui.theme.Red
import talk.push.faceter.feature.ui.theme.Yellow

@Composable
fun FunctionalScreen(
    onClickItem: (type: String) -> Unit
) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Item(R.drawable.ic_call, R.string.call , Yellow ){
            onClickItem(RelationshipMode.BabyMonitor.name)
        }
        Spacer(Modifier.height(15.dp))
        Item(R.drawable.ic_speaker, R.string.baby_monitor , Red){
            onClickItem(RelationshipMode.Call.name)
        }
    }
}

@Composable
fun Item(
    @DrawableRes icon : Int,
    @StringRes label: Int,
    colorBack: Color,
    onClick: ()->Unit
) {
    val type = stringResource(label)
    Row(
        Modifier
            .shadow(4.dp, RoundedCornerShape(15))
            .background(colorBack)
            .fillMaxWidth(0.8f)
            .height(120.dp)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Image(
            painterResource(icon),
            contentDescription =null,
            Modifier.size(60.dp),
            colorFilter = ColorFilter.tint(Color.White)
        )
        Text(type , fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,  color =  Color.White, fontSize = 28.sp )
    }
}