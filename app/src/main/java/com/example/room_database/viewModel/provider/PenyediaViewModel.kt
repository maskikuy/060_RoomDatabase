package com.example.room_database.viewmodel.provider

import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import com.example.room_database.repositori.AplikasiSiswa
import com.example.room_database.viewModel.HomeViewModel
import com.example.room_database.viewmodel.DetailViewModel
import com.example.room_database.viewmodel.EntryViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
        }

        initializer {
            EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            DetailViewModel(
                this.createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa
            )
        }

        // Inisialisasi EditViewModel (membutuhkan SavedStateHandle)
        initializer {
            EditViewModel(this.createSavedStateHandle(), aplikasiSiswa().container.repositoriSiswa)
        }
    }
}
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory
        .APPLICATION_KEY] as AplikasiSiswa)