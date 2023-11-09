package com.droidcon.sduicompsemvvm.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.droidcon.sduicompsemvvm.model.Component
import com.droidcon.sduicompsemvvm.model.ComponentType
import com.droidcon.sduicompsemvvm.model.NewsCardModel
import com.droidcon.sduicompsemvvm.model.PodcastCardModel
import com.droidcon.sduicompsemvvm.ui.component.NewsCard
import com.droidcon.sduicompsemvvm.ui.component.PodcastCard
import com.droidcon.sduicompsemvvm.util.UiState

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()){
    LaunchedEffect(Unit) {
        viewModel.onGetHomeComponents()
    }
    val components = viewModel.componentStateFlow.collectAsState()
    when(val state = components.value){
        is UiState.Loading -> {
            
        }
        is UiState.Success -> {
            HomeScreen(state.data)
        }
        is UiState.Error -> {

        }
    }
}

@Composable
fun HomeScreen(data: List<Component>){
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(data) { item ->
            AddComponent(component = item)
        }
    }
}

@Composable
fun AddComponent(component: Component) {
    return when(component.type){
        is ComponentType.NewsCard -> {
            val data = component as NewsCardModel
            NewsCard(data = data)
        }
        is ComponentType.PodcastCard -> {
            val data = component as PodcastCardModel
            PodcastCard(data = data)
        }
        else -> { Spacer(modifier = Modifier.padding(0.dp)) }
    }
}