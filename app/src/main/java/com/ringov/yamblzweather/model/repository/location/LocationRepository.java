package com.ringov.yamblzweather.model.repository.location;

import java.util.List;

import io.reactivex.Single;

public interface LocationRepository {

    Single<String> getLocation();

    void changeLocation(String newValue);

    Single<List<String>> getSuggestions(String input);
}
