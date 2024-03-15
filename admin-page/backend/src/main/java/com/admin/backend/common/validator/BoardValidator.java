package com.admin.backend.common.validator;

import com.admin.backend.common.exception.IllegalBoardDataException;
import com.admin.backend.common.exception.IllegalFileDataException;
import com.admin.backend.dto.FreeBoardAddDto;
import com.admin.backend.dto.NoticeBoardDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * Board input data validator
 */
public class BoardValidator {

    private static final int NOTICE_TITLE_MIN = 1;
    private static final int NOTICE_TITLE_MAX = 99;
    private static final int NOTICE_CONTENT_MIN = 1;
    private static final int NOTICE_CONTENT_MAX = 3999;
    private static final int FREE_TITLE_MIN = 1;
    private static final int FREE_TITLE_MAX = 99;
    private static final int FREE_CONTENT_MIN = 1;
    private static final int FREE_CONTENT_MAX = 3999;
    private static final int FREE_FILE_LENGTH = 5;
    private static final int FILE_MAX_SIZE = 2 * 1024 * 1024;

    /**
     * Notice Board Validator
     *
     * @param noticeBoardDto
     */
    public static void validateNoticeBoard(NoticeBoardDto noticeBoardDto) {
        validateText(noticeBoardDto.getTitle(), NOTICE_TITLE_MIN, NOTICE_TITLE_MAX);
        validateText(noticeBoardDto.getContent(), NOTICE_CONTENT_MIN, NOTICE_CONTENT_MAX);
    }

    /**
     * Free Board Validator
     *
     * @param freeBoardAddDto
     */
    public static void validateFreeBoard(FreeBoardAddDto freeBoardAddDto){
        validateText(freeBoardAddDto.getTitle(),FREE_TITLE_MIN,FREE_TITLE_MAX);
        validateText(freeBoardAddDto.getContent(), FREE_CONTENT_MIN, FREE_CONTENT_MAX);
        if(freeBoardAddDto.getFile() != null) {
            validateFileLength(freeBoardAddDto.getFile().length, FREE_FILE_LENGTH);
        }
        validateFileSize(freeBoardAddDto.getFile(), FILE_MAX_SIZE);
    }

    private static void validateText(String text, int minLength, int maxLength) {
        if (text == null) {
            throw new IllegalBoardDataException("입력칸이 비어있습니다.");
        } else if (text.length() < minLength || text.length() > maxLength) {
            throw new IllegalBoardDataException("입력값이 올바르지 않습니다.");
        }
    }

    private static void validateFileLength(int fileLength, int maxLength){
        if(fileLength > maxLength){
            throw new IllegalFileDataException("업로드 파일은 5개까지 가능합니다.");
        }
    }

    private static void validateFileSize(MultipartFile[] fileList, int maxSize){
        for(MultipartFile file : fileList){
            if(file.getSize() > maxSize){
                throw new IllegalFileDataException("파일 사이즈가 " + maxSize + "보다 크면 안됩니다.");
            }
        }
    }
}
