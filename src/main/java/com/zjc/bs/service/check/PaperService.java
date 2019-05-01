package com.zjc.bs.service.check;

import com.zjc.bs.entity.check.Paper;

import java.util.List;

public interface PaperService {
    List<Paper> getPaperByPage(Paper Paper);

    Paper getPaper(Paper Paper);

    Boolean addPaper(Paper Paper);

    Boolean updatePaperTeacher(Paper Paper);
    Boolean updatePaperSup(Paper Paper);
    Boolean deletePaper(Paper Paper);


}
