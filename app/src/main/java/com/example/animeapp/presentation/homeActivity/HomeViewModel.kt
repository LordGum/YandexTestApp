package com.example.animeapp.presentation.homeActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animeapp.data.network.ApiFactory
import com.example.animeapp.data.network.ApiService
import com.example.animeapp.data.network.pojo.Datum
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel: ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val animeResponse = MutableLiveData<List<Datum>>()

    fun loadAdventure() {
        val disposable = ApiFactory.apiService.loadList(ApiService.TYPE_ADVENTURE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    animeResponse.value = it.listOfData
                },
                {
                    throw(RuntimeException(it.message))
                }
            )
        compositeDisposable.add(disposable)
    }
    fun loadFantasy() {
        val disposable = ApiFactory.apiService.loadList(ApiService.TYPE_FANTASY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    animeResponse.value = it.listOfData
                },
                {
                    throw(RuntimeException(it.message))
                }
            )
        compositeDisposable.add(disposable)
    }
    fun loadComedy() {
        val disposable = ApiFactory.apiService.loadList(ApiService.TYPE_COMEDY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    animeResponse.value = it.listOfData
                },
                {
                    throw(RuntimeException(it.message))
                }
            )
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}