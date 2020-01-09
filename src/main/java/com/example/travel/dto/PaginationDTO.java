package com.example.travel.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirst;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private Integer totalPage;
    private Integer totalCount;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        this.page = page;
        for (int i = 3; i > 0; i--) {
            if ((page - i) > 0) {
                pages.add(page - i);
            }
        }
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if ((page + i) <= totalPage) {
                pages.add(page + i);
            }
        }
        for (int i = 0; i < 3; i++) {

        }

        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }
        if (pages.contains(1)) {
            showFirst = false;
        } else {
            showFirst = true;
        }
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
