package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BackgroundColor
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme
import com.example.businesscardapp.ui.theme.SubtitleColor
import com.example.businesscardapp.ui.theme.TitleColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.background(BackgroundColor)
    ) {
        // header
        Header()

        // slogan area
        Slogan()

        // contact info
        ContactInfo()
    }
}

@Composable
fun Header() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = stringResource(R.string.logo_desc),
            modifier = Modifier
                .height(100.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    bottom = 4.dp
                )
                .align(Alignment.CenterHorizontally),
            text = stringResource(R.string.name),
            color = TitleColor,
            fontSize = 45.sp
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = stringResource(R.string.title_desc),
            color = SubtitleColor,
            fontSize = 25.sp
        )
    }
}

@Composable
fun Slogan() {
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.quote),
            contentDescription = "Opening Quote image",
            modifier = Modifier.height(150.dp),
            alpha = 0.2f
        )
        Column(
            modifier = Modifier.padding(horizontal = 18.dp)
        ) {
            Text(
                text = stringResource(R.string.slogan_quote),
                color = TitleColor,
                modifier = Modifier.padding(bottom = 5.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.slogan_author_name),
                color = SubtitleColor,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }
    }
}

@Composable
fun ContactInfo() {
    Column(modifier = Modifier) {
        ContactInfoCard(Icons.Rounded.Phone, stringResource(R.string.phone_number))
        ContactInfoCard(Icons.Rounded.Share, stringResource(R.string.handle))
        ContactInfoCard(Icons.Rounded.Person, stringResource(R.string.handle))
    }
}

@Composable
fun ContactInfoCard(cardIcon: ImageVector, cardContent: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Icon(
                cardIcon,
                contentDescription = "Image icon"
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = cardContent,
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}