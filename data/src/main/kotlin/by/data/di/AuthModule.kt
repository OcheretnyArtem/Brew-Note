package by.data.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Named

const val USER_UID = "USER UID"

@Module
@InstallIn(ViewModelComponent::class)
object AuthModule {

    @Provides
    @ViewModelScoped
    internal fun provideTestFireStore(): FirebaseAuth =
        Firebase.auth

    @Provides
    @Named(USER_UID)
    @ViewModelScoped
    internal fun provideUID(): String? =
        Firebase.auth.currentUser?.uid

}