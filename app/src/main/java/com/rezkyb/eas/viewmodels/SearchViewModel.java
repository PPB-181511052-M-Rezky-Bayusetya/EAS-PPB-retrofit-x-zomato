package com.rezkyb.eas.viewmodels;

import com.rezkyb.eas.models.Search;
import com.rezkyb.eas.repositories.SearchRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SearchViewModel extends ViewModel {
    private static final String API_KEY = "2b20d69f59ea44f34147ef96e102ce47 ";
    private SearchRepository searchRepository;
    private MutableLiveData<Search> searchMutableLiveData;

    public void init() {
        searchRepository = new SearchRepository();
        searchMutableLiveData = searchRepository.getSearchMutableLiveData();
    }

    public void search(String keyword) {
        searchRepository.search(keyword, API_KEY);
    }

    public LiveData<Search> getSearchLiveData() {
        return searchMutableLiveData;
    }
}
