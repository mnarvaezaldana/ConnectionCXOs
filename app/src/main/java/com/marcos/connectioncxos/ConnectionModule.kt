package com.marcos.connectioncxos

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ConnectionModule {

    @Provides
    fun providesConnectionRetrofitService(@ApplicationContext context: Context)
    : ConnectionRetrofitService {
        return ConnectionRetrofitService(context)
    }

    @Provides
    fun providesConnectionRepository(collectionRetrofitService: ConnectionRetrofitService)
    : ConnectionRepository{
        return ConnectionRepository(collectionRetrofitService)
    }

}