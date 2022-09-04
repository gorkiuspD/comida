package com.gorkius.comida.di

import android.app.Application
import androidx.room.Room
import com.gorkius.comida.feature_dish.data.data_source.DishDatabase
import com.gorkius.comida.feature_dish.data.repository.DishRepositoryImpl
import com.gorkius.comida.feature_dish.domain.repository.DishRepository
import com.gorkius.comida.feature_dish.domain.use_case.AddDish
import com.gorkius.comida.feature_dish.domain.use_case.DeleteDish
import com.gorkius.comida.feature_dish.domain.use_case.DishUseCases
import com.gorkius.comida.feature_dish.domain.use_case.GetDishes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDishDatabase(app: Application): DishDatabase {
        return Room.databaseBuilder(
            app,
            DishDatabase::class.java,
            DishDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideDishRepository(db: DishDatabase): DishRepository{
        return DishRepositoryImpl(db.dishDao)
    }

    @Provides
    @Singleton
    fun provideDishNoteCases(repository: DishRepository): DishUseCases{
        return DishUseCases(
            getDishes = GetDishes(repository),
            deleteDish = DeleteDish(repository),
            addDish = AddDish(repository)
        )
    }
}