package by.data.di

import by.data.remoteData.FireStore
import by.data.remoteData.RemoteService
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object FireStoreModule {

    @Provides
    @ViewModelScoped
    internal fun provideTestFireStore(): FirebaseFirestore =
        Firebase.firestore

}

@Module
@InstallIn(ViewModelComponent::class)
abstract class FireStoreModuleAbstract{

    @Binds
    @ViewModelScoped
    internal abstract fun bindRemoteService(fireStore: FireStore): RemoteService
}
