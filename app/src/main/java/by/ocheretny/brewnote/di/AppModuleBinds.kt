package by.ocheretny.brewnote.di

import by.ocheretny.brewnote.exceptions.ExceptionParser
import by.ocheretny.brewnote.exceptions.ExceptionParserImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModuleBinds {

    @Binds
    abstract fun bindExceptionParser(exceptionParserImpl: ExceptionParserImpl): ExceptionParser
}