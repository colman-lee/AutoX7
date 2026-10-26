package com.aiselp.autox.ui.material3

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.aiselp.autox.ui.material3.components.MenuTopAppBar
import org.autojs.autojs.ui.log.LogActivityKt
import org.autojs.autojs.ui.main.BottomNavigationItem
import org.autojs.autoxjs.R

@Composable
fun MainTopAppBar(
    openMenuRequest: () -> Unit,
    actions: @Composable () -> Unit = {}
) {
    MenuTopAppBar(
        title = stringResource(id = R.string.app_name),
        openMenuRequest = openMenuRequest,
        actions = {
            LogButton()
            actions()
        }
    )
}

// 主界面日志按钮
@Composable
private fun LogButton() {
    val context = LocalContext.current
    IconButton(onClick = { LogActivityKt.start(context) }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_logcat),
            contentDescription = stringResource(id = R.string.text_logcat),
            tint = Color(0xFF005BC9)
        )
    }
}

@Composable
fun BottomBar(
    items: List<BottomNavigationItem>,
    currentSelected: Int,
    onSelectedChange: (Int) -> Unit
) {
    NavigationBar {
        items.forEachIndexed { i, item ->
            NavigationBarItem(
                selected = i == currentSelected,
                onClick = { onSelectedChange(i) },
                label = { Text(text = item.label) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label
                    )
                })
        }
    }
}