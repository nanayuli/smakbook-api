package com.smakbook.specification;

import com.smakbook.model.TranslationStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class NovelSpecificationBuilder
 * @since 29/11/2024 — 20.22
 **/
public class NovelSpecificationBuilder {
    private final List<SearchCriteria> criteriaList = new ArrayList<>();

    public NovelSpecificationBuilder withTitle(String title) {
        if (title != null && !title.isEmpty()) {
            criteriaList.add(new SearchCriteria("title", title, SearchOperation.CONTAINS));
        }
        return this;
    }

    public NovelSpecificationBuilder withGenreIds(List<Integer> genreIds) {
        if (genreIds != null && !genreIds.isEmpty()) {
            criteriaList.add(new SearchCriteria("genres.id", genreIds, SearchOperation.IN));
        }
        return this;
    }

    public NovelSpecificationBuilder withTagIds(List<Integer> tagIds) {
        if (tagIds != null && !tagIds.isEmpty()) {
            criteriaList.add(new SearchCriteria("tags.id", tagIds, SearchOperation.IN));
        }
        return this;
    }

    public NovelSpecificationBuilder withCountry(String country) {
        if (country != null && !country.isEmpty()) {
            criteriaList.add(new SearchCriteria("country", country, SearchOperation.EQUALITY));
        }
        return this;
    }

    public NovelSpecificationBuilder withTranslationStatus(TranslationStatus translationStatus) {
        if (translationStatus != null) {
            criteriaList.add(new SearchCriteria("translationStatus", translationStatus, SearchOperation.EQUALITY));
        }
        return this;
    }

    public NovelSpecificationBuilder withPublishedStatus(Boolean publishedStatus) {
        if (publishedStatus != null) {
            criteriaList.add(new SearchCriteria("isPublished", publishedStatus, SearchOperation.EQUALITY));
        }
        return this;
    }

    public NovelSpecificationBuilder withTranslatorId(Integer translatorId) {
        if (translatorId != null) {
            criteriaList.add(new SearchCriteria("translator.id", translatorId, SearchOperation.EQUALITY));
        }
        return this;
    }

    public List<SearchCriteria> build() {
        return criteriaList;
    }
}
