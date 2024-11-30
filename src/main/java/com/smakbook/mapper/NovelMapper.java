package com.smakbook.mapper;

import com.smakbook.dto.novel.AdminNovelSearchResponse;
import com.smakbook.dto.novel.NovelDetailedResponse;
import com.smakbook.dto.novel.ReaderNovelSearchResponse;
import com.smakbook.dto.novel.TranslatorNovelSearchResponse;
import com.smakbook.dto.volume.VolumeResponse;
import com.smakbook.model.AlternativeTitle;
import com.smakbook.model.Novel;
import com.smakbook.model.Volume;
import com.smakbook.service.VolumeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class NovelMapper
 * @since 29/11/2024 — 20.27
 **/
@Component
@RequiredArgsConstructor
public class NovelMapper {
    private final UserMapper userMapper;
    private final GenreMapper genreMapper;
    private final TagMapper tagMapper;
    private final VolumeMapper volumeMapper;
    private final VolumeServiceImpl volumeService;

    public ReaderNovelSearchResponse toReaderSearchResponse(Novel novel) {
        ReaderNovelSearchResponse novelSearchResponse = new ReaderNovelSearchResponse();
        novelSearchResponse.setId(novel.getId());
        novelSearchResponse.setTitle(novel.getTitle());
        novelSearchResponse.setCoverImagePath(novel.getCoverImagePath());
        novelSearchResponse.setCountry(novel.getCountry());
        novelSearchResponse.setTranslationStatus(novel.getTranslationStatus().getDbValue());
        return novelSearchResponse;
    }

    public TranslatorNovelSearchResponse toTranslatorSearchResponse(Novel novel) {
        TranslatorNovelSearchResponse translatorNovelSearchResponse = new TranslatorNovelSearchResponse();
        translatorNovelSearchResponse.setId(novel.getId());
        translatorNovelSearchResponse.setTitle(novel.getTitle());
        translatorNovelSearchResponse.setCreatedAt(novel.getCreatedAt());
        translatorNovelSearchResponse.setUpdatedAt(novel.getUpdatedAt());
        return translatorNovelSearchResponse;
    }

    public AdminNovelSearchResponse toAdminSearchResponse(Novel novel) {
        AdminNovelSearchResponse adminNovelSearchResponse = new AdminNovelSearchResponse();
        adminNovelSearchResponse.setId(novel.getId());
        adminNovelSearchResponse.setTitle(novel.getTitle());
        adminNovelSearchResponse.setTranslator(userMapper.toShortResponse(novel.getTranslator()));
        adminNovelSearchResponse.setCreatedAt(novel.getCreatedAt());
        adminNovelSearchResponse.setUpdatedAt(novel.getUpdatedAt());
        return adminNovelSearchResponse;
    }

    public NovelDetailedResponse toDetailedResponse(Novel novel) {
        NovelDetailedResponse novelDetailedResponse = new NovelDetailedResponse();
        novelDetailedResponse.setId(novel.getId());
        novelDetailedResponse.setAuthor(novel.getAuthor().getName());
        novelDetailedResponse.setTranslator(userMapper.toShortResponse(novel.getTranslator()));
        novelDetailedResponse.setCoverImagePath(novel.getCoverImagePath());
        novelDetailedResponse.setTitle(novel.getTitle());
        novelDetailedResponse.setAlternativeTitles(novel.getAlternativeTitles().stream().map(AlternativeTitle::getName).toList());
        novelDetailedResponse.setDescription(novel.getDescription());
        novelDetailedResponse.setCountry(novel.getCountry());
        novelDetailedResponse.setReleaseDate(novel.getReleaseDate());
        novelDetailedResponse.setNovelStatus(novel.getNovelStatus().getDbValue());
        novelDetailedResponse.setTranslationStatus(novel.getTranslationStatus().getDbValue());
        novelDetailedResponse.setCreatedAt(novel.getCreatedAt());
        novelDetailedResponse.setUpdatedAt(novel.getUpdatedAt());
        novelDetailedResponse.setGenres(novel.getGenres().stream().map(genreMapper::toResponse).toList());
        novelDetailedResponse.setTags(novel.getTags().stream().map(tagMapper::toResponse).toList());
        List<Volume> volumes = volumeService.getByNovelId(novel.getId());
        List<VolumeResponse> volumeResponses = volumes.stream().map(volumeMapper::toResponse).toList();
        novelDetailedResponse.setVolumes(volumeResponses);
        novelDetailedResponse.setIsPublished(novel.isPublished());
        return novelDetailedResponse;
    }
}
