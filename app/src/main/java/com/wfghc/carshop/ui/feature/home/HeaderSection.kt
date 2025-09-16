package com.wfghc.carshop.ui.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.wfghc.carshop.R

@Composable
@Preview
fun HeaderSection(userName: String = "John Doe", onBellClick: () -> Unit = {}) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(16.dp)
    ) {
        val (profilePic, nameColumn, bellIcon) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = null,
            modifier = Modifier
                .size(55.dp)
                .constrainAs(ref = profilePic) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        )
        Column(modifier = Modifier.constrainAs(ref = nameColumn) {
            start.linkTo(profilePic.end, margin = 8.dp)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }) {
            Text(text = "text", fontSize = 14.sp)
            Text(text = userName, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
        Image(painter = painterResource(R.drawable.bell),
            contentDescription = null,
            modifier = Modifier
                .clickable { onBellClick() }
                .constrainAs(ref = bellIcon) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}