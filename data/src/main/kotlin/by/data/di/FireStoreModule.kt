package by.data.di

import by.data.remote.TestFireStore
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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

    @Provides
    @ViewModelScoped
    internal fun provideFirebaseFirestore(firebaseFirestore: FirebaseFirestore): TestFireStore =
        TestFireStore(firebaseFirestore)

}
