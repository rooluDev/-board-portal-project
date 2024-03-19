package com.admin.backend.service;

import com.admin.backend.dto.FreeBoardDto;
import com.admin.backend.dto.SearchConditionDto;

import java.util.List;
import java.util.Optional;

/**
 * Free Board Service Interface
 */
public interface FreeBoardService {

    /**
     * 검색조건에 맞는 자유게시물의 총 개수 가져오기
     *
     * @param searchConditionDto 검색조건
     * @return 검색조건에 맞는 자유게시물의 총 개수
     */
    int getTotalRowCountByCondition(SearchConditionDto searchConditionDto);

    /**
     * 검색조건과 페이지네이션에 맞는 자유게시물 리스트 가져오기
     *
     * @param searchConditionDto 검색조건
     * @return 검색조건과 페이지네이션에 맞는 자유게시물 리스트
     */
    List<FreeBoardDto> getBoardListByCondition(SearchConditionDto searchConditionDto);

    /**
     * 자유게시물 추가
     *
     * @param freeBoardDto ( category_id, author_type, author_id, title, content )
     */
    Long addBoard(FreeBoardDto freeBoardDto);

    /**
     * 자유 게시물 찾기
     *
     * @param boardId ( pk )
     * @return boarId와 일치하는 자유 게시물
     */
    Optional<FreeBoardDto> getBoardById(Long boardId);

    /**
     * 자유게시물 삭제
     *
     * @param boardId ( pk )
     */
    void deleteBoard(Long boardId);

    /**
     * 조회수 증가
     *
     * @param boardId ( pk )
     */
    void increaseView(Long boardId);

    /**
     * 게시물 수정
     *
     * @param freeBoardDto ( categoryId, title, content, boardId )
     */
    void modifyBoard(FreeBoardDto freeBoardDto);
}
