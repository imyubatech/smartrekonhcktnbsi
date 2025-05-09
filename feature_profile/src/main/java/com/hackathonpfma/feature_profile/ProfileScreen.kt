package com.hackathonpfma.feature_profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hackathonpfma.core.ui.theme.AppColor

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(AppColor.White)
            .padding(vertical = 64.dp, horizontal = 20.dp)

    ) {
        Text(
            text = "Profile",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = AppColor.Black,
        )
        // Profile Image and Details
        Surface(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            color = AppColor.Emerald.Minus20,
            shape = MaterialTheme.shapes.medium,
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = stringResource(R.string.profile_icon),
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .background(Color.Gray),
                    tint = Color.White
                )

                Column {
                    Text(
                        text = "Darwin Sibarani",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = AppColor.White,
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "darwinsibarani@gmail.com", // Replace with actual email
                            fontSize = 14.sp,
                            color = AppColor.White,
                        )
                    }
                    Text(
                        text = "Male", // Replace with actual gender
                        fontSize = 14.sp,
                        color = AppColor.White,
                    )
                }
            }
        }

        ProfileOption(
            title = stringResource(R.string.my_places),
            icon = Icons.Outlined.Place,
            onClick = { /* Handle click */ }
        )
        ProfileDivider()
        ProfileOption(
            title = stringResource(R.string.payments),
            icon = Icons.Outlined.CreditCard,
            onClick = { /* Handle click */ }
        )
        ProfileDivider()
        ProfileOption(
            title = stringResource(R.string.past_trips),
            icon = Icons.Outlined.History,
            onClick = { /* Handle click */ }
        )

        Spacer(modifier = Modifier.height(200.dp))

        Button(
            onClick = {/* Handle click */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer
            ),
            shape = MaterialTheme.shapes.medium,
        ) {
            Text(stringResource(R.string.logout), color = MaterialTheme.colorScheme.onSecondaryContainer)
        }
    }
}

@Composable
fun ProfileOption(title: String, icon: ImageVector, onClick: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = title,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = stringResource(R.string.go_to, title),
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun ProfileDivider() {
    HorizontalDivider(
        Modifier.padding(horizontal = 16.dp),
        1.dp,
        MaterialTheme.colorScheme.outlineVariant
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}
