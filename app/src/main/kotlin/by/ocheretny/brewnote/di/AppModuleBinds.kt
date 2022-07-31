package by.ocheretny.brewnote.di

import by.ocheretny.brewnote.exceptions.ExceptionParser
import by.ocheretny.brewnote.exceptions.ExceptionParserImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModuleBinds {

    @Binds
    @ViewModelScoped
    abstract fun bindExceptionParser(exceptionParserImpl: ExceptionParserImpl): ExceptionParser
}
